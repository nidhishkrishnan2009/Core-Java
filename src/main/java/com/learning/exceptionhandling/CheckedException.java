package com.learning.exceptionhandling;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;


public class CheckedException {
 public static void main(String[] args)  {
	//IO Exception & SQL Exception
	 try {
		FileOutputStream out=new FileOutputStream("test");
		out.write(new String("test").getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 try {
		PrintWriter pw=new PrintWriter("Nidish");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

