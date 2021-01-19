package com.learning.interview;

import java.util.ArrayList;
import java.util.List;

public enum EnumTest {

	a("APPLE"), b("BAG"), c("CAT"),NUMBER_LIST( new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

	String v;
	List<Integer> listValues;

	EnumTest(String v) {
		this.v = v;
	}

	EnumTest(List<Integer> listValues) {
		this.listValues = listValues;
	}
}
