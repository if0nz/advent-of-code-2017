package it.ifonz.common;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayConverters {
  
	public static ArrayList<Integer> asIntegerArrayList(String[] strings) {
		ArrayList<Integer> ints = new ArrayList<>();
		Arrays.stream(strings).forEach(s -> ints.add(Integer.valueOf(s)));
		return ints;
	}
	
}
