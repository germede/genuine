package org.fluentness.view.container;

import android.content.Context;
import android.view.View;
import org.fluentness.view.component.Component;

public class AndroidLinearLayout extends android.widget.LinearLayout implements LinearLayout {

    public AndroidLinearLayout(Context context, Component[] components) {
        super(context);
        for (Component component : components) {
            add(component);
        }
    }

    @Override
    public void add(Component component) {
        addView((View) component);
    }

    @Override
    public void padding(int top, int left, int bottom, int right) {
        setPadding(left, top, right, bottom);
    }
}
