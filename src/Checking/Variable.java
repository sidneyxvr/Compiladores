package Checking;

import AST.Type;

public class Variable {
	String name;
	Type type;
	
	public Variable(Type type, String name)
	{
		this.type = type;
		this.name = name;
	}
	
	public void print() {
		System.out.println(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
}
