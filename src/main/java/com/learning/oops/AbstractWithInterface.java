package com.learning.oops;

public class AbstractWithInterface {

	public static void main(String[] args) {
		LivingBeing1 h=new HumanBeing("Human");
		System.out.println(h.breath());
		if(h.isSocial())
			System.out.println("Human is a social animal");
	}
}

interface LivingBeing1{
	String breath();
	boolean isSocial();
}

abstract class Animal2 implements LivingBeing1{
	public Animal2(String name) {
		System.out.println("Welcome "+name);
	}
	@Override
	public String breath() {
		// TODO Auto-generated method stub
		return "Oxygen";
	}
	
}

class HumanBeing extends Animal2{

	public HumanBeing(String name) {
		super(name);
	
	}

	@Override
	public boolean isSocial() {
		// TODO Auto-generated method stub
		return true;
	}
	
}