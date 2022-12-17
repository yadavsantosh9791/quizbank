package com.aem.demo.core.workflows;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

import org.osgi.framework.Constants;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import javax.jcr.Node;


@Component(
		service = WorkflowProcess.class,
		property = {
				"process.lable" + "= Geek workflow step",
				Constants.SERVICE_VENDOR + "=AEM Geeks",
				Constants.SERVICE_DESCRIPTION + " = Custom Geeks workflow step."
		}
		
		
		)



public class GeeksWorkflowStep implements WorkflowProcess{
	private static final Logger LOG = LoggerFactory.getLogger(GeeksWorkflowStep.class);
	
	
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap processArguments) {
		LOG.info("\n ====================================Custom Workflow Step========================================");
		try {
			WorkflowData workflowData = workItem.getWorkflowData();
			if(workflowData.getPayloadType().equals("JCR_PATH")) {
				Session session = workflowSession.adaptTo(Session.class);
				String path = workflowData.getPayload().toString()+"/jcr:content";
				Node node = (Node) session.getItem(path);
				String brand = processArguments.get("BRAND", "");
				boolean multinational = processArguments.get("MULTINATIONAL", false);
				LOG.info("\n BRAND : {} , MULTINATIONAL : {} ",brand,multinational);
				String[] countries = processArguments.get("COUNTRIES",new String[]{});
                for (String country : countries) {
                    LOG.info("\n Countries {} ",country);
                }
			}
			
		}catch (Exception e){
            LOG.info("\n ERROR {} ",e.getMessage());
		}
            
		
	
	
	}
	
	
}