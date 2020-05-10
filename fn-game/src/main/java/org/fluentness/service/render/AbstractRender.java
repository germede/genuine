package org.fluentness.service.render;

import org.fluentness.view.Scene;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.view.Camera;
import org.fluentness.view.Fog;
import org.fluentness.view.Light;
import org.fluentness.service.shader.AbstractShader;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import static org.fluentness.service.algebra.DefaultAlgebra.projectionMatrix;
import static org.fluentness.service.algebra.DefaultAlgebra.viewMatrix;

public abstract class AbstractRender<S extends AbstractShader, O> implements Render<O> {

    protected final S shader;
    protected final Scene scene;

    public AbstractRender(S shader, Scene scene) {
        this.shader = shader;
        this.scene = scene;

        // optimization: projection matrix is always the same
        Camera camera = scene.getCamera();
        shader.start();
        shader.set(shader.projectionMatrix, projectionMatrix(camera.getFov(), camera.getAspect(), camera.getNear(), camera.getFar()));
        shader.stop();
    }

    protected void bind(int vaoId) {

        GL30.glBindVertexArray(vaoId);
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);

        Vector3f background = scene.getBackground();
        Camera camera = scene.getCamera();
        Light light = scene.getLight();
        Fog fog = scene.getFog();

        shader.set(shader.viewMatrix, viewMatrix(camera.getTranslation(), camera.getRotation()));
        shader.set(shader.lightPosition, light.getTranslation());
        shader.set(shader.lightColour, light.getColour());
        shader.set(shader.ambientLight, light.getAmbientLight());
        shader.set(shader.fogDensity, fog.getDensity());
        shader.set(shader.fogGradient, fog.getGradient());
        shader.set(shader.skyColour, background);

    }

    protected void unbind() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
}
