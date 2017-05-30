package com.jmt.geomonitor.integration.databank;

import com.jmt.geomonitor.integration.IntegrationConstants;
import com.jmt.geomonitor.integration.config.ClientResourceConfig;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.ErrorResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModelWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implementation of {@link CountryDataIntegrationService}
 */
public class CountryDataIntegrationServiceHandler extends ClientResourceConfig implements
        CountryDataIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CountryDataIntegrationService.class);

    /**
     * {@inheritDoc}
     */
    public AbstractResponseIntegrationModel fetchCountryData(final String country) {

        LOG.debug("Fetching country data for : {}", country);

        final String source = String.format(IntegrationConstants.COUNTRY_DATA_URL, country);
        updateWebTarget(source);

        System.out.println("Source: " + source);

        // Send rest request
        final Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel;
        if (response.getStatus() == 200 || response.getStatus() == 201) {

            abstractResponseIntegrationModel = response.readEntity
                    (CountryDataIntegrationModelWrapper.class);

            LOG.debug("Successfully returned Country data.");
            LOG.trace("Country data integration model: {}", abstractResponseIntegrationModel);
        } else {

            abstractResponseIntegrationModel = response.readEntity
                    (ErrorResponseIntegrationModel.class);

            LOG.debug("Returning error response");
            LOG.trace("Error response: {}", abstractResponseIntegrationModel);
        }

        return abstractResponseIntegrationModel;
    }
}
