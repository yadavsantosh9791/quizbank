package com.aem.demo.core.models.impls;

import com.aem.demo.core.models.BuenFin;
import com.aem.demo.core.models.CitiBuenFin;
//import com.citi.core.models.bean.BuenfinBean;
//import com.citi.core.services.BuenfinOsgiConfig;
//import com.citi.core.utils.CitiConstant;
//import com.citi.core.utils.DataLayerUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.components.ComponentContext;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
//import lombok.Data;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Data
@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = CitiBuenFin.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CitiBuenFinImpl implements CitiBuenFin {
  private final Logger logger = LoggerFactory.getLogger(CitiBuenFinImpl.class);

  @Inject
  //@Via(CitiConstant.RESOURCE)
  Resource resource;
  @Inject
  Page currentPage;

  @Inject
  Resource componentResource;

  @ValueMapValue
 // @Default(values = CitiConstant.DATA_FIB_SEARCH_LABEL_VALUE)
  private String searchLabel;

  @ValueMapValue
 // @Default(values = CitiConstant.DATA_FIN_SEARCH_PLACEHOLDER_VALUE)
  private String searchPlaceholder;

  @ValueMapValue
  private String filterLabel;

  @ValueMapValue
  private String filterOptionLabel;

  @ValueMapValue
  private String filterOptionValue;

  @ValueMapValue
  private String finId;

  @Inject
  @Via("resource")
  @Named("buenFin/.")
  List<BuenFin> buenFinList;

  @Inject
  public ComponentContext componentContext;
  @Self
  private SlingHttpServletRequest request;

  //@JsonIgnore
  public String configJson = "{}";

  @OSGiService
 // BuenfinOsgiConfig buenfinOsgiConfig;

  //private BuenfinBean buenfinBean;
  @SlingObject
  private ResourceResolver resourceResolver;
  private Map<String, String> buenfinmap;

  @PostConstruct
  public void init() {
  //  buenfinBean = new BuenfinBean();
  //  buenfinBean.setQuery(buenfinOsgiConfig.getEndPointUrl());
    //buenfinBean.setCanalesId(buenfinOsgiConfig.getCanalesId());
    //buenfinBean.setCategoriasId(buenfinOsgiConfig.getCategoriasId());
    configJson = getBuenfinConfigurationAsJson();
    logger.info("configJson.." + configJson);

    @Nullable
    Resource operationresource = resourceResolver.getResource("/etc/acs-commons/lists/citybanamex/buen-fin/jcr:content/list");
    if (Objects.nonNull(operationresource)) {
      //buenfinmap = new HashMap<String, String>();
      buenfinmap = new TreeMap<String, String>();
      @NotNull
      Iterable<Resource> children = operationresource.getChildren();
      for (Resource childResource : children) {

        String title = childResource.getValueMap().get("jcr:title", String.class);

        String nodevalue = childResource.getValueMap().get("value", String.class);
        buenfinmap.put(nodevalue, title);
        logger.info("buenfinmap::" + buenfinmap);

      }

    }

  }

  @Override
 // public String getData() {
    //return DataLayerUtil
     //   .builder().currentResource(resource).currentPage(currentPage)
      //  .property(CitiConstant.DATA_TYPE, resource.getResourceType())
       // .property(CitiConstant.DATA_NAME, resource.getName())
       // .property(CitiConstant.DATA_DC_TITLE, currentPage.getTitle())
       // .property(CitiConstant.DATA_LINK, currentPage.getPath())
        //.property(CitiConstant.DATA_MODIFIED_DATE, DataLayerUtil.convertToUtc(currentPage.getLastModified().getTime()))
        //.property(CitiConstant.DATA_FIB_SEARCH_LABEL, searchLabel)
        //.property(CitiConstant.DATA_FIN_SEARCH_PLACEHOLDER, searchPlaceholder)
        //.property(CitiConstant.SEARCH_FIN_FILTER_LABEL, filterLabel)
        //.property(CitiConstant.SEARCH_FIN_FILTER_OPTION_LABEL, filterOptionLabel)
       // .property(CitiConstant.SEARCH_FIN_FILTER_OPTION_VALUE, filterOptionValue)
        //.property(CitiConstant.DATA_FIN_ID, finId)
       // .build()
        //.getJson();
//}

  //@Override
  public String getBuenfinConfigurationAsJson() {
   // final ObjectMapper objectMapper = new ObjectMapper();
    String asJson = "{}";
    try {
     // asJson = objectMapper.writeValueAsString(buenfinBean);
    } catch (Exception e) {
      logger.error("error while generating json", e);
    }
    return asJson;
  }
}
