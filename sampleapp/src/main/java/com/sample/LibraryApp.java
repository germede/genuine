package com.sample;

import org.fluentness.Fluentness;

public class LibraryApp {

    public static void main(String[] args) {
        Fluentness.define(LibraryApp.class.getPackage().getName());
        Fluentness.invoke(args);
    }
}
