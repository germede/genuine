package org.fluentness.view.component;


import android.content.Context;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(Context context, CharSequence text) {
        super(context);
        setText(text);
    }

}
