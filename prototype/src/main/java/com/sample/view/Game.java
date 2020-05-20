package com.sample.view;

import com.sample.repository.GameRepository;
import org.fluentness.view.AbstractGame;
import org.fluentness.view.GameTemplate;
import org.fluentness.view.scene.Scene;
import org.fluentness.view.scene.camera.Camera;
import org.fluentness.view.scene.entity.Player;
import org.fluentness.view.scene.light.Light;
import org.fluentness.view.scene.terrain.Terrain;

public class Game extends AbstractGame {

    private final GameRepository gameRepository;

    public Game(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Terrain terrain;
    public Scene scene;
    public Light light;
    public Camera camera;
    public Player player;

    @Override
    public GameTemplate getTemplate() {
        return scene = scene(
            background(0, 0, 0.7f),
            camera = camera(0, 50, 0),
            light = light(0, 0, 0),
            fog(0.0012f, 5.0f),
            terrain = gameRepository.terrain(),
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
