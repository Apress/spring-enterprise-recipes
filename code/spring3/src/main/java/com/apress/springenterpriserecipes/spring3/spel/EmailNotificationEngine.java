package com.apress.springenterpriserecipes.spring3.spel;

import static java.lang.System.out;

import java.util.Properties;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.apress.springenterpriserecipes.spring3.EmailUtilities;

public class EmailNotificationEngine implements InitializingBean {

	@Value("#{ systemProperties }") 
	private Properties systemProperties;

	//@Value("#{  T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;

	@Value("#{ emailUtilities.email }")
	private String login;

	@Value("#{ emailUtilities.password }")
	private String password;

	@Value("#{ emailUtilities.host}")
	private String host;

	@Autowired
	private EmailUtilities emailUtilities1;

	@Value("#{ emailUtilities }")
	private EmailUtilities emailUtilities2;

	public void afterPropertiesSet() throws Exception {
		out.printf(ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE));
	}

	public void notifyNewCustomers() {
		/** ... */
	}

	public void setRandomNumber(double randomNumber) {
		this.randomNumber = randomNumber;
	}

	public double getRandomNumber() {
		return randomNumber;
	}
}
