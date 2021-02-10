package com.learning.interview;

import java.util.function.BiFunction;
import java.util.function.Function;

class GPS{
	private double latitude;
	private double longitude;
	public GPS(double latitude,double longitude)
	{
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public String callingMethodUsingBifunction(String msg)
	{
		return msg;
	}
	@Override
	public String toString() {
		return String.format("latitide =%f and longitude=%f", latitude,longitude);
	}
}
public class BiFunctionExample {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Double> f1=(a,b)->Math.pow(a, b);
		Function<Double, String> f2=a->"Result is --->"+a;
		String result1=f1.andThen(f2).apply(2, 4);
		System.out.println("Result ==>"+result1);
		String newResult=compute(f1, f2, 2, 5);
		System.out.println("New Result ===>"+newResult);
		Function<Double, String> genericResultfunc=(r)->"Generic Result =="+r;
		String computeResultGeneric=computeResultGeneric(f1, genericResultfunc,2 , 2);
		System.out.println("computeResultGeneric===>"+computeResultGeneric);
		Function<Double, Integer> f4=a->a.intValue();
		int computeAllGeneric=computeAllGeneric(f1, f4, 2, 6);
		System.out.println("computeAllGeneric===>"+computeAllGeneric);
		
		//Testing Factory
		BiFunction<Double, Double, GPS> computeLatitudeLongitudeResultGenericFunc=(latitude,longitude)->{
			return new GPS(latitude, longitude);
		};
		
		GPS computeLatitudeLongitudeResultGeneric=computeLatitudeLongitudeResultGeneric(computeLatitudeLongitudeResultGenericFunc,
				14.345678, 15.788945);
		
		System.out.println("computeLatitudeLongitudeResultGeneric===>"+computeLatitudeLongitudeResultGeneric.toString());
		
		
		GPS computeLatitudeLongitudeAllGeneric=computeLatitudeLongitudeAllGeneric(GPS::new, 5.666, 6.89);
		System.out.println("computeLatitudeLongitudeAllGeneric===>"+computeLatitudeLongitudeAllGeneric.toString());
	
	}
	
	
	public static <A1,A2,R extends GPS> R computeLatitudeLongitudeAllGeneric(BiFunction<A1, A2, R> func,A1 data1,A2 data2)
	{
		return func.apply(data1, data2);
	}
	
	public static <R extends GPS> R computeLatitudeLongitudeResultGeneric(BiFunction<Double, Double, R> func,
			double latitude,double longitude)
	{
		return func.apply(latitude, longitude);
	}
	
	public static String compute(BiFunction<Integer, Integer, Double> powerResult,
			Function<Double, String> stringResult,
			int data1,int data2)
	{
		return powerResult.andThen(stringResult).apply(data1, data2);
	}
	
	//Result is only Generic.
	public static <R> R computeResultGeneric(BiFunction<Integer, Integer, Double> powerResult,
			Function<Double, R> stringResult,
			int data1,int data2)
	{
		return powerResult.andThen(stringResult).apply(data1, data2);
	}
	
	//Parameters and Results all are Generic.
	public static <A1,A2,R1,R2> R2 computeAllGeneric(BiFunction<A1, A2, R1> powerResult,
			Function<R1, R2> stringResult,
			A1 data1,A2 data2)
	{
		return powerResult.andThen(stringResult).apply(data1, data2);
	}
}
