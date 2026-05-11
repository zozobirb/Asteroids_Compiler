/**
 * This class holds the logic for calling functions from Engine based on nodes in the AST.
 * This acts as a request generator, and AST traverser.
 */

class RequestBuilder{
    

    public void generate(Expr e){
        System.out.println("AST Traverser visited.");

        if(e instanceof ID id){
            System.out.println("ID visited");
            // TODO: logic for ID
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
        if(e instanceof FETCH f){
            System.out.println("fetch visited");
            // TODO: logic for fetch
            // NOTE: fetch includes: TODO: update fetch includes
        }
        if(e instanceof COMMAND c){
            System.out.println("Command visited");
            // TODO: logic for command
            // NOTE: command includes fetch (expr), operation set (expr)
        }
        if(e instanceof OPERATIONSET os){
            System.out.println("operation set visited");
            // TODO: logic for operation set
            // NOTE: operation set includes current operation (expr), and next operation set (expr)
        }
        if(e instanceof OPERATION o){
            System.out.println("operation visited");
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
            // TODO: logic for assign
            // NOTE: assign includes id (ID), value (expr)
        }

        throw new RuntimeException("unknown AST node");
    }
}