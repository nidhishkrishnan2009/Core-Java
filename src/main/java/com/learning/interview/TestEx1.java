package com.learning.interview;

public class TestEx1 {
	public static void main(String[] args) {
		int[] a= {5,2,4,6,7};
		int maxDiff=0;
		int minValue=a[0]>a[1]?a[0]:a[1];
		for(int i=0;i<a.length;i++)
		{
			int j=i;
			while(j>0)
			{
				int diff=a[i]-a[j];
				if(diff>maxDiff)
					maxDiff=diff;
				j--;
			}
		}
		
		System.out.println("Max diff ====>"+maxDiff);
	}
}
