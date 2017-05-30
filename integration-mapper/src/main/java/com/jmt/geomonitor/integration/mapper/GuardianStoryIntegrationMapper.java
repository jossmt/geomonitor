package com.jmt.geomonitor.integration.mapper;

import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;

import java.util.List;

/**
 * Guardian story integration model.
 */
public interface GuardianStoryIntegrationMapper {

    /**
     * Maps {@link GuardianStoriesIntegrationModel} to list of {@link NewsStoryModel}
     */
    List<NewsStoryModel> map(final GuardianStoriesIntegrationModel guardianStoriesIntegrationModel);
}
