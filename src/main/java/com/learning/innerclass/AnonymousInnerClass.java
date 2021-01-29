package com.learning.innerclass;

/**
 * 
 * @author Krishnan
 *Anonymous class name is decided by compiler. It extends abstract class or implements interface.
 */
public class AnonymousInnerClass {	
	public static void main(String[] args) {
		Person p=new Person() {

			@Override
			void eat() {
				System.out.println("I have started eating");
				
			}
			
		};
		
		DiningRoom r=new DiningRoom() {
			
			@Override
			public void welcomRoom() {
				System.out.println("Welcome to dining room");
				
			}
		};
		
		p.eat();
		r.welcomRoom();
	}
}


abstract class Person{
	abstract void eat();
}

interface DiningRoom{
	void welcomRoom();
}