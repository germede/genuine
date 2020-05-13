package org.fluentness.service.render;

import org.fluentness.controller.scene.Scene;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.AbstractShader;
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

        // todo optimize projectionMatrix, doesn't need to be always generated
        shader.set(shader.projectionMatrix, algebra.projectionMatrix(scene.camera.fov, scene.camera.aspect, scene.camera.near, scene.camera.far));
        shader.set(shader.viewMatrix, algebra.viewMatrix(scene.camera.translation, scene.camera.rotation));
        shader.set(shader.lightPosition, scene.light.translation);
        shader.set(shader.lightColour, scene.light.colour);
        shader.set(shader.ambientLight, scene.light.ambientLight);
        shader.set(shader.fogDensity, scene.fog.density);
        shader.set(shader.fogGradient, scene.fog.gradient);
        shader.set(shader.skyColour, scene.background.colour);

    }

    protected void unbind() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
}
