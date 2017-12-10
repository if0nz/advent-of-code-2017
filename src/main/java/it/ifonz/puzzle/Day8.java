package it.ifonz.puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import it.ifonz.bean.Memory;
import it.ifonz.common.FileReader;

public class Day8 {

	public static void main(String[] args) throws URISyntaxException, IOException {

		List<String> instructions = FileReader.readLines("/d8_input.txt");
		System.out.println("part 1: "+part1(instructions));
		System.out.println("part 2: "+part2(instructions));
		
	}

	public static long part1(List<String> instructions) {
		Memory memory = executeInstructions(instructions);
		return (memory.registers.values().stream().mapToLong(v -> v).max().getAsLong());
	}
	
	public static long part2(List<String> instructions) {
		Memory memory = executeInstructions(instructions);
		return (memory.maxValueEver);
	}
	
	private static Memory executeInstructions(List<String> instructions) {
		Memory memory = new Memory();
		Map<String, Long> registers = memory.registers;
		// JaVa CaNoT UsE EvAl
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		instructions.forEach(instruction -> {
			String[] tokens = instruction.split(" ");
			Long registeredValue = executeInstruction(registers, tokens, engine);
			long longValue = registeredValue.longValue();
			memory.maxValueEver = longValue > memory.maxValueEver ? longValue : memory.maxValueEver;
		});
		
		return memory;
		
	}

	private static long storedValueToTest(Map<String, Long> registers, String tokens) {
		Long storedRegisterToTest = registers.get(tokens);
		long storedValueToTest = storedRegisterToTest != null ? storedRegisterToTest : 0;
		return storedValueToTest;
	}

	// if instruction's condition == true then returns updated register's value, else returns 0
	private static Long executeInstruction(Map<String, Long> registers, String tokens[], ScriptEngine engine) {
		
		String register = tokens[0];
		Long registeredValue = registers.get(register);
		if (registeredValue == null) registeredValue = 0L;
		try {
			if ((Boolean)engine.eval(storedValueToTest(registers, tokens[4])+tokens[5]+Long.valueOf(tokens[6]))) {
				registeredValue += Integer.valueOf(tokens[2])*("inc".equals(tokens[1])?1:-1); // new value
				registers.put(register, registeredValue); // store it
				return Long.valueOf(registeredValue); // return it
			}
		} catch (NumberFormatException | ScriptException e) {
			e.printStackTrace();
		}
		
		return 0L; // 0 is better than null. everything is better than null.
		
	}

}
