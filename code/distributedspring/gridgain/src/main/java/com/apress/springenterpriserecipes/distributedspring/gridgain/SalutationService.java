package com.apress.springenterpriserecipes.distributedspring.gridgain;


public interface SalutationService {

    String saluteSomeoneInForeignLanguage(String recipient);

    String[] saluteManyPeopleInRandomForeignLanguage(String[] recipients);

}
