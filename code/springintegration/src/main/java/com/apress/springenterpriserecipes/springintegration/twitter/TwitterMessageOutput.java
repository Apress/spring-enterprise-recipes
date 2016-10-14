package com.apress.springenterpriserecipes.springintegration.twitter;

public class TwitterMessageOutput {

	public void announce(Tweet tweet) {
		System.out.println(tweet.toString());
	}
}
