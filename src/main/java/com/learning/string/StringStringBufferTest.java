package com.learning.string;

public class StringStringBufferTest {
public static void main(String[] args) {
	// Hash code test
	String s1="Rahul";
	System.out.println("Hashcode of s1 before concat "+s1.hashCode());
	StringBuffer s2=new StringBuffer("Nidish");
	System.out.println("Hashcode of s2 before concat "+s2.hashCode());
	s1="Dravid";
	System.out.println("Hashcode of s1 after concat "+s1.hashCode());
	s2.append("Naija");
	System.out.println("Hashcode of s2 after concat "+s2.hashCode());
	
	//Performance Test
	long StringStartTime=System.currentTimeMillis();
	for(int i=0;i<10000;i++)
	{
		s1=s1+"Testing";
	}
	
	System.out.println("Time taken by String ="+(System.currentTimeMillis()-StringStartTime));
	
	long stringBufferTime=System.currentTimeMillis();
	StringBuffer strBuffer=new StringBuffer();
	for(int i=0;i<10000;i++)
	{
		strBuffer.append("testing");
	}
	
	System.out.println("Time taken by String Buffer = "+(System.currentTimeMillis()-stringBufferTime));
	long stringBuilderStartTime=System.currentTimeMillis();
	StringBuilder strBuilder=new StringBuilder();
	for(int i=0;i<10000;i++)
	{
		strBuilder.append("testing");
	}
	
	System.out.println("Time taken by String Builder = "+(System.currentTimeMillis()-stringBuilderStartTime));
}
}
