package com.apress.springenterpriserecipes.post;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BackOfficeMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("beans-back.xml");
    }
}
