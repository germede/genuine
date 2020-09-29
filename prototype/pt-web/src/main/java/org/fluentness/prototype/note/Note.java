package org.fluentness.prototype.note;

import org.fluentness.model.Model;
import org.fluentness.prototype.user.User;

import javax.persistence.*;

@Entity
public class Note implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne
    private User user;

    public long getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    User getUser() {
        return user;
    }
}
