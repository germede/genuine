package org.fluentness.service.render;

import org.fluentness.controller.scene.Scene;
import org.fluentness.controller.scene.entity.Entity;
import org.fluentness.repository.texture.Texture;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.EntityShader;
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
        Map<String, List<Entity>> entities = scene.entities;
        for (String key : entities.keySet()) {
            Entity entity1 = entities.get(key).get(0);
            bind(entity1.mesh.getId(), scene);
            bindTexture(entity1.texture);
            for (Entity entity : entities.get(key)) {
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
        shader.set(shader.transformationMatrix, algebra.transformationMatrix(entity.translation, entity.rotation, entity.scale));
        shader.set(shader.shineDamper, entity.shineDamper);
        shader.set(shader.reflectivity, entity.reflectivity);

        GL11.glDrawElements(GL11.GL_TRIANGLES, entity.mesh.vertexCount, GL11.GL_UNSIGNED_INT, 0);
    }

}
