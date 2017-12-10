package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import it.ifonz.common.FileReader;

class Day8Test {

	@Test
	void testPart1() throws URISyntaxException, IOException {
		assertEquals(1, Day8.part1(FileReader.readLines("/d8_test_input.txt")));
	}

	@Test
	void testPart2() throws URISyntaxException, IOException {
		assertEquals(10, Day8.part2(FileReader.readLines("/d8_test_input.txt")));
	}

}
