// Generated from Glib_Gloob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Glib_GloobParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Glib_GloobVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(Glib_GloobParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#fetch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetch(Glib_GloobParser.FetchContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(Glib_GloobParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(Glib_GloobParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(Glib_GloobParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(Glib_GloobParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Glib_GloobParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(Glib_GloobParser.FieldContext ctx);
}