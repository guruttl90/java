package com.java.practice.certification.garbagecollection.classloader.one;

import java.util.ArrayList;


public class SampleOne {

	public static void main(String[] args) {
		System.out.println("Classloader of SampleOne:"+SampleOne.class.getClassLoader());	
		System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
	}
}
