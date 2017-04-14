import com.jmt.geomonitor.integration.config.CSSRemovalSelectors;
import com.jmt.geomonitor.integration.config.URLReader;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Test for {@link URLReader}
 */
public class URLReaderTest {

    /**
     * Tests reader with random url
     */
    @Test
    public void testReader() throws MalformedURLException {

        /** Test url. */
        final URL testURL = new URL("https://www.theguardian" +
                                            ".com/world/2017/apr/14/north-korea-blames-donald-trumps-aggression-amid" +
                                            "-nuclear-test-crisis");

        final String response = URLReader.readHtml(testURL, CSSRemovalSelectors.guardianSelectors);

        System.out.println(response);
    }
}
