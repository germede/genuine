package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.server.Server;
import org.fluentness.server.SunServer;

import java.util.List;


public class LibraryApplication implements Application {






    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
