package com.apress.springenterpriserecipes.osgi.helloworld.service;

public interface GreetingRecorderService {
    int getCountOfGreetingsFor(String name);
    int getCountOfGreetingsIn(String language) ;
}
