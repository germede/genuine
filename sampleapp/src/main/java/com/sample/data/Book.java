package com.sample.data;

import org.fluentness.data.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song")
public class Book implements Model {

    private int id;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
