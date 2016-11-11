package com.weouts.program.andro.weouts;

/**
 * Created by mochadwi on 11/11/16.
 */

public class LocalSite {
    private String title, description, location;

    public LocalSite() {
    }

    public LocalSite(String title, String description, String location) {
        this.title = title;
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
