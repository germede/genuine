package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;

public class LibraryApplication implements Application {

    public static void main(String[] args) {
        Fluentness.bootstrap(new LibraryApplication(), args);
    }
}
