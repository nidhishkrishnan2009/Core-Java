package com.learning.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public interface TestInterface2 extends TestInterface1 {

}

class T{
	public static void main(String[] args) {
		List<Integer> i=Collections.synchronizedList(new ArrayList<Integer>());
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(17);
		q.remove();
		q.poll();
		
		System.out.println(q);
	}
}
