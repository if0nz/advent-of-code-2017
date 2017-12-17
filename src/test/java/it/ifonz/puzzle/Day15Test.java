package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day15Test {

	@Test
	void testPart1() {
		assertEquals(588, Day15.part1(65, 8921));
	}

	@Test
	void testPart2() {
		assertEquals(309, Day15.part2(65, 8921));
	}

}
