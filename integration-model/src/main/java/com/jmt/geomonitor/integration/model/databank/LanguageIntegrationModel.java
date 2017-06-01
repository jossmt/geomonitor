package com.jmt.geomonitor.integration.model.databank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Language integration model.
 */
public class LanguageIntegrationModel {

    /** Name. */
    @JsonProperty("name")
    private String name;

    /**
     * Get name.
     *
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name
     *         Name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        final StringBuilder toStringBuilder = new StringBuilder();

        toStringBuilder.append(name);

        return toStringBuilder.toString();

    }
}
