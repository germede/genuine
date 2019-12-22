package com.sample.repository;

import org.fluentness.repository.Model;

import java.sql.Date;

import static org.fluentness.repository.Model.FieldType.*;


@Query("byName", "name = %s")
public class Author implements Model {

    private int id;

    @Type(TEXT)
    private String name;

    @Type(TEXT)
    private String surname;

    @Type(DATE)
    private Date birthday;

    @Type(FILE)
    private String picture;

    @Type(TEXT)
    private String biography;


}
