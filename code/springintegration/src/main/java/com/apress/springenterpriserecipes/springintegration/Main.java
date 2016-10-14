package com.apress.springenterpriserecipes.springintegration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String contextName = "09-1-gateways_service.xml";
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				contextName);
		applicationContext.start();
	}
}
