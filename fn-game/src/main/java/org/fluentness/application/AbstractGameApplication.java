package org.fluentness.application;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.algebra.AlgebraImpl;
import org.fluentness.service.animator.AnimatorImpl;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.loader.LoaderImpl;
import org.fluentness.service.looper.Looper;
import org.fluentness.service.looper.LooperImpl;
import org.fluentness.service.memory.MemoryImpl;
import org.fluentness.service.parser.MeshParser;
import org.fluentness.service.parser.TextureParser;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.service.shader.TerrainShader;

@Application.Services({
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
    LooperImpl.class,
})
public abstract class AbstractGameApplication implements Application {

    private final Looper looper;
    private final AbstractGameController controller;

    public AbstractGameApplication(Looper looper, AbstractGameController controller) {
        this.looper = looper;
        this.controller = controller;
    }

    @Override
    public void run(String[] args) throws Exception {
        looper.loop(controller);
    }

}
