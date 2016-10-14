package com.apress.springenterpriserecipes.spring3.javaconfig;

import static java.lang.System.*;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@Import(AttorneyConfiguration.class)
public class LawFirmConfiguration {

	@Autowired
	private Attorney[] attorneys; 
	// we could simply use this, instead, but I like the @Value approach :-) 

	@Value("#{denny}")
	private Attorney denny;

	@Value("#{alan}")
	private Attorney alan;

	@Value("#{shirley}")
	private Attorney shirley;

	@Bean
	public LawFirm bostonLegal() {
		LawFirm lawFirm = new LawFirm();
		lawFirm.setLawyers(Arrays.asList(denny, alan, shirley));
		lawFirm.setLocation("Boston");
		return lawFirm;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context5.xml");
		ctx.start();
		ctx.registerShutdownHook();

		LawFirm bostonLegal = ctx.getBean("bostonLegal", LawFirm.class);
		out.printf(bostonLegal.toString());
	}

}
