package org.fluentness.controller.desktop;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DesktopStyle {

    private Map<Class, DesktopStyleLambda> styleMap = new HashMap<>();

    DesktopStyle() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

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

    Map<Class, DesktopStyleLambda> getStyleMap() {
        return styleMap;
    }

}
