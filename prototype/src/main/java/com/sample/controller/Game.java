package com.sample.controller;

import com.sample.repository.GameRepository;
import org.fluentness.controller.AbstractGame;
import org.fluentness.controller.input.GameView;
import org.fluentness.controller.scene.Scene;
import org.fluentness.controller.scene.camera.Camera;
import org.fluentness.controller.scene.entity.Player;
import org.fluentness.controller.scene.light.Light;

public class Game extends AbstractGame {

    private final GameRepository gameRepository;
    public Game(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    Scene scene;
    Light light;
    Camera camera;
    Player player;

    @Override
    public GameView render() {
        return scene = scene(
            background(0, 0, 0.7f),
            camera = camera(0, 50, 0),
            light = light(0, 0, 0),
            fog(0.0012f, 5.0f),
            gameRepository.terrain(),
            player = gameRepository.player(),
            entities(
                gameRepository.lowPolyTrees(),
                gameRepository.highGrasses(),
                gameRepository.flowers(),
                gameRepository.ferns()
            )
        );
    }

}
