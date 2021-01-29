package com.learning.innerclass;

/**
 * 
 * @author Krishnan
 *Non static nested class are known as inner class.
 */
public class MemberInnerClass {

	public static void main(String[] args) {
		MemberOuter outer=new MemberOuter();
		MemberOuter.MemberInner inner=outer.new MemberInner();
		inner.msg();
		inner.test();
	}
}

/**
 * 
 * @author Krishnan
 * 
 *  Member inner class is defined inside the class out side the method. Internally compiler converts the inner class as $Outer.$Inner
 *  (i.e) MemberOuter$MemberInner.class. Since the inner class has reference to outer class, 
 *  it can access data members as well as methods of outer class 
 *  even though it is private. If Inner class & outer class has same method signature then when we call that method from inner class
 *  it will point to inner class method.
 *  
 *
 */
class MemberOuter{

	private int data=5;
	void msg() {
		
	}
	
	
	void msgOuter() {
		System.out.println("Message from outer class method");
	}
	class MemberInner{
		void msg() {
			System.out.println("data is "+data);
		}

		
		void test()
		{
			System.out.println("Call to member outer class");
			msgOuter();
			System.out.println("Call to member inner class");
			msg();
		}
	}
}