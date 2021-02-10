package com.learning.multithreading.synchronization;

/**
 * 
 * @author Krishnan
 *Inter-thread communication is communication between synchronized resources. wait(),notify(),notifyAll()
 *methods are used for inter-thread communication. 
 *wait()- This method will release the object lock and waits for notify() or notifyAll()
 *notify()- this method will notify the the waiting threads for object lock. If more threads are waiting
 *for the object lock then one of the thread will be notified(Runnable) and later it will acquire the object lock.
 *notifyAll()- This method will notify all the threads waiting for the object lock but only one thread can acquire 
 *the object lock at a time.
 *
 *wait(),notify(),notifyAll() are methods of Object class and not Thread class.
 *
 */
public class InterThreadCommunication {

	public static void main(String[] args) {
		final Customer c=new Customer();
		Thread t1=new Thread() {
			public void run()
			{
				c.withdraw(20000);
			}
		};
		
		Thread t2=new Thread() {
			@Override
			public void run()
			{
				c.deposit(50000);
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Customer{
	int amount=10000;
	
	public synchronized void withdraw(int amount) {
		if(amount>this.amount)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.amount-=amount;
		System.out.println("Withdrawed Rs"+amount+" successfully and current balance ="+this.amount);
	}
	
	public synchronized void deposit(int amount) {
		this.amount+=amount;
		System.out.println("Deposited Rs"+amount+" into the account");
		notify();
	}
}