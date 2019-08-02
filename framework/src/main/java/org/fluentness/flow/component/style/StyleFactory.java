package org.fluentness.flow.component.style;

public final class StyleFactory {

    private StyleFactory() {

    }

    public static Style css(CssSelector... selectors) {
        return new CssStyle(selectors);
    }

    public static CssSelector select(String selector, String... rules) {
        return new CssSelector(selector, rules);
    }

    public static Style external(String path) {
        return new ExternalStyle(path);
    }

    public static Style merge(Style... styles) {
        return new MergeStyle(styles);
    }
}
