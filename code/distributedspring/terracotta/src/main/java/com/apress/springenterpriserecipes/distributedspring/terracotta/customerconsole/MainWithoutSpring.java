package com.apress.springenterpriserecipes.distributedspring.terracotta.customerconsole;

import com.apress.springenterpriserecipes.distributedspring.terracotta.customerconsole.service.CustomerService;
import com.apress.springenterpriserecipes.distributedspring.terracotta.customerconsole.service.CustomerServiceImpl;
import com.apress.springenterpriserecipes.distributedspring.terracotta.customerconsole.view.CustomerConsole;

public class MainWithoutSpring {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerConsole customerConsole = new CustomerConsole();
        customerConsole.setCustomerService(customerService);
        while (true)
            customerConsole.handleNextCommand("Welcome to the customer console: your choices are DELETE, UPDATE, CREATE or LIST");
    }
}
