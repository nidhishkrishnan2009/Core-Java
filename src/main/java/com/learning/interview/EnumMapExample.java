package com.learning.interview;

import java.util.HashMap;
import java.util.Map;

public class EnumMapExample {

	public enum DAYS{
		MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
	}
	
	public static void main(String[] args) {
		Map<DAYS, Integer> map=new HashMap<EnumMapExample.DAYS, Integer>();
		map.put(DAYS.MONDAY, 1);
		map.forEach((k,v)->{
			System.out.println("Key is -->"+k);
			System.out.println("Value is -->"+v);
		});
	}
}
