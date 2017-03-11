import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implementation of {@link NewsApiIntegrationService}
 */
public class NewsApiIntegrationServiceHandler extends ClientResourceConfig implements NewsApiIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiIntegrationService.class);

    /**
     * {@inheritDoc}
     */
    public AbstractResponseIntegrationModel getNewsFunnel(final ResourceUrls resourceUrl, final NewsCategories
            newsCategory) {
        updateWebTarget(resourceUrl.getValue() + newsCategory.getValue());

        LOG.debug("URI: " + webTarget.getUri().toString());

        // Send rest request
        final Response response = webTarget.request().accept(MediaType.APPLICATION_XML).get();

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel;
        if (response.getStatus() == 200 || response.getStatus() == 201) {

            //TODO: add switch statement by news service
            abstractResponseIntegrationModel = response.readEntity(GuardianStoriesIntegrationModel.class);

        } else {

            abstractResponseIntegrationModel = new ErrorResponseIntegrationModel(response.getStatus(), response
                    .getHeaders());
        }

        LOG.debug("Returning abstract response integration model {}", abstractResponseIntegrationModel);

        return abstractResponseIntegrationModel;
    }
}
