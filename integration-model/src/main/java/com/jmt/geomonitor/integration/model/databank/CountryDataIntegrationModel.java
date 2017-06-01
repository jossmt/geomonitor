package com.jmt.geomonitor.integration.model.databank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;

import java.util.List;


/**
 * Country data integration model.
 */
public class CountryDataIntegrationModel extends AbstractResponseIntegrationModel {

    /** Name. */
    private String name;

    /** 2 letter country code. */
    private String alpha2Code;

    /** 3 letter country code. */
    private String alpha3Code;

    /** Capital. */
    private String capital;

    /** List of currencies used. */
    @JsonProperty("currencies")
    private List<CurrencyIntegrationModel> currencies;

    /** List of languages used. */
    @JsonProperty("languages")
    private List<LanguageIntegrationModel> languages;

    /** URL of flag. */
    @JsonProperty("flag")
    private String flag;


    /**
     * Gets Name..
     *
     * @return Value of Name..
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new Name..
     *
     * @param name
     *         New value of Name..
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Sets new 2 letter country code..
     *
     * @param alpha2Code
     *         New value of 2 letter country code..
     */
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    /**
     * Gets 2 letter country code..
     *
     * @return Value of 2 letter country code..
     */
    public String getAlpha2Code() {
        return alpha2Code;
    }


    /**
     * Gets 3 letter country code..
     *
     * @return Value of 3 letter country code..
     */
    public String getAlpha3Code() {
        return alpha3Code;
    }

    /**
     * Sets new 3 letter country code..
     *
     * @param alpha3Code
     *         New value of 3 letter country code..
     */
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }


    /**
     * Gets Capital..
     *
     * @return Value of Capital..
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets new Capital..
     *
     * @param capital
     *         New value of Capital..
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }


    /**
     * Gets List of currencies used..
     *
     * @return Value of List of currencies used..
     */
    public List<CurrencyIntegrationModel> getCurrencies() {
        return currencies;
    }

    /**
     * Sets new List of currencies used..
     *
     * @param currencies
     *         New value of List of currencies used..
     */
    public void setCurrencies(List<CurrencyIntegrationModel> currencies) {
        this.currencies = currencies;
    }


    /**
     * Gets URL of flag..
     *
     * @return Value of URL of flag..
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets new URL of flag..
     *
     * @param flag
     *         New value of URL of flag..
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }


    /**
     * Gets List of languages used..
     *
     * @return Value of List of languages used..
     */
    public List<LanguageIntegrationModel> getLanguages() {
        return languages;
    }

    /**
     * Sets new List of languages used..
     *
     * @param languages
     *         New value of List of languages used..
     */
    public void setLanguages(List<LanguageIntegrationModel> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {

        final StringBuilder toStringBuilder = new StringBuilder();

        toStringBuilder.append(name).append(alpha2Code).append(alpha3Code).append(capital).append(currencies).append
                (languages).append(flag);

        return toStringBuilder.toString();

    }
}
