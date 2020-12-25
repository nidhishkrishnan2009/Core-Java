package com.learning.oops;

public class AbstractClass {
	public static void main(String[] args) {
		Animal a=new Dog();
		System.out.println(a.name());
		System.out.println(a.eat());
	}
}

abstract class Animal
{
	public Animal()
	{
		System.out.println("Welcome to Jungle");
	}
	abstract String name();
	String eat() {
		return "Eating";
	}
}

class Dog extends Animal
{

	@Override
	String name() {
		// TODO Auto-generated method stub
		return "This is Dog";
	}

	
}