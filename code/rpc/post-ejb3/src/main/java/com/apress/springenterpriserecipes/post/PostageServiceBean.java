package com.apress.springenterpriserecipes.post;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.jdbc.core.JdbcTemplate;

@Stateless
@Remote( { PostageService.class })
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class PostageServiceBean implements PostageService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public double calculatePostage(String country, double weight) {
		return 1.0;
	}
}
