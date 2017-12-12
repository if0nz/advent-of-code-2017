package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import it.ifonz.bean.Program;
import it.ifonz.common.FileReader;

public class Day07 {

	public static void main(String[] args) throws URISyntaxException, IOException {
		
		List<String> programs = FileReader.readLines("/d07_input.txt");
		
		System.out.println("part1: "+part1(programs));
		System.out.println("part2: "+part2(programs));
	}

	private static Program createTree(List<String> programs) {
		Map<String, Program> tree = new HashMap<String, Program>();
		
		// generate programs
		programs.forEach(prg -> {
			String[] tokens = prg.split(" ");
			Program program = new Program();
			program.name = tokens[0];
			program.weight = Integer.valueOf(tokens[1].substring(1, tokens[1].length()-1));
			tree.put(program.name, program);
		});
		
		// attaching them to the tree
		programs.forEach(prg -> {
			String[] tokens = prg.split(" ");
			if (tokens.length == 4) {
				String[] kids = tokens[3].split(",");
				Arrays.stream(kids).forEach(kid -> {
					Program p = tree.get(kid);
					p.parent = tree.get(tokens[0]);
					List<Program> kids2 = p.parent.kids;
					if (kids2 == null) {
						kids2 = new ArrayList<Program>();
						p.parent.kids = kids2;
					}
					kids2.add(p);
				});
			}
		});
		
		// getting the root
		Program root = tree.get(programs.get(0).split(" ")[0]);
		while(root.parent != null) root = root.parent;
		return root;
	}
	
	public static String part1(List<String> programs) {
		Program root = createTree(programs);
		return root.name;
	}
	
	public static long part2(List<String> programs) {
		Program root = createTree(programs);
		// init values
		Program wrongProgram = root;
		long correctWeight = -1;
		
		// please note that this actually is a breadth-first search
		do {
			// by sorting the list this way, we know that the wrong program is the first one or the last one
			
			wrongProgram.kids.sort((x,y) -> (int)(x.weight+x.kidsWeight()-y.weight-y.kidsWeight())); 
	
			Program k1 = wrongProgram.kids.get(0);
			Program k2 = wrongProgram.kids.get(1); // totally NOT the wrong program
			Program k3 = wrongProgram.kids.get(wrongProgram.kids.size()-1);
			
			long k2TotalWeight = k2.weight+k2.kidsWeight();
			wrongProgram = k1.weight+k1.kidsWeight() == k2TotalWeight ? k3 : k1;
			
			// store temp correctWeight
			correctWeight = wrongProgram.weight - (wrongProgram.weight+wrongProgram.kidsWeight() - k2TotalWeight);
			
		} while(wrongProgram.kids.stream().map(x -> x.weight+x.kidsWeight()).distinct().collect(Collectors.toList()).size() > 1); // program's kids are balanced, stop the loop
		
		return correctWeight;
	}

}
