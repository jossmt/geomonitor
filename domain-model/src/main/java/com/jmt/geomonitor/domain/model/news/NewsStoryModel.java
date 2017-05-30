package com.jmt.geomonitor.domain.model.news;

import java.net.URL;
import java.util.List;

/**
 * news story model.
 */
public class NewsStoryModel {

    /** Author. */
    private String author;

    /** Title. */
    private String title;

    /** Description. */
    private String description;

    /** URL. */
    private URL url;

    /** URL to image. */
    private List<URL> urlToImage;

    /** Published at. */
    private String publishedAt;

    /** Copy right. */
    private String copyRight;


    /**
     * Sets new Author..
     *
     * @param author
     *         New value of Author..
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
     * @param description
     *         New value of Description..
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Sets new Published at..
     *
     * @param publishedAt
     *         New value of Published at..
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
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
     * @param title
     *         New value of Title..
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
     * @param url
     *         New value of URL..
     */
    public void setUrl(URL url) {
        this.url = url;
    }


    /**
     * Sets new URL to image..
     *
     * @param urlToImage
     *         New value of URL to image..
     */
    public void setUrlToImage(List<URL> urlToImage) {
        this.urlToImage = urlToImage;
    }

    /**
     * Gets URL to image..
     *
     * @return Value of URL to image..
     */
    public List<URL> getUrlToImage() {
        return urlToImage;
    }


    /**
     * Sets new Copy right..
     *
     * @param copyRight
     *         New value of Copy right..
     */
    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    /**
     * Gets Copy right..
     *
     * @return Value of Copy right..
     */
    public String getCopyRight() {
        return copyRight;
    }

    /**
     * To string builder
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(title).append(author).append(description).append(publishedAt).append(url).append
                (urlToImage).append(copyRight);

        return stringBuilder.toString();
    }
}
