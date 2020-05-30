package org.fluentness.view.component.layout;

import android.view.View;
import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Component;

public class AndroidLinearLayout extends android.widget.LinearLayout implements LinearLayout {

    public AndroidLinearLayout(int orientation, Component[] components) {
        super(AbstractMobileView.context);
        setOrientation(orientation);
        for (Component component : components) {
            add(component);
        }
    }

    public void add(Component component) {
        addView((View) component);
    }

    @Override
    public void setPadding(int top, int left, int bottom, int right) {
        super.setPadding(left, top, right, bottom);
    }

    @Override
    public void add(Object child) {

    }
}
