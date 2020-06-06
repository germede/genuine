package org.fluentness.view.component.text;


import org.fluentness.AbstractMobile;
import org.fluentness.view.component.text.form.Button;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(AbstractMobile.context);
        setText(text);
    }

}
