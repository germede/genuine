package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;

import javax.swing.*;
import java.util.List;

public abstract class AbstractDesktopApplication implements Application {

    @Override
    public void run(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        List<AbstractDesktopController> instances = Fluentness.getInstances(AbstractDesktopController.class);
        for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
//            controller.getView().getTemplate().render();
//            controller.setListeners();
        }
    }
}
