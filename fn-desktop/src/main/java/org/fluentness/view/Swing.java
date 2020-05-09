package org.fluentness.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Swing<V extends Container> implements Template {

    private static final Map<String, Swing> ID_MAP = new HashMap<>();
    private static final Map<String, List<Swing>> CLASS_MAP = new HashMap<>();

    public static Swing getById(String id) {
        return ID_MAP.get(id);
    }

    public static List<Swing> getByClass(String clazz) {
        return CLASS_MAP.get(clazz);
    }

    protected V view;

    Swing(V view, CharSequence... swings) {
        this.view = view;
        handleSwings(swings);
    }

    private void handleSwings(CharSequence[] swings) {
        for (CharSequence swing : swings) {
            if (swing instanceof Swing) {
                this.view.add(((Swing) swing).getView());
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
        SwingAttribute key = SwingAttribute.valueOf(string.split("=")[0].replace(SwingAttribute.PREFIX, ""));
        String value = string.split("=")[1];

        switch (key) {
            case ID:
                ID_MAP.put(value, this);
                break;
            case CLASS:
                for (String clazz : value.split(" ")) {
                    List<Swing> list = CLASS_MAP.containsKey(clazz) ? CLASS_MAP.get(clazz) : new LinkedList<>();
                    list.add(this);
                    CLASS_MAP.put(clazz, list);
                }
                break;
        }
    }

    private void handleNormalText(String string) {
        if (JLabel.class.equals(view.getClass())) {
            ((JLabel) view).setText(string);
        }
    }

    public V getView() {
        return view;
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
