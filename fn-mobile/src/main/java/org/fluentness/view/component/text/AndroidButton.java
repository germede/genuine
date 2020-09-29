package org.fluentness.view.component.text;


import org.fluentness.application.AbstractMobileApplication;
import org.fluentness.view.component.text.form.Button;
import org.fluentness.view.event.Handler;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(CharSequence text) {
        super(AbstractMobileApplication.context);
        setText(text);
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void onClick(Handler handler) {

    }
}
