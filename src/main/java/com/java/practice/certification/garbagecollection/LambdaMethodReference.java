package com.java.practice.certification.garbagecollection;

@FunctionalInterface
interface Calculator{
	void operation(int num1,int num2);	
}

class Calc{
	
	public Calc() {}
	public Calc(int one,int two) {
		System.out.println("one = "+one+" two = "+two);
	}
	
	public static void add(int num1,int num2){
		System.out.println(num1+" "+" + "+num2+"  =  "+(num1+num2));
	}
	
	public void subract(int num1,int num2){
		System.out.println(num1+" "+" - "+num2+"  =  "+(num1-num2));
	}
	
	
	public static void mul(int num1,int num2){
		System.out.println(num1+" "+" * "+num2+"  =  "+(num1*num2));
	}
}
public class LambdaMethodReference {
	public static void main(String[] args) {
		
		//Clac.addSomething(10, 20);
		
		//1. Reference to a Static method
				//Refering a abstract method inside the interface to a class static method
				//By mapping  static reference to static method
		
		Calculator cRef1 = Calc::add;
		cRef1.operation(44, 44);	
		Calculator cRef2 = Calc::mul;
		cRef2.operation(10, 10);
		//2. Reference to a  non static method
				//We are going to use non static method so we need instance to access the method
		
		Calc calc = new Calc();
		Calculator cRef3 = calc::subract;		
		cRef3.operation(22,11);
		
		
		//3.Reference to a constructor
		Calculator cRef4 = Calc::new;
		cRef4.operation(2, 3);
	}
}
