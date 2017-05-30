package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.domain.model.databank.CountryData;

/**
 * Data bank service.
 */
public interface CountryDataService {

    /**
     * Fetches country data from online source by name
     *
     * @param country
     *         Country name.
     * @return CountryData domain model.
     */
    CountryData fetchCountryInformationby(String country);
}
