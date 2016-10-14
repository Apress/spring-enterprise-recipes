package com.apress.springenterpriserecipes.spring3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	static public void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( args[0]);
		context.start();
		
		context.registerShutdownHook() ;
	}
}
