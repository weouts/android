package com.weouts.program.andro.weouts;

/**
 * Created by mochadwi on 11/3/16.
 */

public class Album {
    private String name;
    private int numOfShops;
    private int thumbnail;

    public Album() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfShops() {
        return numOfShops;
    }

    public void setNumOfShops(int numOfShops) {
        this.numOfShops = numOfShops;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
