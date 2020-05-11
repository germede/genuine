package org.fluentness.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.fluentness.controller.android.AndroidView;

public abstract class AbstractMobile implements ViewHolder<MobileView> {

    public static Context context;

    protected static MobileView activity(View rootView) {
        Activity activity = new Activity();
        return new AndroidView(activity);
    }

    protected static LinearLayout linearLayout(View... views) {
        LinearLayout linearLayout = new LinearLayout(context);
        for (View view : views) {
            linearLayout.addView(view);
        }
        return linearLayout;
    }

    protected static TextView text(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        return textView;
    }
}
