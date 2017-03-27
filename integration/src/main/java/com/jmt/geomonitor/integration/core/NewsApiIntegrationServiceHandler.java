package com.jmt.geomonitor.integration.core;

import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.ResourceUrls;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.ErrorResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.GuardianStoriesIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implementation of {@link NewsApiIntegrationService}
 */
@Service
public class NewsApiIntegrationServiceHandler extends ClientResourceConfig implements NewsApiIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiIntegrationService.class);

    /**
     * {@inheritDoc}
     */
    public AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl, final NewsCategories
            newsCategory) {
        updateWebTarget(resourceUrl.getValue() + newsCategory.getValue());

        LOG.debug("URI: " + webTarget.getUri().toString());

        // Send rest request
        final Response response = webTarget.request().accept(MediaType.APPLICATION_XML).get();

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel;
        if (response.getStatus() == 200 || response.getStatus() == 201) {

            //TODO: add switch statement by news com.jmt.geomonitor.service
            abstractResponseIntegrationModel = response.readEntity(GuardianStoriesIntegrationModel.class);

        } else {

            abstractResponseIntegrationModel = new ErrorResponseIntegrationModel(response.getStatus(), response
                    .getHeaders());
        }

        LOG.debug("Returning abstract response integration model {}", abstractResponseIntegrationModel);

        return abstractResponseIntegrationModel;
    }
}
