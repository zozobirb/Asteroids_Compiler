import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * This class holds the logic for calling functions from Engine based on nodes in the AST.
 * This acts as a request generator, and AST traverser.
 */

class RequestBuilder{
    private final List<String> stack = new ArrayList<>();
    private final List<String[]> parameters = new ArrayList<String[]>();
    private final HashMap<String, String> field = new HashMap<String, String>();
    private final AsteroidServices service = new AsteroidServices();
    private boolean generated = false;
    private String start = null;
    private String end = null;

    private void pushParameters(){
        for(String[] p : parameters){
            if(p[0].toUpperCase().equals("ID") && !generated){
                service.serviceID(Integer.parseInt(p[1]));
                generated=true;
            }
            else if(p[0].toUpperCase().equals("STARTDATE") && !generated){
                if(end!=null){
                    service.serviceDate(p[1], end);
                    generated=true;
                }
                else
                    start=p[1];
            }
            else if(p[0].toUpperCase().equals("ENDDATE") && !generated){
                if(start!=null){
                    service.serviceDate(start, p[1]);
                    generated=true;
                }
                else
                    end=p[1];
            }
            else
                System.out.println(p[0]);
                // throw new RuntimeException("unknown parameter");
        }
        if(!generated && start != null)
            service.serviceDate(start, "7");
        if(!generated && end != null)
            throw new RuntimeException("End date specified but no start date.");
        if(!generated)
            service.serviceAll();
    }

    public void genRequest(Expr e){
        // System.out.println("AST Traverser visited.");

        if(e instanceof ID id){
            // System.out.println("ID visited, id: "+ id.name);
            stack.add(id.name); //adds id name to stack
            return;
            // NOTE: id includes name (string)
        }
        if(e instanceof INT i){
            // System.out.println("int visited, int: "+ i.value);
            stack.add(""+i.value);
            return;
            // NOTE: int includes value (long)
        }
        if(e instanceof DATE d){
            // System.out.println("Date visited, date: "+d.value);
            stack.add(d.value);
            return;
            // NOTE: date includes value (string)
        }
        if(e instanceof BOOL b){
            // System.out.println("Bool visited, bool: "+b.value);
            stack.add(""+b.value);
            return;
            // NOTE: bool includes value (boolean)
        }


        if(e instanceof FIELD f){
            // System.out.println("field visited");
            genRequest(f.value); //id is pushed to stack
            return;
            // NOTE: field includes field (id)
        }
        if(e instanceof FETCH f){
            // System.out.println("fetch visited");
            genRequest(f.parameters);
            return;
        }
        if(e instanceof COMMAND c){
            // System.out.println("Command visited");
            genRequest(c.fetch);
            // System.out.println("fetch returned");
            if(c.operationSet != null)
                genRequest(c.operationSet);
            // System.out.println("returned to cmd");
            return;
            // NOTE: command includes fetch (expr), operation set (expr)
        }
        if(e instanceof OPERATIONSET os){
            // System.out.println("operation set visited");
            genRequest(os.op);
            if(os.nextOpSet != null)
                genRequest(os.nextOpSet);
            // System.out.println("returned to opset");
            return;
            // NOTE: operation set includes current operation (expr), and next operation set (expr)
        }
        if(e instanceof OPERATION o){
            // System.out.println("operation visited");
            genRequest(o.field);
            if(o.op == null){
                String temp = stack.removeLast();
                field.put(temp, null);
                // System.out.println("Added operation "+temp);
                return;
            }
            field.put(o.op, stack.removeLast());
            // System.out.println("Added field "+field.get(o.op)+", op: "+o.op);
            return;
            // NOTE: operation includes operation (string), field (expr)
        }
        if(e instanceof PARAMETER p){
            // System.out.println("parameter visited");
            for(Expr a : p.assigns)
                genRequest(a);
            return;
            // NOTE: parameter includes parameter (expr), nextparameter (expr)
        }
        if(e instanceof ASSIGN a){
            // System.out.println("assign visited");
            
            genRequest(a.value);
            genRequest(a.id);

            String tempId = stack.removeLast();
            String tempVal = stack.removeLast();
            // System.out.println("Assign value "+tempVal+" equal to "+tempId+".");

            if(parameters.contains(tempId))
                throw new RuntimeException("Duplicate parameters used.");
            String[] temp = {tempId, tempVal};
            parameters.add(temp);
            return;
            // NOTE: assign includes id (ID), value (expr)
        }

        throw new RuntimeException("unknown AST node");
    }

    public AsteroidServices generate(Expr e){
        stack.clear();
        genRequest(e);
        pushParameters();
        service.parseFields(field); // will generate output strings in services
        System.out.println("Generation completed.");
        return service; //OR services.getOutput()
    }


    /*----- DEBUG FUNCTIONS ----- */
    private void dumpFields(){
        System.out.println("Dumping fields...");
        field.forEach((key, value)-> System.out.println("0:"+key+","+value));
    }
    private void dumpStack(){
        System.out.println("Dumping stack...");
        for(String s : stack)
            System.out.println(s);
    }
}