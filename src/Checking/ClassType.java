package Checking;

import java.util.Hashtable;

public class ClassType {
	private String name;
	private String fatherName;
	
	Hashtable<String, VariableType> variables;
	Hashtable<String, MethodType> methods;
	
	public ClassType(String name, String fatherName)
	{
		this.name = name;
		this.fatherName = fatherName;
		variables = new Hashtable<String, VariableType>();
		methods = new Hashtable<String, MethodType>();
	}

	public ClassType() {}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public void printClass()
	{
		System.out.println();
		if(fatherName == null)
			System.out.println("******* " + name + " *******");
		else
			System.out.println("******* " + name + " EXTENDS " + fatherName + " *******");
		
		System.out.println("--- Variables ---");
		for(VariableType aux: variables.values())
		{
			aux.print();
		}
		
		System.out.println("--- Methods ---");
		for(MethodType aux: methods.values())
		{
			aux.printMethod();
		}
	}
}
