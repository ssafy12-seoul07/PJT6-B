package com.ssafy.ssafit.model.dto;

public class Video {
    private String id;
    private String title;
    private String description;
    private String bodyPart;
    private int views;

    public Video() {}

    public Video(String id, String title, String description, String bodyPart, int views) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.bodyPart = bodyPart;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                ", views=" + views +
                '}';
    }
}
