package org.fluentness.prototype;

import org.fluentness.application.AbstractGameApplication;
import org.fluentness.Fluentness;
import org.fluentness.application.Application;
import org.fluentness.service.instantiation.InstantiationException;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.prototype.common.Configuration;
import org.fluentness.service.looper.Looper;

@Application.Services(Configuration.class)
public class GameApplication extends AbstractGameApplication {

    public GameApplication(Looper looper, GameController controller) {
        super(looper, controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(GameApplication.class, args);
    }
}
