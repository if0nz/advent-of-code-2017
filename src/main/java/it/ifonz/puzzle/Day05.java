package it.ifonz.puzzle;

import java.util.function.Function;

import it.ifonz.common.ArrayConverters;

public class Day05 {

	public static void main(String[] args) {
		
		Integer[] ints = ArrayConverters.asIntegerArray(args);
		
		System.out.println("part 1:"+part1(ints));
		System.out.println("part 2:"+part2(ints));
		
	}
	
	public static int part1(Integer[] ints) {
		return jump(ints, (n -> n+1));
	}
	
	public static int part2(Integer[] ints) {
		return jump(ints, (n -> n < 3 ? n+1 : n-1));
	}
	
	private static int jump(Integer[] ints, Function<Integer, Integer> offset) {
		
		Integer[] clone = ints.clone(); // in order to avoid side-effects on the input
		int size = clone.length;
		int i = 0;
		int steps = 0;
		while (i < size) {
			int jumps = clone[i];
			clone[i]=offset.apply(jumps); // applying jumps to the offest function
			i += jumps;
			steps++;
		} 
		return steps;
		
	}

}
