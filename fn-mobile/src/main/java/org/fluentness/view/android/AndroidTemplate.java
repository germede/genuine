package org.fluentness.view.android;

import android.view.View;
import org.fluentness.view.MobileTemplate;

public class AndroidTemplate implements MobileTemplate {

    private final View view;

    public AndroidTemplate(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

}
