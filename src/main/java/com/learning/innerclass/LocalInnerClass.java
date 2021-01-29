package com.learning.innerclass;
/**
 * 
 * @author Krishnan
 *Non static nested class are known as inner class.
 */
public class LocalInnerClass {

	public static void main(String[] args) {
		OuterInnerClass outer=new OuterInnerClass();
		outer.msg();
	}
}

/**
 * 
 * @author Krishnan
 *Local inner class is defined inside method body of outer class. It should be instantiated inside outer class method itself.
 *Compiler internally creates class file for Local inner class as OuterClass$1InnerClass. (i.e)OuterInnerClass$1InnerInnerClass.class.
 */
class OuterInnerClass{
	private int classdata=8;
	void helloOuterClass() {
		System.out.println("Hello from outer class");
	}
	void msg() {
		// compile time error since local method variable cannot be private/protected/public
		//private int dataTest=6;
		int data=5;
		class InnerInnerClass{
			void test() {
				System.out.println("Message for local inner class = "+data);
				System.out.println("response from outer class = "+classdata);
			helloOuterClass();
			}
		}
		InnerInnerClass i=new InnerInnerClass();
		i.test();
	}
	
	//Compile time error since local inner class cannot be instantiated outside the method.
	//InnerInnerClass i1=new InnerInnerClass();
}