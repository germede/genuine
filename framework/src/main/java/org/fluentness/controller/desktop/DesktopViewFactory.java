package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.SwingView;
import org.fluentness.controller.desktop.swing.component.JMenuBarView;
import org.fluentness.controller.desktop.swing.component.button.JButtonView;
import org.fluentness.controller.desktop.swing.component.JComponentView;
import org.fluentness.controller.desktop.swing.component.JLabelView;
import org.fluentness.controller.desktop.swing.component.button.JMenuView;
import org.fluentness.controller.desktop.swing.component.button.JMenuItemView;
import org.fluentness.controller.desktop.swing.container.JFrameView;
import org.fluentness.controller.desktop.swing.component.JPanelView;

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

    public static JFrameView frame(String id, SwingView swingContainer) {
        return createWithId(id, new JFrameView(swingContainer));
    }

    public static JFrameView frame(SwingView swingContainer) {
        return new JFrameView(swingContainer);
    }

    public static JPanelView panel(String id, JComponentView... JComponentBuilders) {
        return createWithId(id, new JPanelView(JComponentBuilders));
    }

    public static JPanelView panel(JComponentView... JComponentBuilders) {
        return new JPanelView(JComponentBuilders);
    }

    public static JButtonView button(String id) {
        return createWithId(id, new JButtonView());
    }

    public static JButtonView button() {
        return new JButtonView();
    }

    public static JLabelView label(String id) {
        return createWithId(id, new JLabelView());
    }

    public static JLabelView label() {
        return new JLabelView();
    }


    public static JMenuBarView menuBar(JMenuView... menus) {
        return new JMenuBarView(menus);
    }

    public static JMenuView menu(String text, JMenuItemView... menuItems) {
        return new JMenuView(menuItems).text(text);
    }

    public static JMenuItemView menuItem(String text) {
        return new JMenuItemView().text(text);
    }

}
