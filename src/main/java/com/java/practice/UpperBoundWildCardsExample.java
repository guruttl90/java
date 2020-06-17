package com.java.practice;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundWildCardsExample {
	/*
	 The question mark (?) is known as the wildcard in generic programming . 
	 It represents an unknown type. 
	 The wildcard can be used in a variety of situations such as the 
	 		type of a parameter, 
	 		field, or 
	 		local variable; 
	 	sometimes as a return type. 
	 Unlike arrays, different instantiations of a generic type are not compatible with each other, not even explicitly. 
	 This incompatibility may be softened by the wildcard if ? is used as an actual type parameter.

	Types of wildcards in Java:

		Upper Bounded Wildcards: 
				These wildcards can be used when you want to relax the restrictions on a variable. 
					For example, say you want to write a method that works on List < integer >, List < double >, and List < number > , 
					you can do this  using an upper bounded wildcard.
						To declare an upper-bounded wildcard, use the wildcard character (‘?’), followed by the extends keyword, followed by its upper bound.
	 
	 */
	public static void main(String[] args) {
		
		//here  Number is the immediate super class for Integer,Double,
		
		List<Integer> supportsIntegerList = new ArrayList<Integer>();
		supportsIntegerList.add(12);
		supportsIntegerList.add(13);
		supportsIntegerList.add(14);
		supportsIntegerList.add(15);
		
		List<Double> supportsDoubleList = new ArrayList<Double>();
		supportsDoubleList.add(10.3);
		supportsDoubleList.add(34.3);
		supportsDoubleList.add(33.7);
		
		List<Float> supportsFloatList = new ArrayList<Float>();
		supportsFloatList.add(47.2f);
		supportsFloatList.add(78.5f);
		supportsFloatList.add(11.3f);
		
		
		//We are going to sum all the value and store using a generic method 
		System.out.println("\t\tOutput"
				+ "\n Integer "+ sum(supportsIntegerList).doubleValue()
				+ "\n Float "+ sum(supportsDoubleList).doubleValue()
				+ "\n Double "+ sum(supportsFloatList).doubleValue());		
	}
	
	public static Number sum(List<? extends Number> valueList) {
		Double output = 0.0;
		for(Number value: valueList) {
			output = output.doubleValue() + value.doubleValue();
		}
		return output;
	}

}
