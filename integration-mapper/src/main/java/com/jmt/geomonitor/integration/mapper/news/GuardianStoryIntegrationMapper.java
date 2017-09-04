package com.jmt.geomonitor.integration.mapper.news;

import com.jmt.geomonitor.domain.model.news.NewsStoryModel;
import com.jmt.geomonitor.integration.model.news.GuardianStoriesIntegrationModel;

import java.net.MalformedURLException;
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
