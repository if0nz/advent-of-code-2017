package it.ifonz.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConverters {

	public static List<Integer> asIntegerList(String[] strings) {
		List<Integer> ints = new ArrayList<>();
		Arrays.stream(strings).forEach(s -> ints.add(Integer.valueOf(s)));
		return ints;
	}
	
}
