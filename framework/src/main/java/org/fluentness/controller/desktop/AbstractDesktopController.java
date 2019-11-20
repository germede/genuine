package org.fluentness.controller.desktop;

import org.fluentness.controller.Action;
import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.style.DesktopStyle;

import java.util.List;

public abstract class AbstractDesktopController implements Controller<Action, DesktopView> {

    @Override
    public List<Action> getActions() {
        return null;
    }

    public abstract DesktopStyle getGlobalStyle();

    public abstract DesktopView getMainView();

}
