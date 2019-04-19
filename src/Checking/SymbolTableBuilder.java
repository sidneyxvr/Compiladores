package Checking;

import java.util.*;

import AST.*;
import AST.Visitor.Visitor;

public class SymbolTableBuilder implements Visitor {

	public Vector<String> errorList;
	public SymbolTable symbolTable;

	Class auxClass;
	Method auxMethod;

	public SymbolTableBuilder() {
		symbolTable = new SymbolTable();
		errorList = new Vector<String>();
	}

	/* Used in assignments comparison, return methods and etc. */
	public boolean compareTypes(Type type1, Type type2) {
		if (type1 == null || type2 == null)
			return false;

		if (type1 instanceof BooleanType && type2 instanceof BooleanType)
			return true;

		if (type1 instanceof IntegerType && type2 instanceof IntegerType)
			return true;

		if (type1 instanceof IntArrayType && type2 instanceof IntArrayType)
			return true;

		/* In case the type is a class  */
		if (type1 instanceof IdentifierType && type2 instanceof IdentifierType) {
			IdentifierType t1 = (IdentifierType) type1;
			IdentifierType t2 = (IdentifierType) type2;

			if (t1.s.equals(t2.s))
				return true;

			/*
			 * Checks classes bases Identifier to know if the types
			 * are compatible
			 */
			Class aux = (Class)symbolTable.getClass(t2.s);   
			while (aux != null) {
				if (t1.s.equals(aux.getName()))
					return true;

				aux = (Class)symbolTable.getClass(aux.getFatherName());
			}
		}

		return false;
	}
	
	public void printTable()
	{
		symbolTable.printSymbolTable();
	}
	
	@Override
	public void visit(Display n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Program n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MainClass n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclSimple n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclExtends n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDecl n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MethodDecl n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Formal n) {
		// TODO Auto-generated method stub
		
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
