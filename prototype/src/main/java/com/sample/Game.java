package com.sample;

import org.fluentness.AbstractGame;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class Game extends AbstractGame {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Game(), args);
    }
}
