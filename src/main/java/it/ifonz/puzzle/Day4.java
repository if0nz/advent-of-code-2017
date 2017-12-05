package it.ifonz.puzzle;

import java.util.Arrays;

public class Day4 {

	public static void main(String[] args) {
	
		int validsP1 = 0;
		int validsP2 = 0;
		for (String passphrase : args) {
			String[] phrases = passphrase.split(",");
			
			boolean validP2 = true;
			boolean validP1 = true;
			for (int i = 0; i < phrases.length && validP1; i++) {
				char[] s1Plain = phrases[i].toCharArray();
				
				// cloned+sorted array will be tested against part2 requirements
				char[] s1Sorted = s1Plain.clone();
				Arrays.sort(s1Sorted);
				for (int j = i+1; j < phrases.length && validP1; j++) {
					char[] s2Plain = phrases[j].toCharArray();
					
					// cloned+sorted array will be tested against part2 requirements
					char[] s2Sorted = s2Plain.clone();
					Arrays.sort(s2Sorted);

					// if two strings are equal then are also anagrams of each other, so p1 requirement will be a halt condition for p2 test
					validP1 = !Arrays.equals(s1Plain, s2Plain);
					
					// a given pair of phrases (s1, s2) included in a passphrase p will be tested if and only if no anagrams have already been found in the prase
					// otherwise, the passphrase will not pass part2 requirements
					validP2 = (validP2 && validP1) ? !Arrays.equals(s1Sorted, s2Sorted) : false;
					
				}
			}
			
			if (validP1) validsP1++;
			if (validP2) validsP2++;
		}
		System.out.println(validsP1);
		System.out.println(validsP2);
	}

}
