package Checking;

import java.util.*;

import AST.*;
import AST.Visitor.Visitor;

public class SymbolTable implements Visitor {

	public Vector<String> errorList;
	public Hashtable<String, ClassDecl> globalTable;

	ClassType auxClass;
	MethodType auxMethod;

	public SymbolTable() {
		globalTable = new Hashtable<String, ClassDecl>();
		errorList = new Vector<String>();
	}

	@Override
	public void visit(Display n) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(Program n) {	
		for(int i = 0; i < n.cl.size(); i++) {
			n.cl.get(i).accept(this);
			if(globalTable.contains(n.cl.get(i)))
				errorList.add("Classe " + globalTable.getClass()  + " duplicada\nlinha " + n.cl.get(i).line_number);
			else 
				globalTable.put(n.cl.get(i).toString(), n.cl.get(i));
		}
	}

	@Override
	public void visit(MainClass n) {
		n.accept(this);
	}

	@Override
	public void visit(ClassDeclSimple n) {
		ClassType _class = new ClassType(n.i.s, null);
		
		for(int i = 0; i < n.vl.size(); i++) {
			
			VariableType _var = new VariableType(n.vl.get(i).t, n.vl.get(i).i.s);
			n.vl.get(i).accept(this);
			
			if(_class.variables.contains(_var.getName()))
				errorList.add("Variavel " + _var.getName() + " duplicada na classe " + _class.getName() + "\nlinha " + n.vl.get(i).line_number);
			else 
				_class.variables.put(_var.getName(), _var);
		}
		
		for(int i = 0; i < n.ml.size(); i++) {
			MethodType _met = new MethodType(n.ml.get(i).t, n.ml.get(i).i.s);
			n.ml.get(i).accept(this);
			
			if(_class.methods.contains(_met.getName()))
				errorList.add("Metodo " + _met.getName() + " duplicado na classe " + _class.getName() +"\nlinha " + n.ml.get(i).line_number);
			else 
				_class.methods.put(_met.getName(), _met);
		}
	}

	@Override
	public void visit(ClassDeclExtends n) {
		ClassType _class = new ClassType(n.i.s, n.j.s);
		
		for(int i = 0; i < n.vl.size(); i++) {
			
			VariableType _var = new VariableType(n.vl.get(i).t, n.vl.get(i).i.s);
			n.vl.get(i).accept(this);
			
			if(_class.variables.contains(_var.getName()))
				errorList.add("Variavel " +_var.getName() + " duplicada na classe " + _class.getName() + "\nlinha " + n.vl.get(i).line_number);
			else 
				_class.variables.put(_var.getName(), _var);
		}
		
		for(int i = 0; i < n.ml.size(); i++) {
			MethodType _met = new MethodType(n.ml.get(i).t, n.ml.get(i).i.s);
			n.ml.get(i).accept(this);
			
			if(_class.methods.contains(_met.getName()))
				errorList.add("Metodo " + _met.getName() + " duplicado na classe " + _class.getName() + "\nlinha " + n.ml.get(i).line_number);
			else 
				_class.methods.put(_met.getName(), _met);
		}
	}

	@Override
	public void visit(VarDecl n) {
		n.accept(this);
	}

	@Override
	public void visit(MethodDecl n) {
		MethodType _method = new MethodType(n.t, n.i.s);
		
		
		for(int i = 0; i < n.fl.size(); i++) {
			VariableType _var = new VariableType(n.fl.get(i).t, n.fl.get(i).i.s);
			n.fl.get(i).accept(this);
			_method.argumentsTypes.add(_var.getType());
			
			if(_method.arguments.contains(_var.getName())) 
				errorList.add("Variavel " + _var.getName() + " duplicada no metodo " + _method.getName() + "\nlinha " + n.fl.get(i).line_number);
			else
				_method.arguments.put(_var.getName(), _var);
		}
		
		
		for(int i = 0; i < n.vl.size(); i++) {
			VariableType _var = new VariableType(n.vl.get(i).t, n.vl.get(i).i.s);
			n.vl.get(i).accept(this);
			
			if(_method.localVariable.contains(_var.getName())) 
				errorList.add("Variavel " + _var.getName() + " duplicada no metodo " + _method.getName() + "\nlinha " + n.vl.get(i).line_number);
			else if(_method.arguments.contains(_var.getName()))
				errorList.add("Variavel ja existe como parametro do metodo " + _method.getName() + "\nlinha" + n.vl.get(i).line_number);
			else
				_method.localVariable.put(_var.getName(), _var);
		}
	}

	@Override
	public void visit(Formal n) {
		n.accept(this);		
	}

	@Override
	public void visit(IntArrayType n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BooleanType n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntegerType n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IdentifierType n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Block n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(If n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(While n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Print n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Assign n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayAssign n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(And n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LessThan n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Plus n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Minus n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Times n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayLookup n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayLength n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Call n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntegerLiteral n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(True n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(False n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IdentifierExp n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(This n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewArray n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewObject n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Not n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Identifier n) {
		// TODO Auto-generated method stub
		
	}

}
