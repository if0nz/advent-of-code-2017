package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Day14 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		String input = args[0];

		System.out.println(part1(input));
		System.out.println(part2(input));

	}

	public static long part1(String input) {

		return IntStream.range(0, 128).mapToLong(i -> 
			Day10.part2(input + "-" + i, 256) // get the hash
			.chars().mapToLong(c-> // for each hex-digit in the hash
				Integer.toBinaryString(Integer.parseInt(String.valueOf((char) c), 16)) // convert it in binary (no pad needed for p1)
				.chars().filter(c1 -> c1 == 49).count()) // count the 1s in the single hex digit
			.sum() // count the 1s in the hash string
		).sum(); // count all the 1s
	}

	public static long part2(String input) {
		
		String[] grid = new String[128];// well, we need it right now
		IntStream.range(0, 128).forEach(i -> {
			String hashed = Day10.part2(input + "-" + i, 256);
			StringBuilder sb = new StringBuilder();
			hashed.chars().forEach(c -> {
				String string = Integer.toBinaryString(Integer.parseInt(String.valueOf((char) c), 16));
				sb.append(string.length() == 4 ? string : "0000".substring(0, 4-string.length()) + string); // we need the leading 0s
			});
			grid[i] = sb.toString();
		});
		AtomicLong counting = new AtomicLong(0);
		IntStream.range(0, 128).forEach(i -> { // for each hash in the grid
			IntStream.range(0, 128).forEach(j -> { // for each bit in the hash
				if (grid[i].charAt(j) == '1') { // if the bit is 1
					counting.incrementAndGet(); // increment the regions' counter
					flagCell(grid, i, j); // recursively flag its region 1s as included in a region
				}
			});
		});
		return counting.get();
	}
	
	// recursive function for flagging the 1s belonging to the same region
	private static void flagCell(String[] grid, int i, int j) {
		if (j < 0 || j > 127 || i < 0 || i > 127 || grid[i].charAt(j) != '1') return; // boundary test + value test
		StringBuilder sb = new StringBuilder(grid[i]);
		sb.setCharAt(j, 'x');
		grid[i] = sb.toString();
		flagCell(grid, i, j-1);// flag left cell
		flagCell(grid, i-1, j); // flag upper cell
		flagCell(grid, i, j+1);// flag right cell
		flagCell(grid, i+1, j);// flag bottom cell
	}

}
