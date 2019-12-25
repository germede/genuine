package com.sample.model;

import org.fluentness.model.Model;
import org.fluentness.persistence.Query;

public class Book implements Model {

    public static final Query<Book> byName = new Query<>("SELECT * FROM Book WHERE name = ?");
    public static final Query<Book> all = new Query<>("SELECT * FROM Book");

    String title;
    String cover;
    String genre;
    String synopsis;
    int year;
    boolean bestseller;
    Author author;


}
