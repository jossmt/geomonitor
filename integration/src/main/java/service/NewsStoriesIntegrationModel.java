package service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * News story integration model.
 */
public class NewsStoriesIntegrationModel {

    /** Status. */
    @JsonProperty("status")
    private String status;

    /** Source. */
    @JsonProperty("source")
    private String source;

    /** Sort by. */
    @JsonProperty("sortBy")
    private String sortBy;

    /** List of {@link ArticleIntegrationModel}*/
    @JsonProperty("articles")
    private List<ArticleIntegrationModel> articleIntegrationModels;


    /**
     * Gets status.
     *
     * @return Value of status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets new status.
     *
     * @param status New value of status.
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets source.
     *
     * @return Value of source.
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets new source.
     *
     * @param source New value of source.
     */
    public void setSource(String source) {
        this.source = source;
    }


    /**
     * Gets sortBy.
     *
     * @return Value of sortBy.
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Sets new sortBy.
     *
     * @param sortBy New value of sortBy.
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }


    /**
     * Gets articleIntegrationModels.
     *
     * @return Value of articleIntegrationModels.
     */
    public List<ArticleIntegrationModel> getArticleIntegrationModels() {
        return articleIntegrationModels;
    }

    /**
     * Sets new articleIntegrationModels.
     *
     * @param articleIntegrationModels New value of articleIntegrationModels.
     */
    public void setArticleIntegrationModels(List<ArticleIntegrationModel> articleIntegrationModels) {
        this.articleIntegrationModels = articleIntegrationModels;
    }
}
