package com.learning.interview;

import java.util.Set;

public class EnumSet {
 enum months{
	 JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER
 }
 
 public static void main(String[] args) {
	 Set<months> monthSet=java.util.EnumSet.allOf(months.class);
	 System.out.println("Set using all of  "+monthSet);
	 Set<months> monthSetOf=java.util.EnumSet.of(months.JANUARY,months.FEBRUARY);
	 System.out.println("monthSetOf "+monthSetOf);
	 Set<months> monthSetRange=java.util.EnumSet.range(months.MARCH, months.JUNE);
	 System.out.println("monthSetRange "+monthSetRange);
}
}
