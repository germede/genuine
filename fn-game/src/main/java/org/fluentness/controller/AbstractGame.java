package org.fluentness.controller;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.controller.scene.Entities;
import org.fluentness.controller.scene.Entity;
import org.fluentness.controller.scene.Background;
import org.fluentness.controller.scene.Camera;
import org.fluentness.controller.scene.Fog;
import org.fluentness.controller.scene.Light;
import org.fluentness.controller.scene.Scene;

public abstract class AbstractGame implements ViewHolder<GameView> {

    protected static Scene scene(SceneElement... sceneElements) {
        return new Scene(sceneElements);
    }

    protected static Background background(float r, float g, float b) {
        return new Background(r, g, b);
    }

    protected static Camera camera(float x, float y, float z) {
        return new Camera(x, y, z);
    }

    protected static Light light(float x, float y, float z) {
        return new Light(x, y, z);
    }

    protected static Fog fog(float density, float gradient) {
        return new Fog(density, gradient);
    }

    protected static Entities entities(Entity[]... entities) {
        return new Entities(entities);
    }
}
