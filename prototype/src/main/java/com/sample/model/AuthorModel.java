package com.sample.model;

import org.fluentness.model.Model;

import java.sql.Date;

import static org.fluentness.model.Model.FieldType.*;

public class AuthorModel implements Model {

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
