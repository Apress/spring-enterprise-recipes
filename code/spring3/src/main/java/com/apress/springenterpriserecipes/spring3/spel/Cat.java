package com.apress.springenterpriserecipes.spring3.spel;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Cat {
	private Cat mate;
	private String name;

	public Cat() {
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Cat(String n) {
		this.name = n;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMate(Cat mate) {
		this.mate = mate;
	}

	public Cat getMate() {
		return mate;
	}

}
