package com.learning.interview;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListImpl {
	public static void main(String[] args) {
		//List<String>
		Object[] arr=new Object[0];
		System.out.println(arr);
		CopyOnWriteArrayList<String> c=new CopyOnWriteArrayList<String>();
		c.add("s");
		System.out.println(c);
		Iterator<String> itr=c.iterator();
		System.out.println(c.size());
		for(int i=0;i<c.size();i++)
		{
			System.out.println("Current size ==>"+c.size());
			System.out.println(c.get(i));
			c.add("s1");
		}
	}
}
