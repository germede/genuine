package org.fluentness.controller.desktop.template.swing;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class Swing<V extends Container> implements CharSequence {


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }

    private V actualSwing;

    Swing(V actualSwing, CharSequence... swings) {
        this.actualSwing = actualSwing;
        handleSwings(swings);
    }

    private void handleSwings(CharSequence[] swings) {
        for (CharSequence swing : swings) {
            if (swing instanceof Swing) {
                this.actualSwing.add(((Swing) swing).getActualSwing());
            } else if (swing instanceof String) {
                handleString((String) swing);
            }
        }
    }

    private void handleString(String string) {
        if (string.startsWith(SwingAttribute.PREFIX)) {
            handleAttribute(string);
        } else {
            handleNormalText(string);
        }
    }

    private void handleAttribute(String string) {
        SwingAttribute attribute = SwingAttribute.valueOf(string.replace("###",""));
        switch (attribute) {
            case ID:
        }
    }

    private void handleNormalText(String string) {
        if (JLabel.class.equals(actualSwing.getClass())) {
            ((JLabel) actualSwing).setText(string);
        }
    }

    public V getActualSwing() {
        return actualSwing;
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
