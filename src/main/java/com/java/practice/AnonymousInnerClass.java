package com.java.practice;
interface Age{
	int x=21;
	void getAge();
}


//Types of anonymous inner class : 
	/*Based on declaration and behavior, there are 3 types of anonymous Inner classes
		1. Anonymous Inner class that extends a class
		2. Anonymous Inner class that implements a interface
		3. Anonymous Inner class that defines inside method/constructor argument
		*/


//1. Anonymous Inner class that extends a class

/*
 * we need an immediate thread but we don’t want to create a class that extend Thread class all the time. 
 * By the help of this type of Anonymous Inner class we can define a ready thread as follows
 * */

public class AnonymousInnerClass{

	public AnonymousInnerClass() {
		
	}
	public AnonymousInnerClass(Test11 t11) {
		t11.check();
		t11.check2();
	}
	public void method1(Test11 t11) {
		t11.check();
	}
	
	public static void main(String[] args) {
		
		//No need of Classes to initiate the method inside the interface
		//
		Age age = new Age() {

			@Override
			public void getAge() {
				System.out.println(" CAlling getAge without Class implementation : "+x);
				
			}
		};
		//age.getAge();
		//System.out.println("========= "+age.getClass());
		
		System.out.println("1. Anonymous Inner class that extends a class");
		//Instead of extending the Thread class, can create ready thread
		Thread t = new Thread() {

			@Override
			public void run() {
					System.out.println("Child thread created using Thread class");			
			}
			
		};
		t.start();
		System.out.println("2. Anonymous Inner class that implements a interface");
		//Runnable interface
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("Child thread created using Runnable interface");	
				
			}
			
		};
		Thread t1 = new Thread(r);
		t1.start();
		
		System.out.println("3. Anonymous Inner class that defines inside method/constructor argument");
		
		//My own example
		//defines inside the method
		new AnonymousInnerClass().method1(new Test11(){
			@Override
			public void check() {
				System.out.println("Override the method check , using Anonymous class and callind this method inside the method1");				
			}			
		});
		
		//defines inside the constructor
		new AnonymousInnerClass(new Test11() {
			@Override
			public void check() {
				System.out.println("Override the method check , using constructor and callind this method inside the constructor of this class");
				
			}
			@Override
			public void check2() {
				System.out.println("Override the method check2 , using constructor and callind this method inside the constructor of this class");
			}
			
		});
	}
}


abstract class Test11{
	public abstract void check();
	public void check2() {
		System.out.println("inside method check2 , Test11 class");
	}
}