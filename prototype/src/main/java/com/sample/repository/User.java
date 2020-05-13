package com.sample.repository;

import org.fluentness.repository.AbstractCrudModel;

public class User extends AbstractCrudModel {

    private String username;
    private String password;

    public User(int id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
