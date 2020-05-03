package org.fluentness.controller.mobile.android;

import android.view.View;
import org.fluentness.controller.mobile.MobileTemplate;

public class Android<V extends View> implements MobileTemplate {

    private final V view;

    public Android(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

}
