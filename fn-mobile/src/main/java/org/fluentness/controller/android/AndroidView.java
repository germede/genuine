package org.fluentness.controller.android;

import android.view.View;
import org.fluentness.controller.RootMobileView;

public class AndroidView<V extends View> implements RootMobileView {

    private final V view;

    public AndroidView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

}
