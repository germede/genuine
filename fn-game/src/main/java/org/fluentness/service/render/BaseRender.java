package org.fluentness.service.render;

import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.BaseShader;
import org.fluentness.view.AbstractGameView;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public abstract class BaseRender<S extends BaseShader> implements Render {

    protected final Algebra algebra;
    protected final S shader;

    public BaseRender(Algebra algebra, S shader) {
        this.algebra = algebra;
        this.shader = shader;
    }

    protected void bind(int vaoId, AbstractGameView view) {

        GL30.glBindVertexArray(vaoId);
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);

        // todo optimize projectionMatrix, doesn't need to be always generated
        shader.set(shader.projectionMatrix, algebra.projectionMatrix(
            view.camera.fov, view.camera.aspect, view.camera.near, view.camera.far
        ));
        shader.set(shader.viewMatrix, algebra.viewMatrix(
            view.camera.x, view.camera.y, view.camera.z,
            view.camera.pitch, view.camera.yaw, view.camera.roll)
        );
        shader.set(shader.lightPosition, view.light.x, view.light.y, view.light.z);
        shader.set(shader.lightColour, view.light.r, view.light.g, view.light.b);
        shader.set(shader.ambientLight, view.light.ambientLight);
        shader.set(shader.fogDensity, view.fog.density);
        shader.set(shader.fogGradient, view.fog.gradient);
        shader.set(shader.skyColour, view.background.r, view.background.g, view.background.b);

    }

    protected void unbind() {
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
    }
}
