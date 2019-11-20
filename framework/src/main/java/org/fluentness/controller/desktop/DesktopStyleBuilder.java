package org.fluentness.controller.desktop;

import java.util.Map;

public class DesktopStyleBuilder {

    private Map<Class<? extends DesktopView>, DesktopStyle<? extends DesktopView>> styleMap;

    public <V extends DesktopView> DesktopStyleBuilder set(Class<V> desktopViewClass, DesktopStyle<V> desktopStyle) {
        styleMap.put(desktopViewClass, desktopStyle);
        return this;
    }

    public Map<Class<? extends DesktopView>, DesktopStyle<? extends DesktopView>> getStyleMap() {
        return styleMap;
    }

}
