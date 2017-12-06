package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.function.Function;

import it.ifonz.common.ArrayConverters;

public class Day5 {

	public static void main(String[] args) {
		
		ArrayList<Integer> ints = ArrayConverters.asIntegerArrayList(args);
		
		System.out.println("part 1:"+jump(ints, (n -> n+1)));
		System.out.println("part 2:"+jump(ints, (n -> n < 3 ? n+1 : n-1)));
		
	}
	
	public static int jump(ArrayList<Integer> ints, Function<Integer, Integer> offset) {
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> clone = (ArrayList<Integer>) ints.clone(); // in order to avoid side-effects on the input
		int size = clone.size();
		int i = 0;
		int steps = 0;
		while (i >= 0 && i < size) {
			int jumps = clone.get(i);
			clone.set(i, offset.apply(jumps));
			i += jumps;
			steps++;
		} 
		return steps;
		
	}

}
