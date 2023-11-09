package com.test.indra.presentation.model;


//Class for mapping the data from service
public class PhotoModel {
    public final String id;
    public final String title;
    public final String url;
    public final String thumbnailUrl;
    public PhotoModel(String id, String title, String htmlUrl, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.url = htmlUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}