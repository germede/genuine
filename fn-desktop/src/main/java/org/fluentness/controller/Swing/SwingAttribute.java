package org.fluentness.controller.Swing;

public enum SwingAttribute {
    ID,
    CLASS;

    public static final String PREFIX = "###";

    private final String toString = PREFIX + name() + "=";

    @Override
    public String toString() {
        return toString;
    }
}
