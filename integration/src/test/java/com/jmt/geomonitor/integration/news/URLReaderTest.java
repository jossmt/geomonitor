package com.jmt.geomonitor.integration.news;

import com.jmt.geomonitor.integration.config.CSSRemovalSelectors;
import com.jmt.geomonitor.integration.config.URLReader;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

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
        final URL testURL = new URL("https://www.theguardian.com/money/2017/apr/23/tory-energy-bill-cap-will-save" +
                                            "-families-100-damian-green-says");

        final String response = URLReader.readHtml(testURL, CSSRemovalSelectors.guardianSelectors);

        System.out.println(response);
    }
}
