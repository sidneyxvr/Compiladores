package Checking;

import java.util.Hashtable;

public class Class {

	String name;
	String fatherName;
	
	Hashtable<String, Variable> variables;
	Hashtable<String, Method> methods;
	
	public Class(String name, String fatherName)
	{
		this.name = name;
		this.fatherName = fatherName;
		variables = new Hashtable<String, Variable>();
		methods = new Hashtable<String, Method>();
	}

	public String getFatherName() {
		return fatherName;
	}
	
	public String getName() {
		return name;
	}
	
	public Hashtable<String, Method> getMethods() {
		return methods;
	}
	
	public Hashtable<String, Variable> getVariables() {
		return variables;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMethods(Hashtable<String, Method> methods) {
		this.methods = methods;
	}
	
	public void setVariables(Hashtable<String, Variable> variables) {
		this.variables = variables;
	}
	
	public void printClass()
	{
		System.out.println();
		if(fatherName == null)
			System.out.println("******* " + name + " *******");
		else
			System.out.println("******* " + name + " EXTENDS " + fatherName + " *******");
		
		System.out.println("--- Variables ---");
		for(Variable aux: variables.values())
		{
			aux.print();
		}
		
		System.out.println("--- Methods ---");
		for(Method aux: methods.values())
		{
			aux.printMethod();
		}
	}
}
