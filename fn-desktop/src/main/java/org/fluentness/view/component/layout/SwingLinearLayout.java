package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;

import javax.swing.*;
import java.awt.*;

public class SwingLinearLayout extends JPanel implements LinearLayout {

    private final BoxLayout layoutManager;

    public SwingLinearLayout(int orientation, Component[] components) {
        setLayout(layoutManager = new BoxLayout(this, orientation));
        for (Component component : components) {
            add((Container) component);
        }
    }

    @Override
    public int getOrientation() {
        return layoutManager.getAxis();
    }

    @Override
    public void appendChild(Component child) {
        super.add((java.awt.Component) child);
    }

    @Override
    public void setPadding(int top, int left, int bottom, int right) {
        setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    }
}
