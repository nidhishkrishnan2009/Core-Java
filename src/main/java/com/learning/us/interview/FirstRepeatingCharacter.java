package com.learning.us.interview;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacter {
	public static void main(String[] args) {
		String s="responsible";
		System.out.println(firstRepeatingCharacter(s));;
	}
	
	 public static char firstRepeatingCharacter(String str){
		 
			Set<Character> set=new HashSet<>();
			char[] arr=str.toCharArray();
			char result='\0';
			for(int i=0;i<arr.length;i++) {
				char data=arr[i];
				if(set.contains(data))
				{
					result=data;
					break;
				}
				set.add(data);
			}
		 return result;
	    }
}
