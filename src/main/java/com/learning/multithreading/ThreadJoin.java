package com.learning.multithreading;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {

		normaljoin();
		
	}
	
	public static void normaljoin() {
		T1 t1=new T1();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		T2 t2=new T2();
		t2.start();
		T2 t3=new T2();
		t3.start();
	}
	

}

class T2 extends Thread{

	@Override
	public void run()
	{
		Constants.CHAR_LIST.stream().forEach(d->{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d);
		});
	}
}