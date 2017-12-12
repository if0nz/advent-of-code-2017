package it.ifonz.puzzle;

import java.util.Arrays;

import it.ifonz.common.ArrayConverters;

public class Day02 {

	public static void main(String[] args) {

		System.out.println("part1 " + part1(args));
		System.out.println("part2 " + part2(args));

	}

	public static int part1(String[] rows) {
		return Arrays.stream(rows).mapToInt(row -> {
			Integer[] ints = ArrayConverters.asIntegerArray(row.split(","));
			// max - min
			return (Arrays.stream(ints).max(Integer::compare).get() - Arrays.stream(ints).min(Integer::compare).get());
		}).sum();
	}

	public static int part2(String[] rows) {

		return Arrays.stream(rows).mapToInt(row -> {
			Integer[] ints = ArrayConverters.asIntegerArray(row.split(","));
			// for every i, find j such that j!=i and j%i = 0; then map j with j/i and return the result
			return Arrays.stream(ints).flatMap(i -> Arrays.stream(ints).filter(j -> j != i && j % i == 0).map(j -> j / i))
					.findFirst().get();
		}).sum(); // sum the results

	}
}
