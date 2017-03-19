package com.jmt.geomonitor.domain.model;

public enum ResourceUrls {

    HTTPS("https://www."),

    THE_GUARDIAN(HTTPS.value + "theguardian.com");

    /** Value. */
    private String value;

    /**
     * Resource url
     *
     * @param value
     */
    ResourceUrls(final String value) {
        this.value = value;
    }

    /**
     * Returns value.
     *
     * @return value.
     */
    public String getValue() {
        return value;
    }
}
