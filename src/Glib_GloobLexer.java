// Generated from src/Glib_Gloob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Glib_GloobLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FETCH=6, ASTEROID=7, MIN=8, MAX=9, 
		DISTANCE=10, SIZE=11, TRUE=12, FALSE=13, ID=14, INT=15, DATE=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "FETCH", "ASTEROID", "MIN", "MAX", 
			"DISTANCE", "SIZE", "TRUE", "FALSE", "ID", "INT", "DATE", "WS"
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


	public Glib_GloobLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Glib_Gloob.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0011{\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0005\r`\b\r\n\r\f\rc\t\r\u0001\u000e\u0004\u000ef"+
		"\b\u000e\u000b\u000e\f\u000eg\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0004\u0010v\b\u0010\u000b\u0010\f\u0010"+
		"w\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u00000"+
		"9\u0003\u0000\t\n\r\r  }\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000"+
		"\u0003%\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007"+
		")\u0001\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000"+
		"\u0000\u0000\r3\u0001\u0000\u0000\u0000\u000f<\u0001\u0000\u0000\u0000"+
		"\u0011@\u0001\u0000\u0000\u0000\u0013D\u0001\u0000\u0000\u0000\u0015M"+
		"\u0001\u0000\u0000\u0000\u0017R\u0001\u0000\u0000\u0000\u0019W\u0001\u0000"+
		"\u0000\u0000\u001b]\u0001\u0000\u0000\u0000\u001de\u0001\u0000\u0000\u0000"+
		"\u001fi\u0001\u0000\u0000\u0000!u\u0001\u0000\u0000\u0000#$\u0005|\u0000"+
		"\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0004\u0001"+
		"\u0000\u0000\u0000\'(\u0005)\u0000\u0000(\u0006\u0001\u0000\u0000\u0000"+
		")*\u0005,\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005=\u0000\u0000"+
		",\n\u0001\u0000\u0000\u0000-.\u0005F\u0000\u0000./\u0005E\u0000\u0000"+
		"/0\u0005T\u0000\u000001\u0005C\u0000\u000012\u0005H\u0000\u00002\f\u0001"+
		"\u0000\u0000\u000034\u0005a\u0000\u000045\u0005s\u0000\u000056\u0005t"+
		"\u0000\u000067\u0005e\u0000\u000078\u0005r\u0000\u000089\u0005o\u0000"+
		"\u00009:\u0005i\u0000\u0000:;\u0005d\u0000\u0000;\u000e\u0001\u0000\u0000"+
		"\u0000<=\u0005M\u0000\u0000=>\u0005I\u0000\u0000>?\u0005N\u0000\u0000"+
		"?\u0010\u0001\u0000\u0000\u0000@A\u0005M\u0000\u0000AB\u0005A\u0000\u0000"+
		"BC\u0005X\u0000\u0000C\u0012\u0001\u0000\u0000\u0000DE\u0005d\u0000\u0000"+
		"EF\u0005i\u0000\u0000FG\u0005s\u0000\u0000GH\u0005t\u0000\u0000HI\u0005"+
		"a\u0000\u0000IJ\u0005n\u0000\u0000JK\u0005c\u0000\u0000KL\u0005e\u0000"+
		"\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005s\u0000\u0000NO\u0005i\u0000"+
		"\u0000OP\u0005z\u0000\u0000PQ\u0005e\u0000\u0000Q\u0016\u0001\u0000\u0000"+
		"\u0000RS\u0005T\u0000\u0000ST\u0005R\u0000\u0000TU\u0005U\u0000\u0000"+
		"UV\u0005E\u0000\u0000V\u0018\u0001\u0000\u0000\u0000WX\u0005F\u0000\u0000"+
		"XY\u0005A\u0000\u0000YZ\u0005L\u0000\u0000Z[\u0005S\u0000\u0000[\\\u0005"+
		"E\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000]a\u0007\u0000\u0000\u0000"+
		"^`\u0007\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u001c\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000df\u0007\u0002\u0000\u0000"+
		"ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000h\u001e\u0001\u0000\u0000\u0000ij\u0007"+
		"\u0002\u0000\u0000jk\u0007\u0002\u0000\u0000kl\u0007\u0002\u0000\u0000"+
		"lm\u0007\u0002\u0000\u0000mn\u0005-\u0000\u0000no\u0007\u0002\u0000\u0000"+
		"op\u0007\u0002\u0000\u0000pq\u0005-\u0000\u0000qr\u0007\u0002\u0000\u0000"+
		"rs\u0007\u0002\u0000\u0000s \u0001\u0000\u0000\u0000tv\u0007\u0003\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0006"+
		"\u0010\u0000\u0000z\"\u0001\u0000\u0000\u0000\u0004\u0000agw\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}