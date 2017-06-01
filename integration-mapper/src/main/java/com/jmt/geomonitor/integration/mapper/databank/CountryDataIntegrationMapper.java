package com.jmt.geomonitor.integration.mapper.databank;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;

import java.net.MalformedURLException;

/**
 * Maps {@link CountryDataIntegrationModel} to {@link CountryDataModel}
 */
public interface CountryDataIntegrationMapper {

    /**
     * Maps integration model to domain.
     *
     * @return {@link CountryDataModel}
     */
    CountryDataModel map(CountryDataIntegrationModel countryDataIntegrationModel);
}
