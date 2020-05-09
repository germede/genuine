package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;

import javax.swing.*;
import java.util.List;

public abstract class AbstractDesktop implements Application {

    @Override
    public final void run(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        List<AbstractDesktopController> instances = Fluentness.getInstances(AbstractDesktopController.class);
        for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
            controller.getView().getTemplate().render();
            controller.setListeners();
        }
    }
}
