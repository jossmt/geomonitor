package com.jmt.geomonitor.service;

import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.NewsStoryModel;
import com.jmt.geomonitor.domain.model.ResourceUrls;

import java.util.List;

/**
 * News api com.jmt.geomonitor.service.
 */
public interface NewsApiService {

    /**
     * Gets all news stories for given source and sort by parameters.
     *
     * @param source
     *         News Source
     * @param category
     *         News category.
     * @return
     */
    List<NewsStoryModel> getNewsStories(final ResourceUrls source, final NewsCategories category);
}
