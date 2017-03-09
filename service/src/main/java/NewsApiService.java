/**
 * News api service.
 */
public interface NewsApiService {

    /**
     * Gets all news stories for given souce and sort by parameters.
     *
     * @param source
     *         Source
     * @param sortBy
     *         Sort by.
     * @return
     */
    GuardianStoriesIntegrationModel getNewsStories(final String source, final String sortBy);
}
