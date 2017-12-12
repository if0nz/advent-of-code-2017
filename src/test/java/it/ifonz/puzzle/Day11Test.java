package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day11Test {

	// the puzzlemaker didn't provide any test for p2 ):
	
	@Test
	void testPart1() {
		assertEquals(3, Day11.part1("ne,ne,ne"));
		assertEquals(0, Day11.part1("ne,ne,sw,sw"));
		assertEquals(2, Day11.part1("ne,ne,s,s"));
		assertEquals(3, Day11.part1("se,sw,se,sw,sw"));
	}

}
