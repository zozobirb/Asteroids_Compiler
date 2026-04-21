import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// Vistor portion

class AstBuilder extends Glib_GloobBaseVisitor<Expr>{
    @Override
    public Expr visitExpr(Glib_GloobParser.ExprContext ctx){return visit(ctx.command());}

    @Override
    public Expr visitCommand(Glib_GloobParser.CommandContext ctx){
        Expr node = visit(ctx.fetch());
        for(int i = 1; i < ctx.operation().size(); i++){
            // TODO: fill in after adding operation
        }
        
        System.out.println("Command visited");
        return node;
    }

    // TODO: add operation

    @Override 
    public Expr visitFetch(Glib_GloobParser.FetchContext ctx){
        // TODO: figure this one out
        return null;
    }

    @Override
    public Expr visitParameters(Glib_GloobParser.ParametersContext ctx){
        // NOTE: the last parameter node will be null

        Expr node = visit(ctx.assign(0));
        for(int i = 1; i < ctx.assign().size(); i++){
            Expr right = visit(ctx.assign(i));
            node = new PARAMETER(node, right);
        }
        System.out.println("Parameter visited");
        return node;
    }

    @Override 
    public Expr visitAssign(Glib_GloobParser.AssignContext ctx){
        return new ASSIGN(new ID(ctx.ID().getText()), visit(ctx.value()));
    }

    @Override
    public Expr visitValue(Glib_GloobParser.ValueContext ctx){
        System.out.println("Value visited");

        if(ctx.ID() != null)
            return new ID(ctx.ID().getText());
        if(ctx.INT() != null)
            return new INT(Long.parseLong(ctx.INT().getText()));
        if(ctx.DATE() != null)
            return new DATE(ctx.DATE().getText());
        if(ctx.TRUE() != null || ctx.FALSE() != null)
            return new BOOL(ctx.ID().getText().equals("TRUE"));

        return null;
    }

    @Override
    public Expr visitOperation(Glib_GloobParser.OperationContext ctx){
        System.out.println("Operation visited");
        Expr _field = visit(ctx.field());
        String op = ctx.getChild(0).getText();
        return new OPERATION(op, _field);
    }

}

// AST

abstract class Expr{}

class ID extends Expr{
    final String name;
    ID(String name){this.name=name;}
}

class INT extends Expr{
    final long value;
    INT(long value){this.value=value;}
}

class DATE extends Expr{
    final String value;
    DATE(String value){this.value=value;}
}

class BOOL extends Expr{
    final boolean value;
    BOOL(boolean value){this.value=value;}
}

class FETCH extends Expr{
    // 
}

class OPERATION extends Expr{
    final String op; 
    final Expr field;
    OPERATION(String op, Expr field){this.op=op; this.field=field;}
}

class PARAMETER extends Expr{
    final Expr parameter, nextParameter;
    PARAMETER(Expr parameter, Expr nextParameter){this.parameter=parameter; this.nextParameter=nextParameter;}
}

class ASSIGN extends Expr{
    final ID id;
    final Expr value;
    ASSIGN(ID id, Expr value){this.id=id;this.value=value;}
}

// class Command extends Expr{
//     // fetch
//     // Operation[]
// }

// class Fetch extends Expr{
//     // Parameters //one or none
// }

// class Parameters extends Expr{
//     // Assign[]
// }

// class Assign extends Expr{
//     // value, id
// }

// class Operation extends Expr{
//     // bool MIN
//     // bool MAX
//     // field = 
// }