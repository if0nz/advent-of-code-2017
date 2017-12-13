package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import it.ifonz.common.FileReader;

public class Day13 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		List<String> input = FileReader.readLines("/d13_input.txt");

		System.out.println(part1(input));
		System.out.println(part2(input));

	}

	public static long part1(List<String> input) {

		HashMap<Integer, Integer> firewall = new HashMap<>();
		AtomicInteger max = new AtomicInteger();
		input.forEach(i -> {
			String[] split = i.split(":");
			Integer valueOf = Integer.valueOf(split[0]);
			firewall.put(valueOf, Integer.valueOf(split[1]));
			max.set(valueOf);
		});

		AtomicInteger sum = new AtomicInteger(0);
		IntStream.rangeClosed(0, max.get()).forEach(i -> {
			Integer integer = firewall.get(i);
			if (integer != null)
				if (i % (2 * (integer-1)) == 0) {
					sum.addAndGet(i * integer);
				}
		});

		return sum.get();

	}

	public static boolean part2(List<String> input) {

		return false;

	}

}
