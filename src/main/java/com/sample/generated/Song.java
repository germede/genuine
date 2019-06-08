package com.sample.generated;

// AUTO GENERATED CLASS, MODIFY AT YOUR OWN RISK
public class Song {

    private long id;
    private String title;
    private String artist;
//    @Nullable
    private String album;
    private int year;
    private boolean isNew;

    public Song(long id, String title, String artist, String album, int year, boolean isNew) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.isNew = isNew;
    }

    public long getId() {
        return id;
    }

    public Song setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public Song setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public String getAlbum() {
        return album;
    }

    public Song setAlbum(String album) {
        this.album = album;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Song setYear(int year) {
        this.year = year;
        return this;
    }

    public boolean isNew() {
        return isNew;
    }

    public Song setIsNew(boolean isNew) {
        this.isNew = isNew;
        return this;
    }
}
