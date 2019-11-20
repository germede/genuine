package org.fluentness.controller.desktop;

import java.util.Map;

public abstract class DesktopView<View> {

    private static Map<Class, DesktopStyleLambda> styleMap;

    public static void setGlobalStyle(DesktopStyle style) {
        DesktopView.styleMap = style.getStyleMap();
    }

    protected DesktopView(View view) {
        // Apply global styles
        if (styleMap != null && styleMap.containsKey(view.getClass())) {
            styleMap.get(view.getClass()).style(view);
        }
    }

    public abstract void render();
}
