package org.fluentness.controller.html;

import org.fluentness.controller.AbstractWebController;

public class HtmlAction extends HtmlContainer {

    public HtmlAction(String actionName, CharSequence[] html) {
        super("a", html);
        attributes.append(" href=\"").append(AbstractWebController.methodPathMap.get(actionName)).append("\"");
    }
}
