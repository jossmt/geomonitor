import com.jmt.geomonitor.domain.model.databank.CountryDataModel;
import com.jmt.geomonitor.integration.mapper.databank.CountryDataIntegrationMapper;
import com.jmt.geomonitor.integration.mapper.databank.CountryDataIntegrationMapperHandler;
import com.jmt.geomonitor.integration.model.databank.CountryDataIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.CurrencyIntegrationModel;
import com.jmt.geomonitor.integration.model.databank.LanguageIntegrationModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Test for {@link CountryDataIntegrationMapper}
 */
public class CountryDataIntegrationMapperTest {

    /** {@link CountryDataIntegrationMapper} */
    private CountryDataIntegrationMapper countryDataIntegrationMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        countryDataIntegrationMapper = new CountryDataIntegrationMapperHandler();
    }

    /**
     * Test all fields
     */
    @Test
    public void fullCountryDataIntegrationMapperTest() throws MalformedURLException {

        //Setup
        final CurrencyIntegrationModel currencyIntegrationModel = new CurrencyIntegrationModel();
        currencyIntegrationModel.setName("Currency");

        final LanguageIntegrationModel languageIntegrationModel = new LanguageIntegrationModel();
        languageIntegrationModel.setName("Language");

        final CountryDataIntegrationModel countryDataIntegrationModel = new CountryDataIntegrationModel();
        countryDataIntegrationModel.setCapital("Capital");
        countryDataIntegrationModel.setFlag("http://www.flag.com");
        countryDataIntegrationModel.setName("Name");
        countryDataIntegrationModel.setAlpha2Code("Alpha2Code");
        countryDataIntegrationModel.setAlpha3Code("Alpha3Code");
        countryDataIntegrationModel.setCurrencies(Arrays.asList(currencyIntegrationModel));
        countryDataIntegrationModel.setLanguages(Arrays.asList(languageIntegrationModel));

        final CountryDataModel countryDataModel = new CountryDataModel();
        countryDataModel.setName("Name");
        countryDataModel.setCapital("Capital");
        countryDataModel.setFlag(new URL("http://www.flag.com"));
        countryDataModel.setLanguages(Arrays.asList("Language"));
        countryDataModel.setCurrencies(Arrays.asList("Currency"));

        //Test
        final CountryDataModel actualCountryDataModel = countryDataIntegrationMapper.map(countryDataIntegrationModel);

        //Assert
        Assert.assertEquals(countryDataModel.toString(), actualCountryDataModel.toString());
    }
}
