package com.learning.us.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStrNotRepeatingChar {
    public static void main(String[] args) {
        String str="dvdf";
        System.out.println(longestSubstringWithoutRepeating(str));;
    }
    public static int longestSubstringWithoutRepeating(String str){
        int maxLength=0;
        char[] arr=str.toCharArray();;
        int length= arr.length;
        int left=0,right=0;
        Map<Character,Integer> map=new HashMap<>();
        while(right<length){

            if(map.containsKey(arr[right]))
            {
                maxLength=Math.max(maxLength,map.size());
                left=map.get(arr[right])+1;
                right=map.get(arr[right])+1;
                map.clear();

            }
            int index=str.indexOf(arr[right],left);
            map.put(arr[right],index);
            right++;
        }
        maxLength=Math.max(maxLength,map.size());
        return maxLength;
    }
}
