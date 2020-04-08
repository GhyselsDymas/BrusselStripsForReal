package com.example.brusselstripsforreal.model;
//TODO make this an entity
//TODO add id
public class ComicArt {

    private String imageURL, artTitle, artAuthor, coordinates;

    public ComicArt(String imageUrl, String artTitle, String artAuthor, String coordinates) {
        this.imageURL = imageUrl;
        this.artTitle = artTitle;
        this.artAuthor = artAuthor;
        this.coordinates = coordinates;
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}





