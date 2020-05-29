package org.fluentness.view.component.layout;

public interface LinearLayout<C> extends Layout<C> {

    int HORIZONTAL = 0;
    int VERTICAL = 1;

    int getOrientation();

    void setPadding(int top, int left, int bottom, int right);

}
