package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

	public static void main(String[] args) {
		
		int sumP1 = 0;
		int sumP2 = 0;
		
		for (String row : args) {
			// init row
			String[] elements = row.split(",");
			List<Integer> ints = new ArrayList<Integer>();
			for (String element : elements) ints.add(Integer.valueOf(element));
			ints.sort(Integer::compare);
			int size = ints.size();
			
			// part 1
			Integer min = ints.get(0);
			Integer max = ints.get(size-1);
			sumP1+=(max-min);
			
			// part 2
			boolean found = false; // stop condition
			// outer loop iterates from min value
			for (int i = 0; i < size; i++) {
				Integer valueAtI = ints.get(i);
				// inner loop iterates from max value
				for (int j = size-1; j > i; j--) {
					Integer valueAtJ = ints.get(j);
					if (valueAtJ%valueAtI == 0) {
						sumP2+=(valueAtJ/valueAtI);
						found = true;
						break;
					}
				}
				if (found) break;
			}
			
		}
		
		System.out.println("part1 "+sumP1);
		System.out.println("part2 "+sumP2);
	}
}
