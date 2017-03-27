package com.jmt.geomonitor.integration.core;


import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.ResourceUrls;
import org.springframework.stereotype.Service;

/**
 * News api integration com.jmt.geomonitor.service.
 */
public interface NewsApiIntegrationService {

    /**
     * Funnels bbc news data.
     *
     * @return abstract response integration model.
     */
    AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl,
                                                   final NewsCategories newsCategoy);
}
