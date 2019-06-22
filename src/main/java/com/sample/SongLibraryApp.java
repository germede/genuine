package com.sample;

import org.fluentness.Fluentness;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.INSTANCE.initialize(SongLibraryApp.class, "dev", args);
    }

}
