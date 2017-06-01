package com.jmt.geomonitor.service.news;

import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import com.jmt.geomonitor.integration.mapper.news.GuardianStoryIntegrationMapper;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoryIntegrationModel;
import com.jmt.geomonitor.integration.news.NewsIntegrationService;
import com.jmt.geomonitor.service.core.NewsService;
import com.jmt.geomonitor.service.core.NewsServiceHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link NewsService}
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {

    /**
     * {@link GuardianStoryIntegrationMapper}
     */
    @Mock
    private GuardianStoryIntegrationMapper guardianStoryIntegrationMapper;

    /** {@link NewsIntegrationService} */
    @Mock
    private NewsIntegrationService newsIntegrationService;

    /** {@link NewsService} */
    private NewsService newsService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        newsService = new NewsServiceHandler(guardianStoryIntegrationMapper, newsIntegrationService);
    }

    /**
     * Test for news service.
     */
    @Test
    public void testNewsService() {

        //Setup
        final NewsStoryModel newsStoryModel = new NewsStoryModel();
        newsStoryModel.setTitle("TestTitle");

        final GuardianStoryIntegrationModel guardianStoryIntegrationModel = new GuardianStoryIntegrationModel();
        guardianStoryIntegrationModel.setTitle("TestTitle");

        final GuardianStoriesIntegrationModel guardianStoriesIntegrationModel = new GuardianStoriesIntegrationModel();
        guardianStoriesIntegrationModel.setGuardianStoryIntegrationModels(Arrays.asList(guardianStoryIntegrationModel));

        //Mock
        Mockito.when(newsIntegrationService.getNewsFunnel(ResourceUrls.GUARDIAN, NewsCategories.UK)).thenReturn
                (guardianStoriesIntegrationModel);
        Mockito.when(guardianStoryIntegrationMapper.map(guardianStoriesIntegrationModel)).thenReturn(Arrays.asList
                (newsStoryModel));

        //Test
        final List<NewsStoryModel> newsStoryModelList = newsService.getNewsStories(ResourceUrls.GUARDIAN,
                                                                                   NewsCategories.UK);

        //Verify
        Mockito.verify(newsIntegrationService).getNewsFunnel(ResourceUrls.GUARDIAN, NewsCategories.UK);
        Mockito.verify(guardianStoryIntegrationMapper).map(guardianStoriesIntegrationModel);

        //Assert
        Assert.assertEquals(newsStoryModelList, Arrays.asList(newsStoryModel));
    }

}
