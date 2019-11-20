package org.fluentness.controller.desktop;

import javax.swing.*;

public final class DesktopStyleFactory {

    public static DesktopStyle style() {
        return new DesktopStyle();
    }

    public static DesktopStyle style(LookAndFeel lookAndFeel) {
        return new DesktopStyle(lookAndFeel);
    }

}
