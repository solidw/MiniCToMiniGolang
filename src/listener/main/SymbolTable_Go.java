package listener.main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import generated.MiniCParser;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import listener.main.SymbolTable_Go.Type;
import static listener.main.MiniGoGenListenerHelper.*;


public class SymbolTable_Go {
	enum Type {
		INT, INTARRAY, VOID, ERROR
	}
	
	static public class VarInfo {
		Type type; 
		int id;
		int initVal;
		
		public VarInfo(Type type,  int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}
		public VarInfo(Type type,  int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}
	
	static public class FInfo {
		public String sigStr;
	}
	
	private Map<String, VarInfo> _lsymtable = new HashMap<>();	// local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>();	// global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>();	// function 
	
		
	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;
	
	SymbolTable_Go(){
		initFunDecl();
		initFunTable();
	}
	
	void initFunDecl(){		// at each func decl
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;
		_lsymtable.clear();
	}
	
	void putLocalVar(String varname, Type type){
		VarInfo tempLocalVar = new VarInfo(type, _localVarID++);
		_lsymtable.put(varname, tempLocalVar);
		//done
	}
	
	void putGlobalVar(String varname, Type type){
		VarInfo tempGlobalVar = new VarInfo(type, _globalVarID++);
		_gsymtable.put(varname, tempGlobalVar);
		//done
	}
	
	void putLocalVarWithInitVal(String varname, Type type, int initVar){
		VarInfo tempLocalVar = new VarInfo(type, _localVarID++, initVar);
		_lsymtable.put(varname, tempLocalVar);
		//done
	}
	void putGlobalVarWithInitVal(String varname, Type type, int initVar){
		VarInfo tempGlobalVar = new VarInfo(type, _globalVarID++, initVar);
		_gsymtable.put(varname, tempGlobalVar);
		//done
	}
	
	void putParams(MiniCParser.ParamsContext params) {
		for(int i = 0; i < params.param().size(); i++) {
			ParamContext currentParam = params.param(i);
			String varname = currentParam.IDENT().getText();
			Type type = makeType(currentParam.type_spec().getText());
			
			putLocalVar(varname, type);
		//done
		}
	}
	
	public Type makeType(String type) {
		//INT, INTARRAY, VOID, ERROR
		if("int".equals(type)) {
			return Type.INT;
		}
		else if("intarray".equals(type)) { // no use in this assignment
			return Type.INTARRAY;
		}
		else if("void".equals(type)) {
			return Type.VOID;
		}
		else {
			return Type.ERROR;
		}
			
	}
	private void initFunTable() {
		FInfo printlninfo = new FInfo();
		printlninfo.sigStr = "println()";
		
		FInfo maininfo = new FInfo();
		maininfo.sigStr = "main()";
		_fsymtable.put("_print", printlninfo);
		_fsymtable.put("main", maininfo);
	}
	
	public String getFunSpecStr(String fname) {
		return _fsymtable.get(fname).sigStr;
		// <Fill here>
	}

	public String getFunSpecStr(Fun_declContext ctx) {
		String fname = ctx.IDENT().getText();
		return getFunSpecStr(fname);
		// <Fill here>	
	}
	
	public String putFunSpecStr(Fun_declContext ctx) {
		String fname = getFunName(ctx);
		String argtype = "";
		String rtype = "";
		String res = "";
			
		argtype = getParamTypesText(ctx.params());
		
		rtype = ctx.type_spec().getText();
		
		res =  fname + "(" + argtype + ") " + rtype;
		
		FInfo finfo = new FInfo();
		finfo.sigStr = res;
		_fsymtable.put(fname, finfo);
		
		return res;
	}
	
	String getVarId(String name){
		// <Fill here>
		int id = _lsymtable.get(name).id; 
		return Integer.toString(id);
	}
	
	Type getVarType(String name){
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}
		
		return Type.ERROR;	
	}
	String newLabel() {
		return "label" + _labelID++;
	}
	
	String newTempVar() {
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) {
		int id = _gsymtable.get(ctx.IDENT().toString()).id; 
		return Integer.toString(id);

		// <Fill here>	
	}

	// local
	public String getVarId(Local_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}
	
	// global
	public String getVarName(Var_declContext ctx) {
		int id = _gsymtable.get(ctx.IDENT().toString()).id; 
		return Integer.toString(id);

		// <Fill here>	
	}

	// local
	public String getVarName(Local_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}	
	
}
