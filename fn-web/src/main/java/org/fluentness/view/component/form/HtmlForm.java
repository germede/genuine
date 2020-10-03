package org.fluentness.view.component.form;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlForm extends HtmlContainer implements Form {

    public HtmlForm(HtmlComponent[] inner) {
        super("form");
        withInner(inner);
    }

}
