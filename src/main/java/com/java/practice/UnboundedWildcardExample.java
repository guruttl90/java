package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardExample {

	private List<Integer> integerList = null;
	private List<Float> floatList = null;
	private List<SampleClassA> sampleClassAList = null;
	
	private SampleGenericClass<Integer> sampleGenericClassInteger = null;
	private SampleGenericClass<SampleClassA> sampleGenericClassSampleClassA = null;
	
	public void unboundListMethod(List<?> l) {
		System.out.println("inside unboundListMethod - UnboundedWildcardExample");
		System.out.println(l);
	}
	
	public void unboundSampleGenericClassMethod(SampleGenericClass<?> l) {
		System.out.println("inside unboundSampleGenericClassMethod - UnboundedWildcardExample");
		System.out.println(l);
	}
	
	
	public void trySample() {
		System.out.println("inside trySample");
		integerList = new ArrayList<>(Arrays.asList(1,2,3,4));		
		floatList = new ArrayList<>(Arrays.asList(1f,2f,3f,4f));
		sampleClassAList = new ArrayList<>(Arrays.asList(new SampleClassA("S1","A1"),new SampleClassA("S2","A2")));
		unboundListMethod(integerList);
		unboundListMethod(floatList);
		unboundListMethod(sampleClassAList);
		
		sampleGenericClassInteger = new SampleGenericClass<Integer>(1);
		unboundSampleGenericClassMethod(sampleGenericClassInteger);
		sampleGenericClassSampleClassA = new SampleGenericClass<SampleClassA>(new SampleClassA("S3","A3"));
		unboundSampleGenericClassMethod(sampleGenericClassSampleClassA);		
		
		
	}
	
	public static void main(String[] args) {
		new UnboundedWildcardExample().trySample();
	}
}


class SampleGenericClass<T>{
	private T obj;
	
	public SampleGenericClass(T obj) {
		this.obj = obj;		
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "SampleGenericClass [obj=" + obj + "]";
	}	
	
}

class SampleClassA{
	private String s;
	private String a;
	
	
	public SampleClassA(String s, String a) {		
		this.s = s;
		this.a = a;
	}
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return "SampleClassA [s=" + s + ", a=" + a + "]";
	}

	
}