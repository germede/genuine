package org.fluentness.controller.desktop;

@FunctionalInterface
public interface DesktopStyle<V extends DesktopView> {
    void style(V desktopView);
}
