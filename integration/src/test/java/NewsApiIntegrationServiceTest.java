import com.geomonitor.jmt.integration.NewsApiIntegrationService;
import com.geomonitor.jmt.integration.NewsApiIntegrationServiceHandler;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.GuardianStoriesIntegrationModel;
import com.jmt.geomonitor.integration.model.GuardianStoryIntegrationModel;
import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.ResourceUrls;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link NewsApiIntegrationService}
 */
public class NewsApiIntegrationServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(NewsApiIntegrationServiceTest.class);

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

            System.out.println("Testing guardian news com.jmt.geomonitor.service for category: " + newsCategory + "\n\n");
            final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                    .getNewsFunnel(resourceUrl, newsCategory);

            Assert.assertTrue(abstractResponseIntegrationModel instanceof GuardianStoriesIntegrationModel);

            for (final GuardianStoryIntegrationModel guardianStoryIntegrationModel : (
                    (GuardianStoriesIntegrationModel) abstractResponseIntegrationModel)
                    .getGuardianStoryIntegrationModels()) {

                LOG.debug(guardianStoryIntegrationModel.toString() + "\n\n");
            }
        }
    }
}
