package com.aem.demo.core.models.impls;

import java.util.Iterator;
import java.util.List;

import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.demo.core.models.ServiceDemo;
import com.aem.demo.core.service.DemoService;
import com.aem.demo.core.service.DemoServiceB;
import com.aem.demo.core.service.MultiService;
import com.day.cq.wcm.api.Page;

public class ServiceDemoImpl  implements ServiceDemo {
	
	
	private static final Logger LOG= LoggerFactory.getLogger(ServiceDemoImpl.class);

	@OSGiService
    DemoService demoService;
	
	 
	@OSGiService
    DemoServiceB demoServiceB;
	
	
	
	
	
	@Override
	public Iterator<Page> getPagesList() {
		
		return demoService.getPages();
	}

	@Override
	public List<String> getPageTitleList() {
		
		return demoServiceB.getPages();
	}

	@OSGiService(filter = "(component.name=serviceA)")
	MultiService multiService;
	
	@OSGiService(filter = "(component.name=com.aem.geeks.core.services.impl.MultiServiceBImpl)")
    MultiService multiServiceB;
	
	@Override
	public String getNameFromService() {
		// TODO Auto-generated method stub
		return multiServiceB.getName();
	}

	@Override
	public String getNameFromServiceB() {
		// TODO Auto-generated method stub
		return multiService.getName();
	}

	@Override
	public String getNameWithReference() {
		
		return demoServiceB.getNameWithReference();
	}
	
	
	
	
	
	
	
	
}
