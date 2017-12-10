package it.ifonz.bean;

import java.util.HashMap;
import java.util.Map;

public class Memory {
	
	public Map<String, Long> registers;
	public long maxValueEver;
	
	public Memory() {
		super();
		this.registers = new HashMap<>();
		this.maxValueEver = 0;
	}
	
}
