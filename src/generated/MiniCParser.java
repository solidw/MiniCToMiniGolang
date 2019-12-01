// Generated from MiniC.g4 by ANTLR 4.7.2
 
package generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, VOID=20, INT=21, FOR=22, WHILE=23, IF=24, ELSE=25, 
		RETURN=26, OR=27, AND=28, LE=29, GE=30, EQ=31, NE=32, IDENT=33, LITERAL=34, 
		DecimalConstant=35, OctalConstant=36, HexadecimalConstant=37, WS=38;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_expr_stmt = 8, 
		RULE_while_stmt = 9, RULE_for_stmt = 10, RULE_compound_stmt = 11, RULE_for_decl = 12, 
		RULE_local_decl = 13, RULE_if_stmt = 14, RULE_return_stmt = 15, RULE_expr = 16, 
		RULE_args = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
			"stmt", "expr_stmt", "while_stmt", "for_stmt", "compound_stmt", "for_decl", 
			"local_decl", "if_stmt", "return_stmt", "expr", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'['", "']'", "'('", "')'", "','", "'{'", "'}'", 
			"'-'", "'+'", "'--'", "'++'", "'*'", "'/'", "'%'", "'<'", "'>'", "'!'", 
			"'void'", "'int'", "'for'", "'while'", "'if'", "'else'", "'return'", 
			"'or'", "'and'", "'<='", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "VOID", "INT", "FOR", 
			"WHILE", "IF", "ELSE", "RETURN", "OR", "AND", "LE", "GE", "EQ", "NE", 
			"IDENT", "LITERAL", "DecimalConstant", "OctalConstant", "HexadecimalConstant", 
			"WS"
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
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				decl();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VOID || _la==INT );
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

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				fun_decl();
				}
				break;
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

	public static class Var_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				type_spec();
				setState(46);
				match(IDENT);
				setState(47);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				type_spec();
				setState(50);
				match(IDENT);
				setState(51);
				match(T__1);
				setState(52);
				match(LITERAL);
				setState(53);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				type_spec();
				setState(56);
				match(IDENT);
				setState(57);
				match(T__2);
				setState(58);
				match(LITERAL);
				setState(59);
				match(T__3);
				setState(60);
				match(T__0);
				}
				break;
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==INT) ) {
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

	public static class Fun_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			type_spec();
			setState(67);
			match(IDENT);
			setState(68);
			match(T__4);
			setState(69);
			params();
			setState(70);
			match(T__5);
			setState(71);
			compound_stmt();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				param();
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(74);
					match(T__6);
					setState(75);
					param();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
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

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				type_spec();
				setState(86);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				type_spec();
				setState(89);
				match(IDENT);
				setState(90);
				match(T__2);
				setState(91);
				match(T__3);
				}
				break;
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

	public static class StmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				expr_stmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				while_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				return_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				for_stmt();
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			expr(0);
			setState(104);
			match(T__0);
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(WHILE);
			setState(107);
			match(T__4);
			setState(108);
			expr(0);
			setState(109);
			match(T__5);
			setState(110);
			stmt();
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniCParser.FOR, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public For_declContext for_decl() {
			return getRuleContext(For_declContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(FOR);
			setState(113);
			match(T__4);
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
				{
				setState(114);
				for_decl();
				}
				break;
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case LITERAL:
				{
				setState(115);
				expr(0);
				}
				break;
			case T__0:
				break;
			default:
				break;
			}
			setState(118);
			match(T__0);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				setState(119);
				expr(0);
				}
			}

			setState(122);
			match(T__0);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				setState(123);
				expr(0);
				}
			}

			setState(126);
			match(T__5);
			setState(127);
			stmt();
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__7);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << VOID) | (1L << INT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				setState(132);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case INT:
					{
					setState(130);
					local_decl();
					}
					break;
				case T__4:
				case T__7:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__18:
				case FOR:
				case WHILE:
				case IF:
				case RETURN:
				case IDENT:
				case LITERAL:
					{
					setState(131);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			match(T__8);
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

	public static class For_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public For_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_decl(this);
		}
	}

	public final For_declContext for_decl() throws RecognitionException {
		For_declContext _localctx = new For_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_decl);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				type_spec();
				setState(140);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				type_spec();
				setState(143);
				match(IDENT);
				setState(144);
				match(T__1);
				setState(145);
				match(LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				type_spec();
				setState(148);
				match(IDENT);
				setState(149);
				match(T__2);
				setState(150);
				match(LITERAL);
				setState(151);
				match(T__3);
				}
				break;
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

	public static class Local_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_local_decl);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				type_spec();
				setState(156);
				match(IDENT);
				setState(157);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				type_spec();
				setState(160);
				match(IDENT);
				setState(161);
				match(T__1);
				setState(162);
				match(LITERAL);
				setState(163);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				type_spec();
				setState(166);
				match(IDENT);
				setState(167);
				match(T__2);
				setState(168);
				match(LITERAL);
				setState(169);
				match(T__3);
				setState(170);
				match(T__0);
				}
				break;
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if_stmt);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(IF);
				setState(175);
				match(T__4);
				setState(176);
				expr(0);
				setState(177);
				match(T__5);
				setState(178);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(IF);
				setState(181);
				match(T__4);
				setState(182);
				expr(0);
				setState(183);
				match(T__5);
				setState(184);
				stmt();
				setState(185);
				match(ELSE);
				setState(186);
				stmt();
				}
				break;
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_return_stmt);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(RETURN);
				setState(191);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(RETURN);
				setState(193);
				expr(0);
				setState(194);
				match(T__0);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniCParser.NE, 0); }
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(199);
				match(LITERAL);
				}
				break;
			case 2:
				{
				setState(200);
				match(T__4);
				setState(201);
				expr(0);
				setState(202);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(204);
				match(IDENT);
				}
				break;
			case 4:
				{
				setState(205);
				match(IDENT);
				setState(206);
				match(T__2);
				setState(207);
				expr(0);
				setState(208);
				match(T__3);
				}
				break;
			case 5:
				{
				setState(210);
				match(IDENT);
				setState(211);
				match(T__4);
				setState(212);
				args();
				setState(213);
				match(T__5);
				}
				break;
			case 6:
				{
				setState(215);
				match(T__9);
				setState(216);
				expr(22);
				}
				break;
			case 7:
				{
				setState(217);
				match(T__10);
				setState(218);
				expr(21);
				}
				break;
			case 8:
				{
				setState(219);
				match(T__11);
				setState(220);
				expr(20);
				}
				break;
			case 9:
				{
				setState(221);
				match(T__12);
				setState(222);
				expr(19);
				}
				break;
			case 10:
				{
				setState(223);
				match(T__18);
				setState(224);
				expr(5);
				}
				break;
			case 11:
				{
				setState(225);
				match(IDENT);
				setState(226);
				match(T__1);
				setState(227);
				expr(2);
				}
				break;
			case 12:
				{
				setState(228);
				match(IDENT);
				setState(229);
				match(T__2);
				setState(230);
				expr(0);
				setState(231);
				match(T__3);
				setState(232);
				match(T__1);
				setState(233);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(238);
						match(T__13);
						setState(239);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(241);
						match(T__14);
						setState(242);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(244);
						match(T__15);
						setState(245);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(247);
						match(T__10);
						setState(248);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(250);
						match(T__9);
						setState(251);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(253);
						match(EQ);
						setState(254);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(256);
						match(NE);
						setState(257);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(259);
						match(LE);
						setState(260);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(262);
						match(T__16);
						setState(263);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(265);
						match(GE);
						setState(266);
						expr(8);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(268);
						match(T__17);
						setState(269);
						expr(7);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(271);
						match(AND);
						setState(272);
						expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(274);
						match(OR);
						setState(275);
						expr(4);
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(277);
						match(T__11);
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(278);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(279);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				expr(0);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(286);
					match(T__6);
					setState(287);
					expr(0);
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13\7\3\7\3\7\5"+
		"\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\th\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\5\fw\n\f\3\f\3\f\5\f{\n\f\3\f\3\f\5\f\177\n\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\7\r\u0087\n\r\f\r\16\r\u008a\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009c\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00af\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00bf\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00c7\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ee\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\7\22\u011b\n\22\f\22\16\22\u011e\13\22\3\23\3\23\3\23\7\23\u0123"+
		"\n\23\f\23\16\23\u0126\13\23\3\23\5\23\u0129\n\23\3\23\2\3\"\24\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\26\27\2\u014d\2\'\3\2\2"+
		"\2\4-\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\fU\3\2\2\2\16_\3\2\2\2"+
		"\20g\3\2\2\2\22i\3\2\2\2\24l\3\2\2\2\26r\3\2\2\2\30\u0083\3\2\2\2\32\u009b"+
		"\3\2\2\2\34\u00ae\3\2\2\2\36\u00be\3\2\2\2 \u00c6\3\2\2\2\"\u00ed\3\2"+
		"\2\2$\u0128\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2"+
		"\2*\3\3\2\2\2+.\5\6\4\2,.\5\n\6\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60\5"+
		"\b\5\2\60\61\7#\2\2\61\62\7\3\2\2\62A\3\2\2\2\63\64\5\b\5\2\64\65\7#\2"+
		"\2\65\66\7\4\2\2\66\67\7$\2\2\678\7\3\2\28A\3\2\2\29:\5\b\5\2:;\7#\2\2"+
		";<\7\5\2\2<=\7$\2\2=>\7\6\2\2>?\7\3\2\2?A\3\2\2\2@/\3\2\2\2@\63\3\2\2"+
		"\2@9\3\2\2\2A\7\3\2\2\2BC\t\2\2\2C\t\3\2\2\2DE\5\b\5\2EF\7#\2\2FG\7\7"+
		"\2\2GH\5\f\7\2HI\7\b\2\2IJ\5\30\r\2J\13\3\2\2\2KP\5\16\b\2LM\7\t\2\2M"+
		"O\5\16\b\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RP\3\2\2\2"+
		"SV\7\26\2\2TV\3\2\2\2UK\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\5\b\5"+
		"\2XY\7#\2\2Y`\3\2\2\2Z[\5\b\5\2[\\\7#\2\2\\]\7\5\2\2]^\7\6\2\2^`\3\2\2"+
		"\2_W\3\2\2\2_Z\3\2\2\2`\17\3\2\2\2ah\5\22\n\2bh\5\30\r\2ch\5\36\20\2d"+
		"h\5\24\13\2eh\5 \21\2fh\5\26\f\2ga\3\2\2\2gb\3\2\2\2gc\3\2\2\2gd\3\2\2"+
		"\2ge\3\2\2\2gf\3\2\2\2h\21\3\2\2\2ij\5\"\22\2jk\7\3\2\2k\23\3\2\2\2lm"+
		"\7\31\2\2mn\7\7\2\2no\5\"\22\2op\7\b\2\2pq\5\20\t\2q\25\3\2\2\2rs\7\30"+
		"\2\2sv\7\7\2\2tw\5\32\16\2uw\5\"\22\2vt\3\2\2\2vu\3\2\2\2vw\3\2\2\2wx"+
		"\3\2\2\2xz\7\3\2\2y{\5\"\22\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\7\3\2\2"+
		"}\177\5\"\22\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7"+
		"\b\2\2\u0081\u0082\5\20\t\2\u0082\27\3\2\2\2\u0083\u0088\7\n\2\2\u0084"+
		"\u0087\5\34\17\2\u0085\u0087\5\20\t\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\13\2\2\u008c\31\3\2\2"+
		"\2\u008d\u008e\5\b\5\2\u008e\u008f\7#\2\2\u008f\u009c\3\2\2\2\u0090\u0091"+
		"\5\b\5\2\u0091\u0092\7#\2\2\u0092\u0093\7\4\2\2\u0093\u0094\7$\2\2\u0094"+
		"\u009c\3\2\2\2\u0095\u0096\5\b\5\2\u0096\u0097\7#\2\2\u0097\u0098\7\5"+
		"\2\2\u0098\u0099\7$\2\2\u0099\u009a\7\6\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u008d\3\2\2\2\u009b\u0090\3\2\2\2\u009b\u0095\3\2\2\2\u009c\33\3\2\2"+
		"\2\u009d\u009e\5\b\5\2\u009e\u009f\7#\2\2\u009f\u00a0\7\3\2\2\u00a0\u00af"+
		"\3\2\2\2\u00a1\u00a2\5\b\5\2\u00a2\u00a3\7#\2\2\u00a3\u00a4\7\4\2\2\u00a4"+
		"\u00a5\7$\2\2\u00a5\u00a6\7\3\2\2\u00a6\u00af\3\2\2\2\u00a7\u00a8\5\b"+
		"\5\2\u00a8\u00a9\7#\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab\7$\2\2\u00ab\u00ac"+
		"\7\6\2\2\u00ac\u00ad\7\3\2\2\u00ad\u00af\3\2\2\2\u00ae\u009d\3\2\2\2\u00ae"+
		"\u00a1\3\2\2\2\u00ae\u00a7\3\2\2\2\u00af\35\3\2\2\2\u00b0\u00b1\7\32\2"+
		"\2\u00b1\u00b2\7\7\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\7\b\2\2\u00b4"+
		"\u00b5\5\20\t\2\u00b5\u00bf\3\2\2\2\u00b6\u00b7\7\32\2\2\u00b7\u00b8\7"+
		"\7\2\2\u00b8\u00b9\5\"\22\2\u00b9\u00ba\7\b\2\2\u00ba\u00bb\5\20\t\2\u00bb"+
		"\u00bc\7\33\2\2\u00bc\u00bd\5\20\t\2\u00bd\u00bf\3\2\2\2\u00be\u00b0\3"+
		"\2\2\2\u00be\u00b6\3\2\2\2\u00bf\37\3\2\2\2\u00c0\u00c1\7\34\2\2\u00c1"+
		"\u00c7\7\3\2\2\u00c2\u00c3\7\34\2\2\u00c3\u00c4\5\"\22\2\u00c4\u00c5\7"+
		"\3\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7"+
		"!\3\2\2\2\u00c8\u00c9\b\22\1\2\u00c9\u00ee\7$\2\2\u00ca\u00cb\7\7\2\2"+
		"\u00cb\u00cc\5\"\22\2\u00cc\u00cd\7\b\2\2\u00cd\u00ee\3\2\2\2\u00ce\u00ee"+
		"\7#\2\2\u00cf\u00d0\7#\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d2\5\"\22\2\u00d2"+
		"\u00d3\7\6\2\2\u00d3\u00ee\3\2\2\2\u00d4\u00d5\7#\2\2\u00d5\u00d6\7\7"+
		"\2\2\u00d6\u00d7\5$\23\2\u00d7\u00d8\7\b\2\2\u00d8\u00ee\3\2\2\2\u00d9"+
		"\u00da\7\f\2\2\u00da\u00ee\5\"\22\30\u00db\u00dc\7\r\2\2\u00dc\u00ee\5"+
		"\"\22\27\u00dd\u00de\7\16\2\2\u00de\u00ee\5\"\22\26\u00df\u00e0\7\17\2"+
		"\2\u00e0\u00ee\5\"\22\25\u00e1\u00e2\7\25\2\2\u00e2\u00ee\5\"\22\7\u00e3"+
		"\u00e4\7#\2\2\u00e4\u00e5\7\4\2\2\u00e5\u00ee\5\"\22\4\u00e6\u00e7\7#"+
		"\2\2\u00e7\u00e8\7\5\2\2\u00e8\u00e9\5\"\22\2\u00e9\u00ea\7\6\2\2\u00ea"+
		"\u00eb\7\4\2\2\u00eb\u00ec\5\"\22\3\u00ec\u00ee\3\2\2\2\u00ed\u00c8\3"+
		"\2\2\2\u00ed\u00ca\3\2\2\2\u00ed\u00ce\3\2\2\2\u00ed\u00cf\3\2\2\2\u00ed"+
		"\u00d4\3\2\2\2\u00ed\u00d9\3\2\2\2\u00ed\u00db\3\2\2\2\u00ed\u00dd\3\2"+
		"\2\2\u00ed\u00df\3\2\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed"+
		"\u00e6\3\2\2\2\u00ee\u011c\3\2\2\2\u00ef\u00f0\f\22\2\2\u00f0\u00f1\7"+
		"\20\2\2\u00f1\u011b\5\"\22\23\u00f2\u00f3\f\21\2\2\u00f3\u00f4\7\21\2"+
		"\2\u00f4\u011b\5\"\22\22\u00f5\u00f6\f\20\2\2\u00f6\u00f7\7\22\2\2\u00f7"+
		"\u011b\5\"\22\21\u00f8\u00f9\f\17\2\2\u00f9\u00fa\7\r\2\2\u00fa\u011b"+
		"\5\"\22\20\u00fb\u00fc\f\16\2\2\u00fc\u00fd\7\f\2\2\u00fd\u011b\5\"\22"+
		"\17\u00fe\u00ff\f\r\2\2\u00ff\u0100\7!\2\2\u0100\u011b\5\"\22\16\u0101"+
		"\u0102\f\f\2\2\u0102\u0103\7\"\2\2\u0103\u011b\5\"\22\r\u0104\u0105\f"+
		"\13\2\2\u0105\u0106\7\37\2\2\u0106\u011b\5\"\22\f\u0107\u0108\f\n\2\2"+
		"\u0108\u0109\7\23\2\2\u0109\u011b\5\"\22\13\u010a\u010b\f\t\2\2\u010b"+
		"\u010c\7 \2\2\u010c\u011b\5\"\22\n\u010d\u010e\f\b\2\2\u010e\u010f\7\24"+
		"\2\2\u010f\u011b\5\"\22\t\u0110\u0111\f\6\2\2\u0111\u0112\7\36\2\2\u0112"+
		"\u011b\5\"\22\7\u0113\u0114\f\5\2\2\u0114\u0115\7\35\2\2\u0115\u011b\5"+
		"\"\22\6\u0116\u0117\f\24\2\2\u0117\u011b\7\16\2\2\u0118\u0119\f\23\2\2"+
		"\u0119\u011b\7\17\2\2\u011a\u00ef\3\2\2\2\u011a\u00f2\3\2\2\2\u011a\u00f5"+
		"\3\2\2\2\u011a\u00f8\3\2\2\2\u011a\u00fb\3\2\2\2\u011a\u00fe\3\2\2\2\u011a"+
		"\u0101\3\2\2\2\u011a\u0104\3\2\2\2\u011a\u0107\3\2\2\2\u011a\u010a\3\2"+
		"\2\2\u011a\u010d\3\2\2\2\u011a\u0110\3\2\2\2\u011a\u0113\3\2\2\2\u011a"+
		"\u0116\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d#\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0124"+
		"\5\"\22\2\u0120\u0121\7\t\2\2\u0121\u0123\5\"\22\2\u0122\u0120\3\2\2\2"+
		"\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0129"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u011f\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129%\3\2\2\2\27)-@PU_gvz~\u0086\u0088\u009b\u00ae\u00be"+
		"\u00c6\u00ed\u011a\u011c\u0124\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}