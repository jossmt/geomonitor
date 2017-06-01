package com.jmt.geomonitor.integration.news;

import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoryIntegrationModel;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * config for {@link NewsIntegrationService}
 */
public class NewsIntegrationServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(NewsIntegrationServiceTest.class);

    /** {@link NewsIntegrationService} */
    public NewsIntegrationService newsApiIntegrationService;

    /**
     * Set up for tests.
     */
    @Before
    public void setUp() {
        newsApiIntegrationService = new NewsIntegrationServiceHandler();
    }


    @Test
    public void checkNewsApiServiceGuardian() {

        //Setup
        final ResourceUrls resourceUrl = ResourceUrls.GUARDIAN;
        final NewsCategories newsCategoryStudent = NewsCategories.STUDENT;
        final NewsCategories newsCategoryUK = NewsCategories.UK;

        final List<NewsCategories> newsCategories = Arrays.asList(newsCategoryUK, newsCategoryStudent);

        //Assertion
        for (NewsCategories newsCategory : newsCategories) {

            System.out.println("Testing GUARDIAN service for category: " + newsCategory + "\n\n");
            final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                    .getNewsFunnel(resourceUrl, newsCategory);

            Assert.assertTrue(abstractResponseIntegrationModel instanceof GuardianStoriesIntegrationModel);

            for (final GuardianStoryIntegrationModel guardianStoryIntegrationModel : (
                    (GuardianStoriesIntegrationModel) abstractResponseIntegrationModel)
                    .getGuardianStoryIntegrationModels()) {

                LOG.debug("Model" + guardianStoryIntegrationModel.toString() + "\n\n");
            }
        }
    }
}
