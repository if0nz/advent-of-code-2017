package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.ifonz.common.FileReader;

class Day12Test {

	@Test
	void testPart1() throws URISyntaxException, IOException {
		List<String> readLines = FileReader.readLines("/d12_test_input.txt");
		assertEquals(6, Day12.part1(readLines));
	}

	@Test
	void testPart2() throws URISyntaxException, IOException {
		List<String> readLines = FileReader.readLines("/d12_test_input.txt");
		assertEquals(2, Day12.part2(readLines));
	}

}
