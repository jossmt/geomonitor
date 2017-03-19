package com.geomonitor.jmt.integration; /**
 * Created by jossmillertodd on 04/03/2017.
 */


import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.ResourceUrls;

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
