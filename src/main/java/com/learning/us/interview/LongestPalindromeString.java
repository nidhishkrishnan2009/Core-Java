package com.learning.us.interview;

public class LongestPalindromeString {
    public static void main(String[] args) {
        String s="abbaaa";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String str){
        int length=0;
        int[] occurences=new int[128];
        for(char s:str.toCharArray()){
             occurences[(int) s]++;
        }
        for(int o:occurences){
            length+=o%2==0?o:o-1;
        }
        if(length<str.length())
            length++;
        return length;
    }
}
