package com.jmt.geomonitor.service.Class;

import com.geomonitor.jmt.integration.NewsApiIntegrationService;
import com.jmt.geomonitor.domain.model.NewsCategories;
import com.jmt.geomonitor.domain.model.NewsStoryModel;
import com.jmt.geomonitor.domain.model.ResourceUrls;
import com.jmt.geomonitor.integration.mapper.GuardianStoryIntegrationMapper;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.GuardianStoriesIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation of {@link NewsApiService}
 */
public class NewsApiServiceHandler implements NewsApiService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiService.class);

    /**
     * {@link NewsApiIntegrationService}
     */
    private final NewsApiIntegrationService newsApiIntegrationService;

    /** {@link GuardianStoryIntegrationMapper} */
    private final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper;

    /**
     * News api integration com.jmt.geomonitor.service constructor.
     *
     * @param newsApiIntegrationService
     *         News api integration com.jmt.geomonitor.service.
     */
    @Autowired
    public NewsApiServiceHandler(final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper,
                                 final NewsApiIntegrationService newsApiIntegrationService) {
        this.guardianStoryIntegrationMapper = guardianStoryIntegrationMapper;
        this.newsApiIntegrationService = newsApiIntegrationService;
    }

    /**
     * {@inheritDoc}
     */
    public List<NewsStoryModel> getNewsStories(ResourceUrls source, NewsCategories category) {

        LOG.debug("Getting news stories for source {} and category {}", source, category);

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsApiIntegrationService
                .getNewsFunnel(source, category);

        List<NewsStoryModel> newsStoryModels = null;
        switch (source) {
            case THE_GUARDIAN:
                newsStoryModels = guardianStoryIntegrationMapper.map((GuardianStoriesIntegrationModel)
                                                                             abstractResponseIntegrationModel);
                break;
            default:
                throw new IllegalStateException("No model found for source" + source);
        }

        LOG.debug("Returned news story list {}", newsStoryModels);

        return newsStoryModels;
    }
}
