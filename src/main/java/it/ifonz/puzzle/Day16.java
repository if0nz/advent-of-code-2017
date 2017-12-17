package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import it.ifonz.common.FileReader;

public class Day16 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		String[] input = FileReader.readLines("/d16_input.txt").get(0).split(",");
		String programs = "abcdefghijklmnop";
		System.out.println(part1(input, programs));
		System.out.println(part2(input, programs));
	}

	public static String part1(String[] input, String programs) {
		return waltz(input, programs.toCharArray());
	}

	public static String part2(String[] input, String programs) {
		StringBuilder sb = new StringBuilder(programs);
		List<String> dances = new ArrayList<>();

		IntStream.range(0, 1000000000).anyMatch(i -> {
			String p =  waltz(input, sb.toString().toCharArray());
			if (!dances.contains(p)) {
				dances.add(p);
				sb.replace(0, p.length(), p);
				return false;
			} 
			return true;
		});
		return dances.get(1000000000 % dances.size() -1);
	}

	// programs.forEach(p -> p.dance(Instant.now()))
	private static String waltz(String[] input, char[] programs) {
		int len = programs.length;
		StringBuilder sb = new StringBuilder(new String(programs));
		Arrays.stream(input).forEach(m -> {
			char move = m.charAt(0);
			switch (move) {
				case 's': {
					Integer spin = Integer.valueOf(m.substring(1, m.length()));
					String s = sb.toString();
					sb.replace(0, len, new String(s.substring(len - spin, len) + s.substring(0, len - spin)));
					break;
				}
				case'x': {
					String[] tokens = m.substring(1, m.length()).split("/");
					Integer A = Integer.valueOf(tokens[0]);
					Integer B = Integer.valueOf(tokens[1]);
					char c1 = sb.charAt(A);
					sb.setCharAt(A, sb.charAt(B));
					sb.setCharAt(B, c1);
					break;
				}
				case 'p': {
					String[] tokens = m.substring(1, m.length()).split("/");
					char c1 = tokens[0].charAt(0);
					char c2 = tokens[1].charAt(0);
					int i1 = sb.indexOf(Character.toString(c1));
					int i2 = sb.indexOf(Character.toString(c2));
					sb.setCharAt(i1, c2);
					sb.setCharAt(i2, c1);
				}
			}
		});
		return sb.toString();
	}

}
