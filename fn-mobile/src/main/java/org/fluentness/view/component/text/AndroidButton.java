package org.fluentness.view.component.text;


import org.fluentness.view.FluentnessActivity;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(FluentnessActivity.context);
        setText(text);
    }

}
