package org.fluentness.view.component.text;


import org.fluentness.MobileApplication;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(MobileApplication.context);
        setText(text);
    }

    @Override
    public Type getType() {
        return null;
    }

}
