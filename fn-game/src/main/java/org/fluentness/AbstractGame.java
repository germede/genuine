package org.fluentness;

import org.fluentness.service.Service;
import org.fluentness.service.algebra.DefaultAlgebra;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.loader.DefaultLoader;
import org.fluentness.service.memory.DefaultMemory;
import org.fluentness.service.parser.ShapeParser;
import org.fluentness.service.parser.TextureParser;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.service.shader.TerrainShader;

public abstract class AbstractGame implements Application {

    @Override
    public Provider<Service> services() {
        return Application.super.services()
            .add(DefaultMemory.class)
            .add(DefaultAlgebra.class)
            .add(ShapeParser.class)
            .add(TextureParser.class)
            .add(DefaultLoader.class)
            .add(GlfwDisplay.class)
            .add(EntityShader.class)
            .add(TerrainShader.class)
            .add(EntityRender.class)
            .add(TerrainRender.class)
            ;
    }

    @Override
    public final void run(String[] args) throws Exception {

    }
}
