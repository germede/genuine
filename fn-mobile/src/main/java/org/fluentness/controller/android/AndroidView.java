package org.fluentness.controller.android;

import android.view.View;
import org.fluentness.controller.MobileView;

public class AndroidView implements MobileView {

    private final View view;

    public AndroidView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

}
