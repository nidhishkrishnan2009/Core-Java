package com.learning.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		List<Integer> values=new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9,10));
		
		
	}
	
	public static List<Integer> findEvenNos(List<Integer> values)
	{
		EvenNumber e=new EvenNumber();
		values.removeIf(e);
		return values;
	}
}

class EvenNumber implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		return t%2==0;
	}
	
}