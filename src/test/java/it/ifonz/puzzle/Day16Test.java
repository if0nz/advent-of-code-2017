package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import it.ifonz.common.FileReader;

class Day16Test {

	@Test
	void testPart1() throws URISyntaxException, IOException {
		String[] input = FileReader.readLines("/d16_test_input.txt").get(0).split(",");
		assertEquals("baedc", Day16.part1(input, "abcde"));
	}

	// puzzle spec does not contain a valid unit test about the function's output ):
//	@Test
//	void testPart2() {
//		
//	}

}
