package com.learning.oops;

public class InterfaceClass {
	public static void main(String[] args) {
		Mammals e=new Elefant();
		final String name=e.name();
		System.out.println("Name is "+name);
		System.out.println(e.breath(name));
		System.out.println(Mammals.welcomeMessage());
	}

}


interface LivingBeing{
	String name();
}

interface Animal1 extends LivingBeing {
	
	default String breath(String name) {
		return name+"\t"+ "breath\t" +"Oxygen";
	}
}

interface Mammals extends Animal1{
	default String getType()
	{
		return "Lives in land";
	}
	
	static String welcomeMessage()
	{
		return "Welcome to the Community of Mammals";
	}
}

class Elefant implements Mammals{

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Elefant";
	}

}

