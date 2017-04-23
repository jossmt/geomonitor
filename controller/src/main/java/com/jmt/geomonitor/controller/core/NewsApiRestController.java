package com.jmt.geomonitor.controller.core;

import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.NewsStoryModel;
import com.jmt.geomonitor.domain.model.ResourceUrls;
import com.jmt.geomonitor.service.core.NewsApiService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * News api rest controller.
 */
@Controller
@RequestMapping(value = "/")
public class NewsApiRestController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiRestController.class);

    /** {@link NewsApiService} */
    private final NewsApiService newsApiService;

    /** {@link NewsStoryModel} list. */
    private List<NewsStoryModel> recentlyGeneratedList;

    /**
     * News api rest controller.
     *
     * @param newsApiService
     *         News api com.jmt.geomonitor.service.
     */
    @Autowired
    public NewsApiRestController(final NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    /**
     * Returns news stories with resource and category funnel
     *
     * @param resource
     *         Resource.
     * @param category
     *         Category.
     * @return Model and view.
     */
    @RequestMapping(value = "/news/{resource}/{category}", method = RequestMethod.GET)
    public ModelAndView getNewsStoriesByCategory(@PathVariable final String resource,
                                                 @PathVariable final String category) {

        LOG.debug("Received news stories request with resource {}, and category {}", resource, category);

        final ModelAndView modelAndView = new ModelAndView();

        final ResourceUrls resourceUrl = ResourceUrls.valueOf(resource);
        final NewsCategories newsCategory = NewsCategories.valueOf(category);
        Validate.notNull(resourceUrl, "The request resource does not exist {}", resource);
        Validate.notNull(newsCategory, "The news category requested is not available {}", category);

        recentlyGeneratedList = newsApiService.getNewsStories(resourceUrl, newsCategory);

        LOG.debug("News story request returned news story models {}", recentlyGeneratedList);

        modelAndView.addObject("nList", recentlyGeneratedList);
        modelAndView.setViewName("NewsDashboard");

        return modelAndView;

    }

    /**
     * Home page test.
     *
     * @param model
     *         Model objects.
     * @return HTML page.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        LOG.debug("index() is executed!");

        return "MonitorDashboard";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody String viewTemp(@PathVariable final Integer id){

        final URL urlResponse;

        if(recentlyGeneratedList != null){

            urlResponse = recentlyGeneratedList.get(id).getUrl();

        }else{

            throw new IllegalArgumentException("Error returning news article");
        }

        return newsApiService.getNewsStory(urlResponse);

    }
}
