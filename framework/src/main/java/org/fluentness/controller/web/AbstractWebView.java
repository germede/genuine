package org.fluentness.controller.web;

import org.fluentness.controller.View;
import org.fluentness.controller.web.template.WebTemplate;

public abstract class AbstractWebView implements View {

    public abstract WebTemplate getTemplate(CharSequence actionResult);
}
