import java.util.List;

/**
 * Implementation of {@link GuardianStoryIntegrationMapper}
 */
public class GuardianStoryIntegrationMapperHandler implements GuardianStoryIntegrationMapper {

    /**
     * {@inheritDoc}
     */
    public List<NewsStoryModel> map(GuardianStoriesIntegrationModel guardianStoriesIntegrationModels) {

        //TODO: Add logs

        List<NewsStoryModel> newsStoryModels = null;
        if (guardianStoriesIntegrationModels != null) {

            for (final GuardianStoryIntegrationModel guardianStoryIntegrationModel : guardianStoriesIntegrationModels
                    .getGuardianStoryIntegrationModels()) {

                NewsStoryModel newsStoryModel = new NewsStoryModel();
                newsStoryModel.setAuthor(guardianStoryIntegrationModel.getAuthor());
                newsStoryModel.setDescription(guardianStoryIntegrationModel.getDescription());
                newsStoryModel.setPublishedAt(guardianStoryIntegrationModel.getPublishedAt());
                newsStoryModel.setTitle(guardianStoryIntegrationModel.getTitle());
                newsStoryModel.setUrl(guardianStoryIntegrationModel.getUrl());
                newsStoryModel.setUrlToImage(guardianStoryIntegrationModel.getUrlToImage());

                newsStoryModels.add(newsStoryModel);
            }
        }

        //TODO: Add logs

        return newsStoryModels;
    }
}