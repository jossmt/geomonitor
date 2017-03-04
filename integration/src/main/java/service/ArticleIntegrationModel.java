package service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

/**
 * Article integration model.
 */
public class ArticleIntegrationModel {

    /** Author. */
    @JsonProperty("author")
    private String author;

    /** Title. */
    @JsonProperty("title")
    private String title;

    /** Description. */
    @JsonProperty("description")
    private String description;

    /** URL. */
    @JsonProperty("url")
    private URL url;

    /** URL to image. */
    @JsonProperty("urlToImage")
    private URL urlToImage;

    /** Published at. */
    @JsonProperty("publishedAt")
    private String publishedAt;


    /**
     * Sets new Author..
     *
     * @param author New value of Author..
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets Author..
     *
     * @return Value of Author..
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Gets Description..
     *
     * @return Value of Description..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new Description..
     *
     * @param description New value of Description..
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets Title..
     *
     * @return Value of Title..
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new Title..
     *
     * @param title New value of Title..
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets URL..
     *
     * @return Value of URL..
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Sets new URL..
     *
     * @param url New value of URL..
     */
    public void setUrl(URL url) {
        this.url = url;
    }


    /**
     * Sets new URL to image..
     *
     * @param urlToImage New value of URL to image..
     */
    public void setUrlToImage(URL urlToImage) {
        this.urlToImage = urlToImage;
    }

    /**
     * Gets URL to image..
     *
     * @return Value of URL to image..
     */
    public URL getUrlToImage() {
        return urlToImage;
    }


    /**
     * Gets Published at..
     *
     * @return Value of Published at..
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets new Published at..
     *
     * @param publishedAt New value of Published at..
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
