package service;

import constants.IntegrationConstants;
import org.testng.annotations.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Properties;

/**
 * Implementation of {@link NewsApiIntegrationService}
 */
public class NewsApiIntegrationServiceHandler extends ClientResourceConfig implements NewsApiIntegrationService {


    /**
     * {@inheritDoc}
     */
    public Response getNewsFunnel(final String source, final String sortBy) {

        // Send rest request
        final Response response = webTarget.request().header(IntegrationConstants.SOURCE_HEADER, source)
                .header(IntegrationConstants.SORT_BY_HEADER, sortBy).accept(MediaType.APPLICATION_JSON).get();


        return response;
    }


    @Test
    public void runTest() {

        final Response response = getNewsFunnel("bbc-news", "latest");

        final NewsStoriesIntegrationModel newsStoriesIntegrationModel = response.readEntity(NewsStoriesIntegrationModel.class);

        for(ArticleIntegrationModel articleIntegrationModel : newsStoriesIntegrationModel.getArticleIntegrationModels()){

            System.out.println(articleIntegrationModel.getTitle());
        }


    }
}
