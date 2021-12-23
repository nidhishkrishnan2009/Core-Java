package com.learning.interview;

import java.util.Stack;

public class AngleBracketProblem {

	public static void main(String[] args) {
		String s="><<><>><<<>";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		char[] strArr=s.toCharArray();
		int openAngle=0;
		int closedAngle=0;
		Stack<Character> stack=new Stack<>();
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char c=strArr[i];
			if(strArr[i]=='<') {
				stack.push(c);
			}
			if(strArr[i]=='>' && stack.size()==0)
			{
				builder.append('<');
			}
			
			if(strArr[i]=='>' && stack.size()>0)
			{
				stack.pop();
			}
			builder.append(c);
			
		}
		
		stack.forEach(d->{
			builder.append('>');
		});
		return builder.toString();
		
	}
}
