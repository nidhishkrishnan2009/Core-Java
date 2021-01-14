package com.learning.oops;

public class ArrayTest {

	public static void main(String[] args) {
		SingleDimension s=new SingleDimension();
		System.out.println("Single Dimension Array");
		for(int i:s.get())
		{
			System.out.println(i);
		}
		
		MultiDimensionalArray m=new MultiDimensionalArray();
		int mul[][]=m.get();
		System.out.println("Multi Dimensional Array");
		for(int j=0;j<mul.length;j++)
		{
			System.out.println();
			for(int k=0;k<mul[j].length;k++)
			{
				System.out.print(mul[j][k]+" ");
			}
		}
		
		JaggedArray j=new JaggedArray();
		int[][] jagg=j.get();
		System.out.println("\n\nJagged Array");
		for(int l=0;l<jagg.length;l++)
		{
			System.out.println();
			for(int n=0;n<jagg[l].length;n++)
			{
				System.out.print(jagg[l][n]+" ");
			}
		}
		
		String arrayClassName=jagg.getClass().getName();
		
		System.out.println("\n\nClass name of Array is "+arrayClassName);
			
	}
}

class SingleDimension{
	int arr[] =new int[5];
	int count=0;
	int[] get() {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=count++;
		}
		
		return arr;
	}
}

class MultiDimensionalArray{
	int arr[][]= {{1,2,3},{4,5,6}, {7,8,9}};
	int[][] get()
	{
		return arr;
	}	

}

class JaggedArray{
	int arr[][]=new int[3][];
	int count=0;
	int[][] get()
	{
		arr[0]=new int[2];
		arr[1]=new int[3];
		arr[2]=new int[4];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=count++;
			}
		}
		return arr;
	}
		
}
