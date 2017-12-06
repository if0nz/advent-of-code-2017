package it.ifonz.puzzle;

import java.util.ArrayList;

import it.ifonz.common.ArrayConverters;

public class Day2 {

	public static void main(String[] args) {
		
		int sumP1 = 0;
		int sumP2 = 0;
		
		for (String row : args) {
			// init row
			ArrayList<Integer> ints = ArrayConverters.asIntegerArrayList(row.split(","));
			ints.sort(Integer::compare);
			int size = ints.size();
			
			// part 1
			sumP1+=(ints.get(size-1)-ints.get(0)); // max - min
			
			// part 2
			boolean found = false; // stop condition
			// outer loop iterates from min value
			for (int i = 0; i < size && !found; i++) {
				Integer valueAtI = ints.get(i);
				// inner loop iterates from max value
				for (int j = size-1; j > i && !found; j--) {
					Integer valueAtJ = ints.get(j);
					if (valueAtJ%valueAtI == 0) {
						sumP2+=(valueAtJ/valueAtI);
						found = true;
					}
				}
			}
			
		}
		
		System.out.println("part1 "+sumP1);
		System.out.println("part2 "+sumP2);
	}
}
