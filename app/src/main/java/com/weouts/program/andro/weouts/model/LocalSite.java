package com.weouts.program.andro.weouts.model;

import android.graphics.drawable.Drawable;

/**
 * Created by mochadwi on 11/11/16.
 */

public class LocalSite {
    private String title, description, location;
    private int thumbnail;

    public LocalSite() {
    }

    public LocalSite(String title, String description, int thumbnail, String location) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.location = location;
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

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
