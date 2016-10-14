package com.apress.springenterpriserecipes.springbatch.solution2;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.retry.RetryCallback;
import org.springframework.batch.retry.RetryContext;
import org.springframework.batch.retry.support.RetryTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.apress.springenterpriserecipes.springbatch.User;
import com.apress.springenterpriserecipes.springbatch.UserRegistrationService;
import com.apress.springenterpriserecipes.springbatch.solution1.UserRegistration;

/**
 * 
 * 
 * This class writes the user registration by calling an RPC service (whose
 * client interface is wired in using Spring
 */
public class RetryableUserRegistrationServiceItemWriter implements
      ItemWriter<UserRegistration> {

   private static final Logger logger = Logger
         .getLogger(RetryableUserRegistrationServiceItemWriter.class);

   // this is the client interface to an HTTP Invoker service.
   @Autowired
   private UserRegistrationService userRegistrationService;

   @Autowired
   private RetryTemplate retryTemplate;

   /**
    * takes aggregated input from the reader and 'writes' them using a custom
    * implementation.
    */
   public void write(List<? extends UserRegistration> items) throws Exception {
      for (final UserRegistration userRegistration : items) {
         User registeredUser = retryTemplate.execute(new RetryCallback<User>() {
            public User doWithRetry(RetryContext context) throws Exception {
               return userRegistrationService.registerUser(userRegistration);
            }
         });
         logger.debug("Registered:"
               + ToStringBuilder.reflectionToString(registeredUser));
      }
   }

}
