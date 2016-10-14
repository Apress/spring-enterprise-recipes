package com.apress.springenterpriserecipes.post;

public interface PostageService {
	public double calculatePostage(String country, double weight);
}
