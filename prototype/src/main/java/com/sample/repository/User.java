package com.sample.repository;

import org.fluentness.repository.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static org.fluentness.repository.Model.Type.PASSWORD;
import static org.fluentness.repository.Model.Type.TEXT;

@Entity
public class User implements Model {

    private int id;

    @Field(TEXT)
    private String username;

    @Field(PASSWORD)
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
