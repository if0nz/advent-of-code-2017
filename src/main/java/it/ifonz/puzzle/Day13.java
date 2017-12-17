package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import it.ifonz.common.FileReader;

public class Day13 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		List<String> input = FileReader.readLines("/d13_input.txt");

		System.out.println("part 1: "+part1(input));
		System.out.println("part 2: "+part2(input));

	}

	public static long part1(List<String> input) {

		HashMap<Integer, Integer> firewall = createFirewall(input);

		// each layer needs 2*(range-1) steps for a round-trip scan. the packet
		// reaches layer N after N steps
		return firewall.entrySet().stream()
				.filter(e -> e.getKey().intValue() % (2 * (e.getValue().intValue() - 1)) == 0)
				.mapToLong(e -> e.getKey() * e.getValue()).sum();

	}

	public static long part2(List<String> input) {
		long begin = System.currentTimeMillis();
		HashMap<Integer, Integer> firewall = createFirewall(input);
		AtomicInteger delay = new AtomicInteger(0);
		// same logic, but the packet reaches layer N after N+delay steps
		// if at least ONE layer catches the packet, then increment the delay
		// and retest again
		Set<Entry<Integer, Integer>> entrySet = firewall.entrySet();
		while (entrySet.stream()
				.anyMatch(e -> (delay.get() + e.getKey().intValue()) % (2 * (e.getValue().intValue() - 1)) == 0)) {
			delay.incrementAndGet();
		}
		System.out.println(System.currentTimeMillis()-begin);
		return delay.get();

	}

	// parsing the input
	private static HashMap<Integer, Integer> createFirewall(List<String> input) {
		HashMap<Integer, Integer> firewall = new HashMap<>();
		input.forEach(i -> {
			String[] split = i.split(":");
			Integer valueOf = Integer.valueOf(split[0]);
			firewall.put(valueOf, Integer.valueOf(split[1]));
		});
		return firewall;
	}

}
