package com.apress.springenterpriserecipes.springbatch;

import java.util.Collection;
import java.util.Date;

import com.apress.springenterpriserecipes.springbatch.solution1.UserRegistration;

public interface UserRegistrationService {

	Collection<UserRegistration> getOutstandingUserRegistrationBatchForDate(int quantity, Date date);

	User registerUser(UserRegistration userRegistration);

	User unregisterUser(UserRegistration userRegistration);
}
