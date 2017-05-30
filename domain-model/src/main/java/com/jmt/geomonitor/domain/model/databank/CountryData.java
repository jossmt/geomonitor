package com.jmt.geomonitor.domain.model.databank;

import java.net.URL;

/**
 * Country Data fetched from Country Rest online service.
 */
public class CountryData {

    /**
     * Capital city.
     */
    private String capital;

    /**
     * President.
     */
    private String president;

    /**
     * Countries currencies;
     */
    private String[] currencies;

    /**
     * Languages.
     */
    private String[] languages;

    /**
     * URL for image of flag.
     */
    private URL flag;

    /**
     * Gets Capital city..
     *
     * @return Value of Capital city..
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets new Capital city..
     *
     * @param capital
     *         New value of Capital city..
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Gets President..
     *
     * @return Value of President..
     */
    public String getPresident() {
        return president;
    }

    /**
     * Sets new President..
     *
     * @param president
     *         New value of President..
     */
    public void setPresident(String president) {
        this.president = president;
    }

    /**
     * Gets Countries currencies;.
     *
     * @return Value of Countries currencies;.
     */
    public String[] getCurrencies() {
        return currencies;
    }

    /**
     * Sets new Countries currencies;.
     *
     * @param currencies
     *         New value of Countries currencies;.
     */
    public void setCurrencies(String[] currencies) {
        this.currencies = currencies;
    }

    /**
     * Gets Languages..
     *
     * @return Value of Languages..
     */
    public String[] getLanguages() {
        return languages;
    }

    /**
     * Sets new Languages..
     *
     * @param languages
     *         New value of Languages..
     */
    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    /**
     * Gets URL for image of flag..
     *
     * @return Value of URL for image of flag..
     */
    public URL getFlag() {
        return flag;
    }

    /**
     * Sets new URL for image of flag..
     *
     * @param flag
     *         New value of URL for image of flag..
     */
    public void setFlag(URL flag) {
        this.flag = flag;
    }



    @Override
    public String toString() {

        final StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(capital).append(currencies).append(languages).append(president).append(flag);

        return toStringBuilder.toString();

    }
}
