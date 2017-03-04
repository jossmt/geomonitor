package service;

import javax.inject.Inject;

/**
 * Implementation of {@link NewsApiService}
 */
public class NewsApiServiceHandler implements NewsApiService {

    /**
     * {@link NewsApiIntegrationService}
     */
    private NewsApiIntegrationService newsApiIntegrationService;

    /**
     * News api integration service constructor.
     *
     * @param newsApiIntegrationService
     *         News api integration service.
     */
    @Inject
    public NewsApiServiceHandler(final NewsApiIntegrationService newsApiIntegrationService) {
        this.newsApiIntegrationService = newsApiIntegrationService;
    }

    /**
     * Gets news stories.
     *
     * @param source
     *         Source
     * @param sortBy
     *         Sort by.
     */
    public void getNewsStories(String source, String sortBy) {

//        private List<NewsInte>
    }
}
