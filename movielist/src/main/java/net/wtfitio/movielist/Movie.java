package net.wtfitio.movielist;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by plamend on 1/10/14.
 */
public class Movie implements Serializable {

    private String title;
    private int  year;
    private Drawable picture;
    private String director;
    private String shortdis;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDescription(String shortdis) {
        this.shortdis = shortdis;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Drawable getPicture() {
        return picture;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return shortdis;
    }
}
