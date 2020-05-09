package org.fluentness.view;

import android.view.View;

public class Android<V extends View> implements MobileTemplate {

    private final V view;

    public Android(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

}
