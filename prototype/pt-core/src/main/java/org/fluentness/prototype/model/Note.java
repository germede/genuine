package org.fluentness.prototype.model;

import org.fluentness.model.AbstractCrudModel;

public class Note extends AbstractCrudModel {

    private String title;
    private String description;
    private User user;

    public Note(int id, String title, String description, User user) {
        super(id);
        this.title = title;
        this.description = description;
        this.user = user;
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
