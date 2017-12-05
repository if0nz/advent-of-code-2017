package it.ifonz.puzzle;

import java.util.List;

import it.ifonz.common.ArrayConverters;

public class Day5 {

	public static void main(String[] args) {

		List<Integer> intsP1 = ArrayConverters.asIntegerList(args);
		List<Integer> intsP2 = ArrayConverters.asIntegerList(args);
		
		int stepsP1 = 0;
		int stepsP2 = 0;
		int i = 0;
		int j = 0;
		
		int size = intsP1.size();
		
		while (i >= 0 && i < size || j >= 0 && j < size) {
			if (i >= 0 && i < size) {
				int jumpsP1 = intsP1.get(i);
				intsP1.set(i, jumpsP1+1);
				i += jumpsP1;
				stepsP1++;
			}
			
			if (j >= 0 && j < size) {
				int jumpsP2 = intsP2.get(j);
				intsP2.set(j, jumpsP2 < 3 ? jumpsP2+1 : jumpsP2-1);
				j += jumpsP2;
				stepsP2++;
			}
		} 
		
		System.out.println("part 1:"+stepsP1);
		System.out.println("part 2:"+stepsP2);
		
	}

}
