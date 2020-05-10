package com.sample.view;

import com.sample.repository.GameRepository;
import org.fluentness.view.AbstractGameView;
import org.fluentness.view.GameTemplate;

public class GameView extends AbstractGameView {

    private final GameRepository gameRepository;

    public GameView(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameTemplate getTemplate() {
        return scene("My scene",
            background(0, 0, 0.7f),
            camera(0,0,0),
            light(0,0,0),
            fog(0.0012f, 5.0f),
            gameRepository.terrains(),
            gameRepository.lowPolyTrees(),
            gameRepository.highGrasses(),
            gameRepository.flowers(),
            gameRepository.ferns()
        );
    }
}
