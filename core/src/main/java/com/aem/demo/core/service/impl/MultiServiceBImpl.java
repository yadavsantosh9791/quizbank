package com.aem.demo.core.service.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.aem.demo.core.service.MultiService;

@Component(service = MultiService.class,immediate = true)


public class MultiServiceBImpl implements MultiService{

	
	
	
	
	
	@Override
	public String getName() {
		
		return "MultiServiceBImpl";
	}
	
	
}