package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;

/**
 * Data bank service.
 */
public interface CountryDataService {

    /**
     * Fetches country data from online source by name
     *
     * @param country
     *         Country name.
     * @return CountryDataModel domain model.
     */
    CountryDataModel fetchCountryInformationBy(String country);
}
