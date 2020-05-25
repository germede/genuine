package org.fluentness.view;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.container.HtmlContainer;

public class HtmlHeadChildFactory {

    private HtmlHeadChildFactory() {

    }

    public static HtmlComponent title(CharSequence text) {
        return new HtmlContainer("title", text);
    }

    public static HtmlComponent base(String... attributes) {
        return new HtmlComponent("base", attributes);
    }

    public static HtmlComponent link(String... attributes) {
        return new HtmlComponent("link", attributes);
    }

    public static HtmlComponent meta(String... attributes) {
        return new HtmlComponent("meta", attributes);
    }

    public static HtmlComponent noscript(String... attributes) {
        return new HtmlComponent("noscript", attributes);
    }

    public static HtmlComponent script(String... attributes) {
        return new HtmlContainer("script", attributes);
    }

    public static HtmlComponent style(String... attributes) {
        return new HtmlComponent("style", attributes);
    }

    public static HtmlComponent template(String... attributes) {
        return new HtmlComponent("template", attributes);
    }
}
