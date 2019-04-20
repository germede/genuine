package com.sample.model;

import org.fwf.ann.Column;
import org.fwf.ann.Table;
import org.fwf.mvc.Model;

@Table("person")
public class Person extends Model<Person> {

    @Column(pk = true)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;

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

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
