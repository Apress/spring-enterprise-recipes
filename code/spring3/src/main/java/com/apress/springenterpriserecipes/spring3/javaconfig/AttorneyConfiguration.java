package com.apress.springenterpriserecipes.spring3.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttorneyConfiguration {

	@Bean
	public Attorney alan() {
		return new Attorney("Alan");
	}

	@Bean
	public Attorney denny() {
		return new Attorney("Denny");
	}

	@Bean
	public Attorney shirley() {
		return new Attorney("Shirley");
	}
}
