package com.sample.repository;

import org.fluentness.repository.Model;

import static org.fluentness.repository.Model.FieldType.*;

public class Book implements Model {

    private int id;

    @Type(TEXT)
    private String title;

    @Type(FILE)
    private String cover;

    @Type(TEXT)
    private String genre;

    @Type(TEXT)
    private String synopsis;

    @Type(NUMBER)
    private int year;

    @Type(CHECKBOX)
    private boolean bestseller;

    @Type(SELECT)
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
