package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.ifonz.common.ArrayConverters;

public class Day10 {

	private static int currentPosition;
	private static int skipSize;
	private static Integer[] suffix = {17,31,73,47,23};
	public static void main(String[] args) {

		System.out.println("part 1: "+part1(args[0], 256));
		System.out.println("part 2: "+part2(args[0], 256));
		
	}

	public static int part1(String args, int listSize) {
		int[] ints = init(listSize);
		List<Integer> lengths = Arrays.asList(ArrayConverters.asIntegerArray(args.split(",")));
		singleRound(lengths, ints);
		return ints[0] * ints[1];
	}

	public static String part2(String args, int listSize) {
		List<Integer> lengths = args.chars().boxed().collect(Collectors.toList());
		lengths.addAll(Arrays.asList(suffix));
		int[] ints = init(listSize);
		IntStream.range(0, 64).forEach(round ->	singleRound(lengths, ints));
		StringBuilder sb = new StringBuilder();
		// for each 16-char length block
		IntStream.range(0, 16).forEach(i -> 
			{
				// XOR EVERYTHING!
				String hexString = Integer.toHexString(Arrays.stream(Arrays.copyOfRange(ints, i * 16, (i + 1) * 16)).reduce(0, (a, b) -> a ^ b));
				
				// eventually pad the resulting hex string with a leading 0
				sb.append(hexString.length() > 1 ? hexString : "0"+hexString);
			}
		);
		
		return sb.toString();
	}

	private static int[] init(int listSize) {
		int[] ints = IntStream.range(0, listSize).toArray();
		currentPosition = 0;
		skipSize = 0;
		return ints;
	}
	
	private static void singleRound(List<Integer> lengths, int[] ints) {
		
		lengths.forEach(l-> {
			
			List<Integer> subList = new ArrayList<>();
			
			// extracting the sublist to reverse
			IntStream.range(currentPosition, currentPosition + l).forEach(i ->
				subList.add(ints[i% ints.length])
			);
			
			Collections.reverse(subList);
			
			// put the sublist back in the main list
			IntStream.range(0,subList.size()).forEach(i->
				ints[(currentPosition + i) % ints.length] = subList.get(i)
			);
			currentPosition += (l + (skipSize++));
			
		});
		
	}

}
