package com.learning.us.interview;

import java.util.Arrays;

public class FindPairSumsK {
	public static void main(String[] args) {
		int[] arr=new int[] {3,7,5,8,9};
		//{3,5,7,8,9}
		int left=0;
		int right=arr.length-1;
		int target=20;
		boolean flag=false;
		while(left<right) {
			Arrays.sort(arr);
			if(arr[left]+arr[right]>target)
				right--;
			else if(arr[left]+arr[right]==target)
			{
				flag=true;
				break;
			}
			else
				left++;
		}
		
		if(flag) {
			System.out.println("Found paires");
			System.out.println(arr[left]+" "+arr[right]);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
}
