package com.learning.interview;

import java.util.ArrayList;
import java.util.List;

public class ListRemovePrime {
public static void main(String[] args) {
	List<Integer> list= new ArrayList<>(List.of(1,3,5,7,8,6));
	list.removeIf(d->isPrime(d));
	System.out.println(list);
	
}
	public static boolean isPrime(int j)
	{
		boolean flag = true;
		 
		for(int k=2;k<=j/2; k++)
		{
			if(j%k==0 )
			{
				flag=false;
				break;
			}
			
			else
			{
				flag=true;
				
			}
		}
		
		return flag;
	}
}
