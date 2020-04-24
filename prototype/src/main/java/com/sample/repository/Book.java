package com.sample.repository;

import org.fluentness.repository.Model;

public class Book extends Model {

    private String title;
    private String cover;
    private String genre;
    private String synopsis;
    private int year;
    private boolean bestseller;
    private Author author;

    public Book(String title, String cover, String genre, String synopsis, int year, boolean bestseller, Author author) {
        this.title = title;
        this.cover = cover;
        this.genre = genre;
        this.synopsis = synopsis;
        this.year = year;
        this.bestseller = bestseller;
        this.author = author;
    }
}
