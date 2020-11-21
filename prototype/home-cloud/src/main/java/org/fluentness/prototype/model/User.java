package org.fluentness.prototype.model;

import org.fluentness.model.PersistableModel;

public class User implements PersistableModel {

    private long id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
