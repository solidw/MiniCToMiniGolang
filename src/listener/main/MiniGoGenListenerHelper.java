package listener.main;

import generated.MiniCParser;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.If_stmtContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;

public class MiniGoGenListenerHelper {

	// <boolean functions>

	static boolean isFunDecl(MiniCParser.ProgramContext ctx, int i) {
		return ctx.getChild(i).getChild(0) instanceof MiniCParser.Fun_declContext;
	}

	// type_spec IDENT '[' ']'
	static boolean isArrayParamDecl(ParamContext param) {
		return param.getChildCount() == 4;
	}

	// global vars
	static int initVal(Var_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	// var_decl : type_spec IDENT '=' LITERAL ';
	static boolean isDeclWithInit(Var_declContext ctx) {
		return ctx.getChildCount() == 5;
	}

	// var_decl : type_spec IDENT '[' LITERAL ']' ';'
	static boolean isArrayDecl(Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	// <local vars>
	// local_decl : type_spec IDENT '[' LITERAL ']' ';'
	static int initVal(Local_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	static boolean isArrayDecl(Local_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	static boolean isDeclWithInit(Local_declContext ctx) {
		return ctx.getChildCount() == 5;
	}

	static boolean isVoidF(Fun_declContext ctx) {
		return "void".equals(ctx.type_spec().getText());
	}

	static boolean isIntReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 3;
	}

	static boolean isVoidReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 2;
	}

	static String getTypeText(Type_specContext typespec) {
		return typespec.getText();
	}

	// params
	static String getParamName(ParamContext param) {
		return param.IDENT().getText();
	}

	/*
	 * param : type_spec IDENT | type_spec IDENT '[' ']';
	 */
	static String getParamTypesText(ParamsContext params) {
		String typeText = "";
		for (int i = 0; i < params.param().size(); i++) {
			typeText += params.param(i).IDENT() + " ";

			if (params.param(i).getChildCount() == 4) { // array
				typeText += "[]";
			}
			typeText += params.param(i).type_spec().getText();
			typeText += ", ";
		}
		if(typeText.length() > 2)
			typeText = typeText.substring(0, typeText.length() -2);
		return typeText;
	}

	static String getLocalVarName(Local_declContext local_decl) {
		return local_decl.IDENT().getText();
	}

	static String getFunName(Fun_declContext ctx) {
		return ctx.IDENT().getText();
	}

	static String getFunName(ExprContext ctx) {
		return ctx.IDENT().getText();
	}

	static boolean noElse(If_stmtContext ctx) {
		return ctx.getChildCount() <= 5;
	}

	static String getFunProlog() {
		return "package main" + "\n" + "\n";
	}
	
	static String getCurrentClassName() {
		return "no use";
	}
}
