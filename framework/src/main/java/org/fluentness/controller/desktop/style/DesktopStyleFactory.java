package org.fluentness.controller.desktop.style;

import javax.swing.*;

public final class DesktopStyleFactory {

    public static DesktopStyle style(LookAndFeel lookAndFeel) {
        return new DesktopStyle(lookAndFeel);
    }

    public static DesktopStyle ubuntuStyle() {
        return new UbuntuDesktopStyle();
    }

}
