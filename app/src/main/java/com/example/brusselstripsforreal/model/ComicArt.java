package com.example.brusselstripsforreal.model;
//TODO make this an entity
//TODO add id

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ComicArt implements Serializable {

    private String imageURL, artTitle, artAuthor, coordinate, id;

    public int getComicArtId() {
        return comicArtId;
    }

    public void setComicArtId(int comicArtId) {
        this.comicArtId = comicArtId;
    }

    @NonNull
    @PrimaryKey(autoGenerate = false)
    private int comicArtId;

    public ComicArt(String imageURL, String artTitle, String artAuthor, String coordinate, String id) {
        this.imageURL = imageURL;
        this.artTitle = artTitle;
        this.artAuthor = artAuthor;
        this.coordinate = coordinate;
        this.id = id;
    }

    public String getCoordinate() { return coordinate; }

    public void setCoordinate(String coordinate) { this.coordinate = coordinate; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getArtAuthor() { return artAuthor; }

    public void setArtAuthor(String artAuthor) {
        this.artAuthor = artAuthor;
    }

}





