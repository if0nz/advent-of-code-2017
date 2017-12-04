package it.ifonz.puzzle;

public class Day1 {

	public static void main(String[] args) {
		
		// same input for both parts
		char[] input = args[0].toCharArray();
		
		System.out.println("part 1 "+sumIfSameDigitForward(input, 1));
		System.out.println("part 2 "+sumIfSameDigitForward(input, input.length/2));
		
	}

	private static int sumIfSameDigitForward(char[] charArray, int steps) {
		
		// init returning sum. if no digit matches the requirements, then the resulting sum will be 0
		int sum = 0;
		int length = charArray.length;
		
		for (int i = 0; i < length; i++) {
			
			char digit = charArray[i];
			// % operator allows us to access the array in a circular fashion
			// hypotesis: every char in the array is in [0-9] range
			if (digit == charArray[(i+steps)%length]) sum+=(digit-48);
			
		}
		
		return sum;
		
	}
	
}
