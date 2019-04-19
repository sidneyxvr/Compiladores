package Code;

import java.io.*;

import AST.*;
import AST.Visitor.Visitor;
import Checking.SymbolTable;

public class CodeGenerator implements Visitor {

	public SymbolTable tableGC;
	
	String codeAsm;
	File codeAssembly;
	FileWriter fwCodeAsm;
	BufferedWriter bwCodeAsm;
	
	public CodeGenerator()
	{
		tableGC = new SymbolTable();
		codeAsm = new String();
	}
	
	public void generatingCodeFile(String code) throws Exception
	{
		codeAssembly = new File("CodeAsmGenerated.s");
		
		fwCodeAsm = new FileWriter(codeAssembly);
		bwCodeAsm = new BufferedWriter(fwCodeAsm);
		bwCodeAsm.write(code);
		
		bwCodeAsm.close();
		fwCodeAsm.close();
	}
	
	@Override
	public void visit(Display n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Program n)
	{	
		codeAsm = "#Code Assembly Generated\n\n";
		codeAsm = codeAsm + "\t.text\n";
		codeAsm = codeAsm + "\t.global asm_main		#label for Main program\n\n";
		codeAsm = codeAsm + "#Main function\n";
		codeAsm = codeAsm + "asm_main:\n";
		
		codeAsm = codeAsm + "\tpushl	%ebp		# prologue - save frame ptr\n";
		codeAsm = codeAsm + "\tmovl	%esp,%ebp		# no local vars - no additional stack\n\n";
		
		n.m.accept(this);

		for(int i = 0; i < n.cl.size(); i++)
		{ 
			n.cl.get(i).accept(this);	
		}
		
		/* Escrevendo o Epilogo */
		codeAsm = codeAsm + "\n\tmovl	%ebp,%esp	# epilogue - return\n";
		codeAsm = codeAsm + "\tpopl	%ebp\n";
		codeAsm = codeAsm + "\tret\n";
		
		/* Escrevendo a String do código no arquivo .s */
		try{
			//System.out.println(codigoAsm);
			generatingCodeFile(codeAsm);
		}catch (Exception e) {
			// TODO: handle exception
		}
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
