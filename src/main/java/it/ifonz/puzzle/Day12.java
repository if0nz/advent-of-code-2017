package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import it.ifonz.common.FileReader;

public class Day12 {

	// the puzzle asks to visit a disconnected graph
	public static void main(String[] args) throws URISyntaxException, IOException {

		List<String> nodes = FileReader.readLines("/d12_input.txt");

		System.out.println("part 1: " + part1(nodes));
		System.out.println("part 2: " + part2(nodes));
		
	}

	public static int part1(List<String> nodes) {
		
		// create the graph
		HashMap<Integer, List<Integer>> graph = createGraph(nodes);

		// visit the 0-rooted connected component
		List<Integer> visited = createConnectedComponent(graph, 0);

		// return the component's size
		return visited.size();
	}

	public static int part2(List<String> nodes) {

		// create the graph
		HashMap<Integer, List<Integer>> graph = createGraph(nodes);

		int groups = 0;
		do {
			// visit an unvisited graph's connected component
			createConnectedComponent(graph, graph.keySet().iterator().next());
			groups++;
		} while (!graph.isEmpty());
		
		// return the numbers of connected components in the graph
		return groups;
	}

	private static HashMap<Integer, List<Integer>> createGraph(List<String> nodev) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		nodev.forEach(n -> {
			String[] tokens = n.split(" ");
			graph.put(Integer.valueOf(tokens[0]),
					Arrays.stream(tokens[2].split(",")).map(s -> Integer.valueOf(s)).collect(Collectors.toList()));
		});
		return graph;
	}
	
	// visit the graph with a beradth-first search approach
	private static List<Integer> createConnectedComponent(HashMap<Integer, List<Integer>> graph, int root) {
		
		Queue<Integer> q = new ArrayDeque<>(); // next nodes to visit
		List<Integer> visited = new ArrayList<>(); // connected component so far
		q.add(root); // init queue

		while (!q.isEmpty()) {
			Integer poll = q.poll(); // get next node
			if (!visited.contains(poll)) { // if it's not already visited
				visited.add(poll); // visit it
				q.addAll(graph.get(poll)); // and put its neighbourhood in the queue
			}
		}
		visited.forEach(v -> graph.remove(v)); // removes the connected component from the graph
		return visited;
		
	}
	
}
