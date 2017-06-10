package com.jmt.geomonitor.controller.core;

import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import com.jmt.geomonitor.service.core.NewsService;
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

import java.net.URL;
import java.util.List;


/**
 * news api rest controller.
 */
@Controller
@RequestMapping(value = "/")
public class NewsController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsController.class);

    /** {@link NewsService} */
    private final NewsService newsService;

    /** {@link NewsStoryModel} list. */
    private List<NewsStoryModel> recentlyGeneratedList;

    /**
     * api rest controller.
     *
     * @param newsService
     *         news api service.
     */
    @Autowired
    public NewsController(final NewsService newsService) {
        this.newsService = newsService;
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
        Validate.notNull(newsCategory, "The category requested is not available {}", category);

        recentlyGeneratedList = newsService.getNewsStories(resourceUrl, newsCategory);

        LOG.debug("news story request returned news story models {}", recentlyGeneratedList);

        modelAndView.addObject("nList", recentlyGeneratedList);
        modelAndView.setViewName("NewsDashboard");

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String getNewsArticle(@PathVariable final Integer id){

        final URL urlResponse;

        if(recentlyGeneratedList != null){

            urlResponse = recentlyGeneratedList.get(id).getUrl();

        }else{

            throw new IllegalArgumentException("Error returning news article");
        }

        return newsService.getNewsStory(urlResponse);

    }
}
