package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;

public interface LinearLayout extends Component {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    int getOrientation();

    void setPadding(int top, int left, int bottom, int right);

    void appendChild(Component child);

}
