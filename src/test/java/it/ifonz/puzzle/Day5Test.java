package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day5Test {

	@Test
	void testPart1() {
		assertEquals(5, Day5.part1(new Integer[] {0,3,0,1,-3}));
	}

	@Test
	void testPart2() {
		assertEquals(10, Day5.part2(new Integer[] {0,3,0,1,-3}));
	}

}
