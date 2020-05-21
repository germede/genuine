package org.fluentness.view.container;

import org.fluentness.view.style.Bordeable;

public interface LinearLayout extends Container, Bordeable {

    enum Orientation {
        VERTICAL,
        HORIZONTAL;
    }

    Orientation getOrientation();

}
