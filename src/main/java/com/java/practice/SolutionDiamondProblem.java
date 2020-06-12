package com.java.practice;


interface InterfaceA{
	public default void method() {
		System.out.println("Default Method inside InterfaceA");
	} 	
}


interface InterfaceB{
	public default void method() {
		System.out.println("Default Method inside InterfaceB");
	}	
}


public class SolutionDiamondProblem implements InterfaceA, InterfaceB{
//Incase to overide InterfaceA default method
	@Override
	public void method() {
		// TODO Auto-generated method stub
		InterfaceA.super.method();
	}

	public static void main(String[] args) {
		new SolutionDiamondProblem().method();
	}
}
