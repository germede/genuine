package org.fluentness.controller.desktop.style;

import javax.swing.*;

public final class StyleFactory {

    public static Style style(LookAndFeel lookAndFeel) {
        return new Style(lookAndFeel);
    }

    public static Style ubuntuStyle() {
        return new UbuntuStyle();
    }

}
