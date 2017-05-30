package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;

import java.net.URL;
import java.util.List;

/**
 * news api com.jmt.geomonitor.service.
 */
public interface NewsApiService {

    /**
     * Gets all news stories for given source and sort by parameters.
     *
     * @param source
     *         news Source
     * @param category
     *         news category.
     * @return
     */
    List<NewsStoryModel> getNewsStories(ResourceUrls source, NewsCategories category);

    /**
     * Loads HTML response by url
     *
     * @param url
     *         URL reference of news article.
     * @return Article in HTML format.
     */
    String getNewsStory(URL url);
}
