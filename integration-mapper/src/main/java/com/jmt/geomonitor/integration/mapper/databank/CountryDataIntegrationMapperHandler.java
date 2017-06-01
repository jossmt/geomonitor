package com.jmt.geomonitor.integration.mapper.databank;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CurrencyIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.LanguageIntegrationModel;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link CountryDataIntegrationMapper}
 */
@Component
public class CountryDataIntegrationMapperHandler implements CountryDataIntegrationMapper {

    /**
     * {@inheritDoc}
     */
    public CountryDataModel map(final CountryDataIntegrationModel countryDataIntegrationModel) {

        CountryDataModel countryDataModel = null;
        if (countryDataIntegrationModel != null) {

            countryDataModel = new CountryDataModel();
            countryDataModel.setName(countryDataIntegrationModel.getName());
            countryDataModel.setCapital(countryDataIntegrationModel.getCapital());

            //Add currencies
            final List<String> currencies = new ArrayList<>();
            for (final CurrencyIntegrationModel currency : countryDataIntegrationModel.getCurrencies()) {
                currencies.add(currency.getName());
            }
            countryDataModel.setCurrencies(currencies);

            //Add languages
            final List<String> languages = new ArrayList<>();
            for (final LanguageIntegrationModel language : countryDataIntegrationModel.getLanguages()) {
                languages.add(language.getName());
            }
            countryDataModel.setLanguages(languages);
            try {
                countryDataModel.setFlag(new URL(countryDataIntegrationModel.getFlag()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("Unable to create url from: " + countryDataIntegrationModel
                        .getFlag());
            }
        }

        return countryDataModel;
    }
}
