package com.magda.recipesearch.model;

public class Recipe {

    private String url;
    private String title;
    private String imageUrl;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
