package com.sample.repository;

import org.fluentness.repository.Model;

import java.sql.Date;

public class Author implements Model {

    String name;
    String surname;
    Date birthday;
    String picture;
    String biography;
}
