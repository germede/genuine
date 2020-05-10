package org.fluentness.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.fluentness.view.android.AndroidView;

public abstract class AbstractMobileView implements View {

    public static Context context;

    protected static AndroidView linearLayout(AndroidView... inner) {
        LinearLayout linearLayout = new LinearLayout(context);
        for (AndroidView androidView : inner) {
            linearLayout.addView(androidView.getView());
        }
        return new AndroidView(linearLayout);
    }

    protected static AndroidView text(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        return new AndroidView(textView);
    }

    private final RootMobileView rootMobileView;

    public AbstractMobileView(RootMobileView rootMobileView) {
        this.rootMobileView = rootMobileView;
    }

    public RootMobileView getRootMobileView() {
        return rootMobileView;
    }
}
