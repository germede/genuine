package com.sample.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song")
public class Song {

    private int id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
            Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
