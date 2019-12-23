package org.fluentness.view.desktop.style;

import javax.swing.*;
import java.awt.*;

public final class DesktopStyleFactory {

    public static DesktopStyle style(LookAndFeel lookAndFeel, Style... styles) {
        return new DesktopStyle(lookAndFeel, styles);
    }

    public static DesktopStyle ubuntuStyle(Style... extraStyles) {
        return new UbuntuDesktopStyle(extraStyles);
    }

    public static <T extends Container> Style byClass(Class<T> swingClass, DesktopStyleLambda<T> styleLambda) {
        return new Style(swingClass, styleLambda);
    }
}
