package com.sample.repository;

import org.fluentness.repository.field.Field;

import javax.persistence.*;

import static org.fluentness.repository.field.Type.*;

@Entity
public class Book {

    private int id;

    @Field(TEXT)
    private String title;

    @Field(FILE)
    private String cover;

    @Field(TEXT)
    private String genre;

    @Field(TEXT)
    private String synopsis;

    @Field(NUMBER)
    private int year;

    @Field(CHECKBOX)
    private boolean bestseller;

    @Field(SELECT)
    private Author author;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "bestseller")
    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    @ManyToOne
    @Column(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
