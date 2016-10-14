package com.apress.springenterpriserecipes.distributedspring.terracotta.customerconsole.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Customer implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName, lastName;
	private Date birthday;

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).setExcludeFieldNames(
				new String[] { "uuid" }).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).
		toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Customer))
			return false;

		Customer otherCustomer = (Customer) obj;
		return new EqualsBuilder().append( getId(), otherCustomer.getId()).isEquals();
	}

	private UUID uuid;

	public Customer(String firstName, String lastName, Date birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthdate;

		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
