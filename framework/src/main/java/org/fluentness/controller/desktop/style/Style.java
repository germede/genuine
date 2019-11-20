package org.fluentness.controller.desktop.style;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Style {

    private Map<Class, StyleLambda> styleMap = new HashMap<>();

    Style(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public <View> Style set(Class<View> desktopViewClass, StyleLambda<View> styleLambda) {
        styleMap.put(desktopViewClass, styleLambda);
        return this;
    }

    public Map<Class, StyleLambda> getStyleMap() {
        return styleMap;
    }

}
