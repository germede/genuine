package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class LibraryApplication implements Application {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.web(new LibraryApplication());
    }
}
