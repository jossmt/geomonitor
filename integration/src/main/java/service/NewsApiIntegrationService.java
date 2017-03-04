package service;

/**
 * Created by jossmillertodd on 04/03/2017.
 */


import javax.ws.rs.core.Response;

/**
 * News api integration service.
 */
public interface NewsApiIntegrationService {

    /**
     * Funnels bbc news data.
     * @return Response.
     */
    Response getNewsFunnel(final String source, final String sortBy);
}
