package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.component.SwingButton;
import org.fluentness.controller.desktop.swing.component.SwingComponent;
import org.fluentness.controller.desktop.swing.component.SwingLabel;
import org.fluentness.controller.desktop.swing.container.SwingContainer;
import org.fluentness.controller.desktop.swing.container.SwingFrame;
import org.fluentness.controller.desktop.swing.container.SwingPanel;

public final class DesktopViewFactory {

    public static SwingFrame frame(SwingContainer swingContainer) {
        return new SwingFrame(swingContainer);
    }

    public static SwingPanel panel(SwingComponent... swingComponents) {
        return new SwingPanel(swingComponents);
    }

    public static SwingButton button(String title) {
        return new SwingButton(title);
    }

    public static SwingLabel label(String title) {
        return new SwingLabel(title);
    }

}
