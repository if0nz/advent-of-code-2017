package it.ifonz.puzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.ifonz.common.FileReader;

class Day13Test {

	@Test
	void testPart1() throws URISyntaxException, IOException {
		List<String> input = FileReader.readLines("/d13_test_input.txt");
		assertEquals(24, Day13.part1(input));
	}

	@Test
	void testPart2() throws URISyntaxException, IOException {
		List<String> input = FileReader.readLines("/d13_test_input.txt");
		assertEquals(10, Day13.part2(input));
	}

}
