package com.sample.repository;

import org.fluentness.repository.Model;

import javax.persistence.*;

import static org.fluentness.repository.Model.Type.*;

@Entity
@Table(name = "book")
public class Book implements Model {

    private int id;

    @Field(type = TEXT, label = "book_title")
    private String title;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

}
