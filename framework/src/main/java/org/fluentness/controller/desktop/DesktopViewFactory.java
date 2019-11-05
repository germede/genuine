package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.SwingView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;
import org.fluentness.controller.desktop.swing.component.button.ButtonView;
import org.fluentness.controller.desktop.swing.component.ComponentView;
import org.fluentness.controller.desktop.swing.component.LabelView;
import org.fluentness.controller.desktop.swing.component.button.MenuView;
import org.fluentness.controller.desktop.swing.component.button.MenuItemView;
import org.fluentness.controller.desktop.swing.container.JFrameView;
import org.fluentness.controller.desktop.swing.component.PanelView;

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

    public static PanelView panel(String id, ComponentView... JComponentBuilders) {
        return createWithId(id, new PanelView(JComponentBuilders));
    }

    public static PanelView panel(ComponentView... JComponentBuilders) {
        return new PanelView(JComponentBuilders);
    }

    public static ButtonView button(String id) {
        return createWithId(id, new ButtonView());
    }

    public static ButtonView button() {
        return new ButtonView();
    }

    public static LabelView label(String id) {
        return createWithId(id, new LabelView());
    }

    public static LabelView label() {
        return new LabelView();
    }


    public static MenuBarView menuBar(MenuView... menus) {
        return new MenuBarView(menus);
    }

    public static MenuView menu(String text, MenuItemView... menuItems) {
        return new MenuView(menuItems).text(text);
    }

    public static MenuItemView menuItem(String text) {
        return new MenuItemView().text(text);
    }

}
