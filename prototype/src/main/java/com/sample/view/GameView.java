package com.sample.view;

import com.sample.repository.GameRepository;
import org.fluentness.view.AbstractGameView;
import org.fluentness.view.environment.Light;

public class GameView extends AbstractGameView {


    static Light light = null;

    public GameView(GameRepository gameRepository) {
        super(background(0, 0, 0.7f),
            camera(0, 0, 0),
            // todo hold ids instead of using maps?
            light = light(0, 0, 0),
            fog(0.0012f, 5.0f),
            gameRepository.terrains(),
            gameRepository.lowPolyTrees(),
            gameRepository.highGrasses(),
            gameRepository.flowers(),
            gameRepository.ferns()
        );
    }

}
