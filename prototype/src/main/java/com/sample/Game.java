package com.sample;

import com.sample.controller.GameController;
import com.sample.repository.GameRepository;
import com.sample.view.GameView;
import org.fluentness.AbstractGame;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;
import org.fluentness.view.View;

public class Game extends AbstractGame {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(GameController.class)
            ;
    }

    @Override
    public Provider<Repository> repositories() {
        return super.repositories()
            .add(GameRepository.class)
            ;
    }

    @Override
    public Provider<View> views() {
        return super.views()
            .add(GameView.class)
            ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Game(), args);
    }
}
