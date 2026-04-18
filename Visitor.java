public class Visitor extends Glib_GloobBaseVisitor<Void> {
    //private final OurEngine engine;


/*
    public Visitor(OurEngine _engine) {
        OurEngine = _engine ;
    }
*/
    //Would need to get a string or sort to collect parameters: private int val(logoParser.ExprContext e) { return Integer.parseInt(e.getText()); }
//NOTE MAY NOT ACTUALLY NEED ALL OF THESE VISITORS JUST THE TERMINAL NODES THAT WILL HAVE US EXECUTE CERTIANN REQUEST OKAY



    @Override public Void visitCommand(Glib_GloobParser.CommandContext ctx) { /*engine.move(val(ctx.expr()));*/ return null; *}
    @Override public visitFetch(Glib_GloobParser.FetchContext ctx) { return null; }
    @Override public Void visitOperation(Glib_GloobParser.OperationContext ctx) { return null; }
    @Override public Void visitParameters(Glib_GloobParser.ParametersContext ctx) { return null;}



}