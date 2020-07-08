package com.java.practice.certification.garbagecollection;


/*Java Memory Management, with its built-in garbage collection, is one of the language's finest achievements. 
	It allows developers to create new objects without worrying explicitly about memory allocation and deallocation, 
	because the garbage collector automatically reclaims memory for reuse.*/
/*
 	Java, the programmer need not to care for all those objects which are no longer in use. 
 	Garbage collector destroys these objects.
	Garbage collector is best example of Daemon thread as it is always running in background.
	Main objective of Garbage Collector is to free heap memory by destroying unreachable objects.
 * */
public class GarbageCollectionTheoryWithExample {

	
	
	public void example1(){
		Integer i = new Integer(4);
			// the new Integer object is reachable  via the reference in 'i' 
		i = null;
		// the Integer object is no longer reachable.
		
		System.gc();
	}
	
	public static void main(String[] args) {
		
	}
}
