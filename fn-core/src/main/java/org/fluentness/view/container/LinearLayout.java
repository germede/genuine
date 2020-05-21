package org.fluentness.view.container;

import org.fluentness.view.style.Bordeable;

public interface LinearLayout extends Container, Bordeable {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    int getOrientation();

}
