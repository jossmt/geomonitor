import java.util.List;

/**
 * News api service.
 */
public interface NewsApiService {

    /**
     * Gets all news stories for given source and sort by parameters.
     *
     * @param source
     *         News Source
     * @param category
     *         News category.
     * @return
     */
    List<NewsStoryModel> getNewsStories(final ResourceUrls source, final NewsCategories category);
}
