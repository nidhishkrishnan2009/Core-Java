package com.learning.string;

public class StringMethodsExamples {
public static void main(String[] args) {
	String s1="Hello Naija how are you?";
	//Contains
	System.out.println(s1.contains("Naija how are you"));
	System.out.println(s1.contains("is"));
	
	//EndsWith
	System.out.println(s1.endsWith("?"));
	System.out.println(s1.endsWith("you?"));
	System.out.println(s1.endsWith("are"));
	
	// equals method compares the content of String
	String s2="test";
	String s3=new String("test");
	System.out.println(s2.equals(s3));
	
	//String format
	System.out.println(String.format("Age is %d",29));
	System.out.println(String.format("Name is %s", "Naija"));
	System.out.println(String.format("Weight is %f",39.45678923));
	System.out.println(String.format("Weight is %30f",39.45678923));
	System.out.println(String.format("Weight is %2.4f",39.45));
	System.out.println(String.format("Sex is %c", 'M'));
	System.out.println(String.format("|%10d|", 101));
	System.out.println(String.format("|%-10d|", 101));
	System.out.println(String.format("|%010d|", 101));
	
	//getChars
	
	String s4="Hi Testing";
	char[] c1=new char[s4.length()];
	s4.getChars(0, s4.length(), c1, 0);
	System.out.println(c1);
	
	//index of
	System.out.println(s4.indexOf("i"));
	System.out.println(s4.indexOf("i", 3));
	
	//isEmpty
	String s5="";
	System.out.println(s5.isEmpty());
	
	//IsBlank from java 11 onwards
	String s6=" ";
	System.out.println(s6.isEmpty());
	System.out.println(s6.isBlank());
	
	//Join from java 8 onwards
	
	String[] s7=new String[] {"java","T","Point"};
	System.out.println(String.join("-", s7));
}

}
