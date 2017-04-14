package com.jmt.geomonitor.integration.config;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Reads url and returns html document
 */
public class URLReader {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(URLReader.class);

    /**
     * Reads file line by line from url and saves in output file.
     *
     * @param url
     *         Source URL.
     */
    public static String readHtml(final URL url, final String[] cssSelectorList) {

        try {
            final Document doc = Jsoup.connect(url.toString()).get();

            //remove excess data
            for (final String elementToRemove : cssSelectorList) {

                LOG.debug("Removing element: {}", elementToRemove);

                Elements article = doc.select(elementToRemove);
                article.remove();
            }

            //return modified doc
            return doc.html();

        } catch (MalformedURLException e) {
            e.printStackTrace();

            throw new IllegalArgumentException("The url:" + url + "was not a valid source");
        } catch (IOException e) {
            e.printStackTrace();

            throw new IllegalStateException("Unable to read source at url: " + url);
        }
    }
}
