package it.ifonz.puzzle;

import java.util.Arrays;

public class Day4 {

	private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	
	public static void main(String[] args) {
	
		System.out.println(part1(args));
		System.out.println(part2(args));
	}
	
	public static int part1(String[] passphrases) {
		
		return Arrays.stream(passphrases).mapToInt(passphrase -> {
			String[] phrases = passphrase.split(",");
			// for each p1, for each p2 such that p1 and p2 are not the same object but are the same string, count 1; otherwise count 0
			return Arrays.stream(phrases).flatMap(p1 -> Arrays.stream(phrases).filter(p2 -> p1 != p2 && p2.equals(p1)).map(s->s)).findFirst().isPresent() ? 0 : 1;
		}).sum(); // and sum the bits
		
	}

	public static int part2(String[] passphrases) {
		
		return Arrays.stream(passphrases).mapToInt(passphrase -> {
			String[] phrases = passphrase.split(",");
			// for each p1, for each p2 such that p1 and p2 are not the same object but are anagrams, count 1; otherwise count 0
			return Arrays.stream(phrases).flatMap(p1 -> Arrays.stream(phrases).filter(p2 -> p1 != p2 && stringHash(p2)==stringHash(p1)).map(s->s)).findFirst().isPresent() ? 0 : 1;
		}).sum();
		
	}
	
	private static long stringHash(String s) {
		// every char in [az] is mapped with a prime number, so two string "hashed" this way must be anagrams
		return s.chars().reduce(1, (a,b) -> a*primes[b-97]);
	}
}
