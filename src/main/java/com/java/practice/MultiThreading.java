package com.java.practice;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThreading {
	private static final Logger log = Logger.getLogger(MultiThreading.class.getName());
	private int count = 0;
	public static void main(String[] args) {
		MultiThreading obj = new MultiThreading();
		obj.doWork();
	}
	
	public synchronized  void increment(String threadName) throws InterruptedException {
		count++;
		System.out.println("Thread in Progress: " + threadName + " and count is: " + count);
	}
	
	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						increment(Thread.currentThread().getName());
					}catch(InterruptedException e) {
						log.log(Level.SEVERE, null, e);
					}
					
				}				
			}			
		});
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {				
				for (int i = 0; i < 10; i++) {
					try {
						increment(Thread.currentThread().getName());
					}catch(InterruptedException e) {
						log.log(Level.SEVERE, null, e);
					}
				}				
			}			
		});		
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Count is: " + count);
		} 
		
	}
}
 
/*
interface Interface{
	
	public void create();
	
}
class Class1{
	private Interface obj;
	public Class1() {
		
	}	
	public Class1(Interface obj) {
		this.obj = obj;
	}
	public Interface getObj() {
		return obj;
	}	
	
}

class Class2{
	public void method() {
		Class1 obj=new Class1(new Interface() {

			@Override
			public void create() {
				System.out.println("Inside Class2 , override during object creation");
				
			}			
		});
		obj.getObj().create();
	}
	public static void main(String[] args) {
		Class2 obj = new Class2();
		obj.method();
	}
}

*/