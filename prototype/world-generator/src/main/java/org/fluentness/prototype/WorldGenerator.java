package org.fluentness.prototype;

import org.fluentness.application.GameApplication;
import org.fluentness.Fluentness;
import org.fluentness.application.Application;
import org.fluentness.service.instantiation.InstantiationException;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.looper.Looper;

@Application.Services(Configuration.class)
public class WorldGenerator extends GameApplication {

    public WorldGenerator(Looper looper, GameController controller) {
        super(looper, controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(WorldGenerator.class, args);
    }
}
