package org.fluentness.prototype;

import org.fluentness.AbstractGame;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.service.manager.Manager;

public class Game extends AbstractGame {

    public Game(Manager manager, GameController controller) {
        super(manager, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Game.class, args);
    }
}
