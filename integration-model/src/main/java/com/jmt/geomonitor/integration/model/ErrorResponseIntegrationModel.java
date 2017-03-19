package com.jmt.geomonitor.integration.model;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Error response integration model.
 */
public class ErrorResponseIntegrationModel extends AbstractResponseIntegrationModel {

    /** Error headers */
    private final MultivaluedMap<String, Object> headers;

    public ErrorResponseIntegrationModel(final Integer httpStatusCode, final MultivaluedMap<String, Object> headers) {
        setHttpStatus(httpStatusCode);
        this.headers = headers;
    }

    /**
     * Returns error headers.
     *
     * @return headers.
     */
    public MultivaluedMap<String, Object> getHeaders() {
        return headers;
    }

}
