package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day15 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		int s1 = Integer.valueOf(args[0]);
		int s2 = Integer.valueOf(args[1]);
		System.out.println("part 1 " + part1(s1, s2));
		System.out.println("part 2 " + part2(s1, s2));
	}

	public static int part1(int s1, int s2) {

		long p1 = s1;
		long p2 = s2;
		int c = 0;
		for (int i = 0; i < 40000000; i++) {
			p1 = (p1 * 16807) % 2147483647;
			p2 = (p2 * 48271) % 2147483647;
			if ((p1 & 65535) == (p2 & 65535))
				c++;
		}
		return c;

	}

	public static int part2(int s1, int s2) {

		long p1 = s1;
		long p2 = s2;
		int c = 0;
		for (int i = 0; i < 5000000; i++) {
			do {
				p1 = (p1 * 16807) % 2147483647;
			} while (p1 % 4 != 0);
			do {
				p2 = (p2 * 48271) % 2147483647;
			} while (p2 % 8 != 0);

			if ((p1 & 65535) == (p2 & 65535))
				c++;
		}
		return c;

	}

}
