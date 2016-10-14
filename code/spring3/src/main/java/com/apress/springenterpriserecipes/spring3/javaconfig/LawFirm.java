package com.apress.springenterpriserecipes.spring3.javaconfig;

import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class LawFirm {
	private String location;
	private Collection<Attorney> lawyers;

	public void setLawyers(Collection<Attorney> lawyers) {
		this.lawyers = lawyers;
	}

	public Collection<Attorney> getLawyers() {
		return lawyers;
	}

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

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

}
