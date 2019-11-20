package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class LibraryApplication implements Application {

    @Override
    public Platform getPlatform() {
        return Platform.WEB;
    }

    @Override
    public Environment getEnvironment() {
        return Environment.DEV;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
