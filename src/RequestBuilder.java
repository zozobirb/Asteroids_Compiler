import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the logic for calling functions from Engine based on nodes in the AST.
 * This acts as a request generator, and AST traverser.
 */

class RequestBuilder{
    private final List<String> stack = new ArrayList<>();
    

    public void genRequest(Expr e){
        System.out.println("AST Traverser visited.");

        if(e instanceof ID id){
            System.out.println("ID visited");
            stack.add(id.name); //adds id name to stack
            
            // NOTE: id includes name (string)
        }
        if(e instanceof INT i){
            System.out.println("int visited");
            // TODO: logic for int
            // NOTE: int includes value (long)
        }
        if(e instanceof DATE d){
            System.out.println("Date visited");
            // TODO: logic for date
            // NOTE: date includes value (string)
        }
        if(e instanceof BOOL b){
            System.out.println("Bool visited");
            // TODO: logic for bool
            // NOTE: bool includes value (boolean)
        }
        if(e instanceof FIELD f){
            System.out.println("field visited");
            // TODO: logic for field
            // NOTE: field includes field (expr)
        }
        if(e instanceof FETCH f){
            System.out.println("fetch visited");
            genRequest(f.parameters);

            // TODO: logic for fetch
        }
        if(e instanceof COMMAND c){
            System.out.println("Command visited");
            genRequest(c.fetch);
            genRequest(c.operationSet);

            // TODO: logic for command
            // NOTE: command includes fetch (expr), operation set (expr)
        }
        if(e instanceof OPERATIONSET os){
            System.out.println("operation set visited");
            genRequest(os.op);
            if(os.nextOpSet != null)
                genRequest(os.nextOpSet);

            // TODO: logic for operation set
            // NOTE: operation set includes current operation (expr), and next operation set (expr)
        }
        if(e instanceof OPERATION o){
            System.out.println("operation visited");
            genRequest(o.field);

            // TODO: logic for operation
            // NOTE: operation includes operation (string), field (expr)
        }
        if(e instanceof PARAMETER p){
            System.out.println("parameter visited");
            // TODO: logic for parameter
            // NOTE: parameter includes parameter (expr), nextparameter (expr)
        }
        if(e instanceof ASSIGN a){
            System.out.println("assign visited");
            genRequest(a.id);
            genRequest(a.value);

            String value = "";
            String id = stack.removeLast();

            // TODO: pop value from stack, then id, then use
            // NOTE: assign includes id (ID), value (expr)
        }

        throw new RuntimeException("unknown AST node");
    }

    public void generate(Expr e){
        stack.clear();
        genRequest(e);
    }
}