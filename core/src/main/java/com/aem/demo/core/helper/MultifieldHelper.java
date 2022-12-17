package com.aem.demo.core.helper;


import java.util.Date;
import java.util.List;


import org.apache.sling.api.resource.Resource;

public class MultifieldHelper{
	
	private String bookName;
	private Date publishDate;
	private int copies;
	private List<NastedHelper> bookEditons;
	public MultifieldHelper(Resource resource) {
		try {
			
			if(resource.getValueMap().get("bookname", String.class)!=null) {
				this.bookName = resource.getValueMap().get("bookname", String.class);
				
			}
			if(resource.getValueMap().get("publishdate", Date.class)!=null) {
				this.publishDate = resource.getValueMap().get("publishdate", Date.class);
				
			}
			if(resource.getValueMap().get("copies", Integer.class)!=null) {
				this.copies = resource.getValueMap().get("copies", Integer.class);
				
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public List<NastedHelper> getBookEditons(){
		return bookEditons;
	}
	
	public void setBookEditons(List<NastedHelper> bookEditons) {
		this.bookEditons = bookEditons;
	}
	
}