package org.fluentness.controller.web.text;

import org.fluentness.controller.web.WebView;

public class RawView extends WebView {
    private String raw;

    public RawView(String raw) {
        this.raw = raw;
    }

    @Override
    public String render() {
        return raw;
    }
}
