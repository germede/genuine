package org.fluentness.service.render;

import org.fluentness.view.Scene;
import org.fluentness.view.Entity;
import org.fluentness.model.shape.ShapeModel;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.model.texture.ObjectTexture;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import java.util.List;
import java.util.Map;

import static org.fluentness.service.algebra.MatrixFactory.transformationMatrix;

public class EntityRender extends AbstractRender<EntityShader, Map<ShapeModel, List<Entity>>> {

    public EntityRender(Scene scene) {
        super(new EntityShader(), scene);
    }

    @Override
    public void render(Map<ShapeModel, List<Entity>> objects) {
        shader.start();
        for (ShapeModel model : objects.keySet()) {
            bind(model.getVao());
            bindTexture(model.getTexture());
            for (Entity entity : objects.get(model)) {
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

    private void renderObject(Entity entity) {
        shader.set(shader.transformationMatrix, transformationMatrix(entity.getTranslation(), entity.getRotation(), entity.getScale()));
        shader.set(shader.shineDamper, entity.getShineDamper());
        shader.set(shader.reflectivity, entity.getReflectivity());

        GL11.glDrawElements(GL11.GL_TRIANGLES, entity.getModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
    }

}
