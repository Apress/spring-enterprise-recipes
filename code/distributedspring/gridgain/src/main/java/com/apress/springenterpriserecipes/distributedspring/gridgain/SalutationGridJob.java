package com.apress.springenterpriserecipes.distributedspring.gridgain;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridNode;
import org.gridgain.grid.resources.GridSpringApplicationContextResource;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;

/**
 * @author Josh Long
 */
public class SalutationGridJob implements GridJob {
	
	private static final long serialVersionUID = 1L;

	public void cancel() {

    }

    @GridSpringApplicationContextResource
    private ApplicationContext context;


    private String nameOfPersonToSalute;

    public SalutationGridJob(String name) {
        this.nameOfPersonToSalute = name;
    }

    public Serializable execute() throws GridException { 
    	GridNode gridNode = GridFactory.getGrid().getLocalNode();
    	Serializable attribute = gridNode.getAttribute("");
        System.out.println(nameOfPersonToSalute + ":" + (null == context));
        for (String beanName : context.getBeanDefinitionNames())
            System.out.println(beanName);
        return null;
    }
}
