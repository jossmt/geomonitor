import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation of {@link NewsApiService}
 */
public class NewsApiServiceHandler implements NewsApiService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiService.class);

    /**
     * {@link NewsApiIntegrationService}
     */
    private final NewsApiIntegrationService newsApiIntegrationService;

    /** {@link GuardianStoryIntegrationMapper} */
    private final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper;

    /**
     * News api integration service constructor.
     *
     * @param newsApiIntegrationService
     *         News api integration service.
     */
    @Inject
    public NewsApiServiceHandler(final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper,
                                 final NewsApiIntegrationService newsApiIntegrationService) {
        this.guardianStoryIntegrationMapper = guardianStoryIntegrationMapper;
        this.newsApiIntegrationService = newsApiIntegrationService;
    }

    /**
     * {@inheritDoc}
     */
    public List<NewsStoryModel> getNewsStories(ResourceUrls source, NewsCategories category) {

        LOG.debug("Getting news stories for source {} and category {}", source, category);

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                .getNewsFunnel(source, category);

        List<NewsStoryModel> newsStoryModels = null;
        switch (source) {
            case THE_GUARDIAN:
                newsStoryModels = guardianStoryIntegrationMapper.map((GuardianStoriesIntegrationModel)
                                                                             abstractResponseIntegrationModel);
                break;
            default:
                throw new IllegalStateException("No mapper found for source" + source);
        }

        LOG.debug("Returned news story list {}", newsStoryModels);

        return newsStoryModels;
    }
}
