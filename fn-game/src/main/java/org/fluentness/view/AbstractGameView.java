package org.fluentness.view;

import org.fluentness.view.scene.Scene;
import org.fluentness.view.scene.SceneElement;
import org.fluentness.view.scene.environment.Background;
import org.fluentness.view.scene.environment.Camera;
import org.fluentness.view.scene.environment.Fog;
import org.fluentness.view.scene.environment.Light;

public abstract class AbstractGameView implements View<GameTemplate> {

    protected final Scene scene(String title, Background background, Camera camera, Light light, Fog fog, SceneElement[]... elements) {
        Scene scene = new Scene(background, camera, light, fog);
        for (SceneElement[] element : elements) {
            scene.add(element);
        }
        return scene;
    }


    protected final Background background(float r, float g, float b) {
        return new Background(r, g, b);
    }

    protected final Camera camera(float x, float y, float z) {
        return new Camera(x, y, z);
    }

    protected final Light light(float x, float y, float z) {
        return new Light(x, y, z);
    }

    protected final Fog fog(float density, float gradient) {
        return new Fog(density, gradient);
    }



}
