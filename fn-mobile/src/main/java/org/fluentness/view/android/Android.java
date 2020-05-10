package org.fluentness.view.android;

import android.view.View;
import org.fluentness.view.MobileTemplate;

public class Android<V extends View> implements MobileTemplate {

    private final V view;

    public Android(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

}
