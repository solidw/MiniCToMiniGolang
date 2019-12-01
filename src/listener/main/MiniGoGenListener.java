package listener.main;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.Compound_stmtContext;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.For_stmtContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.ProgramContext;
import generated.MiniCParser.StmtContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;

import static listener.main.MiniGoGenListenerHelper.*;
import static listener.main.SymbolTable_Go.*;

public class MiniGoGenListener extends MiniCBaseListener implements ParseTreeListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	SymbolTable_Go symbolTable = new SymbolTable_Go();

	int tab = 0;
	int label = 0;

	// program : decl+
	@Override
	public void enterFun_decl(MiniCParser.Fun_declContext ctx) {
		symbolTable.initFunDecl();

		String fname = getFunName(ctx);
		ParamsContext params;

		if (fname.equals("main")) {
			symbolTable.putLocalVar("args", Type.INTARRAY);
		} else {
			symbolTable.putFunSpecStr(ctx);
			params = (MiniCParser.ParamsContext) ctx.getChild(3);
			symbolTable.putParams(params);
		}
	}

	// var_decl : type_spec IDENT ';'
	// | type_spec IDENT '=' LITERAL ';'
	// | type_spec IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();

		if (isArrayDecl(ctx)) {
			symbolTable.putGlobalVar(varName, Type.INTARRAY);
		} else if (isDeclWithInit(ctx)) {
			symbolTable.putGlobalVarWithInitVal(varName, Type.INT, initVal(ctx));
		} else { // simple decl
			symbolTable.putGlobalVar(varName, Type.INT);
		}
		newTexts.put(ctx, varName);
	}

	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) {
		String varName = ctx.IDENT().getText();
		if (isArrayDecl(ctx)) {
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);
		} else if (isDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx));
		} else { // simple decl
			if (ctx.type_spec().getText() == "int") {
				symbolTable.putLocalVar(getLocalVarName(ctx), Type.INT);
			}
		}
		newTexts.put(ctx, varName);
	}

	@Override
	public void enterCompound_stmt(Compound_stmtContext ctx) {
		// TODO Auto-generated method stub
		tab++;
	}
	
	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) {
		String classProlog = getFunProlog();

		String fun_decl = "", var_decl = "";

		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (isFunDecl(ctx, i))
				fun_decl += newTexts.get(ctx.decl(i));
			else
				var_decl += newTexts.get(ctx.decl(i));
		}

		newTexts.put(ctx, classProlog + var_decl + fun_decl);

		System.out.println(newTexts.get(ctx));
	}

	// decl : var_decl | fun_decl
	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		String decl = "";
		if (ctx.getChildCount() == 1) {
			if (ctx.var_decl() != null) // var_decl
				decl += newTexts.get(ctx.var_decl());
			else // fun_decl
				decl += newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, decl);
	}

	// stmt : expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt |
	// for_stmt
	@Override
	public void exitStmt(MiniCParser.StmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() > 0) {
			if (ctx.expr_stmt() != null) // expr_stmt
				stmt += newTexts.get(ctx.expr_stmt());
			else if (ctx.compound_stmt() != null) // compound_stmt
				stmt += newTexts.get(ctx.compound_stmt());
			else if (ctx.if_stmt() != null) // if_stmt
				stmt += newTexts.get(ctx.if_stmt());
			else if (ctx.while_stmt() != null)
				stmt += newTexts.get(ctx.while_stmt());
			else if (ctx.return_stmt() != null)
				stmt += newTexts.get(ctx.return_stmt());
			else if (ctx.for_stmt() != null)
				stmt += newTexts.get(ctx.for_stmt());
			// <(0) Fill here!>
		}
		newTexts.put(ctx, stmt);
	}

	// expr_stmt : expr ';'
	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() == 2) {
			stmt += newTexts.get(ctx.expr()); // expr
		}
		stmt += "\n";
		newTexts.put(ctx, stmt);
	}

	// while_stmt : WHILE '(' expr ')' stmt
	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
		String stmt = "";

		if (ctx.getChildCount() == 5) {
			stmt += "for ";
			stmt += "; "; // local_decl
			ExprContext expr = ctx.expr();
			if (expr != null)
				stmt += newTexts.get(ctx.expr()) + "; ";

			if (ctx.stmt() != null)
				stmt += newTexts.get(ctx.stmt());

		}
		newTexts.put(ctx, stmt);
		// <(1) Fill here!>
	}

	// for_stmt : FOR '(' (local_decl|expr)? ';' expr? ';' expr? ')' stmt;
	// ";" has index 3, 5
	@Override
	public void exitFor_stmt(MiniCParser.For_stmtContext ctx) {
		String stmt = "";

		int count_none = 0;
		int count_expr = 0;
		stmt += ctx.FOR().getText() + " ";

		if (";".equals(ctx.getChild(3).getText())) { // local_decl이나 expr이 있음
			if (ctx.getChild(3) == ctx.local_decl())
				stmt += newTexts.get(ctx.local_decl());
			else {
				stmt += newTexts.get(ctx.expr(count_expr));
				count_expr++;
			}
		} else {
			count_none++;
		}

		stmt += "; ";

		if (";".equals(ctx.getChild(5 - count_none).getText())) {
			if (ctx.expr(count_expr) != null)
				stmt += newTexts.get(ctx.expr(count_expr));
			count_expr++;
		} else { // None expr
			count_none++;
		}
		stmt += "; ";

		if (ctx.expr(count_expr) != null)
			stmt += newTexts.get(ctx.expr(count_expr)) + " ";

		if (ctx.stmt() != null) {
			stmt += newTexts.get(ctx.stmt());
		}

		newTexts.put(ctx, stmt);
		// <(1) Fill here!>
	}

	// fun_decl : type_spec IDENT '(' params ')' compound_stmt ;
	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		String fun_decl = "";
		String fname = ctx.IDENT().getText();
		fun_decl += funcHeader(ctx, fname);
		if (ctx.getChildCount() == 6) {
			if (ctx.compound_stmt() != null) {
				fun_decl += newTexts.get(ctx.compound_stmt());
			}
		}
		fun_decl += "\n";
		newTexts.put(ctx, fun_decl);
		// <(2) Fill here!>
	}

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) {
		return "func " + symbolTable.getFunSpecStr(fname);
	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();
		String varDecl = "";

		if (isDeclWithInit(ctx)) {
			varDecl += "putfield " + varName + "\n";
			// v. initialization => Later! skip now..:
		}
		newTexts.put(ctx, varDecl);
	}

	/*
	 * local_decl : type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';' |
	 * type_spec IDENT '[' LITERAL ']' ';';
	 */
	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
		String varDecl = "";
		String ident = ctx.IDENT().getText();
		String type_spec = ctx.type_spec().getText();
		if (ctx.getChildCount() == 3) {
			varDecl += "var ";
			varDecl += ident + " ";
			varDecl += type_spec + " ";
			symbolTable.putLocalVar(ident, symbolTable.makeType(type_spec));
		} else if (isDeclWithInit(ctx)) {
			String literal = ctx.LITERAL().getText();

			varDecl += ident + " ";
			varDecl += ":= ";
			varDecl += literal + " ";

			int initVar = Integer.parseInt(literal);
			symbolTable.putLocalVarWithInitVal(ident, symbolTable.makeType(type_spec), initVar);
		} else if (isArrayDecl(ctx)) {
			String literal = ctx.LITERAL().getText();

			varDecl += ident + " ";
			varDecl += ":= ";
			varDecl += "make([]" + type_spec + ", " + literal + ")";
			symbolTable.putLocalVar(ident, Type.INTARRAY);
		}
		varDecl += "\n";

		newTexts.put(ctx, varDecl);
	}

	// compound_stmt : '{' local_decl* stmt* '}'
	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		String stmt = "";
		stmt += "{" + "\n";
		if (ctx.getChildCount() > 1) {
			for (int i = 0; i < ctx.local_decl().size(); i++) {
				stmt += newTexts.get(ctx.local_decl(i));
			}
			for (int i = 0; i < ctx.stmt().size(); i++) {
				stmt += newTexts.get(ctx.stmt(i));
			}
		}
		stmt += "}" + "\n";
		newTexts.put(ctx, stmt);
		// <(3) Fill here>
	}

	// if_stmt : IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		String stmt = "";
		String condExpr = newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt(0));

		stmt += ctx.IF().getText() + " ";
		stmt += condExpr + " ";
		if (noElse(ctx)) {
			stmt += thenStmt;
		} else {
			String elseStmt = newTexts.get(ctx.stmt(1));
			thenStmt = thenStmt.replace("\n", "");
			stmt += thenStmt;
			stmt += ctx.ELSE().getText();
			stmt += elseStmt;
		}

		newTexts.put(ctx, stmt);
	}

	// return_stmt : RETURN ';' | RETURN expr ';'
	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		String stmt = "";
		stmt += "return ";
		if (ctx.getChildCount() > 1) {
			if (ctx.expr() != null) { // RETURN expr;
				stmt += newTexts.get(ctx.expr());
			}
			// else RETURN ;
		}
		stmt += "\n";
		newTexts.put(ctx, stmt);
	}

	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		String expr = "";

		if (ctx.getChildCount() <= 0) {
			newTexts.put(ctx, "");
			return;
		}

		if (ctx.getChildCount() == 1) { // IDENT | LITERAL
			if (ctx.IDENT() != null) {
				String idName = ctx.IDENT().getText();
				expr += idName;
				// else // Type int array => Later! skip now..
				// expr += " lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
			} else if (ctx.LITERAL() != null) {
				String literalStr = ctx.LITERAL().getText();
				expr += literalStr;
			}
		} else if (ctx.getChildCount() == 2) { // UnaryOperation

			expr = handleUnaryExpr(ctx, expr);

		} else if (ctx.getChildCount() == 3) {
			if (ctx.getChild(0).getText().equals("(")) { // '(' expr ')'
				expr = "(" + newTexts.get(ctx.expr(0)) + ")";

			} else if (ctx.getChild(1).getText().equals("=")) { // IDENT '=' expr
				expr = ctx.IDENT().getText() + " = " + newTexts.get(ctx.expr(0));

			} else { // binary operation
				expr = handleBinExpr(ctx, expr);

			}
		}
		// IDENT '(' args ')' | IDENT '[' expr ']'
		else if (ctx.getChildCount() == 4) {
			if (ctx.args() != null) { // function calls
				expr = handleFunCall(ctx, expr);
			} else { // expr
				// Arrays: TODO
			}
		}
		// IDENT '[' expr ']' '=' expr
		else { // Arrays: TODO */
		}
		newTexts.put(ctx, expr);
	}

	// ex) ++a, but ++a can't use in golang
	private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) {
		if (ctx.getChild(1) == ctx.expr(0)) {
			expr += ctx.getChild(0).getText();
			expr += newTexts.get(ctx.expr(0));
		} else if (ctx.getChild(0) == ctx.expr(0)) {
			expr += newTexts.get(ctx.expr(0));
			expr += ctx.getChild(1).getText();
		}
		return expr;
	}

	private String handleBinExpr(MiniCParser.ExprContext ctx, String expr) {
		expr += newTexts.get(ctx.expr(0));
		expr += ctx.getChild(1).getText();
		expr += newTexts.get(ctx.expr(1));
		return expr;
	}

	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);
		if (fname.equals("_print")) { // System.out.println
			expr = "println(" + newTexts.get(ctx.args()) + ")";
		} else {
			expr = newTexts.get(ctx.args()) + "invokestatic " + getCurrentClassName() + "/"
					+ symbolTable.getFunSpecStr(fname) + "\n";
		}
		return expr;

	}

	// args : expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {

//		String argsStr = "\n";
		String argsStr = "";

		for (int i = 0; i < ctx.expr().size(); i++) {
			argsStr += newTexts.get(ctx.expr(i));
		}
		newTexts.put(ctx, argsStr);
	}

//	@Override
//	public void exitEveryRule(ParserRuleContext ctx) {
//		// TODO Auto-generated method stub
//		System.out.println(ctx.getText());
//	}
}
