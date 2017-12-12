package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day03Test {

	@Test
	void testPart1() {
		assertEquals(0, Day03.part1(1));
		assertEquals(3, Day03.part1(12));
		assertEquals(2, Day03.part1(23));
		assertEquals(31, Day03.part1(1024));
	}

	@Test
	void testPart2() {
		assertEquals(4, Day03.part2(3));
	}

}
