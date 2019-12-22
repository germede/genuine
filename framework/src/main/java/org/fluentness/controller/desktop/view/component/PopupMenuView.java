package org.fluentness.controller.desktop.view.component;

import org.fluentness.controller.desktop.view.component.button.menu.AbstractMenuItemView;

import javax.swing.*;
import javax.swing.plaf.PopupMenuUI;
import java.awt.*;

public class PopupMenuView extends AbstractComponentView<PopupMenuView, JPopupMenu> {

    public PopupMenuView(AbstractMenuItemView... menuItems) {
        super(new JPopupMenu());
        for (AbstractMenuItemView menuItem : menuItems) {
            view.add(menuItem.getView());
        }
    }

    public PopupMenuView borderPainted(boolean b) {
        view.setBorderPainted(b);
        return this;
    }

    public PopupMenuView invoker(Component invoker) {
        view.setInvoker(invoker);
        return this;
    }

    public PopupMenuView label(String label) {
        view.setLabel(label);
        return this;
    }

    public PopupMenuView lightWeightPopupEnabled(boolean aFlag) {
        view.setLightWeightPopupEnabled(aFlag);
        return this;
    }

    public PopupMenuView popupSize(int width, int height) {
        view.setPopupSize(width, height);
        return this;
    }

    public PopupMenuView selected(Component sel) {
        view.setSelected(sel);
        return this;
    }

    public PopupMenuView uI(PopupMenuUI ui) {
        view.setUI(ui);
        return this;
    }
}
