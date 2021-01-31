package com.learning.multithreading;

public class ThreadJoinWithTimeOut {

	public static void main(String[] args) {
		joinwithtimeout();
	}
	public static void joinwithtimeout() {
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
