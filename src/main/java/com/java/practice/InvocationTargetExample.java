package com.java.practice;

public class InvocationTargetExample {

	public int divideByZeroExample() {
        return 1 / 0;
    }
	
	
	public static void main(String[] args) {
		InvocationTargetExample obj = new InvocationTargetExample();
		obj.divideByZeroExample();
	}
}

/*
 * Refer:
 * 	https://www.baeldung.com/java-lang-reflect-invocationtargetexception
 * */
 