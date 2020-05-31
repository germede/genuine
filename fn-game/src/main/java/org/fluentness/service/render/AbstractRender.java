package org.fluentness.service.render;

import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.AbstractShader;
import org.fluentness.view.AbstractGameView;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public abstract class AbstractRender<S extends AbstractShader> implements Render {

    protected final Algebra algebra;
    protected final S shader;

    public AbstractRender(Algebra algebra, S shader) {
        this.algebra = algebra;
        this.shader = shader;
    }

    protected void bind(int vaoId, AbstractGameView view) {

        GL30.glBindVertexArray(vaoId);
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);

        // todo optimize projectionMatrix, doesn't need to be always generated
        shader.set(shader.projectionMatrix, algebra.projectionMatrix(view.camera.fov, view.camera.aspect, view.camera.near, view.camera.far));
        shader.set(shader.viewMatrix, algebra.viewMatrix(view.camera.translation, view.camera.rotation));
        shader.set(shader.lightPosition, view.light.translation);
        shader.set(shader.lightColour, view.light.colour);
        shader.set(shader.ambientLight, view.light.ambientLight);
        shader.set(shader.fogDensity, view.fog.density);
        shader.set(shader.fogGradient, view.fog.gradient);
        shader.set(shader.skyColour, view.background.colour);

    }

    protected void unbind() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
}
