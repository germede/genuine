package com.sample.model;

import org.fwf.mvc.Model;
import org.fwf.ann.Column;
import org.fwf.ann.Table;

@Table("person")
public class Person extends Model<Person> {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    private String surname;


    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
