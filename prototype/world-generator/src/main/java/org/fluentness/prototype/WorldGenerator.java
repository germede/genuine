package org.fluentness.prototype;

import org.fluentness.GameApplication;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.injector.ConstructorInjector;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;

public class WorldGenerator extends GameApplication {


    public WorldGenerator(GameController gameController, TerrainRender terrainRender, EntityRender entityRender, Memory memory, Animator animator) {
        super(gameController, terrainRender, entityRender, memory, animator);
    }

    public static void main(String[] args) throws Exception {
        new ConstructorInjector().inject(WorldGenerator.class).run(args);
    }
}
