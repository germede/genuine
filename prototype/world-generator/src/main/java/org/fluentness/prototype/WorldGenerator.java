package org.fluentness.prototype;

import org.fluentness.GameApplication;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;
import org.fluentness.service.injector.ConstructorInjector;
import org.fluentness.service.looper.Looper;

@Services(Configuration.class)
public class WorldGenerator extends GameApplication {

    public WorldGenerator(Looper looper, GameController controller) {
        super(looper, controller);
    }

    public static void main(String[] args) throws Exception {
        new ConstructorInjector().inject(WorldGenerator.class).run(args);
    }
}
