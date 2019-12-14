package com.sample.model;

import org.fluentness.model.Model;

import static org.fluentness.model.Model.FieldType.PASSWORD;
import static org.fluentness.model.Model.FieldType.TEXT;

public class UserModel implements Model {

    private int id;

    @Type(TEXT)
    private String username;

    @Type(PASSWORD)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
