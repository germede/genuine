package com.sample.repository;

import org.fluentness.repository.Model;

public class Book implements Model {

    String title;
    String cover;
    String genre;
    String synopsis;
    int year;
    boolean bestseller;
    Author author;


}
