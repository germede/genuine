package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

import java.util.List;

public abstract class AbstractDesktopController implements Controller {

    @Override
    public List<Action> getActions() {
        return null;
    }
}
