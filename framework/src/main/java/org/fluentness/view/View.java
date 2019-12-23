package org.fluentness.view;

import org.fluentness.ApplicationComponent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public interface View extends ApplicationComponent {

    static Map<String, Container> register = new HashMap<>();

    public static <View extends Container> View getByName(Class<View> viewClass, String name) {
        return (View) register.get(name);
    }

}
