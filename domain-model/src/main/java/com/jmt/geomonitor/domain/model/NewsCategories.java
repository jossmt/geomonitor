package com.jmt.geomonitor.domain.model;

import org.springframework.stereotype.Component;

/**
 * News categories.
 */
public enum NewsCategories {

    STUDENT("/education/students/rss"),
    UK("/uk/rss"),


    INVALID_CATEGORY("invalid/category/rss")
    ;

    /** Value. */
    private String value;

    /**
     * News categories enum constructor.
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
