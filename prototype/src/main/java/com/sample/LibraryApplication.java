package com.sample;

import org.fluentness.*;

public class LibraryApplication implements Application {

    @Override
    public Platform getPlatform() {
        return Platform.DESKTOP;
    }

    @Override
    public Environment getEnvironment() {
        return Environment.DEV;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
