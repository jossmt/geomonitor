package com.jmt.geomonitor.persistence.model;

/**
 * User account details.
 */
public class UserAccountPersistenceModel {

    /** Id number. */
    private Integer id;

    /** User name. */
    private String name;

    /** User password hash. */
    private String passHash;


    /**
     * Sets new passHash.
     *
     * @param passHash
     *         New value of passHash.
     */
    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    /**
     * Gets passHash.
     *
     * @return Value of passHash.
     */
    public String getPassHash() {
        return passHash;
    }

    /**
     * Sets new name.
     *
     * @param name
     *         New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }
}
