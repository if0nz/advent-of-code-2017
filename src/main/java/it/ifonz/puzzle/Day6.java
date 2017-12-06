package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.List;

import it.ifonz.common.ArrayConverters;

public class Day6 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ArrayList<Integer> input = ArrayConverters.asIntegerArrayList(args);
		List<ArrayList<Integer>> banks = new ArrayList<>();
		banks.add(input);
		int steps = -1; 
		int size = input.size();
		int indexOfLastBank = 0;
		ArrayList<Integer> toTest = input;
		while(indexOfLastBank == ++steps) { // steps == banks.size()-1
			toTest = (ArrayList<Integer>)toTest.clone();
			int max = toTest.stream().max(Integer::compareTo).get();
			int index = toTest.indexOf(max);
			toTest.set(index, 0);
			for (; max > 0; max--) {
				int circularIndex = ++index%size;
				toTest.set(circularIndex, toTest.get(circularIndex)+1);
			}
			banks.add(toTest);
			indexOfLastBank = banks.indexOf(toTest);
		}
		System.out.println("part 1: "+(steps));
		System.out.println("part 2: "+((steps)-indexOfLastBank));
	}
	
}
