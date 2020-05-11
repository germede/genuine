package org.fluentness.controller;

import org.fluentness.controller.entity.Entity;
import org.fluentness.controller.entity.Terrain;
import org.fluentness.controller.environment.Background;
import org.fluentness.controller.environment.Camera;
import org.fluentness.controller.environment.Fog;
import org.fluentness.controller.environment.Light;

public abstract class AbstractGame implements Template<GameView> {

    protected static Scene scene(Background background, Camera camera, Light light, Fog fog, Terrain[] terrains, Entity[]... entities) {
        return new Scene(background, camera, light, fog, terrains, entities);
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

}
