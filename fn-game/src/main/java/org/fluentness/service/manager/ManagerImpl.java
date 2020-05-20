package org.fluentness.service.manager;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.display.Display;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.view.scene.Scene;

public class ManagerImpl implements Manager {


    private final Display display;
    private final TerrainRender terrainRender;
    private final EntityRender entityRender;
    private final Memory memory;
    private final Animator animator;

    public ManagerImpl(Display display, TerrainRender terrainRender, EntityRender entityRender, Memory memory, Animator animator) {
        this.display = display;
        this.terrainRender = terrainRender;
        this.entityRender = entityRender;
        this.memory = memory;
        this.animator = animator;
    }

    @Override
    public void manage(AbstractGameController controller) {
        Scene scene = (Scene) controller.getGame().getTemplate();

        while (!display.shouldClose()) {
            display.clear(scene.background.colour);
            terrainRender.render(scene);
            entityRender.render(scene);
            controller.loop();
            animator.step();
            display.update();
        }
        memory.cleanUp();
        display.close();
    }
}
