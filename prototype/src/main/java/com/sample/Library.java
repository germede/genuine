package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class Library implements Application {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Library()).web();
    }
}
