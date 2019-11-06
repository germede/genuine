package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class LibraryApplication implements Application {

    public static void main(String[] args) throws FluentnessException {
        // todo implement functions and get rid of console commands
        Fluentness.console(new LibraryApplication(), Environment.DEV, args);
        Fluentness.desktop(new LibraryApplication(), Environment.PROD);
        Fluentness.web(new LibraryApplication(), Environment.PROD);
    }
}
