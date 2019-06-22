package com.sample.data;

import org.fluentness.data.ModelF;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song")
public class Song implements ModelF {

    private int id;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
            Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
