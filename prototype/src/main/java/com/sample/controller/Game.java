package com.sample.controller;

import com.sample.repository.GameRepository;
import org.fluentness.controller.AbstractGame;
import org.fluentness.controller.GameView;
import org.fluentness.controller.scene.Camera;
import org.fluentness.controller.scene.Light;

public class Game extends AbstractGame {

    private final GameRepository gameRepository;

    public Game(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    Light light;
    Camera camera;

    @Override
    public GameView render() {
        return scene(
            background(0, 0, 0.7f),
            camera = camera(0, 0, 0),
            light = light(0, 0, 0),
            fog(0.0012f, 5.0f),
            gameRepository.terrain(),
            entities(
                gameRepository.lowPolyTrees(),
                gameRepository.highGrasses(),
                gameRepository.flowers(),
                gameRepository.ferns()
            )
        );
    }

}
