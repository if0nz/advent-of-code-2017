package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day6Test {

	@Test
	void testPart1() {
		assertEquals(5, Day6.part1(new String[] {"0","2","7","0"}));
	}

	@Test
	void testPart2() {
		assertEquals(4, Day6.part2(new String[] {"0","2","7","0"}));
	}

}
