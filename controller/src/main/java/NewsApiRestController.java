import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * News api rest controller.
 */
public class NewsApiRestController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiRestController.class);

    /** {@link NewsApiService} */
    private final NewsApiService newsApiService;

    /**
     * News api rest controller.
     *
     * @param newsApiService
     *         News api service.
     */
    @Inject
    public NewsApiRestController(final NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    @GET
    public Response getNewsStoriesByCategory(final String resource, final String category) {

        LOG.debug("Received news stories request with resource {}, and category {}", resource, category);

        final ResourceUrls resourceUrl = ResourceUrls.valueOf(resource);
        final NewsCategories newsCategory = NewsCategories.valueOf(category);
        Validate.notNull(resourceUrl, "The request resource does not exist {}", resource);
        Validate.notNull(newsCategory, "The news category requested is not available {}", category);

        final List<NewsStoryModel> newsStoryModels = newsApiService.getNewsStories(resourceUrl, newsCategory);

        LOG.debug("News story request returned news story models {}", newsStoryModels);

        return Response.ok().entity(newsStoryModels).build();
    }
}
