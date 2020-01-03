package org.fluentness.controller.desktop.template.swing;

public enum SwingAttribute {
    ID,
    CLASS;

    public static final String PREFIX = "###";

    private final String toString = PREFIX + toString();

    @Override
    public String toString() {
        return toString;
    }
}
