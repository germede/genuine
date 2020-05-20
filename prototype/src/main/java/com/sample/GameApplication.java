package com.sample;

import com.sample.controller.GameController;
import com.sample.repository.GameRepository;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractGameApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.Src;

@Src(
    services = MapConfiguration.class,
    repositories = GameRepository.class,
    controllers = GameController.class
)
public class GameApplication extends AbstractGameApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new GameApplication(), args);
    }
}
