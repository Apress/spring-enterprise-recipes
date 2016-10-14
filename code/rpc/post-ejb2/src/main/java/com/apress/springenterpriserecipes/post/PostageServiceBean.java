package com.apress.springenterpriserecipes.post;

import javax.ejb.CreateException;

import org.springframework.ejb.support.AbstractStatelessSessionBean;

public class PostageServiceBean extends AbstractStatelessSessionBean
        implements PostageService {

    private PostageService postageService;

    protected void onEjbCreate() throws CreateException {
        postageService = (PostageService)
                getBeanFactory().getBean("postageService");
    }

    public double calculatePostage(String country, double weight) {
        return postageService.calculatePostage(country, weight);
    }
}
