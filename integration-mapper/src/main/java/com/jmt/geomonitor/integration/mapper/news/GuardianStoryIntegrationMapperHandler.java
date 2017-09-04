package com.jmt.geomonitor.integration.mapper.news;

import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.integration.config.LogoConstants;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoryIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link GuardianStoryIntegrationMapper}
 */
@Component
public class GuardianStoryIntegrationMapperHandler implements GuardianStoryIntegrationMapper {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GuardianStoryIntegrationMapper.class);

    /**
     * {@inheritDoc}
     */
    public List<NewsStoryModel> map(GuardianStoriesIntegrationModel guardianStoriesIntegrationModels){

        LOG.debug("Mapping from GUARDIAN stories integration model {} to list of news story model",
                  guardianStoriesIntegrationModels);

        List<NewsStoryModel> newsStoryModels = new ArrayList<NewsStoryModel>();
        if (guardianStoriesIntegrationModels != null) {

            for (final GuardianStoryIntegrationModel guardianStoryIntegrationModel : guardianStoriesIntegrationModels
                    .getGuardianStoryIntegrationModels()) {

                NewsStoryModel newsStoryModel = new NewsStoryModel();
                newsStoryModel.setAuthor(guardianStoryIntegrationModel.getAuthor());
                newsStoryModel.setDescription(guardianStoryIntegrationModel.getDescription());
                newsStoryModel.setPublishedAt(guardianStoryIntegrationModel.getPublishedAt());
                newsStoryModel.setTitle(guardianStoryIntegrationModel.getTitle());
                newsStoryModel.setUrl(guardianStoryIntegrationModel.getUrl());
                newsStoryModel.setUrlToImage(LogoConstants.guardianURL);
                newsStoryModel.setCopyRight(guardianStoriesIntegrationModels.getCopyRight());
                newsStoryModels.add(newsStoryModel);
            }
        }

        LOG.debug("Successfully mapped to {}", newsStoryModels);

        return newsStoryModels;
    }
}