package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.ifonz.common.FileReader;

public class Day21 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		List<String> input = FileReader.readLines("/d21_input.txt");
		HashMap<String, String[]> rulesMap = new HashMap<>();
		input.forEach(r -> {
			String[] split = r.split("=> ");
			String trim = split[0].trim();
			List<String> subgrid = Arrays.asList(trim.split("/"));
			List<String> readCols = readCols(subgrid);
			List<String> rar = rar(subgrid);
			List<String> rarReadCols = readCols(rar);
			List<String> rarBottmUp = readColsBottomUp(rar);
			List<String> buRarJoin = joinBottomUp(rar);
			String readColsKey = StringUtils.join(readCols, '/');
			String rarBuKey = StringUtils.join(rarBottmUp, '/');
			String rarReadColsKey = StringUtils.join(rarReadCols, '/');
			String buRarJoinKey = StringUtils.join(buRarJoin, '/');
			String rarKey = StringUtils.join(rar, '/');
			String[] applied = split[1].split("/");
			rulesMap.put(readColsKey, applied);
			rulesMap.put(rarBuKey, applied);
			rulesMap.put(rarReadColsKey, applied);
			rulesMap.put(buRarJoinKey, applied);
			rulesMap.put(rarKey, applied);
			rulesMap.put(trim, applied);
		});
		System.out.println(part1(rulesMap));
		System.out.println(part2(rulesMap));

	}

	public static long part1(HashMap<String, String[]> rulesMap) {
		return countFractalPixel(5, rulesMap);
	}

	public static long part2(HashMap<String, String[]> rulesMap) {
		long countFractalPixel = countFractalPixel(18, rulesMap);
		return countFractalPixel;
	}
	
	public static long countFractalPixel(int loops, HashMap<String, String[]> rulesMap) {
		List<String> fractal = new ArrayList<>();
		fractal.add(".#.");
		fractal.add("..#");
		fractal.add("###");

		for (int i = 0; i < loops; i++) {
			List<StringBuilder> newFractal = new ArrayList<>();

			if ((fractal.size() & 1) == 0) { // size % 2 == 0
				int iterations = fractal.size()/2;
				for (int row = 0; row < iterations; row++) {
					newFractal.add(new StringBuilder());
					newFractal.add(new StringBuilder());
					newFractal.add(new StringBuilder());
					int shiftRow = 3*row;
					int beginRow = 2*row;
					int endRow = beginRow+1;
					for (int column = 0; column < iterations; column++) {
						List<String> subgrid = new ArrayList<>();
						int beginColumn = 2*column;
						int endColumn = beginColumn+2;
						subgrid.add(fractal.get(beginRow).substring(beginColumn, endColumn));
						subgrid.add(fractal.get(endRow).substring(beginColumn, endColumn));
						String key = StringUtils.join(subgrid, '/'); 
						String[] applied = rulesMap.get(key);
						for (int index = 0; index < 3 ; index++) {
							newFractal.get(shiftRow+index).append(applied[index]);
						}
					}
				}
				
			} else {// fractal.size % 3 == 0  
				int iterations = fractal.size()/3;
				for (int row = 0; row < iterations; row++) {
					newFractal.add(new StringBuilder());
					newFractal.add(new StringBuilder());
					newFractal.add(new StringBuilder());
					newFractal.add(new StringBuilder());
					int firstRow = 3*row;
					int secondRow = firstRow+1;
					int thirdRow = firstRow+2;
					int shiftRow = 4*row;
					for (int column = 0; column < iterations; column++) {
						List<String> subgrid = new ArrayList<>();
						
						int beginColumn = 3*column;
						int endColumn = beginColumn+3;
						subgrid.add(fractal.get(firstRow).substring(beginColumn, endColumn));
						
						subgrid.add(fractal.get(secondRow).substring(beginColumn, endColumn));
						
						subgrid.add(fractal.get(thirdRow).substring(beginColumn, endColumn));
						String key = StringUtils.join(subgrid, '/'); 
						String[] applied = rulesMap.get(key);
						for (int index = 0; index < 4 ; index++) {
							
							newFractal.get(shiftRow+index).append(applied[index]);
						}
					}
				}
			}
			fractal = new ArrayList<>();
			for (StringBuilder sb : newFractal) fractal.add(sb.toString());
		}
		return fractal.stream().mapToLong(s -> s.chars().filter(c -> c == '#').count()).sum();
	}

	private static List<String> rar(List<String> subgrid) {
		List<String> rar = new ArrayList<>();
		for (String s : subgrid) {
			rar.add(StringUtils.reverse(s));
		}
		return rar;
	}

	private static List<String> readCols(List<String> subgrid) {
		List<String> readCols = new ArrayList<>();
		for (int i = 0; i < subgrid.size(); i++) {
			StringBuilder col = new StringBuilder();
			for (int j = 0; j < subgrid.size(); j++) {
				col.append(subgrid.get(j).charAt(i));
			}
			readCols.add(col.toString());
		}
		return readCols;
	}
	
	private static List<String> readColsBottomUp(List<String> subgrid) {
		List<String> readCols = new ArrayList<>();
		for (int i = 0; i < subgrid.size(); i++) {
			StringBuilder col = new StringBuilder();
			for (int j = subgrid.size() -1 ; j > -1; j--) {
				col.append(subgrid.get(j).charAt(i));
			}
			readCols.add(col.toString());
		}
		return readCols;
	}
	
	private static List<String> joinBottomUp(List<String> subgrid) {
		List<String> reversing = new ArrayList<>(subgrid);
		Collections.reverse(reversing);

		return reversing;
	}
}
