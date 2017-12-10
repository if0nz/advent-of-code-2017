package it.ifonz.bean;

import java.util.List;

public class Program {

	public String name;
	public int weight;
	public Program parent;
	public List<Program> kids;
	
	public long kidsWeight() {
		return kids == null ? 0 :kids.stream().mapToLong(k -> k.kidsWeight()+k.weight).sum();
	}
}
