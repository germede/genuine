package com.sample;

import org.fluentness.Fluentness;

import static org.fluentness.base.settings.BooleanKey.ENABLE_CACHE;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.call
            .set(ENABLE_CACHE, false)
            .initialize(args);
    }

}
