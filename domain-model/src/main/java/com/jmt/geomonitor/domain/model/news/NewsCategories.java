package com.jmt.geomonitor.domain.model.news;

/**
 * news categories.
 */
public enum NewsCategories {

    STUDENT("/education/students/rss"),
    UK("/uk/rss"),


    INVALID_CATEGORY("invalid/category/rss")
    ;

    /** Value. */
    private String value;

    /**
     * news categories enum constructor.
     *
     * @param value
     */
    NewsCategories(final String value) {
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
