package org.fluentness.view.component.dialog;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlDialog extends HtmlContainer implements Dialog {

    public HtmlDialog(HtmlComponent[] inner) {
        super("div");
        withAttribute("class", "modal");
        withInner(inner);
    }

}
