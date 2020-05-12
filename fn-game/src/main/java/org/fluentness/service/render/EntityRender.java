package org.fluentness.service.render;

import org.fluentness.repository.Shape;
import org.fluentness.repository.Texture;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.controller.scene.Scene;
import org.fluentness.controller.scene.entity.Entity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import java.util.List;
import java.util.Map;

public class EntityRender extends AbstractRender<EntityShader> {

    public EntityRender(Algebra algebra, EntityShader entityShader) {
        super(algebra, entityShader);
    }

    @Override
    public void render(Scene scene) {
        shader.start();
        Map<Shape, List<Entity>> entities = scene.getEntities();
        for (Shape shape : entities.keySet()) {
            bind(shape.getId(), scene);
            bindTexture(entities.get(shape).get(0).getTexture());
            for (Entity entity : entities.get(shape)) {
                renderEntity(entity);
            }
            unbind();
        }
        shader.stop();
    }

    private void bindTexture(Texture texture) {
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

    private void renderEntity(Entity entity) {
        shader.set(shader.transformationMatrix, algebra.transformationMatrix(entity.getTranslation(), entity.getRotation(), entity.getScale()));
        shader.set(shader.shineDamper, entity.getShineDamper());
        shader.set(shader.reflectivity, entity.getReflectivity());

        GL11.glDrawElements(GL11.GL_TRIANGLES, entity.getShape().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
    }

}
