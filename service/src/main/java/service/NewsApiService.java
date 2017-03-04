package service;

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
    void getNewsStories(final String source, final String sortBy);
}
