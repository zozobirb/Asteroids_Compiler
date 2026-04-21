// Generated from src/Glib_Gloob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Glib_GloobParser}.
 */
public interface Glib_GloobListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Glib_GloobParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Glib_GloobParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(Glib_GloobParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(Glib_GloobParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#fetch}.
	 * @param ctx the parse tree
	 */
	void enterFetch(Glib_GloobParser.FetchContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#fetch}.
	 * @param ctx the parse tree
	 */
	void exitFetch(Glib_GloobParser.FetchContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(Glib_GloobParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(Glib_GloobParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(Glib_GloobParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(Glib_GloobParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(Glib_GloobParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(Glib_GloobParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(Glib_GloobParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(Glib_GloobParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Glib_GloobParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(Glib_GloobParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Glib_GloobParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(Glib_GloobParser.FieldContext ctx);
}