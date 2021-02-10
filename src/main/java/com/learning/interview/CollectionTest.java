package com.learning.interview;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Spliterator;

public class CollectionTest {
	public static void main(String[] args) {
		List<Integer> i=Collections.synchronizedList(new ArrayList<Integer>());
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(5);
		q.add(6);
		q.add(27);
		q.add(17);
		//q.add(null);
	//	q.add(null);
		q.remove();
		q.poll();
		
		List<Integer> l=new ArrayList<>();
		l.add(1);
		l.add(2);
		System.out.println(q);
		
		LinkedList<Integer> linkedList=new LinkedList<Integer>(l);
		Iterator linkedListItr=linkedList.descendingIterator();
		
//		Spliterator<Integer> splititr=linkedList.spliterator();
//		
//		splititr.forEachRemaining(System.out::println);
		
		ListIterator<Integer> itr1=linkedList.listIterator(linkedList.size());
		while(itr1.hasPrevious())
		{
			System.out.println(itr1.previous());
		}
		
		
		List<String> al=new ArrayList<String>();    
        al.add("Amit");    
        al.add("Vijay");    
        al.add("Kumar");    
        al.add("Sachin");    
        ListIterator<String> itr=al.listIterator(al.size());
        System.out.println("In forward direction");
//        while(itr.hasNext())
//        	System.out.println(itr.next());
        System.out.println("In backward direction");
        while(itr.hasPrevious()){    
            
            System.out.println("index:"+itr.previousIndex()+" value:"+itr.previous());    
            } 
        
        
	}
}
