package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.style.DesktopStyle;
import org.fluentness.controller.desktop.style.Style;

import java.util.List;

public abstract class DesktopView {

    private static List<Style> styleMap;

    public static void setGlobalStyle(DesktopStyle desktopStyle) {
        DesktopView.styleMap = desktopStyle.getStyles();
    }

    protected DesktopView(Object view) {
        // Apply global styles
        if (styleMap != null) {
            styleMap.stream()
                .filter(entry -> entry.getSwingClass().isAssignableFrom(view.getClass()))
                .map(entry -> entry.getStyleLambda())
                .forEach(desktopStyleLambda -> desktopStyleLambda.style(view));
        }
    }

    public abstract void render();
}
