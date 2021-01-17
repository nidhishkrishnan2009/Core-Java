package com.learning.string;

public class ImmutableClassTest {
 public static void main(String[] args) {
	Immutable i1=new Immutable(2345667);
	Immutable i2=new Immutable(567884332);
	System.out.println(i1.getAtmNumber());
	System.out.println(i2.getAtmNumber());
}
}

final class Immutable{
	 private final long atmNumber;
	 public Immutable(long atmNumber)
	 {
		 this.atmNumber=atmNumber;
	 }
	public long getAtmNumber() {
		return atmNumber;
	}
	
}
