package com.learning.synchronization;

/**
 * 
 * @author Krishnan
 *When thread is in wait() or sleep() state then calling interrupt() on that thread will disturb the 
	waiting state or sleep state by throwing interrupted exception. If the exception is propagated
	then the thread will stop working or if the exception is handled thread will still works.
	Calling a thread which is not in wait() or sleep() state will not disturb it and it will work
	normally only setting the interrupted flag true
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread() {
			@Override
			public void run()
			{
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Thread stops working since the exception is propagated");
				}
				
				System.out.println("t1 is running");
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Exception is handled "+e);
				}
				System.out.println("t2 is running");
			}
		};
		
		Thread t3=new Thread() {
			public void run() {
				for(int i=1;i<6;i++)
				{
					System.out.println(i);
				}
				
			}
		};
		
		t1.start();
		//Thread stop working for t1 since exception is propogated
		t1.interrupt();
		t1.join();
		t2.start();
		//Thread continues working since exception is handled
		t2.interrupt();
		t2.join();
		t3.start();
		//Thread continues working normally even though no interrupted exception is thrown inthe absence of wait() or sleep()
		t3.interrupt();
		//Thread.sleep(2000);
		System.out.println("check t3 is interrupted "+t3.isInterrupted());
	}
}

