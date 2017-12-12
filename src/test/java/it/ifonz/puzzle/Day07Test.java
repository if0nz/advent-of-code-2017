package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import it.ifonz.common.FileReader;

class Day07Test {

	@Test
	void testPart1() throws URISyntaxException, IOException {
		assertEquals("tknk", Day07.part1(FileReader.readLines("/d7_test_input.txt")));
	}

	@Test
	void testPart2() throws URISyntaxException, IOException {
		assertEquals(60, Day07.part2(FileReader.readLines("/d7_test_input.txt")));
	}

}
