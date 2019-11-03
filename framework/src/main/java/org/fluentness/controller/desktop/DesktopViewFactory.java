package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.component.SwingButton;
import org.fluentness.controller.desktop.swing.component.SwingComponent;
import org.fluentness.controller.desktop.swing.component.SwingLabel;
import org.fluentness.controller.desktop.swing.container.SwingContainer;
import org.fluentness.controller.desktop.swing.container.SwingFrame;
import org.fluentness.controller.desktop.swing.container.SwingPanel;

import java.util.HashMap;
import java.util.Map;

public final class DesktopViewFactory {

    private static final Map<String, DesktopView> ID_MAP = new HashMap<>();

    public static <D extends DesktopView> D getView(Class<D> dClass, String id) {
        return (D) ID_MAP.get(id);
    }

    private static <D extends DesktopView> D createWithId(String id, D desktopView) {
        ID_MAP.put(id, desktopView);
        return desktopView;
    }

    public static SwingFrame frame(String id, SwingContainer swingContainer) {
        return createWithId(id, new SwingFrame(swingContainer));
    }

    public static SwingFrame frame(SwingContainer swingContainer) {
        return new SwingFrame(swingContainer);
    }

    public static SwingPanel panel(String id, SwingComponent... swingComponents) {
        return createWithId(id, new SwingPanel(swingComponents));
    }

    public static SwingPanel panel(SwingComponent... swingComponents) {
        return new SwingPanel(swingComponents);
    }

    public static SwingButton button(String id) {
        return createWithId(id, new SwingButton());
    }

    public static SwingButton button() {
        return new SwingButton();
    }

    public static SwingLabel label(String id) {
        return createWithId(id, new SwingLabel());
    }

    public static SwingLabel label() {
        return new SwingLabel();
    }

}
