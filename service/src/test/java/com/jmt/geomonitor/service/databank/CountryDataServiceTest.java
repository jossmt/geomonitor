package com.jmt.geomonitor.service.databank;

import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.integration.databank.CountryDataIntegrationService;
import com.jmt.geomonitor.integration.mapper.databank.CountryDataIntegrationMapper;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import com.jmt.geomonitor.service.core.CountryDataService;
import com.jmt.geomonitor.service.core.CountryDataServiceHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test for {@link CountryDataService}
 */
@RunWith(MockitoJUnitRunner.class)
public class CountryDataServiceTest {

    /** {@link CountryDataIntegrationMapper} */
    @Mock
    private CountryDataIntegrationMapper countryDataIntegrationMapper;

    /** {@link CountryDataIntegrationService} */
    @Mock
    private CountryDataIntegrationService countryDataIntegrationService;

    /** {@link CountryDataService} */
    private CountryDataService countryDataService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        countryDataService = new CountryDataServiceHandler(countryDataIntegrationService, countryDataIntegrationMapper);
    }

    /**
     * Test for country data service.
     */
    @Test
    public void validateCountryDataServiceTest() {

        //Setup
        final CountryDataIntegrationModel countryDataIntegrationModel = new CountryDataIntegrationModel();
        countryDataIntegrationModel.setName("Spain");

        final CountryDataModel countryDataModel = new CountryDataModel();
        countryDataModel.setName("Spain");

        //Mock
        Mockito.when(countryDataIntegrationService.fetchCountryData("Spain")).thenReturn(countryDataIntegrationModel);
        Mockito.when(countryDataIntegrationMapper.map(countryDataIntegrationModel)).thenReturn(countryDataModel);

        //Test
        final CountryDataModel actualCountryDataModel = countryDataService.fetchCountryInformationBy("Spain");

        //Verify
        Mockito.verify(countryDataIntegrationService).fetchCountryData("Spain");
        Mockito.verify(countryDataIntegrationMapper).map(countryDataIntegrationModel);

        //Assert
        Assert.assertEquals(countryDataModel.toString(), actualCountryDataModel.toString());
    }
}
