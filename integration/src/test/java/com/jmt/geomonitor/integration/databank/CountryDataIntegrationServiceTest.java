package com.jmt.geomonitor.integration.databank;

import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CurrencyIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.LanguageIntegrationModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test for {@link CountryDataIntegrationService}
 */
public class CountryDataIntegrationServiceTest {

    /** Country. */
    private static final String COUNTRY_TEST = "Spain";

    /** Class under test. */
    private CountryDataIntegrationService countryDataIntegrationService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        countryDataIntegrationService = new CountryDataIntegrationServiceHandler();
    }

    /**
     * Country data rest request test.
     */
    @Test
    public void countryDataRestRequestTest() {

        //Setup
        final CurrencyIntegrationModel currencyIntegrationModel = new CurrencyIntegrationModel();
        currencyIntegrationModel.setName("Euro");

        final LanguageIntegrationModel languageIntegrationModel = new LanguageIntegrationModel();
        languageIntegrationModel.setName("Spanish");

        final CountryDataIntegrationModel spainCountryModel = new CountryDataIntegrationModel();
        spainCountryModel.setName("Spain");
        spainCountryModel.setAlpha2Code("ES");
        spainCountryModel.setAlpha3Code("ESP");
        spainCountryModel.setCapital("Madrid");
        spainCountryModel.setFlag("https://restcountries.eu/data/esp.svg");
        spainCountryModel.setCurrencies(Arrays.asList(currencyIntegrationModel));
        spainCountryModel.setLanguages(Arrays.asList(languageIntegrationModel));

        //Test
        final CountryDataIntegrationModel countryDataIntegrationModel = (CountryDataIntegrationModel)
                countryDataIntegrationService.fetchCountryData(COUNTRY_TEST);

        System.out.println(countryDataIntegrationModel.toString());

        //Assert
        Assert.assertEquals(countryDataIntegrationModel.toString(), spainCountryModel.toString());
    }
}
