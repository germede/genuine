package org.fluentness.prototype.model;

import org.fluentness.model.PersistableModel;

public class Note implements PersistableModel {

    private long id;
    private String title;
    private String description;
    private User user;

    public Note(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
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
