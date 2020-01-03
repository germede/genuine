package org.fluentness.controller.desktop.style.property;

@FunctionalInterface
public interface PropertyLambda<View> {
    void style(View view);
}
