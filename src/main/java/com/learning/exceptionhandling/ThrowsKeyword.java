package com.learning.exceptionhandling;

import java.io.IOException;

public class ThrowsKeyword {

	static void m() throws IOException
	{
		throw new IOException("device error");
	}
	public static void main(String[] args) throws IOException {
		m();
		System.out.println("rest of code");
	}
}
