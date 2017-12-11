package it.ifonz.puzzle;

import java.util.Arrays;
import java.util.HashMap;

public class Day11 {

	public static void main(String[] args) {
		
		System.out.println("part 1: "+part1(args));
		System.out.println("part 2: "+part2(args));
		
	}

	private static long part1(String[] args) {
		String[] movements = args[0].split(",");

		
		long x = Math.abs(Arrays.stream(movements).filter(m -> m.equals("s") || m.equals("sw")).count() -  Arrays.stream(movements).filter(m -> m.equals("n") || m.equals("ne")).count());
		long y = Math.abs(Arrays.stream(movements).filter(m -> m.equals("ne") || m.equals("se")).count() -  Arrays.stream(movements).filter(m -> m.equals("nw") || m.equals("sw")).count());
		long z = Math.abs(Arrays.stream(movements).filter(m -> m.equals("nw") || m.equals("n")).count() -  Arrays.stream(movements).filter(m -> m.equals("se") || m.equals("s")).count());
		
		return Math.max(Math.max(x,y),z);
	}
	
	public static long part2(String[] args) {
		HashMap<String, int[]> m = new HashMap<>();
		m.put("n", new int[]{-1,0,1});
		m.put("ne", new int[]{-1,1,0});
		m.put("se", new int[]{0,1,-1});
		m.put("s", new int[]{1,0,-1});
		m.put("sw", new int[]{1,-1,0});
		m.put("nw", new int[]{0,-1,1});
		long currentX = 0;
		long currentY = 0;
		long currentZ = 0;
		long maxDist = 0;
		
		for (String movement : args[0].split(",")) {
			int[] shift = m.get(movement);
			currentX+=shift[0];
			currentY+=shift[1];
			currentZ+=shift[2];
			long max = Math.max(Math.max(currentX, currentY), currentZ);
			maxDist = Math.max(maxDist, max);
		}
		return maxDist;
	}

}
