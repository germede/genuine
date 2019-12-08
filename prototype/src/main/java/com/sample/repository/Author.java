package com.sample.repository;

import org.fluentness.repository.Model;

import java.sql.Date;

import static org.fluentness.repository.Model.FieldType.*;

public class Author implements Model {

    private int id;

    @Type(TEXT)
    private String name;

    @Type(TEXT)
    private String surname;

    @Type(DATE)
    private Date birthday;

    @Type(FILE)
    private String picture;

    @Type(TEXT)
    private String biography;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

}
