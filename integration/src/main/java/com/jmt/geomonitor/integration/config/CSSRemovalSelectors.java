package com.jmt.geomonitor.integration.config;

/**
 * List of css selectors to be removed from html responses.
 */
public class CSSRemovalSelectors {

    /** Removal selectors guardian */
    public static final String[] guardianSelectors = {"#top > footer", "#bannerandheader", "div.content-footer",
            "footer.l-footer.u-cf"};
}
