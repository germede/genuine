package com.sample.model;

import org.fwf.mvc.Model;
import org.fwf.ann.Column;
import org.fwf.ann.Table;

@Table("person")
public class Person extends Model<Person> {

    @Column
    private int id;
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
