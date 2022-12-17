package com.aem.demo.core.service;

import com.day.cq.wcm.api.Page;

import java.util.Iterator;

public interface DemoService {
	public Iterator<Page> getPages();
    
}