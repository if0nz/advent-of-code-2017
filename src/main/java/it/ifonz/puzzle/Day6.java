package it.ifonz.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import it.ifonz.bean.Bank;
import it.ifonz.common.ArrayConverters;

public class Day6 {

	public static void main(String[] args) {

		System.out.println(part1(args));
		System.out.println(part2(args));

	}

	public static int part1(String[] args) {

		List<Bank> banks = loopOverBanks(args);
		return banks.size();

	}

	public static int part2(String[] args) {

		List<Bank> banks = loopOverBanks(args);
		Bank bank = banks.stream().filter(b -> b.hits == 2).findFirst().get();
		return banks.size() - banks.indexOf(bank);

	}

	private static List<Bank> loopOverBanks(String[] args) {
		Integer[] input = ArrayConverters.asIntegerArray(args);
		List<Bank> banks = new ArrayList<>();

		int size = input.length;
		boolean noCycle = true;
		Bank bank;
		do {
			bank = new Bank(input); // it also works as init
			int indexOf = banks.indexOf(bank);
			if (indexOf != -1) { // it's the second time we see this bank, we found the loop's entry point
				noCycle = false; // stop this
				bank.hits = 2;
				banks.set(indexOf, bank);
			} else {
				bank.hits = 1; // it's the first time we see this bank
				banks.add(bank);
			}
			input = input.clone(); // cloned in order to avoid side effect on previous input
			int max = Arrays.stream(input).max(Integer::compareTo).get(); // bank's max value...
			int index = ArrayUtils.indexOf(input, max); // ... and its index
			input[index] = 0; // apply puzzle specs
			for (; max > 0; max--) {
				++input[++index % size]; // circular array
			}

		} while (noCycle);
		return banks;
	}
}
