package com.learning.string;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		StringTokenizer str1=new StringTokenizer("Hi Myname is Khan");
		while (str1.hasMoreElements()) {
			System.out.println(str1.nextToken());
		}
		
		StringTokenizer str2=new StringTokenizer("My,name,is,sachin");
		while(str2.hasMoreElements())
		{
			System.out.println(str2.nextToken(","));
		}
		
		StringTokenizer str3=new StringTokenizer("My,name,is,Dravid", ",");
		while (str3.hasMoreElements()) {
			System.out.println(str3.nextElement());
			
		}
		
		StringTokenizer str4=new StringTokenizer("My,name,is,Dhoni", ",", true);
		while (str4.hasMoreElements()) {
			System.out.println(str4.nextToken());
			
		}
		
		StringTokenizer str5=new StringTokenizer("My,name,is,Ganguly", ",", false);
		while (str5.hasMoreElements()) {
			System.out.println(str5.nextToken());
			
		}
	}
}
