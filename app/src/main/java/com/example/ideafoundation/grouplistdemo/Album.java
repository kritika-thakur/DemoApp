package com.example.ideafoundation.grouplistdemo;

/**
 * Created by ideafoundation on 25/07/17.
 */

public class Album {
    private String name;
    private String price;
    private String thumbnail;

    public Album() {
    }

    public Album(String name, String price, String thumbnail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
