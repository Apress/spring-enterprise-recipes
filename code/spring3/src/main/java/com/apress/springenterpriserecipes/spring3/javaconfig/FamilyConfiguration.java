package com.apress.springenterpriserecipes.spring3.javaconfig;

import static java.lang.System.out;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@Import(BusinessConfiguration.class)
public class FamilyConfiguration {

   @Bean
   public Person mario() {
      Person mario = new Person();
      mario.setName("Mario");
      return mario;
   }

   @Bean
   public Person fumiko() {
      Person fumiko = new Person();
      fumiko.setName("Fumiko");
      return fumiko;
   }

   @Bean
   public Person makani() {
      Person makani = new Person();
      makani.setName("Makani");
      makani.setFather(mario());
      makani.setMother(fumiko());
      return makani;
   }

   public static void main(String[] args) {
      ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
            "context4.xml");
      classPathXmlApplicationContext.start();
      classPathXmlApplicationContext.registerShutdownHook();

      Person mario = classPathXmlApplicationContext.getBean("mario", Person.class);
      Person fumiko = classPathXmlApplicationContext
            .getBean("fumiko", Person.class);
      Person makani = classPathXmlApplicationContext
            .getBean("makani", Person.class);

      out.println(mario.toString());
      out.println(fumiko.toString());
      out.println(makani.toString());

   }
}
