package com.jmt.geomonitor.integration.databank;

import com.jmt.geomonitor.integration.IntegrationConstants;
import com.jmt.geomonitor.integration.config.ClientResourceConfig;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Implementation of {@link CountryDataIntegrationService}
 */

@Service
public class CountryDataIntegrationServiceHandler extends ClientResourceConfig implements
        CountryDataIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CountryDataIntegrationService.class);

    /**
     * {@inheritDoc}
     */
    public CountryDataIntegrationModel fetchCountryData(final String country) {

        LOG.debug("Fetching country data for : {}", country);

        final String source = String.format(IntegrationConstants.COUNTRY_DATA_URL, country);
        updateWebTarget(source);

        System.out.println("Source: " + source);

        // Send rest request
        final Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();

        final List<CountryDataIntegrationModel> countryDataIntegrationModels;
        if (response.getStatus() == 200 || response.getStatus() == 201) {

            countryDataIntegrationModels = response.readEntity
                    (new GenericType<List<CountryDataIntegrationModel>>() {
                    });

            LOG.debug("Successfully returned Country data.");
            LOG.trace("Country data integration model: {}", countryDataIntegrationModels);
        } else {

            LOG.debug("Returning error response");
            throw new IllegalArgumentException("Error returned accessing country information");

        }


        return countryDataIntegrationModels.get(0);
    }
}
