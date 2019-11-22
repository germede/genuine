package org.fluentness.controller.desktop.style;

import java.awt.*;

public class Style<T extends Container> {
    public Style(Class<T> swingClass, DesktopStyleLambda<T> styleLambda) {

    }

    public Style(String name, DesktopStyleLambda<T> styleLambda) {

    }
}
