package com.learning.lambda;

import java.util.ArrayList;
import java.util.List;

public class CustomFunctionalInterface {
public static void main(String[] args) {
	List<Integer> nos=new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9,10));
	GreaterThan g=d->d>5;
	nos.removeIf(g::apply);
	System.out.println(nos);
}

}

@FunctionalInterface
interface GreaterThan{
	boolean apply(int t);
}