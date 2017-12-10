package it.ifonz.puzzle;

import java.util.stream.IntStream;

public class Day1 {

	public static void main(String[] args) {
		
		System.out.println("part 1 "+sumIfSameDigitForward(args[0], 1));
		System.out.println("part 2 "+sumIfSameDigitForward(args[0], args[0].length()/2));
		
	}

	public static long sumIfSameDigitForward(String input, int steps) {
		
		char[] charArray = input.toCharArray();
		int length = charArray.length;
		
		return IntStream.range(0, length).mapToLong(i -> {
			
			char digit = charArray[i];
			// % operator allows us to access the array in a circular fashion
			// hypotesis: every char in the array is in [0-9] range
			return (digit == charArray[(i+steps)%length]) ? (digit-48) : 0;
			
		}).sum();
		
	}
	
}
