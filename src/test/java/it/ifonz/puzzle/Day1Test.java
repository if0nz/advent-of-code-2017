package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static it.ifonz.puzzle.Day1.sumIfSameDigitForward;

import org.junit.jupiter.api.Test;

class Day1Test {

	@Test
	void testSumIfSameDigitForward() {
		
		// part 1
		assertEquals(3, sumIfSameDigitForward("1122", 1));
		assertEquals(4, sumIfSameDigitForward("1111", 1));
		assertEquals(0, sumIfSameDigitForward("1234", 1));
		assertEquals(9, sumIfSameDigitForward("91212129", 1));
		
		// part 2
		assertEquals(6, sumIfSameDigitForward("1212", 2));
		assertEquals(0, sumIfSameDigitForward("2112", 2));
		assertEquals(4, sumIfSameDigitForward("123425", 3));
		assertEquals(12, sumIfSameDigitForward("123123", 3));
		assertEquals(4, sumIfSameDigitForward("12131415", 4));
		
	}

}
