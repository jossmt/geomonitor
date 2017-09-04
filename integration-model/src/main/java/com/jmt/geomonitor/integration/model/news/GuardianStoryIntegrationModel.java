package com.jmt.geomonitor.integration.model.news;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.net.URL;
import java.util.List;

/**
 * Article integration model.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GuardianStoryIntegrationModel{

    /** Author. */
    @XmlElement(name = "dc:creator")
    private String author;

    /** Title. */
    @XmlElement(name = "title")
    private String title;

    /** Description. */
    @XmlElement(name = "description")
    private String description;

    /** URL. */
    @XmlElement(name = "guid")
    private URL url;

    /** Published at. */
    @XmlElement(name = "dc:date")
    private String publishedAt;


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
     * @param publishedAt
     *         New value of Published at..
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * To string builder
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(title).append(author).append(description).append(publishedAt).append(url);

        return stringBuilder.toString();
    }
}
