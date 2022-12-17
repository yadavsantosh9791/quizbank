package com.aem.demo.core.models.impls;





import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.resource.Resource;

import com.aem.demo.core.models.AddAuthor;
import com.aem.demo.core.service.UtilService;




@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = AddAuthor.class,
        resourceType = AddAuthorImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class AddAuthorImpl implements AddAuthor {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AddAuthorImpl.class);
    final protected static String RESOURCE_TYPE="demotraining/components/custom/addauthor";
	

    @SlingObject
    Resource resource;

    @OSGiService
    UtilService utilService;

    @ValueMapValue
    private String actionType;
    

    
   
    @Override
	public String getActionType() {
		
		return actionType;
	}
    
    protected void init() throws LoginException {
        actionType=utilService.getActionURL(resource);
    }
	
}