package com.java.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;



public class InvocationTargetExampleTest {

	@Test
	public void divideByZeroExample() throws Exception{
		InvocationTargetExample targetExample = new InvocationTargetExample(); 
		Method method =
		  InvocationTargetExample.class.getMethod("divideByZeroExample");
		
		Assertions.assertThrows(InvocationTargetException.class, () -> method.invoke(targetExample));
	}
}
