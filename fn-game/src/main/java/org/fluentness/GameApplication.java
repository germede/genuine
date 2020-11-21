package org.fluentness;

import org.fluentness.controller.GameController;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.algebra.AlgebraImpl;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.animator.AnimatorImpl;
import org.fluentness.service.injector.DefaultImplementations;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.loader.LoaderImpl;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.memory.MemoryImpl;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.view.AbstractGameView;

public abstract class GameApplication implements Application {

    static {
        DefaultImplementations.set(Loader.class, LoaderImpl.class);
        DefaultImplementations.set(Algebra.class, AlgebraImpl.class);
        DefaultImplementations.set(Animator.class, AnimatorImpl.class);
        DefaultImplementations.set(Memory.class, MemoryImpl.class);
    }

    private final GameController gameController;
    private final TerrainRender terrainRender;
    private final EntityRender entityRender;
    private final Memory memory;
    private final Animator animator;

    public GameApplication(GameController gameController, TerrainRender terrainRender, EntityRender entityRender, Memory memory, Animator animator) {
        this.gameController = gameController;
        this.terrainRender = terrainRender;
        this.entityRender = entityRender;
        this.memory = memory;
        this.animator = animator;
    }

    @Override
    public void run(String[] args) {
        AbstractGameView view = gameController.getGameView();
        while (!view.shouldClose()) {
            view.clear(view.background.r, view.background.g, view.background.b);
            terrainRender.render(view);
            entityRender.render(view);
            gameController.loop();
            animator.step();
            view.update();
        }
        memory.cleanUp();
        view.close();
    }

}
