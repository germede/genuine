package com.sample;

import com.sample.base.DevEnvironment;
import org.fluentness.Fluentness;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.bootstrap(new DevEnvironment(), args);
    }

}
