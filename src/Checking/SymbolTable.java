package Checking;

import java.util.Hashtable;

public class SymbolTable {
	
	
	public Hashtable<String, Object> table;
	
	public SymbolTable()
	{
		table = new Hashtable<String, Object>();
	}
	
	public void printSymbolTable() {
		System.out.println("----------- Symbol Table ------------");
		System.out.println("-------------- Classes --------------");
		for (Object aux : table.values()) {
			System.out.println(aux.getClass());
		}
	}

	public boolean addClass(Object object){
		if(table.contains(object.getClass()))
		{
			return false;
		}
		table.put(object.getClass().toString(), object);
		return true;
	}
	
	public Object getClass(String className) {
		if (table.containsKey(className)) {
			return table.get(className);
		}
		return null;
	}
	
	public Method getMethod(String methodName, Class classAux) {
		if (classAux.methods.containsKey(methodName))
			return classAux.methods.get(methodName);
		return null;
	}
}
