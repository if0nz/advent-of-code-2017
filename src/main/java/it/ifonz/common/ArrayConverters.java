package it.ifonz.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayConverters {
  
	public static Integer[] asIntegerArray(String[] strings) {
		Integer[] ints = new Integer[strings.length];
		Arrays.stream(strings).map(s->Integer.valueOf(s)).collect(Collectors.toList()).toArray(ints);
		return ints;
	}
	
}
