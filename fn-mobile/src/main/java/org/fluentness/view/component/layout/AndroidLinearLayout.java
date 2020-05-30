package org.fluentness.view.component.layout;

import android.view.View;
import org.fluentness.AbstractMobile;
import org.fluentness.view.component.Component;

public class AndroidLinearLayout extends android.widget.LinearLayout implements LinearLayout {

    public AndroidLinearLayout(Component[] components) {
        super(AbstractMobile.context);
        setOrientation(android.widget.LinearLayout.VERTICAL);
        for (Component component : components) {
            appendChild(component);
        }
    }

    @Override
    public void appendChild(Component child) {
        addView((View) child);
    }

    @Override
    public void setPadding(int top, int left, int bottom, int right) {
        super.setPadding(left, top, right, bottom);
    }

}
