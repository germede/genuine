package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.style.Style;
import org.fluentness.controller.desktop.style.StyleLambda;

import java.util.Map;

public abstract class DesktopView<View> {

    private static Map<Class, StyleLambda> styleMap;

    public static void setGlobalStyle(Style style) {
        DesktopView.styleMap = style.getStyleMap();
    }

    protected DesktopView(View view) {
        // Apply global styles
        if (styleMap != null) {
            styleMap.entrySet().stream()
                .filter(entry -> entry.getKey().isAssignableFrom(view.getClass()))
                .map(Map.Entry::getValue)
                .forEach(styleLambda -> styleLambda.style(view));
        }
    }

    public abstract void render();
}
