package org.fluentness.controller.desktop.style;

@FunctionalInterface
public interface StyleLambda<View> {
    void style(View view);
}
