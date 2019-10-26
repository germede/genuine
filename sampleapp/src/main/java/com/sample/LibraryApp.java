package com.sample;

import org.fluentness.Fluentness;

public class LibraryApp {

    public static void main(String[] args) {
        Fluentness.does.inject(LibraryApp.class.getPackage().getName());
        Fluentness.does.invoke(args);
    }
}
