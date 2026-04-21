// Generated from src/Glib_Gloob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Glib_GloobParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FETCH=6, ASTEROID=7, MIN=8, MAX=9, 
		DISTANCE=10, SIZE=11, TRUE=12, FALSE=13, ID=14, INT=15, DATE=16, WS=17;
	public static final int
		RULE_expr = 0, RULE_command = 1, RULE_fetch = 2, RULE_operation = 3, RULE_parameters = 4, 
		RULE_assign = 5, RULE_value = 6, RULE_field = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "command", "fetch", "operation", "parameters", "assign", "value", 
			"field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'('", "')'", "','", "'='", "'FETCH'", "'asteroid'", "'MIN'", 
			"'MAX'", "'distance'", "'size'", "'TRUE'", "'FALSE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "FETCH", "ASTEROID", "MIN", "MAX", 
			"DISTANCE", "SIZE", "TRUE", "FALSE", "ID", "INT", "DATE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Glib_Gloob.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Glib_GloobParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			command();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public FetchContext fetch() {
			return getRuleContext(FetchContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			fetch();
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(19);
				match(T__0);
				setState(20);
				operation();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FetchContext extends ParserRuleContext {
		public TerminalNode FETCH() { return getToken(Glib_GloobParser.FETCH, 0); }
		public TerminalNode ASTEROID() { return getToken(Glib_GloobParser.ASTEROID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FetchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterFetch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitFetch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitFetch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchContext fetch() throws RecognitionException {
		FetchContext _localctx = new FetchContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fetch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(FETCH);
			setState(27);
			match(ASTEROID);
			setState(28);
			match(T__1);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(29);
				parameters();
				}
			}

			setState(32);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public TerminalNode MIN() { return getToken(Glib_GloobParser.MIN, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode MAX() { return getToken(Glib_GloobParser.MAX, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operation);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(MIN);
				setState(35);
				match(T__1);
				setState(36);
				field();
				setState(37);
				match(T__2);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(MAX);
				setState(40);
				match(T__1);
				setState(41);
				field();
				setState(42);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			assign();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(47);
				match(T__3);
				setState(48);
				assign();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Glib_GloobParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(55);
			match(T__4);
			setState(56);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Glib_GloobParser.ID, 0); }
		public TerminalNode INT() { return getToken(Glib_GloobParser.INT, 0); }
		public TerminalNode DATE() { return getToken(Glib_GloobParser.DATE, 0); }
		public TerminalNode TRUE() { return getToken(Glib_GloobParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Glib_GloobParser.FALSE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public TerminalNode DISTANCE() { return getToken(Glib_GloobParser.DISTANCE, 0); }
		public TerminalNode SIZE() { return getToken(Glib_GloobParser.SIZE, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Glib_GloobListener ) ((Glib_GloobListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Glib_GloobVisitor ) return ((Glib_GloobVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==DISTANCE || _la==SIZE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0011?\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0016"+
		"\b\u0001\n\u0001\f\u0001\u0019\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003-\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u00042\b\u0004\n\u0004\f\u00045\t\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0000\u0002\u0001\u0000\f\u0010\u0001\u0000\n\u000b:\u0000"+
		"\u0010\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004"+
		"\u001a\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b.\u0001"+
		"\u0000\u0000\u0000\n6\u0001\u0000\u0000\u0000\f:\u0001\u0000\u0000\u0000"+
		"\u000e<\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011"+
		"\u0001\u0001\u0000\u0000\u0000\u0012\u0017\u0003\u0004\u0002\u0000\u0013"+
		"\u0014\u0005\u0001\u0000\u0000\u0014\u0016\u0003\u0006\u0003\u0000\u0015"+
		"\u0013\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017"+
		"\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018"+
		"\u0003\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0005\u0006\u0000\u0000\u001b\u001c\u0005\u0007\u0000\u0000\u001c"+
		"\u001e\u0005\u0002\u0000\u0000\u001d\u001f\u0003\b\u0004\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 !\u0005\u0003\u0000\u0000!\u0005\u0001\u0000\u0000"+
		"\u0000\"#\u0005\b\u0000\u0000#$\u0005\u0002\u0000\u0000$%\u0003\u000e"+
		"\u0007\u0000%&\u0005\u0003\u0000\u0000&-\u0001\u0000\u0000\u0000\'(\u0005"+
		"\t\u0000\u0000()\u0005\u0002\u0000\u0000)*\u0003\u000e\u0007\u0000*+\u0005"+
		"\u0003\u0000\u0000+-\u0001\u0000\u0000\u0000,\"\u0001\u0000\u0000\u0000"+
		",\'\u0001\u0000\u0000\u0000-\u0007\u0001\u0000\u0000\u0000.3\u0003\n\u0005"+
		"\u0000/0\u0005\u0004\u0000\u000002\u0003\n\u0005\u00001/\u0001\u0000\u0000"+
		"\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u00004\t\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005"+
		"\u000e\u0000\u000078\u0005\u0005\u0000\u000089\u0003\f\u0006\u00009\u000b"+
		"\u0001\u0000\u0000\u0000:;\u0007\u0000\u0000\u0000;\r\u0001\u0000\u0000"+
		"\u0000<=\u0007\u0001\u0000\u0000=\u000f\u0001\u0000\u0000\u0000\u0004"+
		"\u0017\u001e,3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}