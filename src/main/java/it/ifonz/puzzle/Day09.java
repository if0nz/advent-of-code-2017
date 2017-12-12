package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;

import it.ifonz.bean.ParserReport;
import it.ifonz.common.FileReader;

public class Day09 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		String input = FileReader.readLines("/d09_input.txt").get(0);
		System.out.println("part 1: "+part1(input));
		System.out.println("part 2: "+part2(input));
		
	}

	public static int part1(String input) {
		return parse(input).score;
	}
	
	public static int part2(String input) {
		return parse(input).garbageTotal;
	}
	
	private static ParserReport parse(String input) {
		boolean garbage = false;
		boolean skip = false;
		int currentScore = 0;
		ParserReport pr = new ParserReport();
		
		// straight-forward application of puzzle specs
		for (char c : input.toCharArray()) {
			if (!skip) {
				if (c == '!') // skip next loop
					skip = true;
				else {
					if (!garbage) {
						if (c == '<')
							garbage = true; // next chars but '!' are garbage
						else if (c == '{') // begin group
							++currentScore; // stack-like behavior (push)
						else if (c == '}') // end group
							pr.score+=currentScore--; // (pop)
						
					} else {
						if (c == '>') // garbage ends here
							garbage = false;
						else
							pr.garbageTotal++; // increase total garbage size
					}
				}
			} else
				skip = false;
		}
		return pr;
	}

}
