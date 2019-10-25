package org.fluentness.flow.web.text;

import org.fluentness.flow.View;

public class RawView extends View {
    private String raw;

    public RawView(String raw) {
        this.raw = raw;
    }

    @Override
    public String render() {
        return raw;
    }
}
