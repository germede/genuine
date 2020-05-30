package org.fluentness.view.component.text;


import org.fluentness.AbstractMobile;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(AbstractMobile.context);
        setText(text);
    }

}
