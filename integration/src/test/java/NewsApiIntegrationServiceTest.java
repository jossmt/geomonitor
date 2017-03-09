import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link NewsApiIntegrationService}
 */
public class NewsApiIntegrationServiceTest {

    /** {@link NewsApiIntegrationService} */
    public NewsApiIntegrationService newsApiIntegrationService;

    /**
     * Set up for tests.
     */
    @Before
    public void setUp() {
        newsApiIntegrationService = new NewsApiIntegrationServiceHandler();
    }


    @Test
    public void checkNewsApiServiceGuardian() {

        //Setup
        final ResourceUrls resourceUrl = ResourceUrls.THE_GUARDIAN;
        final NewsCategories newsCategoryStudent = NewsCategories.STUDENT;
        final NewsCategories newsCategoryUK = NewsCategories.UK;

        final List<NewsCategories> newsCategories = Arrays.asList(newsCategoryUK, newsCategoryStudent);

        //Assertion
        for (NewsCategories newsCategory : newsCategories) {

            System.out.println("Testing guardian news service for category: " + newsCategory);
            final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                    .getNewsFunnel(resourceUrl, newsCategory);

            Assert.assertTrue(abstractResponseIntegrationModel instanceof GuardianStoriesIntegrationModel);

            for (final GuardianStoryIntegrationModel guardianStoryIntegrationModel : (
                    (GuardianStoriesIntegrationModel) abstractResponseIntegrationModel)
                    .getGuardianStoryIntegrationModels()) {

                System.out.println(guardianStoryIntegrationModel.toString());
            }
        }
    }
}
