package org.fluentness.view;

import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.LinearLayout;
import org.fluentness.view.scene.Scene;
import org.fluentness.view.scene.SceneElement;
import org.fluentness.view.scene.camera.Camera;
import org.fluentness.view.scene.entity.Entities;
import org.fluentness.view.scene.entity.Entity;
import org.fluentness.view.scene.environment.Background;
import org.fluentness.view.scene.environment.Fog;
import org.fluentness.view.scene.light.Light;

public abstract class AbstractGameView extends AbstractView {

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

    @Override
    protected LinearLayout linearLayout(Component... components) {
        return null;
    }

    @Override
    protected Button button(CharSequence text) {
        return null;
    }
}
