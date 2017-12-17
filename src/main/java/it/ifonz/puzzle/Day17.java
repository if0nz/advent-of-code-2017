package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

	public static void main(String[] args) {

		int input = 356;
		System.out.println("part 1: " + part1(input));
		System.out.println("quasi-brute force part 2: " + part2(input));
		System.out.println("optiimzed part 2: " + part2v2(input));

	}

	public static int part1(int input) {
		List<Integer> buffer = new ArrayList<Integer>();
		buffer.add(0);
		int currPos = 0;
		for (int i = 1; i < 2018; i++) {
			currPos = (currPos + input) % buffer.size() + 1;
			buffer.add(currPos, i);
		}
		return buffer.get(currPos + 1);
	}

	// quasi-brute force
	public static int part2(int input) {
		int currPos = 0;
		int result = 0;
		for (int i = 1; i < 50000001; i++) {
			currPos = (currPos + input) % i + 1;
			if (currPos == 1)
				result = i;
		}
		return result;
	}

	// optimized algorithm as shown here:
	// https://www.reddit.com/r/adventofcode/comments/7kc0xw/2017_day_17_solutions/drd8b1n/
	// n = buffer size
	// n + fits = buffer size after +fits+ steps
	public static int part2v2(int input) {
		int currPos = 1;
		int result = 0;
		int limit = 50000000;
		int n = 1;
		while (n < limit) {
			if (currPos == 1)
				result = n;
			/*
			 * How many steps fit between `currPos` and the next n to wrap? Call this `fits`.
			 * Each time we add input + 1 steps, so: currPos + input * fits + fits >= n +
			 * fits currPos + input * fits >= n
			 */
			int fits = (n - currPos) / input;

			/*
			 * We advance `fits` times (right before we wrap) and one more (wrap). As noted
			 * above, we add (step_size + 1) each time, but we only add the very last step
			 * after wrapping + writing.
			 */
			n += (fits + 1);
			currPos = (currPos + (fits + 1) * (input + 1) - 1) % n + 1;
		}
		return result;
	}
}
