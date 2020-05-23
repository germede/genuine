package org.fluentness.view.component;


import android.content.Context;
import org.fluentness.controller.event.OnClickEvent;

public class AndroidButton extends android.widget.Button implements Button {

    public AndroidButton(Context context, CharSequence text) {
        super(context);
        setText(text);
    }

    @Override
    public void onClick(OnClickEvent<Button> onClickEvent) {
        setOnClickListener(view -> onClickEvent.handle(this));
    }
}
