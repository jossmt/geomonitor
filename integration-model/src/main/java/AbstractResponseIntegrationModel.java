/**
 * Abstract rest response model.
 */
public abstract class AbstractResponseIntegrationModel {

    /** Http status. */
    private Integer httpStatus;

    /**
     * Returns http status
     *
     * @return Http Status.
     */
    public Integer getHttpStatus() {
        return httpStatus;
    }

    /**
     * Sets the http status.
     *
     * @param httpStatus
     *         Http status.
     */
    public void setHttpStatus(final Integer httpStatus) {
        this.httpStatus = httpStatus;
    }
}
