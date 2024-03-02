package com.mymusic.model;

public class MusicModel {

    private String title;
    private String artist;

    // Parameterized constructor
    public MusicModel(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
