package com.learning.lambda;

import java.util.function.Supplier;

public class SImpleLambda {
	public static void main(String[] args) {
		test t=()->{
			System.out.println("testing");
		};
		
		t.testing();
		Supplier<String> s=()->"hello";
		System.out.println(s.get());
	}
}

@FunctionalInterface
interface test{
	public void testing();
}