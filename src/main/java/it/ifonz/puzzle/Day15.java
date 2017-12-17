package it.ifonz.puzzle;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Day15 {

	public static void main(String[] args) {
		int n1 = Integer.valueOf(args[0]);
		int n2 = Integer.valueOf(args[1]);
		
		System.out.println("part 1 " + part1(n1, n2));
		System.out.println("part 2 " + part2(n1, n2));
	}

	public static long part1(int s1, int s2) {

		AtomicLong p1 = new AtomicLong(s1);
		AtomicLong p2 = new AtomicLong(s2);

		return IntStream.range(0, 40000000).filter(i -> {
			p1.set(next(p1.get(), 16807));
			p2.set(next(p2.get(), 48271));
			return (p1.get() & 65535) == (p2.get() & 65535); // & (2^16 - 1) takes the 16 less significative bits
		}).count();
	}

	public static long part2(int s1, int s2) {

		AtomicLong p1 = new AtomicLong(s1);
		AtomicLong p2 = new AtomicLong(s2);
		return IntStream.range(0, 5000000).filter(i -> {
			p1.set(nextPart2(p1.get(), 16807, 3));
			p2.set(nextPart2(p2.get(), 48271, 7));
			return (p1.get() & 65535) == (p2.get() & 65535); // & (2^16 - 1) takes the 16 less significative bits
		}).count();

	}

	private static long next(long prev, int factor) {
		long product = prev * factor;
		long bitShifted = (product & 0x7fffffff) + (product >> 31); // by puzzle's spec, the product must be reduced mod 2^32 - 1
		return bitShifted >> 31 > 0 ? bitShifted - 0x7fffffff : bitShifted;
	}

	private static long nextPart2(long n, int factor, int bitMod) {
		do {
			n = next(n, factor);
		} while ((n & bitMod) != 0); // & 3 is equivalent to mod 4, & 7 is equivalent to mod 8
		return n;
	}
}
