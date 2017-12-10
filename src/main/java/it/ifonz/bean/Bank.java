package it.ifonz.bean;

import java.util.Arrays;

public class Bank {

	public Integer[] blocks;
	public int hits;
	
	public Bank(Integer[] blocks) {
		super();
		this.blocks = blocks;
		this.hits = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(blocks);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (!Arrays.equals(blocks, other.blocks))
			return false;
		return true;
	}

}
