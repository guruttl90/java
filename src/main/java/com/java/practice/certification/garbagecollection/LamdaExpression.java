package com.java.practice.certification.garbagecollection;

import java.lang.annotation.Annotation;

/**Reason for lambda expression <br>, 
	<ol><li>Start functional programming in java</li>
	<li>Anonymous function that doesnot have a name and doesn't belong to any class</li>
	<li>Clear and concise way to represent a method interface via an expression</li>
	<li>Provides implementation of a functional interface & simplifies the software development</li></ol><br>
Syntax<br>
	 parameter -> expression body<br>		
Characteristics
  
  	<ol><li>-> Optional Type declarations</li>
    	<li>-> Optional Parenthesis around Parameters</li>
    	<li>-> Optional Curly Braces</li>
    	<li>-> Optional return keyword</li></ol>
 */
	
public class LamdaExpression {
	
	public static void main(String[] args) {
		//1.
		
		FunInterface obj = new Demo(); //Polymorphic statement
		obj.method();
		
		//2.
		/*Anonymous class implementation
		  No class need to implement the interface automatically create a new instance 		  		 
		 */
		
		FunInterface funObj = new FunInterface() {

			@Override
			public void method() {
				System.out.println("Creating instance Anonymously class and calling method \"method\"");				
			}
			
		};
		
		funObj.method();
		
		//3. Using lambda expression
		FunInterface funObj1 = ()->{
			System.out.println("Using lambda expression");
		};
		funObj1.method();
		
		
		//lamda expression with parameter
		SecongFunInterface sfobj = (first,second)->{
			System.out.println(String.format("first = %s and second = %s",first,second));
		};
		
		sfobj.method("one", "two");
		
		
		//lamda expression with parameter with return type
		StringOper result = (f,s)->{			
			return f+" "+s;
		};
		
		System.out.println(result.concat("Guru", "S"));
		
		
		
		//lambda expression with one arg
		OneArgFunInterface res = (one)->{return one;};
		System.out.println(res.method("Boss"));
	}
}

class Demo implements FunInterface{

	@Override
	public void method() {
		System.out.println("Inside class Demo - Override method \"method\"");
		
	}
	
}

@FunctionalInterface //Optional
interface FunInterface{
	public void method();
}


@FunctionalInterface 
interface SecongFunInterface{
	public void method(String f,String s);
}


@FunctionalInterface 
interface OneArgFunInterface{
	public String method(String f);
}



@FunctionalInterface 
interface StringOper{
	public String concat(String f,String s);
}