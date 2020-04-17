package com.example.brusselstripsforreal.model;
//TODO make this an entity
//TODO add id

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

//Author: Dymas Ghysels
@Entity
public class ComicArt implements Serializable {


    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String comicArtId;
    private String imageURL, artTitle, artAuthor, coordinate, id, artAnnee;


    public ComicArt(String imageURL, String artTitle, String artAuthor, String coordinate, String id, String artAnnee) {
        this.imageURL = imageURL;
        this.artTitle = artTitle + " ";
        this.artAuthor = artAuthor + " ";
        this.coordinate = coordinate;
        this.comicArtId = id;
        this.artAnnee = artAnnee + " ";
    }

    @NonNull
    public String getComicArtId() {
        return comicArtId;
    }

    public void setComicArtId(@NonNull String comicArtId) {
        this.comicArtId = comicArtId;
    }

    //binnengetrokken als string dus haakjes moeten weg
    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getArtAuthor() {
        return artAuthor;
    }

    public void setArtAuthor(String artAuthor) {
        this.artAuthor = artAuthor;
    }

    public String getArtAnnee() { return artAnnee; }

    public void setArtAnnee(String artAnnee) { this.artAnnee = artAnnee; }

    @Override
    public String toString() {
        return "ComicArt{" +
                "comicArtId='" + comicArtId + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", artTitle='" + artTitle + '\'' +
                ", artAuthor='" + artAuthor + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", id='" + id + '\'' +
                ", artAnnee='" + artAnnee + '\'' +
                '}';
    }
}






