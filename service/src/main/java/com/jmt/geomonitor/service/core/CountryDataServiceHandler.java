package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.integration.databank.CountryDataIntegrationService;
import com.jmt.geomonitor.integration.mapper.databank.CountryDataIntegrationMapper;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CountryDataService}
 */
@Service
public class CountryDataServiceHandler implements CountryDataService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CountryDataService.class);

    /** {@link CountryDataService} */
    private CountryDataIntegrationService countryDataIntegrationService;

    /** {@link CountryDataIntegrationMapper} */
    private CountryDataIntegrationMapper countryDataIntegrationMapper;

    /**
     * Constructor.
     *
     * @param countryDataIntegrationService
     *         {@link CountryDataIntegrationService}
     */
    @Autowired
    public CountryDataServiceHandler(final CountryDataIntegrationService countryDataIntegrationService,
                                     final CountryDataIntegrationMapper countryDataIntegrationMapper) {

        this.countryDataIntegrationService = countryDataIntegrationService;
        this.countryDataIntegrationMapper = countryDataIntegrationMapper;
    }

    /**
     * {@inheritDoc}
     */
    public CountryDataModel fetchCountryInformationBy(final String country) {

        LOG.debug("Fetching country information for {}", country);

        final CountryDataIntegrationModel countryDataIntegrationModel = countryDataIntegrationService
                .fetchCountryData(country);

        final CountryDataModel countryDataModel = countryDataIntegrationMapper.map(countryDataIntegrationModel);

        LOG.debug("Returning fetched model data");
        LOG.trace("Country data model: {}", countryDataModel);

        return countryDataModel;
    }
}
