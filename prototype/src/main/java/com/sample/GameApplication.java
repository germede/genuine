package com.sample;

import com.sample.controller.GameController;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractGameApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.Services;
import org.fluentness.service.manager.Manager;

@Services(MapConfiguration.class)
public class GameApplication extends AbstractGameApplication {

    public GameApplication(Manager manager, GameController controller) {
        super(manager, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(GameApplication.class, args);
    }
}
