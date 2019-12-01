package listener.main;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.Compound_stmtContext;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.For_declContext;

import static listener.main.MiniGoGenListenerHelper.*;

public class MiniGoGenListener extends MiniCBaseListener implements ParseTreeListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();

	int tab = 0;
	int label = 0;

	// program : decl+

	// var_decl : type_spec IDENT ';'
	// | type_spec IDENT '=' LITERAL ';'
	// | type_spec IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();
		newTexts.put(ctx, varName);
	}

	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) {
		String varName = ctx.IDENT().getText();
		newTexts.put(ctx, varName);
	}

	@Override
	public void enterCompound_stmt(Compound_stmtContext ctx) {
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
			else if (ctx.while_stmt() != null) // while_stmt
				stmt += newTexts.get(ctx.while_stmt());
			else if (ctx.return_stmt() != null) // return_stmt
				stmt += newTexts.get(ctx.return_stmt());
			else if (ctx.for_stmt() != null) // for_stmt
				stmt += newTexts.get(ctx.for_stmt());
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
			ExprContext expr = ctx.expr();
			if (expr != null)
				stmt += newTexts.get(ctx.expr()) + " ";

			if (ctx.stmt() != null)
				stmt += newTexts.get(ctx.stmt());

		}
		newTexts.put(ctx, stmt);
	}

	// for_stmt : FOR '(' (for_decl|expr)? ';' expr? ';' expr? ')' stmt;
	// ";" has at index 3, 5 in normally
	@Override
	public void exitFor_stmt(MiniCParser.For_stmtContext ctx) {
		String stmt = "";

		int count_none = 0;
		int count_expr = 0;
		stmt += ctx.FOR().getText() + " ";

		if (";".equals(ctx.getChild(3).getText())) { // local_decl이나 expr이 있음
			if (ctx.getChild(2) == ctx.for_decl())
				stmt += newTexts.get(ctx.for_decl());
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
	}

	// fun_decl : type_spec IDENT '(' params ')' compound_stmt ;
	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		String fun_decl = "";
		String fname = ctx.IDENT().getText();
		fun_decl += funcHeader(ctx, fname) + " ";
		if (ctx.getChildCount() == 6) {
			if (ctx.compound_stmt() != null) {
				fun_decl += newTexts.get(ctx.compound_stmt());
			}
		}
		fun_decl += "\n";
		newTexts.put(ctx, fun_decl);
	}

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) {
		String argtype = "";
		String rtype = "";
		String res = "";
			
		argtype = getParamTypesText(ctx.params());
		
		rtype = " " + ctx.type_spec().getText();
		if(isVoidF(ctx))
			rtype = "";
		
		res =  fname + "(" + argtype + ")" + rtype;
		return "func " + res;
	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) {
		String varDecl = "";
		String ident = ctx.IDENT().getText();
		String type_spec = ctx.type_spec().getText();
		if (ctx.getChildCount() == 3) {
			varDecl += "var ";
			varDecl += ident + " ";
			varDecl += type_spec + " ";
		} else {
			String literal = ctx.LITERAL().getText();

			varDecl += ident + " ";
			varDecl += ":= ";
			if (isDeclWithInit(ctx)) {
				varDecl += literal + " ";
			} else if (isArrayDecl(ctx)) {
				varDecl += "make([]" + type_spec + ", " + literal + ")";
			}
		}
		varDecl += "\n";

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
		} else {
			String literal = ctx.LITERAL().getText();
			varDecl += ident + " ";
			varDecl += ":= ";
			if (isDeclWithInit(ctx)) {
				varDecl += literal + " ";
			} else if (isArrayDecl(ctx)) {
				varDecl += "make([]" + type_spec + ", " + literal + ")";
			}
		}
		varDecl += "\n";

		newTexts.put(ctx, varDecl);
	}

	/*
	 * for_decl : type_spec IDENT | type_spec IDENT '=' LITERAL | type_spec IDENT
	 * '[' LITERAL ']'
	 */

	@Override
	public void exitFor_decl(For_declContext ctx) {
		String varDecl = "";
		String ident = ctx.IDENT().getText();
		String type_spec = ctx.type_spec().getText();
		if (ctx.getChildCount() == 2) {
			varDecl += "var ";
			varDecl += ident + " ";
			varDecl += type_spec + " ";
		} else {
			String literal = ctx.LITERAL().getText();
			varDecl += ident + " ";
			varDecl += ":= ";
			if (ctx.getChildCount() == 4) {
				varDecl += literal + "";
			} else if (ctx.getChildCount() == 5) {
				varDecl += "make([]" + type_spec + ", " + literal + ")";
			}

		}

		newTexts.put(ctx, varDecl);
	}

	// compound_stmt : '{' local_decl* stmt* '}'
	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		String stmt = "";
		stmt += "{" + "\n";
		if (ctx.getChildCount() > 1) {
			for (int i = 1; i < ctx.getChildCount() - 1; i++) {
				stmt += tab_count(tab) + newTexts.get(ctx.getChild(i));
			}
		}
		stmt += tab_count(tab - 1) + "}" + "\n";
		tab--;
		newTexts.put(ctx, stmt);
	}

	private String tab_count(int tab) {
		String tab_str = "";
		for (int i = 0; i < tab; i++) {
			tab_str += "\t";
		}
		return tab_str;
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
			thenStmt = thenStmt.substring(0, thenStmt.length() - 1);
			String elseStmt = newTexts.get(ctx.stmt(1));
			stmt += thenStmt;
			stmt += " ";
			stmt += ctx.ELSE().getText();
			stmt += " ";
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
			String identOrLiteral = ctx.getChild(0).getText();
			expr += identOrLiteral;
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
				expr += ctx.IDENT().getText();
				expr += "[" + newTexts.get(ctx.expr(0)) + "]";
			}
		}
		// IDENT '[' expr ']' '=' expr
		else {
			expr += ctx.IDENT().getText();
			expr += "[" + newTexts.get(ctx.expr(0)) + "]" + " = " + newTexts.get(ctx.expr(1));
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
		expr += " ";
		expr += ctx.getChild(1).getText();
		expr += " ";
		expr += newTexts.get(ctx.expr(1));
		return expr;
	}

	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);
		if (fname.equals("_print")) { // System.out.println
			expr = "println(" + newTexts.get(ctx.args()) + ")";
		} else {
			expr = ctx.IDENT().getText();
			expr += "(";
			expr += newTexts.get(ctx.args());
			expr += ")";
		}
		return expr;

	}

	// args : expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {
		String argsStr = "";

		for (int i = 0; i < ctx.expr().size(); i++) {
			argsStr += newTexts.get(ctx.expr(i));
			argsStr += ", ";
		}
		argsStr = argsStr.substring(0, argsStr.length() - 2);
		newTexts.put(ctx, argsStr);
	}
}
