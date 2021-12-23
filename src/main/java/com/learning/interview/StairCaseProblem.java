package com.learning.interview;

import java.util.HashSet;
import java.util.Set;

public class StairCaseProblem {

	static Set<Long> alreadyVisited=new HashSet<>();
	public static void main(String[] args) {
		System.out.println(solution(3));
		
	
	}
	
	public static long solution(long n) {
		long noOfStairs=1;
		for(int i=2;i<=n;i++)
		{
			noOfStairs+=i-1;
			
		}
		return noOfStairs;
	}
	
}
