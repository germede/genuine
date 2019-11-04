package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.SwingBuilder;
import org.fluentness.controller.desktop.swing.component.JMenuBarBuilder;
import org.fluentness.controller.desktop.swing.component.button.JButtonBuilder;
import org.fluentness.controller.desktop.swing.component.JComponentBuilder;
import org.fluentness.controller.desktop.swing.component.JLabelBuilder;
import org.fluentness.controller.desktop.swing.component.button.JMenuBuilder;
import org.fluentness.controller.desktop.swing.component.button.JMenuItemBuilder;
import org.fluentness.controller.desktop.swing.container.JFrameBuilder;
import org.fluentness.controller.desktop.swing.component.JPanelBuilder;

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

    public static JFrameBuilder frame(String id, SwingBuilder swingContainer) {
        return createWithId(id, new JFrameBuilder(swingContainer));
    }

    public static JFrameBuilder frame(SwingBuilder swingContainer) {
        return new JFrameBuilder(swingContainer);
    }

    public static JPanelBuilder panel(String id, JComponentBuilder... JComponentBuilders) {
        return createWithId(id, new JPanelBuilder(JComponentBuilders));
    }

    public static JPanelBuilder panel(JComponentBuilder... JComponentBuilders) {
        return new JPanelBuilder(JComponentBuilders);
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
