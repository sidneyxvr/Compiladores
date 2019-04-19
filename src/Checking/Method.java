package Checking;

import java.util.Hashtable;
import java.util.Vector;

import AST.Type;

public class Method {
	String name;
	Type type;
	
	Hashtable<String, Variable> arguments;
	Hashtable<String, Variable> localVariable;
	
	/* Used in type checking to verify if the method is called with the types of the arguments correct */
	Vector<Type> argumentsTypes;
	
	public Method(String name, Type type)
	{
		this.name = name;
		this.type = type;
		arguments = new Hashtable<String, Variable>();
		localVariable = new Hashtable<String, Variable>();
		argumentsTypes = new Vector<Type>();
	}
	
	public Hashtable<String, Variable> getArguments() {
		return arguments;
	}
	
	public Vector<Type> getArgumentsTypes() {
		return argumentsTypes;
	}
	
	public Hashtable<String, Variable> getLocalVariable() {
		return localVariable;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setArguments(Hashtable<String, Variable> arguments) {
		this.arguments = arguments;
	}
	
	public void setArgumentsTypes(Vector<Type> argumentsTypes) {
		this.argumentsTypes = argumentsTypes;
	}
	
	public void setLocalVariable(Hashtable<String, Variable> localVariable) {
		this.localVariable = localVariable;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public void printMethod()
	{
		System.out.println("*** " + name + " ***");
		
		System.out.println("--- Arguments ---");
		for(Variable aux: arguments.values())
		{
			aux.print();
		}
		
		System.out.println("--- Local Variables ---");
		for(Variable aux: localVariable.values())
		{
			aux.print();
		}
	}
}
