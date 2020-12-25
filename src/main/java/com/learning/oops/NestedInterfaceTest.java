package com.learning.oops;

public class NestedInterfaceTest {
	public static void main(String[] args) {
		I1.I2 d=new D();
		d.msg();
		C.I3 c=new E();
		c.msgI3();
	}
}

interface I1{
void test();
interface I2{
	void msg();
}
}

class C{
	void test()
	{
		System.out.println("testing");
	}
	
	interface I3{
		void msgI3();
	}
}

class D implements I1.I2{

	@Override
	public void msg() {
		System.out.println("hai from I2");
		
	}
	
}

class E implements C.I3{

	@Override
	public void msgI3() {
		System.out.println("hai from I3");
		
	}
	
}