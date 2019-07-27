package org.fluentness.flow.component.style;

import java.util.Arrays;

public class BundleStyle extends Style {

    private Style[] styles;

    BundleStyle(Style[] styles) {
        this.styles = styles;
    }

    @Override
    public String render() {
        return Arrays.stream(styles).map(Style::render).reduce("", String::concat);
    }
}
