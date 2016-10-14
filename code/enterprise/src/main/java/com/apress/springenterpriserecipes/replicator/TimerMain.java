package com.apress.springenterpriserecipes.replicator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimerMain {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-replicator-timer.xml");
		applicationContext.start();

	}
}
