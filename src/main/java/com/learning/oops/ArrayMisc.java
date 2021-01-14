package com.learning.oops;

public class ArrayMisc {
public static void main(String[] args) {
	ArrayCopy a=new ArrayCopy();
	a.copyArray();
	
	System.out.println("Matrix Addition");
	MatrixAddition m=new MatrixAddition();
	m.calculateSum();
	m.display();
}
}

class ArrayCopy{
	char[] c= {'a','b','c','o','f','f','e','e','x','y','z'};
	char[] toCopy=new char[7];
	void copyArray(){
		System.arraycopy(c, 2, toCopy, 0, 6);
		System.out.println(String.valueOf(toCopy));
	}
}

class MatrixAddition{
	int[][] a= {{1,2,3},{4,5,6}};
	int[][] b= {{7,8,9},{10,11,12}};
	int[][] result=new int[2][3];
	
	void calculateSum() {
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				result[i][j]=a[i][j]+b[i][j];
				
			}
		}
	}
	
	void display(){
		
		for(int k=0;k<result.length;k++)
		{
			System.out.println();
			for(int l=0;l<result[k].length;l++)
			{
				System.out.print(result[k][l]+" ");
			}
		}
	
	}
	
} 