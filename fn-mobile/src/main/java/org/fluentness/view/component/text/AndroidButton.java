package org.fluentness.view.component.text;


import org.fluentness.view.AbstractMobileView;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(AbstractMobileView.context);
        setText(text);
    }

}
