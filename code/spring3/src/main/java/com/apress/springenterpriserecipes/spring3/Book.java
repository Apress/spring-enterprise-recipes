package com.apress.springenterpriserecipes.spring3;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/*** simple POJO for illustration purposes */
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String id;
	private int copiesCheckedOut;
	private int totalCopiesAvailable;

	public Book(String string) {
		this.setTitle(string);
		this.setId(UUID.randomUUID().toString());
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTotalCopiesAvailable(int totalCopiesAvailable) {
		this.totalCopiesAvailable = totalCopiesAvailable;
	}

	public int getTotalCopiesAvailable() {
		return totalCopiesAvailable;
	}

	public void setCopiesCheckedOut(int copiesCheckedOut) {
		this.copiesCheckedOut = copiesCheckedOut;
	}

	public int getCopiesCheckedOut() {
		return copiesCheckedOut;
	}

}
