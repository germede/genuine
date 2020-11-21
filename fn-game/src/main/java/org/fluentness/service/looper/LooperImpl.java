package org.fluentness.service.looper;

import org.fluentness.controller.GameController;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.display.Display;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.view.AbstractGameView;

public class LooperImpl implements Looper {

    private final Display display;
    private final TerrainRender terrainRender;
    private final EntityRender entityRender;
    private final Memory memory;
    private final Animator animator;

    public LooperImpl(Display display, TerrainRender terrainRender, EntityRender entityRender, Memory memory, Animator animator) {
        this.display = display;
        this.terrainRender = terrainRender;
        this.entityRender = entityRender;
        this.memory = memory;
        this.animator = animator;
    }

    @Override
    public void loop(GameController controller) {
        AbstractGameView view = controller.getGameView();
        display.setTitle(view.getTitle());
        while (!display.shouldClose()) {
            display.clear(view.background.r, view.background.g, view.background.b);
            terrainRender.render(view);
            entityRender.render(view);
            controller.loop();
            animator.step();
            display.update();
        }
        memory.cleanUp();
        display.close();
    }
}
