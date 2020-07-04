package com.java.practice.certification.garbagecollection;


//lambda expression is an object that can be assigned to a variable and pass around 
//lambda expression can access variables that are declared outside the lambda function body under
	//certain circumstances


//how to capture different type of variable  
	//local variable
	//instance variable
	//static variable
//and use it inside the lambda expression


public class LambdaObject {
	
	int classGlobalVar = 10;
	static int classStaticVar = 20;
	public static void main(String[] args) {
		int classMethodVar =30;
		
		SampleFunInterface sobj = (one)->{
			int lambdaLocalVariable =40;
			System.out.println("Printing the class global variable inside the labda expression "+new LambdaObject().classGlobalVar);
			System.out.println("Printing the class static variable inside the labda expression "+classStaticVar);
			System.out.println("Printing the class method variable inside the lambda expression "+classMethodVar);
			System.out.println("Printing the lambda local variable inside the lambda expression "+lambdaLocalVariable);
			return "check"+" "+one;
		};
		
		System.out.println(sobj.method("oooo"));
	}
}

@FunctionalInterface
interface SampleFunInterface{
	String method(String o);
}