package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.style.DesktopStyle;
import org.fluentness.controller.desktop.style.DesktopStyleLambda;

import java.util.Map;

public abstract class DesktopView {

    private static Map<Class, DesktopStyleLambda> styleMap;

    public static void setGlobalStyle(DesktopStyle desktopStyle) {
        DesktopView.styleMap = desktopStyle.getStyleMap();
    }

    protected DesktopView(Object view) {
        // Apply global styles
        if (styleMap != null) {
            styleMap.entrySet().stream()
                .filter(entry -> entry.getKey().isAssignableFrom(view.getClass()))
                .map(Map.Entry::getValue)
                .forEach(desktopStyleLambda -> desktopStyleLambda.style(view));
        }
    }

    public abstract void render();
}
