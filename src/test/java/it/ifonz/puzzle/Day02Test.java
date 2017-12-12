package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static it.ifonz.puzzle.Day02.*
;
class Day02Test {

	@Test
	void testPart1() {
		assertEquals(18, part1(new String[] {"5,1,9,5","7,5,3","2,4,6,8"}));
	}

	@Test
	void testPart2() {
		assertEquals(9, part2(new String[] {"5,9,2,8","9,4,7,3","3,8,6,5"}));
	}

}
