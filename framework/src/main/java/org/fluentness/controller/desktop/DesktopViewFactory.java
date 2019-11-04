package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.JMenuBarBuilder;
import org.fluentness.controller.desktop.swing.button.JButtonBuilder;
import org.fluentness.controller.desktop.swing.JComponentBuilder;
import org.fluentness.controller.desktop.swing.JLabelBuilder;
import org.fluentness.controller.desktop.swing.button.JMenuBuilder;
import org.fluentness.controller.desktop.swing.button.JMenuItemBuilder;
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

    public static SwingPanel panel(String id, JComponentBuilder... JComponentBuilders) {
        return createWithId(id, new SwingPanel(JComponentBuilders));
    }

    public static SwingPanel panel(JComponentBuilder... JComponentBuilders) {
        return new SwingPanel(JComponentBuilders);
    }

    public static JButtonBuilder button(String id) {
        return createWithId(id, new JButtonBuilder());
    }

    public static JButtonBuilder button() {
        return new JButtonBuilder();
    }

    public static JLabelBuilder label(String id) {
        return createWithId(id, new JLabelBuilder());
    }

    public static JLabelBuilder label() {
        return new JLabelBuilder();
    }


    public static JMenuBarBuilder menuBar(JMenuBuilder... menus) {
        return new JMenuBarBuilder(menus);
    }

    public static JMenuBuilder menu(String text, JMenuItemBuilder... menuItems) {
        return new JMenuBuilder(menuItems).text(text);
    }

    public static JMenuItemBuilder menuItem(String text) {
        return new JMenuItemBuilder().text(text);
    }

}
