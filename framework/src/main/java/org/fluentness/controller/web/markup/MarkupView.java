package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

public interface MarkupView extends WebView {
    MarkupView attr(String key, String value);
}
