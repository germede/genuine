package org.fluentness.prototype;

import org.fluentness.AbstractGame;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;
import org.fluentness.service.looper.Looper;

@Services(Configuration.class)
public class Game extends AbstractGame {

    public Game(Looper looper, GameController controller) {
        super(looper, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Game.class, args);
    }
}
