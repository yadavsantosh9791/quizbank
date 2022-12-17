
package com.aem.demo.core.models.impls;
import com.aem.demo.core.helper.MultifieldHelper;
import com.aem.demo.core.helper.NastedHelper;
import com.aem.demo.core.helper.NastedHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.demo.core.helper.MultifieldHelper;
import com.aem.demo.core.models.AuthorBooks;


@Model(
		adaptables = SlingHttpServletRequest.class,
		adapters = AuthorBooks.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		
		)

public class AuthorBooksImpl implements AuthorBooks{
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthorBooksImpl.class);

	
	@Inject 
	Resource componentResource;
	
	@ValueMapValue
	@Default(values = "AEM")
	private String authorname;
	
	@ValueMapValue
	private List<String> books;
	
	
	
	@Override
	public String getAuthorName() {
		// TODO Auto-generated method stub
		return authorname;
	}

	@Override
	public List<String> getAuthorBooks() {
		// TODO Auto-generated method stub
		if(books!=null) {
			
			return new ArrayList<String>(books);
		}else {
			return Collections.emptyList();
			
		}
		
		
	}
	
	
	@ValueMapValue
	private String bookname;
	
	@ValueMapValue
	private String booksubject;
	
	@ValueMapValue
	private String publishyear;

	@Override
	public List<Map<String, String>> getBookDetailsWithMap() {
		// TODO Auto-generated method stub
		
		List<Map<String, String>> bookDetailsMap = new ArrayList<>();
		try {
			Resource bookDetail = componentResource.getChild("bookdetailswithmap");
			if(bookDetail!=null) {
				for(Resource book : bookDetail.getChildren()) {
					
					Map<String, String> bookMap = new HashMap<>();
					bookMap.put("bookname", book.getValueMap().get("bookname", String.class));
					bookMap.put("booksubject", book.getValueMap().get("booksubject", String.class));
					bookMap.put("publishyear", book.getValueMap().get("publishyear", String.class));
					bookDetailsMap.add(bookMap);
				}
			}
			
			
		}catch(Exception e) {
			LOG.info("\n Error while getting book details {}", e.getMessage());
		}
		LOG.info("\n SIZE {}", bookDetailsMap.size());
		System.out.println("........................"+ bookDetailsMap);
		return bookDetailsMap;
	}

	@Override
    public List<MultifieldHelper> getBookDetailsWithBean(){
        List<MultifieldHelper> bookDetailsBean=new ArrayList<>();
        try {
            Resource bookDetailBean=componentResource.getChild("bookdetailswithbean");
            if(bookDetailBean!=null){
                for (Resource bookBean : bookDetailBean.getChildren()) {
                    LOG.info("\n PATH Bean {} ",bookBean.getPath());
                    LOG.info("\n BEAN PRO {} ",bookBean.getValueMap().get("bookname",String.class));

                    bookDetailsBean.add(new MultifieldHelper(bookBean));
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details With Bean {} ",e.getMessage());
        }
        return bookDetailsBean;
    }


}
	
