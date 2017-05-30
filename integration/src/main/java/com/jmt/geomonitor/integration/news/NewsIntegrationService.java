package com.jmt.geomonitor.integration.news;


import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;

/**
 * news api integration com.jmt.geomonitor.service.
 */
public interface NewsIntegrationService {

    /**
     * Funnels bbc news data.
     *
     * @return abstract response integration model.
     */
    AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl,
                                                   final NewsCategories newsCategoy);
}
