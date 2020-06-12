package com.java.practice;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyThread extends Thread{
	private static final Logger log = LoggerFactory.getLogger(MyThread.class);
	private Semaphore sem;
	private String threadName;
	
	public MyThread(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem; 
        this.threadName = threadName;
	}

	@Override
	public void run() {
		if(this.getName().equals("A")) {
			log.info("Starting " + threadName);			
			try {
				log.info(threadName + " is waiting for a permit.");
				sem.acquire();
				log.info(threadName + " gets a permit.");
				
				for(int i=0; i < 5; i++) {
					SemaphoreDemo.count++;
					log.info(threadName + ": " + SemaphoreDemo.count);
					Thread.sleep(10);
				}
				
				
			} catch (InterruptedException e) {				
				log.error("Error : "+e.getMessage());
			}
			log.info(threadName + " releases the permit."); 
            sem.release(); 
		}else {
			log.info("Starting " + threadName);
			try {
				log.info(threadName + " is waiting for a permit.");
				sem.acquire();
				log.info(threadName + " gets a permit.");
				
				for(int i=0; i < 5; i++) {
					SemaphoreDemo.count--;
					log.info(threadName + ": " + SemaphoreDemo.count);
					Thread.sleep(10);
				}
				
				
			} catch (InterruptedException e) {				
				log.error("Error : "+e.getMessage());
			}
			log.info(threadName + " releases the permit."); 
            sem.release(); 
			
		}
		
	}
	
	
	
}

public class SemaphoreDemo {
	private static final Logger log = LoggerFactory.getLogger(SemaphoreDemo.class);
	static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(1);
		MyThread mt1 = new MyThread(sem, "A");
		MyThread mt2 = new MyThread(sem, "B");
		mt1.start();
		mt2.start();
		mt1.join(); 
        mt2.join();
        log.info("count: " + SemaphoreDemo.count); 
	}
	
}

/*
 * A semaphore controls access to a shared resource through the use of a counter. 
 * If the counter is greater than zero, then access is allowed. If it is zero, then access is denied. 
 * What the counter is counting are permits that allow access to the shared resource. 
 * Thus, to access the resource, a thread must be granted a permit from the semaphore.

						Working of semaphore

	In general, to use a semaphore, the thread that wants access to the shared resource tries to acquire a permit.


If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the semaphore’s count to be decremented.
Otherwise, the thread will be blocked until a permit can be acquired.
When the thread no longer needs an access to the shared resource, it releases the permit, which causes the semaphore’s count to be incremented.
If there is another thread waiting for a permit, then that thread will acquire a permit at that time.
Java provide Semaphore class in java.util.concurrent package that implements this mechanism, 

so you don’t have to implement your own semaphores.

*Refer:
*
*	https://www.geeksforgeeks.org/semaphore-in-java/
*/
