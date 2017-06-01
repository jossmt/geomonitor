package com.jmt.geomonitor.integration.news;


import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;

/**
 * com.jmt.geomonitor.integration.news api integration com.jmt.geomonitor.service.
 */
public interface NewsIntegrationService {

    /**
     * Funnels bbc com.jmt.geomonitor.integration.news data.
     *
     * @return abstract response integration model.
     */
    AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl,
                                                   final NewsCategories newsCategoy);
}
