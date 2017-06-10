//package databank;
//
//import com.jmt.geomonitor.controller.core.CountryDataController;
//import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
//import com.jmt.geomonitor.service.core.CountryDataService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import javax.ws.rs.core.Response;
//
///**
// * Test for {@link CountryDataController}
// */
//@RunWith(MockitoJUnitRunner.class)
//public class CountryDataControllerTest {
//
//    /** {@link CountryDataService} */
//    @Mock
//    private CountryDataService countryDataService;
//
//    /** {@link CountryDataController} */
//    private CountryDataController countryDataController;
//
//    /**
//     * Set up.
//     */
//    @Before
//    public void setUp() {
//
//        countryDataController = new CountryDataController(countryDataService);
//    }
//
//    /**
//     * Test for country data controller.
//     */
//    @Test
//    public void countryDataControllerTest() {
//
//        //Setup
//        final CountryDataModel countryDataModel = new CountryDataModel();
//        countryDataModel.setName("Spain");
//        countryDataModel.setCapital("Madrid");
//
//        //Mock
//        Mockito.when(countryDataService.fetchCountryInformationBy("Spain")).thenReturn(countryDataModel);
//
//        //Test
//        final Response response = countryDataController.getCountryData("Spain");
//
//        //Verify
//        Mockito.verify(countryDataService).fetchCountryInformationBy("Spain");
//
//        //Assert
//        final CountryDataModel countryDataModelActual = (CountryDataModel) response.getEntity();
//        Assert.assertEquals(countryDataModel, countryDataModelActual);
//
//    }
//}
