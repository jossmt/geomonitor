package news;

import com.jmt.geomonitor.integration.databank.CountryDataIntegrationService;
import com.jmt.geomonitor.integration.databank.CountryDataIntegrationServiceHandler;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import org.junit.Before;
import org.junit.Test;

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


        //Test
        final CountryDataIntegrationModel countryDataIntegrationModel = (CountryDataIntegrationModel)
                countryDataIntegrationService.fetchCountryData(COUNTRY_TEST);

        //Assert
        System.out.println(countryDataIntegrationModel.toString());
    }
}
