package org.fluentness.controller.android;

import android.app.Activity;
import org.fluentness.controller.MobileView;

public class AndroidView implements MobileView {

    private final Activity activity;

    public AndroidView(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

}
