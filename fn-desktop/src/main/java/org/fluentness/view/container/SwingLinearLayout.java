package org.fluentness.view.container;

import org.fluentness.view.component.Component;

import javax.swing.*;

public class SwingLinearLayout extends JPanel implements LinearLayout{

    private BoxLayout layoutManager;

    public SwingLinearLayout(Component[] components) {
        setLayout(layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Component component : components) {
            add(component);
        }
    }

    @Override
    public Orientation getOrientation() {
        return layoutManager.getAxis() == BoxLayout.Y_AXIS ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    @Override
    public void add(Component component) {
        add((java.awt.Container)component);
    }

    @Override
    public void add(Container container) {
        add((java.awt.Container)container);
    }

    @Override
    public void addBorder(int top, int left, int bottom, int right) {
        setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    }
}
