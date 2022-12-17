package com.aem.demo.core.impl;



import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.LoggerFactory;
import org.slf4j.*;

import com.aem.demo.core.models.Author;
import com.day.cq.wcm.api.Page;



@Model(adaptables = SlingHttpServletRequest.class,
adapters = Author.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class AuthorImpl implements Author{
	private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);
	
	@SlingObject
	ResourceResolver resourceResolver;
	
	@RequestAttribute(name = "rAttribute")
	private String reqAttribute;
	
	@ScriptVariable
	Page currentPage;
	
	
	@Inject
	@Via("resource")
	@Default(values = "AEM")
	String fname;
	
	
	@ValueMapValue
	@Default(values = "DEMO")
	String lname;
	
	@Inject
	@Via("resource")
	boolean professor;
	
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return fname;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lname;
	}

	@Override
	public boolean getIsProfessor() {
		// TODO Auto-generated method stub
		return professor;
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return currentPage.getTitle();
	}
	
	@Override
	public String getRequestAttribute() {
		return reqAttribute;
	}
	
}