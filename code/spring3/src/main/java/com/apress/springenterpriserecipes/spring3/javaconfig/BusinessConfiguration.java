package com.apress.springenterpriserecipes.spring3.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfiguration {

	@Bean(initMethod = "startLife", destroyMethod = "die")
	public Person companyLawyer() {
		Person companyLawyer = new Person();
		companyLawyer.setName("Alan Crane");
		return companyLawyer;
	}

	@Bean(name = "theArtistFormerlyKnownAsJosh")
	public Person josh() {
		Person josh = new Person();
		josh.setName("Josh");
		return josh;
	}

}
