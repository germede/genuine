package org.fluentness.controller;

import org.fluentness.controller.scene.SceneElement;
import org.fluentness.controller.scene.entity.Entities;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.controller.scene.environment.Background;
import org.fluentness.controller.scene.camera.Camera;
import org.fluentness.controller.scene.environment.Fog;
import org.fluentness.controller.scene.light.Light;
import org.fluentness.controller.scene.Scene;

public abstract class AbstractGame implements ViewHolder<GameView> {

    protected Scene scene(SceneElement... sceneElements) {
        return new Scene(sceneElements);
    }

    protected Background background(float r, float g, float b) {
        return new Background(r, g, b);
    }

    protected Camera camera(float x, float y, float z) {
        return new Camera(x, y, z);
    }

    protected Light light(float x, float y, float z) {
        return new Light(x, y, z);
    }

    protected Fog fog(float density, float gradient) {
        return new Fog(density, gradient);
    }

    protected Entities entities(Entity[]... entities) {
        return new Entities(entities);
    }
}
