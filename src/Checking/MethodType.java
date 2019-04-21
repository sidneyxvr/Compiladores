package Checking;

import java.util.Hashtable;
import java.util.Vector;

import AST.Type;

public class MethodType {
	private String name;
	private Type type;
	
	Hashtable<String, VariableType> arguments;
	Hashtable<String, VariableType> localVariable;
	
	/* Used in type checking to verify if the method is called with the types of the arguments correct */
	Vector<Type> argumentsTypes;
	
	public MethodType(Type type, String name)
	{
		this.name = name;
		this.type = type;
		arguments = new Hashtable<String, VariableType>();
		localVariable = new Hashtable<String, VariableType>();
		argumentsTypes = new Vector<Type>();
	}
	
	public Hashtable<String, VariableType> getArguments() {
		return arguments;
	}
	
	public Vector<Type> getArgumentsTypes() {
		return argumentsTypes;
	}
	
	public Hashtable<String, VariableType> getLocalVariable() {
		return localVariable;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setArguments(Hashtable<String, VariableType> arguments) {
		this.arguments = arguments;
	}
	
	public void setArgumentsTypes(Vector<Type> argumentsTypes) {
		this.argumentsTypes = argumentsTypes;
	}
	
	public void setLocalVariable(Hashtable<String, VariableType> localVariable) {
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
		for(VariableType aux: arguments.values())
		{
			aux.print();
		}
		
		System.out.println("--- Local Variables ---");
		for(VariableType aux: localVariable.values())
		{
			aux.print();
		}
	}
}
