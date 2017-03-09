import javax.inject.Inject;
import java.util.List;

/**
 * Implementation of {@link NewsApiService}
 */
public class NewsApiServiceHandler implements NewsApiService {

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

        //TODO: add logs

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                .getNewsFunnel(source, category);

        //TODO: add switch statement by resource

        List<NewsStoryModel> newsStoryModel = null;
        switch (source) {
            case THE_GUARDIAN:
                newsStoryModel = guardianStoryIntegrationMapper.map((GuardianStoriesIntegrationModel)
                                                                            abstractResponseIntegrationModel);
                break;
            default:
                throw new IllegalStateException("No mapper found for source" + source);
        }

        //TODO: add logs

        return newsStoryModel;
    }
}
