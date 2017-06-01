package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;

import java.net.URL;
import java.util.List;

/**
 * com.jmt.geomonitor.integration.news api com.jmt.geomonitor.service.
 */
public interface NewsService {

    /**
     * Gets all com.jmt.geomonitor.integration.news stories for given source and sort by parameters.
     *
     * @param source
     *         com.jmt.geomonitor.integration.news Source
     * @param category
     *         com.jmt.geomonitor.integration.news category.
     * @return
     */
    List<NewsStoryModel> getNewsStories(ResourceUrls source, NewsCategories category);

    /**
     * Loads HTML response by url
     *
     * @param url
     *         URL reference of com.jmt.geomonitor.integration.news article.
     * @return Article in HTML format.
     */
    String getNewsStory(URL url);
}
