package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.Map;

public interface MarkupView extends WebView {

    // fluent method
    MarkupView attr(String key, String value);

    String getTag();

    Map<String, String> getAttributes();

}
