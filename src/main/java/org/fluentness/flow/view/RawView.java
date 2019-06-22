package org.fluentness.flow.view;

public class RawView extends View {
    private String raw;

    public RawView(String raw) {
        this.raw = raw;
    }

    @Override
    public String render() {
        return raw;
    }

    @Override
    View setTemplate(View view) {
        return null;
    }
}
