package com.aem.demo.core.models;

import java.util.*;

import com.aem.demo.core.helper.MultifieldHelper;


public interface AuthorBooks{
	
	String getAuthorName();
	List<String> getAuthorBooks();
	List<Map<String,String>> getBookDetailsWithMap();
	List<MultifieldHelper> getBookDetailsWithBean();
	 
}