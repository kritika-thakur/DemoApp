package com.example.ideafoundation.grouplistdemo;

/**
 * Created by ideafoundation on 25/07/17.
 */

public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private int image;

    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, String title, int image) {
        this.showNotify = showNotify;
        this.title = title;
        this.image = image;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}