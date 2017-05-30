package com.jmt.geomonitor.integration.databank;

import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;

/**
 * Country data integration service (https://www.restcountries.eu/)
 */
public interface CountryDataIntegrationService {


    /**
     * Fetches country data via rest service.
     *
     * @param country
     *         Country to fetch data for.
     * @return {@link CountryDataIntegrationModel}
     */
    AbstractResponseIntegrationModel fetchCountryData(String country);
}
