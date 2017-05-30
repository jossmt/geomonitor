package com.jmt.geomonitor.service.core;

import com.jmt.geomonitor.integration.config.CSSRemovalSelectors;
import com.jmt.geomonitor.integration.config.URLReader;
import com.jmt.geomonitor.integration.news.NewsIntegrationService;
import com.jmt.geomonitor.domain.model.news.NewsCategories;
import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.domain.model.news.ResourceUrls;
import com.jmt.geomonitor.integration.mapper.GuardianStoryIntegrationMapper;
import com.jmt.geomonitor.integration.model.AbstractResponseIntegrationModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

/**
 * Implementation of {@link NewsApiService}
 */
@Service
public class NewsApiServiceHandler implements NewsApiService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(NewsApiService.class);

    /**
     * {@link NewsIntegrationService}
     */
    private final NewsIntegrationService newsIntegrationService;

    /** {@link GuardianStoryIntegrationMapper} */
    private final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper;

    /**
     * news api integration com.jmt.geomonitor.service constructor.
     *
     * @param newsIntegrationService
     *         news api integration com.jmt.geomonitor.service.
     */
    @Autowired
    public NewsApiServiceHandler(final GuardianStoryIntegrationMapper guardianStoryIntegrationMapper,
                                 final NewsIntegrationService newsIntegrationService) {
        this.guardianStoryIntegrationMapper = guardianStoryIntegrationMapper;
        this.newsIntegrationService = newsIntegrationService;
    }

    /**
     * {@inheritDoc}
     */
    public List<NewsStoryModel> getNewsStories(ResourceUrls source, NewsCategories category) {

        LOG.debug("Getting news stories for source {} and category {}", source, category);

        final AbstractResponseIntegrationModel abstractResponseIntegrationModel = newsIntegrationService
                .getNewsFunnel(source, category);

        List<NewsStoryModel> newsStoryModels = null;
        switch (source) {
            case GUARDIAN:
                newsStoryModels = guardianStoryIntegrationMapper.map((GuardianStoriesIntegrationModel)
                                                                             abstractResponseIntegrationModel);
                break;
            default:
                throw new IllegalStateException("No model found for source" + source);
        }

        LOG.debug("Returned news story list {}", newsStoryModels);

        return newsStoryModels;
    }

    public String getNewsStory(final URL url) {

        if(url.toString().contains(ResourceUrls.GUARDIAN.getValue())){

            return URLReader.readHtml(url, CSSRemovalSelectors.guardianSelectors);
        }else{

            return URLReader.readHtml(url, null);
        }
    }
}
