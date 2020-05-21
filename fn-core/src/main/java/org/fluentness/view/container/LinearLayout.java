package org.fluentness.view.container;

import org.fluentness.view.style.Paddingable;

public interface LinearLayout extends Container, Paddingable {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    int getOrientation();

}
