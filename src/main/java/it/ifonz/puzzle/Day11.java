package it.ifonz.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Day11 {

	private static HashMap<String, long[]> hops;

	// recommended reading:
	// http://keekerdc.com/2011/03/hexagon-grids-coordinate-systems-and-distance-calculations/

	// movement rules
	static {
		hops = new HashMap<>();
		hops.put("n", new long[] { -1, 0, 1 });
		hops.put("ne", new long[] { -1, 1, 0 });
		hops.put("se", new long[] { 0, 1, -1 });
		hops.put("s", new long[] { 1, 0, -1 });
		hops.put("sw", new long[] { 1, -1, 0 });
		hops.put("nw", new long[] { 0, -1, 1 });
	}

	public static void main(String[] args) {

		System.out.println("part 1: " + part1(args[0]));
		System.out.println("part 2: " + part2(args[0]));

	}

	public static long part1(String movements) {

		return Arrays.stream(Arrays.stream(movements.split(",")) // read the input
				.map(m -> hops.get(m)) // map into movement rules
				.reduce(new long[] { 0, 0, 0 }, // begins from grid's origin
						(a, b) -> IntStream.range(0, 3) // for i = 0 to 2
								.mapToLong(i -> a[i] + b[i]) // update coord i according to its movement rule
								.toArray() // wrap the 3 coords into the accumulation array
		)).max().getAsLong(); // get the distance from the origin

	}

	public static long part2(String movements) {

		AtomicLong maxDist = new AtomicLong(0); // trolling lambda's scope
		
		Arrays.stream(movements.split(",")).map(m -> hops.get(m)).reduce(new long[] { 0, 0, 0 }, (a, b) -> { // I'm using the accumulator as the current position
			long[] array = IntStream.range(0, 3).mapToLong(i -> a[i] + b[i]).toArray();
			maxDist.set(Math.max(maxDist.get(), Arrays.stream(array).max().getAsLong())); // compare max distance to current distance
			return array; // update the accumulator
		});

		return maxDist.get();
		
	}

}
