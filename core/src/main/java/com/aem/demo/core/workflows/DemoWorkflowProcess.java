package com.aem.demo.core.workflows;

import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(
		service = WorkflowProcess.class,
		property = "process.label = Demo workflow Process"
		
		)


public class DemoWorkflowProcess implements WorkflowProcess{

	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		// TODO Auto-generated method stub
		
	}

}
