package com.jmt.geomonitor.integration.mapper;

import com.jmt.geomonitor.domain.model.NewsStoryModel;
import com.jmt.geomonitor.integration.config.CSSRemovalSelectors;
import com.jmt.geomonitor.integration.config.URLReader;
import com.jmt.geomonitor.integration.model.GuardianStoriesIntegrationModel;
import com.jmt.geomonitor.integration.model.GuardianStoryIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public List<NewsStoryModel> map(GuardianStoriesIntegrationModel guardianStoriesIntegrationModels) {

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
                newsStoryModel.setUrlToImage(guardianStoryIntegrationModel.getUrlToImage());
                newsStoryModel.setCopyRight(guardianStoriesIntegrationModels.getCopyRight());
                newsStoryModel.setRawBody(URLReader.readHtml(guardianStoryIntegrationModel.getUrl(),
                                                             CSSRemovalSelectors.guardianSelectors));
                newsStoryModels.add(newsStoryModel);
            }
        }

        LOG.debug("Successfully mapped to {}", newsStoryModels);

        return newsStoryModels;
    }
}