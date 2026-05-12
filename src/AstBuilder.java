import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// Vistor portion

class AstBuilder extends Glib_GloobBaseVisitor<Expr>{
    @Override
    public Expr visitExpr(Glib_GloobParser.ExprContext ctx){return visit(ctx.command());}

    @Override
    public Expr visitCommand(Glib_GloobParser.CommandContext ctx){
        System.out.println("Command visited");
        Expr f = visit(ctx.fetch());
        Expr opS = null;
        if(ctx.operation().size() < 1)
            return new COMMAND(f, opS);
        for(int i = 0; i < ctx.operation().size(); i++){
            System.out.println("creating op set");
            Expr op = visit(ctx.operation(i));
            opS = new OPERATIONSET(op, opS);
        }
        
        return new COMMAND(f, opS);
    }

    @Override 
    public Expr visitFetch(Glib_GloobParser.FetchContext ctx){
        System.out.println("Fetch visited.");
        /* checks for parameters, if any. Should be 5 if parameters. 
        * Checking for ctx.parameters().size() does not work, unsure of why.*/
       Expr node = null;
        if(ctx.getChildCount() == 5)
            node = visit(ctx.parameters());
        return new FETCH(node);
    }

    @Override
    public Expr visitParameters(Glib_GloobParser.ParametersContext ctx){
        System.out.println("Parameter visited");

        PARAMETER node = new PARAMETER();
        node.add(visit(ctx.assign(0)));

        for(int i = 1; i < ctx.assign().size(); i++){
            node.add(visit(ctx.assign(i)));
        }
        return node;
    }

    @Override 
    public Expr visitAssign(Glib_GloobParser.AssignContext ctx){
        System.out.println("Assign visited, id: "+ctx.ID().getText());
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
        if(ctx.getChildCount() == 1){
            Expr temp = visit(ctx.field());
            return new OPERATION(null, visit(ctx.field()));
        }
        System.out.println(ctx.getChildCount());
        return new OPERATION(ctx.getChild(0).getText(), visit(ctx.field()));
    }

    @Override
    public Expr visitField(Glib_GloobParser.FieldContext ctx){
        System.out.println("Field visited.");
        System.out.println(ctx.getChildCount());
        return new FIELD(visitValue(ctx.value()));
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

class FIELD extends Expr{
    // Might be useless, unsure
    final Expr value;
    FIELD(Expr v){this.value=v;}
}

class OPERATION extends Expr{
    final String op; 
    final Expr field;
    OPERATION(String op, Expr field){this.op=op; this.field=field;}
}

class OPERATIONSET extends Expr{
    final Expr op, nextOpSet;
    OPERATIONSET(Expr op, Expr nOp){this.op=op;this.nextOpSet=nOp;}
}

class FETCH extends Expr{
    final Expr parameters;
    FETCH(Expr p){this.parameters=p;}
}

class PARAMETER extends Expr{
    final List<Expr> assigns;
    PARAMETER(){this.assigns = new ArrayList<Expr>();}
    public void add(Expr a){this.assigns.add(a);}
}

class ASSIGN extends Expr{
    final ID id;
    final Expr value;
    ASSIGN(ID id, Expr value){this.id=id;this.value=value;}
}

class COMMAND extends Expr{
    final Expr fetch;
    final Expr operationSet;
    COMMAND(Expr f, Expr op){this.fetch=f;this.operationSet=op;}
}

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