/**
 * News categories.
 */
public enum NewsCategories {

    STUDENT("/education/students/rss"),
    UK("/uk/rss")
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
