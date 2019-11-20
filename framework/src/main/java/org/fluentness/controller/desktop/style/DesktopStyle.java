package org.fluentness.controller.desktop.style;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DesktopStyle {

    private Map<Class, DesktopStyleLambda> styleMap = new HashMap<>();

    DesktopStyle(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public <View> DesktopStyle set(Class<View> desktopViewClass, DesktopStyleLambda<View> desktopStyleLambda) {
        styleMap.put(desktopViewClass, desktopStyleLambda);
        return this;
    }

    public Map<Class, DesktopStyleLambda> getStyleMap() {
        return styleMap;
    }

}
