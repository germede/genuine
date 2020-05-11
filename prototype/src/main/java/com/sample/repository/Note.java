package com.sample.repository;

import org.fluentness.repository.Model;

public class Note implements Model {

    private int id;
    private String title;
    private String description;
    private User user;

    public Note(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }
}
