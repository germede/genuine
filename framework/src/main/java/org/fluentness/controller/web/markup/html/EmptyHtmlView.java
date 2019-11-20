package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.AttributeMarkupView;
import org.fluentness.controller.web.markup.EmptyMarkupView;

public class EmptyHtmlView extends EmptyMarkupView implements HtmlView {

    public EmptyHtmlView(String tag, AttributeMarkupView[] attributes) {
        super(tag, attributes);
    }

}
