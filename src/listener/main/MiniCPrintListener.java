package listener.main;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import generated.*;

public class MiniCPrintListener extends MiniCBaseListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();

	/*
	 * MiniC.g4의 문법에 따라 해당 Context가 어떤 Context인지 확인하는 메소드들 ~ 180줄까지
	 */

	/*
	 * decl
	 */
	private boolean isVarDecl_Decl(MiniCParser.DeclContext ctx) {
		return ctx.getChild(0) == ctx.var_decl();
	}

	private boolean isFunDecl_Decl(MiniCParser.DeclContext ctx) {
		return ctx.getChild(0) == ctx.fun_decl();
	}

	/*
	 * var_decl
	 */
	private boolean isDeclare_VarDecl(MiniCParser.Var_declContext ctx) {
		return ctx.getChildCount() == 3;
	}

	private boolean isAssign_VarDecl(MiniCParser.Var_declContext ctx) {
		return ctx.getChildCount() == 5;
	}

	private boolean isDeclareArray_VarDecl(MiniCParser.Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	/*
	 * type_spec
	 */
	private boolean isVoid_TypeSpec(MiniCParser.Type_specContext ctx) {
		return ctx.getChild(0) == ctx.VOID();
	}

	private boolean isInt_TypeSpec(MiniCParser.Type_specContext ctx) {
		return ctx.getChild(0) == ctx.INT();
	}

	/*
	 * params
	 */
	private boolean isParams_Params(MiniCParser.ParamsContext ctx) {
		return ctx.getChildCount() > 1;
	}

	private boolean isVoid_Params(MiniCParser.ParamsContext ctx) {
		return ctx.getChildCount() == 1;
	}

	private boolean isEmpty_Params(MiniCParser.ParamsContext ctx) {
		return ctx.getChildCount() == 0;
	}

	/*
	 * param
	 */
	private boolean isNonArrayParam_Param(MiniCParser.ParamContext ctx) {
		return ctx.getChildCount() == 2;
	}

	private boolean isArrayParam_Param(MiniCParser.ParamContext ctx) {
		return ctx.getChildCount() == 3;
	}

	/*
	 * stmt
	 */
	private boolean isExprStmt_Stmt(MiniCParser.StmtContext ctx) {
		return ctx.getChild(0) == ctx.expr_stmt();
	}

	private boolean isCompoundStmt_Stmt(MiniCParser.StmtContext ctx) {
		return ctx.getChild(0) == ctx.compound_stmt();
	}

	private boolean isIfStmt_Stmt(MiniCParser.StmtContext ctx) {
		return ctx.getChild(0) == ctx.if_stmt();
	}

	private boolean isWhileStmt_Stmt(MiniCParser.StmtContext ctx) {
		return ctx.getChild(0) == ctx.while_stmt();
	}

	private boolean isReturnStmt_Stmt(MiniCParser.StmtContext ctx) {
		return ctx.getChild(0) == ctx.return_stmt();
	}

	/*
	 * local_decl
	 */
	private boolean isDeclare_LocalDecl(MiniCParser.Local_declContext ctx) {
		return ctx.getChildCount() == 3;
	}

	private boolean isAssign_LocalDecl(MiniCParser.Local_declContext ctx) {
		return ctx.getChildCount() == 5;
	}

	private boolean isDeclareArray_LocalDecl(MiniCParser.Local_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	/*
	 * if_stmt
	 */
	private boolean isIfStmt_IfStmt(MiniCParser.If_stmtContext ctx) {
		return ctx.getChildCount() == 5;
	}

	private boolean isIfElseStmt_IfStmt(MiniCParser.If_stmtContext ctx) {
		return ctx.getChildCount() == 7;
	}

	/*
	 * return_stmt
	 */
	private boolean isReturnVoid_ReturnStmt(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 2;
	}

	private boolean isReturnExpr_ReturnStmt(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 3;
	}

	/*
	 * expr
	 */
	private boolean isLITERAL_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 1 && ctx.getChild(0) == ctx.LITERAL();
	}

	private boolean isBrackets_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 3 && ctx.getChild(1) == ctx.expr();
	}

	private boolean isIDENT_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 1 && ctx.getChild(0) == ctx.IDENT();
	}

	private boolean isIDENTArray_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChild(0) == ctx.IDENT() && ctx.getChildCount() == 4 && ctx.getChild(2) == ctx.expr();
	}

	private boolean isIDENTFunction_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChild(0) == ctx.IDENT() && ctx.getChildCount() == 4 && ctx.getChild(2) == ctx.args();
	}

	private boolean isBinaryOperation_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 3 && ctx.getChild(1) != ctx.expr() && ctx.getChild(0) == ctx.expr(0);
	}

	private boolean isUnaryOperation_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 2 && ctx.getChild(0) != ctx.expr();
	}

	private boolean isAssign_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 3 && ctx.getChild(0) == ctx.IDENT();
	}

	private boolean isArrayAssign_Expr(MiniCParser.ExprContext ctx) {
		return ctx.getChildCount() == 6;
	}

	private boolean isExprs_Args(MiniCParser.ArgsContext ctx) {
		return ctx.getChildCount() != 0;
	}

	private boolean isEmpty_Args(MiniCParser.ArgsContext ctx) {
		return ctx.getChildCount() == 0;
	}
	/*
	 * 문법을 parsing하고 exit하면서 처리 처리한 문자열을 newTexts에 저장하고 parent에서는 그 문자열을 get하여 덧붙인 후
	 * 해당 context를 newTexts에 put하는 방식
	 */

	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) {
		String s = "";
		for (int i = 0; i < ctx.decl().size(); i++) {
			s += newTexts.get(ctx.decl(i)); //decl+
			s += "\n";
		}
		newTexts.put(ctx, s);
		System.out.println(newTexts.get(ctx));
		// exit이므로 마지막으로 저장된 ctx를 get하면 pretty print된 문자열을 볼 수 있다.
	}

	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		// var_decl 혹은 fun_decl
		String s = "";
		if (isVarDecl_Decl(ctx)) {
			s = newTexts.get(ctx.var_decl());
		} else if (isFunDecl_Decl(ctx)) {
			s = newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, s);
	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) {
		// 3가지로 나뉨
		String s = "";
		s = newTexts.get(ctx.type_spec());
		s += ctx.IDENT();
		if (isDeclare_VarDecl(ctx)) {
			s += ";";
		} else if (isAssign_VarDecl(ctx)) {
			s += " = ";
			s += ctx.LITERAL();
			s += ";";
		} else if (isDeclareArray_VarDecl(ctx)) {
			s += "[";
			s += ctx.LITERAL();
			s += "]";
			s += ";";
		}
		newTexts.put(ctx, s);
	}

	@Override
	public void exitType_spec(MiniCParser.Type_specContext ctx) {
		// VOID 혹은 INT지만 구분 필요 없이 공백만 추가 
		newTexts.put(ctx, ctx.getText() + " ");
	}

	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		// compound_stmt를 호출하기 전에 \n을 통해 줄바꿈을 해주어야 한다.
		String s = "";
		s = newTexts.get(ctx.type_spec()); // type_spec
		s += ctx.IDENT(); // IDENT
		s += "("; // '('
		s += newTexts.get(ctx.params()); // params
		s += ")"; // ')'
		s += "\n";
		s += newTexts.get(ctx.compound_stmt()); // compound_stmt
		newTexts.put(ctx, s);
	}

	@Override
	public void exitParams(MiniCParser.ParamsContext ctx) {
		//param이 여러개 있는 경우 ", "를 통해 쉼표와 공백을 넣어준다.
		if (isParams_Params(ctx)) {
			List<MiniCParser.ParamContext> params = ctx.param();
			String paramsText = newTexts.get(params.get(0));
			for (int i = 1; i < params.size(); i++) {
				paramsText += ", " + newTexts.get(params.get(i));
			}
			newTexts.put(ctx, paramsText);
		} else if (isVoid_Params(ctx)) {
			// VOID는 그냥 출력
			newTexts.put(ctx, newTexts.get(ctx));
		} else if (isEmpty_Params(ctx)) {
			// BLANK일 경우 인자가 없으므로 아무것도 출력하지 않음
			newTexts.put(ctx, "");
		}
	}

	@Override
	public void exitParam(MiniCParser.ParamContext ctx) {
		if(isNonArrayParam_Param(ctx)) {
			String type = ctx.type_spec().getText();
			String ident = ctx.IDENT().getText();
			newTexts.put(ctx, type + " " + ident);			
		}
		else if(isArrayParam_Param(ctx)) {
			String s = "";
			s += ctx.type_spec().getText();
			s += " ";
			s += ctx.IDENT().getText();
			s += "[]";//array
			newTexts.put(ctx, s);
		}
	}

	@Override
	public void exitStmt(MiniCParser.StmtContext ctx) {
		//5가지 stmt지만 모두 child가 1개이므로 getChild(0)
		newTexts.put(ctx, newTexts.get(ctx.getChild(0)));
	}

	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		// ';'만 추가
		String s = "";
		s += newTexts.get(ctx.expr()) + ";";
		newTexts.put(ctx, s);
	}

	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
		/*
		 *  만약 자식이 compound_stmt가 아닐 경우는 
		 *  while (1)
		 *  	printf("hello");
		 *  와 같은 경우이므로 괄호를 추가해준다. 
		 */
	
		String s = "";
		s = ctx.WHILE() + " ";
		s += "(";
		s += newTexts.get(ctx.expr());
		s += ")" + "\n";
		if (!(ctx.stmt().getChild(0) instanceof MiniCParser.Compound_stmtContext))
			s += "....";
		// 만약 자식이 compound_stmt라면 compound_stmt에서 '{'괄호를 추가해줄 것임
		s += newTexts.get(ctx.stmt());
		newTexts.put(ctx, s);
	}

	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		String s = "";
		s = "{" + "\n";
		for (int i = 1; i < ctx.getChildCount() - 1; i++) { // curly bracket안의 코드들은 indent 되어야 한다.
			// '\n'를 기준으로 line을 만들어서 인덴트를 추가한 후 newTexts에 put
			String[] toIndentedLine = newTexts.get(ctx.getChild(i)).split("\n");
			String newS = "";
			for (int j = 0; j < toIndentedLine.length; j++) {
				newS += "...." + toIndentedLine[j] + "\n";
			}
			s += newS;
		}
		s += "}";
		newTexts.put(ctx, s);
	}

	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
		// 3종류가 있지만 유의해야할 것은 '=' 사이에 공백넣기
		String s = "";
		s += newTexts.get(ctx.type_spec());
		s += ctx.IDENT();
		if (isDeclare_LocalDecl(ctx)) {

		} else if (isAssign_LocalDecl(ctx)) {
			s += " = ";
			s += ctx.LITERAL();
		} else if (isDeclareArray_LocalDecl(ctx)) {
			s += "[";
			s += ctx.LITERAL();
			s += "]";
		}
		s += ';';
		newTexts.put(ctx, s);
	}

	/*
	 * if_stmt : IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	 */
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		/*
		 * exitWhile_stmt와 유사하나, else일 때도 compound_stmt를 체크해주어야 한다. 
		 */
		String s = "";
		s += ctx.IF() + " "; // if
		s += "("; // '('
		s += newTexts.get(ctx.expr()); // expr
		s += ")"; // ')'
		s += "\n";
		if (!(ctx.stmt(0).getChild(0) instanceof MiniCParser.Compound_stmtContext)) {
			s += "{" + "\n";
			s += "...." + newTexts.get(ctx.stmt(0));
			s += "\n" + "}" + "\n";
		} else {
			s += newTexts.get(ctx.stmt(0)); // stmt
		}
		if (isIfElseStmt_IfStmt(ctx)) { // else case
			s += ctx.ELSE() + "\n"; // else
			if (!(ctx.stmt(1).getChild(0) instanceof MiniCParser.Compound_stmtContext)) {
				s += "{" + "\n";
				s += "...." + newTexts.get(ctx.stmt(0));
				s += "\n" + "}" + "\n";
			} else {
				s += newTexts.get(ctx.stmt(1)); // stmt
			}
		}
		newTexts.put(ctx, s);
	}

	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		// return expr;의 경우에 공백만 주의하면 된다.
		String s = "";
		if (isReturnExpr_ReturnStmt(ctx)) { // return 0;
			s = ctx.RETURN() + " "; // return 
			s += newTexts.get(ctx.expr()) + ";";// 0;
		}
		else {
			s = ctx.getText(); // return;
		}
		newTexts.put(ctx, s);
	}

	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		// 각 조건에 맞는 출력형태로 newTexts에 저장
		System.out.println(ctx.getText());
		if (isLITERAL_Expr(ctx)) {
			newTexts.put(ctx, ctx.getText());
		} else if (isBrackets_Expr(ctx)) {
			String s = "";
			s += "(";
			s += newTexts.get(ctx.expr(0));
			s += ")";
			newTexts.put(ctx, s);
		} else if (isIDENT_Expr(ctx)) {
			newTexts.put(ctx, ctx.getText());
		} else if (isIDENTArray_Expr(ctx)) {
			String s = "";
			s += ctx.IDENT();
			s += "[";
			s += newTexts.get(ctx.expr(0));
			s += "]";
			newTexts.put(ctx, s);
		} else if (isIDENTFunction_Expr(ctx)) {
			String s = "";
			s += ctx.IDENT();
			s += "(";
			s += newTexts.get(ctx.args());
			s += ")";
			newTexts.put(ctx, s);
		} else if (isUnaryOperation_Expr(ctx)) {
			String s = "";
			s += ctx.getChild(0).getText();
			s += newTexts.get(ctx.expr(0));
			newTexts.put(ctx, s);
		} else if (isAssign_Expr(ctx)) {
			String s = "";
			s += ctx.IDENT();
			s += " = ";
			s += newTexts.get(ctx.expr(0));
			newTexts.put(ctx, s);
		} else if (isArrayAssign_Expr(ctx)) {
			String s = "";
			s += ctx.IDENT();
			s += "[";
			s += newTexts.get(ctx.expr(0));
			s += "]";
			s += " = ";
			s += newTexts.get(ctx.expr(1));
			newTexts.put(ctx, s);
		} else if (isBinaryOperation_Expr(ctx)) {
			String s1 = "", s2 = "", op = "";
			// 예 : expr '+' expr
			s1 = newTexts.get(ctx.expr(0));
			s2 = newTexts.get(ctx.expr(1));
			op = ctx.getChild(1).getText();
			newTexts.put(ctx, s1 + " " + op + " " + s2);
		} else if (isAssign_Expr(ctx)) {
			String LValue = "", RValue = "", equalSign = "";
			LValue = ctx.getChild(0).getText();
			equalSign = ctx.getChild(1).getText();
			RValue = newTexts.get(ctx.expr(0));
			newTexts.put(ctx, LValue + " " + equalSign + " " + RValue);
		} else {
			newTexts.put(ctx, ctx.getText());
		}
	}

	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {
		// args가 여러개일 경우 ", "를 반복적으로 추가
		String s = "";
		if (isExprs_Args(ctx)) {
			s += newTexts.get(ctx.expr(0));
			for (int i = 1; i < ctx.expr().size(); i++) {
				s += ", ";
				s += newTexts.get(ctx.expr(i));
			}
		} else if (isEmpty_Args(ctx)) {

		}
		newTexts.put(ctx, s);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {

	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// debug할 때 유용
	}

}