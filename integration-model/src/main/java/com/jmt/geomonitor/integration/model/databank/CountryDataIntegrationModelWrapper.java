package com.jmt.geomonitor.integration.model.databank;

import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;

import java.util.List;

/**
 * Wrapper for {@link CountryDataIntegrationModel}
 */
public class CountryDataIntegrationModelWrapper extends AbstractResponseIntegrationModel{

    /**
     * Country data integration model.
     */
    private List<CountryDataIntegrationModel> countryDataIntegrationModels;
}
