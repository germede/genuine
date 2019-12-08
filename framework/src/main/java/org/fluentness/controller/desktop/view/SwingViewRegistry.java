package org.fluentness.controller.desktop.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class SwingViewRegistry {
    private static Map<String, Container> register = new HashMap<>();

    public static <View extends Container> View getByName(Class<View> viewClass, String name) {
        return (View) register.get(name);
    }

    static <View extends Container> void add(String name, View swingView) {
        register.put(name, swingView);
    }
}
