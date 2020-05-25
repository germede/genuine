package org.fluentness.view.component.container;

import org.fluentness.view.component.Component;

public interface LinearLayout<C extends Component> extends Container<C> {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    int getOrientation();

    void setPadding(int top, int left, int bottom, int right);
}
