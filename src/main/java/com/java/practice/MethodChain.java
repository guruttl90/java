package com.java.practice;

public class MethodChain {

	/*Method Chaining is the practice of calling different methods in a single line instead of calling different methods with the same object reference separately. 
	 * Under this procedure, 
	 * 	we have to write the object reference once and then call the methods by separating them with a (dot.).*/ 
	public static void main(String[] args) {
		Sample obj = new Sample().setAllData(1, "Guru", 34.3);		
		System.out.println(obj);
		Sample obj1 = new Sample().setA(2).setD(33.23).setS("ABC");
		System.out.println(obj1);
		Sample obj3 = new Sample().setAllData(3, "CXD", null).setD(34.3);
		System.out.println(obj3);
	}
}


class Sample{

	private int a;
	private String s;
	private Double d;
	
	
	public Sample() {		
	}

	public Sample(int a, String s, Double d) {
		super();
		this.a = a;
		this.s = s;
		this.d = d;
	}	
	
	public Sample setAllData(int a, String s, Double d) {
		this.a = a;
		this.s = s;
		this.d = d;
		return new Sample(this.a,this.s,this.d);
	}
	
	private Sample setAllData(Sample obj) {
		this.a = obj.a;
		this.s = obj.s;
		this.d = obj.d;
		return new Sample(this.a,this.s,this.d);
	}
	
	
	public int getA() {
		return a;
	}

	public Sample setA(int a) {
		this.a = a;
		return setAllData(this);
	}

	public String getS() {
		return s;
	}

	public Sample setS(String s) {
		this.s = s;
		return setAllData(this);
	}

	public Double getD() {
		return d;
	}

	public Sample setD(Double d) {
		this.d = d;
		return setAllData(this);
	}

	@Override
	public String toString() {
		return "Sample [a=" + a + ", s=" + s + ", d=" + d + "]";
	}
	
	
}
