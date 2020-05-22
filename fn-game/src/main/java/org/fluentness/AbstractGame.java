package org.fluentness;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.manager.Manager;

public abstract class AbstractGame implements Application {

    private final Manager manager;
    private final AbstractGameController controller;

    public AbstractGame(Manager manager, AbstractGameController controller) {
        this.manager = manager;
        this.controller = controller;
    }

    @Override
    public void run(String[] args) {
        manager.manage(controller);
    }

}
