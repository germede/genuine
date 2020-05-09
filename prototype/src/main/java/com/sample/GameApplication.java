package com.sample;

import org.fluentness.AbstractGameApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class GameApplication extends AbstractGameApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new GameApplication(), args);
    }
}
