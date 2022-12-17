package com.aem.demo.core.servlets;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;


@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/executeworkflow","/demo/executeworkflow"}
)

public class ExecuteWorkflow extends SlingSafeMethodsServlet{
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ExecuteWorkflow.class);
	
	protected void doget(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)throws ServletException, IOException{
		
		String status = "Workflow Excution";
		final ResourceResolver resourceResolver = req.getResourceResolver();
		String payload = req.getRequestParameter("page").getString();
		
		try {
			 if(StringUtils.isNotBlank(payload)){
				
				WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
				WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/geeks-page-version");
				WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payload);
				status = workflowSession.startWorkflow(workflowModel, workflowData).getState();
				
			}
		}catch(Exception e) {
			LOG.info("\n ERROR IN WORKFLOW {} ", e.getMessage());
		}
		resp.setContentType("application/json");
		resp.getWriter().write(status);
		
	}
	
}