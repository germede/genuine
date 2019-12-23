package com.sample.model;

import org.fluentness.model.Model;

import java.sql.Date;

public class Author implements Model {

    String name;
    String surname;
    Date birthday;
    String picture;
    String biography;
}
