package com.learning.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionTest {
public static void main(String[] args) {
	try {
		
		throw new RuntimeException("Test");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}
