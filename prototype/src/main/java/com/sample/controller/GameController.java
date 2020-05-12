package com.sample.controller;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.display.Display;

public class GameController extends AbstractGameController<Game> {

    public GameController(Game game, Display display) {
        super(game, display);
    }

    @Override
    public void loop() {
        handleCamera();
    }

    private void handleCamera() {
        translateWithArrows(game.camera.getTranslation());
        rotateWithMouse(game.camera.getRotation());
    }

}
