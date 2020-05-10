package org.fluentness.service.render;

import org.fluentness.model.Texture;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.shader.TerrainShader;
import org.fluentness.view.AbstractGameView;
import org.fluentness.view.entity.Terrain;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class TerrainRender extends AbstractRender<TerrainShader> {

    public TerrainRender(Algebra algebra, TerrainShader terrainShader) {
        super(algebra, terrainShader);

        // bind multi-texture slots to uniforms
        shader.start();
        shader.set(shader.blendMap, 0);
        shader.set(shader.blackTexture, 1);
        shader.set(shader.redTexture, 2);
        shader.set(shader.greenTexture, 3);
        shader.set(shader.blueTexture, 4);
        shader.stop();
    }

    @Override
    public void render(AbstractGameView scene) {
        shader.start();
        for (Terrain terrain : scene.getTerrains()) {
            bind(terrain.getShape().getId(),scene);
            bindTextures(terrain.getRepeatTextures(), terrain.getTextures());
            renderTerrain(terrain);
            unbind();
        }
        shader.stop();
    }

    private void bindTextures(float repeatTextures, Texture[] textures) {

        shader.set(shader.repeatTextures, repeatTextures);
        // todo handle transparency

        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures[0].getId());
        GL13.glActiveTexture(GL13.GL_TEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures[1].getId());
        GL13.glActiveTexture(GL13.GL_TEXTURE2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures[2].getId());
        GL13.glActiveTexture(GL13.GL_TEXTURE3);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures[3].getId());
        GL13.glActiveTexture(GL13.GL_TEXTURE4);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures[4].getId());
    }

    private void renderTerrain(Terrain terrain) {
        shader.set(shader.transformationMatrix, algebra.transformationMatrix(terrain.getTranslation(), terrain.getRotation(), terrain.getScale()));
        shader.set(shader.shineDamper, 1);
        shader.set(shader.reflectivity, 0);

        GL11.glDrawElements(GL11.GL_TRIANGLES, terrain.getShape().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
    }
}
