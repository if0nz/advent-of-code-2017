package it.ifonz.puzzle;

public class Day3 {

	public static void main(String[] args) {
		
		long input = Long.valueOf(args[0]);
		
		System.out.println("part 1:"+part1(input));
		System.out.println("part 2:"+part2(input));
		
	}

	// test fails if the algoritm will attempt to get a value outside the spiral or it will attempt to sum the generating value to itself
	private static boolean boundaryTest(int size, int horizontal, int vertical, int x, int y) {
		return !((x==0 && y==0) || horizontal+x < 0 || horizontal+x >= size || vertical+y < 0 || vertical+y > size-1);
	}
	
	public static int part1(long input) {
		/*
		 * P1 can be solved with a close-form expression!
		 * one can easily check that a spiral full round creates a square which sides' lenght is an odd number
		 * thus we can find on which layer our input is by solving the following equation
		 * (2n+1)^2 = input
		 * n = ceil((sqrt(input)-1)/2) (without loss of generality, we just need the positive value from sqrt)
		 */
		
		if (input == 1) return 0; // spiral's center
		
		int n = (int) Math.ceil((Math.sqrt(input)-1)/2);
		
		// init: n is is the distance from the layer to its parallel axis
		int distanceP1 = n; 
		
		// now we have to perform the distance from the poinr to the other axis
		// it's the layer's starting point
		long startingPoint = (long) Math.pow(2*n-1, 2);
		
		// calculating the side: 0 = right; 1 = up; 2 = left; 3 = down
		// recall: spiral outer layer's size == n
		int k = (int)Math.ceil((input-startingPoint)/(2*n));
		
		// set the starting point on the right side
		startingPoint += 2*k*n;
		
		// calculating the distance from the side's center
		distanceP1+= Math.abs(input-(startingPoint+n));
		
		/* one can easily reverse the algorithm to retrieve the following close-form expression :
		 * ((long) Math.ceil((Math.sqrt(input)-1)/2)) +  Math.abs(input-(((long) Math.pow(2*n-1, 2))+2*k*((long) Math.ceil((Math.sqrt(input)-1)/2))+((long) Math.ceil((Math.sqrt(input)-1)/2))));
		 */
		return distanceP1;
		
	}
	
	public static long part2(long input) {
		// I wasn't able to find any close-form expression for P2, but this sequence is stored in OEIS :P
		
		int n = (int) Math.ceil((Math.sqrt(input)-1)/2);
		
		// estimated spiral's size
		int size=2*n+1;
		
		long[][] spiral = new long[size][size];
		
		// spiral init
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				spiral[i][j] = 0;
			}
		}
		
		// the center is out starting point
		spiral[n][n] = 1;
		
		int direction = 0;
		int horizontal = n;
		int vertical = horizontal;
		int steps = 1;
		while (spiral[horizontal][vertical] <= input) {
			for (int i = 0; i < 2 && spiral[horizontal][vertical] <= input; i++) {
				for (int j = 0; j < steps && spiral[horizontal][vertical] <= input; j++) {
					switch (direction%4) {
						case 0: {++horizontal; break;} // go right
						case 1: {--vertical; break;} // go up
						case 2: {--horizontal; break;} // go left
						case 3: {++vertical;break;} // go down
					}
					// generate new value
					for (int x=-1;x<=1;x++) {
						for (int y=-1;y<=1;y++) {
							spiral[horizontal][vertical] += (boundaryTest(size, horizontal, vertical, x, y) ? spiral[horizontal+x][vertical+y] : 0);
						}
					}
				}
				direction++;
			}
			steps++;
		}
		
		return spiral[horizontal][vertical];
		
	}

}
