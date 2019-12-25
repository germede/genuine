package com.sample.repository;

import org.fluentness.repository.Model;

import java.sql.Date;

public class AuthorRepository implements Model {

    String name;
    String surname;
    Date birthday;
    String picture;
    String biography;
}
