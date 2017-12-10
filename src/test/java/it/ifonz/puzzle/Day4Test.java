package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day4Test {

	@Test
	void testPart1() {
		assertEquals(1, Day4.part1(new String[] {"aa,bb,cc,dd,ee"}));
		assertEquals(0, Day4.part1(new String[] {"aa,bb,cc,dd,aa"}));
		assertEquals(1, Day4.part1(new String[] {"aa,bb,cc,dd,aaa"}));
	}

	@Test
	void testPart2() {
		assertEquals(1, Day4.part2(new String[] {"abcde,fghij"}));
		assertEquals(0, Day4.part2(new String[] {"abcde,xyz,ecdab"}));
		assertEquals(1, Day4.part2(new String[] {"a,ab,abc,abd,abf,abj"}));
		assertEquals(1, Day4.part2(new String[] {"iiii,oiii,ooii,oooi,oooo"}));
		assertEquals(0, Day4.part2(new String[] {"oiii,ioii,iioi,iiio"}));
	}

}
