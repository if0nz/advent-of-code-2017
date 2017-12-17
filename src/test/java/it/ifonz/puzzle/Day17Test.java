package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day17Test {

	@Test
	void testPart1() {
		assertEquals(638, Day17.part1(3));
	}

	@Test
	void testPart2() {
		assertEquals(47465686, Day17.part2(356));
	}

	@Test
	void testPart2v2() {
		assertEquals(47465686, Day17.part2v2(356));
	}

}
