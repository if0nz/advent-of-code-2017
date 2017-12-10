package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day9Test {

	@Test
	void testPart1() {
		assertEquals(1, Day9.part1("{}"));
		assertEquals(6, Day9.part1("{{{}}}"));
		assertEquals(5, Day9.part1("{{},{}}"));
		assertEquals(16, Day9.part1("{{{},{},{{}}}}"));
		assertEquals(1, Day9.part1("{<a>,<a>,<a>,<a>}"));
		assertEquals(9, Day9.part1("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
		assertEquals(9, Day9.part1("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
		assertEquals(3, Day9.part1("{{<a!>},{<a!>},{<a!>},{<ab>}}"));
	}

	@Test
	void testPart2() {
		assertEquals(0, Day9.part2("<>"));
		assertEquals(17, Day9.part2("<random characters>"));
		assertEquals(3, Day9.part2("<<<<>"));
		assertEquals(2, Day9.part2("<{!>}>"));
		assertEquals(0, Day9.part2("<!!>"));
		assertEquals(0, Day9.part2("<!!!>>"));
		assertEquals(10, Day9.part2("<{o\"i!a,<{i<a>"));
	}

}
