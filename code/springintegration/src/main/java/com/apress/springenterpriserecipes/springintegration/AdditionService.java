package com.apress.springenterpriserecipes.springintegration;

import org.springframework.integration.core.Message;

/** 
 * simple example designed to demonstrate adding over queues! Horribly inefficient, but it demonstrates a point.
 *  
 */
public class AdditionService {
	
	public Number add( Operands ops) {
		 return  new Float(
				 ops.getA().floatValue() + ops.getB().floatValue());
		 
	}
}
