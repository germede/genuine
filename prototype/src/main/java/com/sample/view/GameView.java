package com.sample.view;

import com.sample.repository.EntityRepository;
import org.fluentness.view.AbstractGameView;
import org.fluentness.view.GameTemplate;

public class GameView extends AbstractGameView {

    private final EntityRepository entityRepository;

    public GameView(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public GameTemplate getTemplate() {
        return scene("My scene",
            background(0, 0, 0.7f),
            camera(0,0,0),
            light(0,0,0),
            fog(0.0012f, 5.0f),
            entityRepository.terrains(),
            entityRepository.lowPolyTrees(),
            entityRepository.highGrasses(),
            entityRepository.flowers(),
            entityRepository.ferns()
        );
    }
}
