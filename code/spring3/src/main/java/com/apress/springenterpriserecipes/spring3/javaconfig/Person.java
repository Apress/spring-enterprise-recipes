package com.apress.springenterpriserecipes.spring3.javaconfig;

import static java.lang.System.out;

import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Person /* implements InitializingBean, DisposableBean */{
	private String name;
	private Person significantOther;
	private Person mother;
	private Collection<Person> children;
	private Person father;

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public void setSignificantOther(Person significantOther) {
		this.significantOther = significantOther;
	}

	public Person getSignificantOther() {
		return significantOther;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getFather() {
		return father;
	}

	public void startLife() {
		out.println("Starting life");
	}

	public void die() {
		out.println("Dieing");
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getMother() {
		return mother;
	}

	public void setChildren(Collection<Person> children) {
		this.children = children;
	}

	public Collection<Person> getChildren() {
		return children;
	}
 
}
