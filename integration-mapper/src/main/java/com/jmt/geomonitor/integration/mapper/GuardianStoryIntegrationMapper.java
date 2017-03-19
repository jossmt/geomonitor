package com.jmt.geomonitor.integration.mapper;

import com.jmt.geomonitor.domain.model.NewsStoryModel;
import com.jmt.geomonitor.integration.model.GuardianStoriesIntegrationModel;

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
