package org.fluentness.controller.web;

import org.fluentness.controller.View;
import org.fluentness.controller.web.template.WebTemplate;

public interface WebView extends View {

    WebTemplate getTemplate(CharSequence actionResult);
}
