package org.fluentness;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.Services;
import org.fluentness.service.algebra.AlgebraImpl;
import org.fluentness.service.animator.AnimatorImpl;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.generator.GeneratorImpl;
import org.fluentness.service.loader.LoaderImpl;
import org.fluentness.service.manager.Manager;
import org.fluentness.service.manager.ManagerImpl;
import org.fluentness.service.memory.MemoryImpl;
import org.fluentness.service.parser.MeshParser;
import org.fluentness.service.parser.TextureParser;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.service.shader.TerrainShader;

@Services({
    GeneratorImpl.class,
    LoaderImpl.class,
    MeshParser.class,
    TextureParser.class,
    EntityRender.class,
    TerrainRender.class,
    EntityShader.class,
    TerrainShader.class,
    GlfwDisplay.class,
    AlgebraImpl.class,
    AnimatorImpl.class,
    MemoryImpl.class,
    ManagerImpl.class,
})
public abstract class AbstractGame implements Application {

    private final Manager manager;
    private final AbstractGameController controller;

    public AbstractGame(Manager manager, AbstractGameController controller) {
        this.manager = manager;
        this.controller = controller;
    }

    @Override
    public void run(String[] args) throws Exception {
        manager.manage(controller);
    }

}
