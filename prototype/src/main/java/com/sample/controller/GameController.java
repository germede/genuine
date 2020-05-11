package com.sample.controller;

import com.sample.view.GameView;
import org.fluentness.controller.AbstractGameController;

public class GameController extends AbstractGameController<GameView> {

    public GameController(GameView view) {
        super(view);
    }

    @Override
    public void loop() {
        view.light.getAmbientLight();
    }
}
