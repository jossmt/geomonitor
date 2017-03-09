import java.util.List;

/**
 * Guardian story integration mapper.
 */
public interface GuardianStoryIntegrationMapper {

    /**
     * Maps {@link GuardianStoriesIntegrationModel} to list of {@link NewsStoryModel}
     */
    List<NewsStoryModel> map(final GuardianStoriesIntegrationModel guardianStoriesIntegrationModel);
}
