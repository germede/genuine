package org.fluentness.controller.desktop.template.swing;

import org.fluentness.controller.desktop.template.DesktopTemplate;

import java.awt.*;

public class Swing<V extends Container> implements DesktopTemplate {

    private V actualSwing;

    Swing(V actualSwing) {
        this.actualSwing = actualSwing;
    }

    public V getActualSwing() {
        return actualSwing;
    }

    @Override
    public void render() {
        actualSwing.setVisible(true);
    }

    // ==== instead of layout()
//    public Self borderLayout(String... arrangements) {
//        view.setLayout(new BorderLayout());
//        Component[] components = view.getComponents();
//        view.removeAll();
//        for (int i = 0; i < components.length && i < arrangements.length; i++) {
//            view.add(components[i], arrangements[i]);
//        }
//        return (Self) this;
//    }
//
//    public Self boxLayout(int align) {
//        view.setLayout(new BoxLayout(view, align));
//        Component[] components = view.getComponents();
//        view.removeAll();
//        for (Component component : components) {
//            view.add(component, Component.CENTER_ALIGNMENT);
//        }
//        return (Self) this;
//    }
//
//    public Self flowLayout() {
//        view.setLayout(new FlowLayout());
//        return (Self) this;
//    }

}
