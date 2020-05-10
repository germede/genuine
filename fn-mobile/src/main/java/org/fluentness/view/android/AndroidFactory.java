package org.fluentness.view.android;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class AndroidFactory {

    public static Context context;

    public static Android linearLayout(Android... inner) {
        LinearLayout linearLayout = new LinearLayout(context);
        for (Android android : inner) {
            linearLayout.addView(android.getView());
        }
        return new Android(linearLayout);
    }

    public static Android text(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        return new Android(textView);
    }

    private AndroidFactory() {
    }
}
