package org.fluentness;

import org.fluentness.controller.GameController;
import org.fluentness.repository.GameRepository;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.display.Display;
import org.fluentness.service.injection.Provider;

public class GameApplication extends AbstractGameApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .repository(GameRepository.class)
            .controller(GameController.class)
        ;
    }

    @Override
    public void configure(Configuration configuration) {
        super.configure(configuration);
        configuration
            .set(Display.TITLE, "Forest")
            .set(Display.WIDTH, 1800)
            .set(Display.HEIGHT, 900)
            .set(Display.FULLSCREEN, false)
        ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new GameApplication(), args);
    }
}
