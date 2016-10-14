package com.apress.springenterpriserecipes.spring3.spel;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class SocialNetworkingSiteContext implements Serializable {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	private static final long serialVersionUID = 1L;
	private Date sessionStart;
	private Date sessionStop;

	private Friend loggedInUser;

	public void setLoggedInUser(Friend loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public Friend getLoggedInUser() {
		return loggedInUser;
	}

	public void setSessionStop(Date sessionStop) {
		this.sessionStop = sessionStop;
	}

	public Date getSessionStop() {
		return sessionStop;
	}

	public void setSessionStart(Date sessionStart) {
		this.sessionStart = sessionStart;
	}

	public Date getSessionStart() {
		return sessionStart;
	}

}
