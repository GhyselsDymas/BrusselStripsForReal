package com.example.brusselstripsforreal.model;
//TODO make this an entity
//TODO add id

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

@Entity
public class ComicArt implements Serializable {


    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String comicArtId;
    private String imageURL, artTitle, artAuthor, coordinate, id;




    public ComicArt(String imageURL, String artTitle, String artAuthor, String coordinate, String id) {
        this.imageURL = imageURL;
        this.artTitle = artTitle;
        this.artAuthor = artAuthor;
        this.coordinate = coordinate;
        this.comicArtId = id;
    }

    @NonNull
    public String getComicArtId() {
        return comicArtId;
    }

    public void setComicArtId(@NonNull String comicArtId) {
        this.comicArtId = comicArtId;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

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




    @Override
    public String toString() {
        return "ComicArt{" +
                "imageURL='" + imageURL + '\'' +
                ", artTitle='" + artTitle + '\'' +
                ", artAuthor='" + artAuthor + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", id='" + id + '\'' +
                ", comicArtId=" + comicArtId +
                '}';
    }
}





