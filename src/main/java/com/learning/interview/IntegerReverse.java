package com.learning.interview;

public class IntegerReverse {
public static void main(String[] args) {
	int i=345;
	StringBuilder s=new StringBuilder(String.valueOf(i));
	System.out.println(Integer.parseInt(s.reverse().toString()));
	
}

}
