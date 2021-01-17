package com.learning.interview;

import java.util.ArrayList;
import java.util.List;

public class ArraysTest {
public static void main(String[] args) {
	ArrayList<Integer> a= new ArrayList<Integer>(List.of(8,9,5,6,4));
	System.out.println(a);
	a.remove(3);
	System.out.println(a);
}
}
