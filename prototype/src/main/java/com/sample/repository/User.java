package com.sample.repository;

import org.fluentness.repository.Model;

import javax.persistence.*;

import static org.fluentness.repository.Model.Type.*;

@Entity
@Table(name = "user")
public class User implements Model {

    private int id;

    @Field(type = TEXT, label = "user_username")
    private String username;

    @Field(type = PASSWORD, label = "user_password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
