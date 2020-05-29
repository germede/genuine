package org.fluentness.view.component.container;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;

import javax.swing.*;

public class SwingLinearLayout extends JPanel implements LinearLayout {

    private final BoxLayout layoutManager;

    public SwingLinearLayout(int orientation, Component[] components) {
        setLayout(layoutManager = new BoxLayout(this, orientation));
        for (Component component : components) {
            add(component);
        }
    }

    @Override
    public int getOrientation() {
        return layoutManager.getAxis();
    }

    @Override
    public void add(Component component) {
        add((java.awt.Container)component);
    }

    @Override
    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    }
}
