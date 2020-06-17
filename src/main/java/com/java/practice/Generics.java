package com.java.practice;

public class Generics {

	public void test() {
		new Type().callGenerics();
		
	}
	public static void main(String[] args) {
		new Generics().test();
	}
	
}


class Type{
	
	private String name;
	private String password;
			
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "Type [name=" + name + ", password=" + password + "]";
	}

	public void callGenerics() {
		String s= "Generic Class Hold String type data";
		GenericClass<String> genericHoldString = new GenericClass<>();
		genericHoldString.setObj(s);
		System.out.println(" "+genericHoldString.toString());
		
		Integer i = 10;
		GenericClass<Integer> genericHoldInteger = new GenericClass<>();
		genericHoldInteger.setObj(i);
		System.out.println(" "+genericHoldInteger.toString());
		
		Type obj = new Type();
		obj.setName("Don");
		obj.setPassword("DonDon");
		GenericClass<Type> genericHoldType = new GenericClass<>();
		genericHoldType.setObj(obj);
		System.out.println(" "+genericHoldType.toString());
		
		
	}
	
}


class GenericClass<T>{
	
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "GenericClass [obj=" + obj + "]";
	}

}




/*
 
 // To create an instance of generic class 
BaseType <Type> obj = new BaseType <Type>()

Note: In Parameter type we can not use primitives like 
      'int','char' or 'double'.
 
  
  */
 


