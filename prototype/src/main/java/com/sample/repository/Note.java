package com.sample.repository;

import org.fluentness.repository.crud.AbstractModel;

public class Note extends AbstractModel {

    private String title;
    private String description;
    private long user_id;

    public Note(String title, String description, long user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
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

    public long getUser_id() {
        return user_id;
    }
}
