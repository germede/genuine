package com.sample.view;

import org.fluentness.view.AbstractGameView;
import org.fluentness.view.GameTemplate;
import org.fluentness.service.algebra.Vector3f;

public class GameView extends AbstractGameView {

    @Override
    public GameTemplate getTemplate() {
        return scene("My scene",
            background(new Vector3f(0, 0, 0.7f)),
            terrain(entityRepository.loadTerrain()),

            entities(entityRepository.loadTrees()),
            entities(entityRepository.loadGrasses()),
            entities(entityRepository.loadFlowers()),
            entities(entityRepository.loadFerns())
        );
    }
}
