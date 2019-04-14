import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import AST.Program;
import AST.Statement;
import AST.Visitor.PrettyPrintVisitor;
import Parser.parser;
import Scanner.scanner;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        // create a scanner on the input file
			String path = "D:\\Compiladores\\cse401-minijava-starter-18sp\\SamplePrograms\\SampleMiniJavaPrograms\\BinarySearch.java";
	        ComplexSymbolFactory sf = new ComplexSymbolFactory();
	        Reader in = new BufferedReader(new FileReader(path));
	        scanner s = new scanner(in, sf);
	        parser p = new parser(s, sf);
	        Symbol root;
	    // replace p.parse() with p.debug_parse() in next line to see trace of
	    // parser shift/reduce actions during parse
	        root = p.debug_parse();
	        Program program = (Program)root.value;
	        program.accept(new PrettyPrintVisitor());
	        System.out.print("\nParsing completed"); 
	    } catch (Exception e) {
	        // yuck: some kind of error in the compiler implementation
	        // that we're not expecting (a bug!)
	        System.err.println("Unexpected internal compiler error: " + 
	                           e.toString());
	        // print out a stack dump
	        e.printStackTrace();
	    }
	}
	
}
