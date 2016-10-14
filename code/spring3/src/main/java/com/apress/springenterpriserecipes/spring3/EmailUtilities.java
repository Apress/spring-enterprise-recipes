package com.apress.springenterpriserecipes.spring3;

import java.io.Serializable;

public class EmailUtilities implements Serializable {

	private static final long serialVersionUID = -776006059840673754L;
	private String email;
	private String password;
	private String host;

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void sendEmail(String from, String to, String txt, String html) {
		// ... presumably this does something with javamail mail sender
	}

}
