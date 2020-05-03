package org.fluentness.controller.mobile.template.android;

import android.view.View;
import org.fluentness.controller.mobile.template.MobileTemplate;

public class Android<V extends View> implements MobileTemplate {

    private final V view;

    public Android(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    @Override
    public void render() {
        view.setVisibility(View.VISIBLE);
    }
}
