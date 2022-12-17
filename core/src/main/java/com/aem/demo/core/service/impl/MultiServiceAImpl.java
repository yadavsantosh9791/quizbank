package com.aem.demo.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.demo.core.service.MultiService;

public class MultiServiceAImpl implements MultiService{
	
	private static final Logger LOG = LoggerFactory.getLogger(MultiServiceAImpl.class);
	

	@Override
	public String getName() {
		
		return "MultiServiceAImpl";
	}
	
	
	
}