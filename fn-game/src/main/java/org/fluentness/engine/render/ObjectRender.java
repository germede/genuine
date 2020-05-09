package org.fluentness.engine.render;

import org.fluentness.engine.AbstractScene;
import org.fluentness.engine.entity.Object;
import org.fluentness.engine.model.ObjectModel;
import org.fluentness.engine.shader.ObjectShader;
import org.fluentness.engine.texture.ObjectTexture;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import java.util.List;
import java.util.Map;

import static org.fluentness.engine.algebra.MatrixFactory.transformationMatrix;

public class ObjectRender extends AbstractRender<ObjectShader> {

    public ObjectRender(AbstractScene scene) {
        super(new ObjectShader(), scene);
    }

    public void render(Map<ObjectModel, List<Object>> objects) {
        shader.start();
        for (ObjectModel model : objects.keySet()) {
            bind(model.getVao());
            bindTexture(model.getTexture());
            for (Object entity : objects.get(model)) {
                renderObject(entity);
            }
            unbind();
        }
        shader.stop();
    }

    private void bindTexture(ObjectTexture texture) {
        if (texture.hasTransparency()) {
            GL11.glDisable(GL11.GL_CULL_FACE);
        } else {
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glCullFace(GL11.GL_BACK);
        }

        shader.set(shader.lightUniformly, texture.isLightUniformly());

        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getId());
    }

    private void renderObject(Object object) {
        shader.set(shader.transformationMatrix, transformationMatrix(object.getTranslation(), object.getRotation(), object.getScale()));
        shader.set(shader.shineDamper, object.getShineDamper());
        shader.set(shader.reflectivity, object.getReflectivity());

        GL11.glDrawElements(GL11.GL_TRIANGLES, object.getModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
    }

}
