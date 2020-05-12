package org.fluentness.service.render;

import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.AbstractShader;
import org.fluentness.controller.scene.Scene;
import org.fluentness.controller.scene.environment.Background;
import org.fluentness.controller.scene.camera.Camera;
import org.fluentness.controller.scene.environment.Fog;
import org.fluentness.controller.scene.light.Light;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public abstract class AbstractRender<S extends AbstractShader> implements Render {

    protected final Algebra algebra;
    protected final S shader;

    public AbstractRender(Algebra algebra, S shader) {
        this.algebra = algebra;
        this.shader = shader;
    }

    protected void bind(int vaoId, Scene scene) {

        GL30.glBindVertexArray(vaoId);
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);

        Background background = scene.getBackground();
        Camera camera = scene.getCamera();
        Light light = scene.getLight();
        Fog fog = scene.getFog();

        // optimize projectionMatrix, doesn't need to be always generated
        shader.set(shader.projectionMatrix, algebra.projectionMatrix(camera.getFov(), camera.getAspect(), camera.getNear(), camera.getFar()));
        shader.set(shader.viewMatrix, algebra.viewMatrix(camera.getTranslation(), camera.getRotation()));
        shader.set(shader.lightPosition, light.getTranslation());
        shader.set(shader.lightColour, light.getColour());
        shader.set(shader.ambientLight, light.getAmbientLight());
        shader.set(shader.fogDensity, fog.getDensity());
        shader.set(shader.fogGradient, fog.getGradient());
        shader.set(shader.skyColour, background.getColour());

    }

    protected void unbind() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
}
