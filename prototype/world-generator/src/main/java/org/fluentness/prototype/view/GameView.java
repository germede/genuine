package org.fluentness.prototype.view;

import org.fluentness.model.Background;
import org.fluentness.model.Camera;
import org.fluentness.model.Fog;
import org.fluentness.model.Light;
import org.fluentness.view.AbstractGameView;

public class GameView extends AbstractGameView {

    public GameView() {
        super("Forest", 1024, 768, false);

        background = new Background(0, 0, 0.7f);
        camera = new Camera(0, 50, 0);
        light = new Light(0, 0, 0);
        fog = new Fog(0.0012f, 5.0f);
    }
}
