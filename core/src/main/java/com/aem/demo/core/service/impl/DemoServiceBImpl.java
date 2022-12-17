package com.aem.demo.core.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.demo.core.service.DemoService;
import com.aem.demo.core.service.DemoServiceB;
import com.aem.demo.core.service.MultiService;
import com.day.cq.wcm.api.Page;

@Component(service = DemoServiceB.class,immediate = true)
public class DemoServiceBImpl implements DemoServiceB {
	
	private static final Logger LOG = LoggerFactory.getLogger(DemoServiceBImpl.class);

	
	@Reference(target = "(component.name=com.aem.demo.core.service.impl.MultiServiceBImpl)")
	MultiService multiService;
	
	
	@Override
	public String getNameWithReference() {
		
		return "Response coming from  "+multiService.getName();
	}
	
	@Reference
    DemoService demoService;
	
	
	@Override
	public List<String> getPages() {
		
		List<String> listPages = new ArrayList<String>();
		
		try {
			Iterator<Page> pages=demoService.getPages();
            while (pages.hasNext()) {
                listPages.add(pages.next().getTitle());
            }
            return listPages;
			
			
		}catch (Exception e) {
            LOG.info("\n  Exception {} ",e.getMessage());
        }
		return null;
		
	}

	
	
}



