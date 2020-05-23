package org.fluentness.view;

import org.fluentness.view.component.HtmlButton;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.container.HtmlContainer;
import org.fluentness.view.container.HtmlLinearLayout;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractWebView extends AbstractView<
    HtmlComponent,
    HtmlContainer,
    HtmlButton,
    HtmlLinearLayout
    > {

    private final HtmlContainer html;
    private String renderedHtml;

    public AbstractWebView(HtmlComponent... headComponents) {
        this.html = new HtmlContainer("html",
            new HtmlContainer("head", headComponents),
            new HtmlContainer("body", structure())
        );
    }

    public String getHtml() {
        if (renderedHtml == null) {
            renderedHtml = "<!DOCTYPE html>" + html.toString();
        }
        return renderedHtml;
    }

    @Override
    protected HtmlButton button(CharSequence text) {
        return new HtmlButton(text);
    }

    @Override
    protected HtmlLinearLayout linearLayout(int orientation, HtmlComponent... components) {
        return new HtmlLinearLayout(orientation, components);
    }

    protected static HtmlComponent title(CharSequence text) {
        return new HtmlContainer("title", text);
    }

    protected static HtmlComponent base(String... attributes) {
        return new HtmlComponent("base", attributes);
    }

    protected static HtmlComponent link(String... attributes) {
        return new HtmlComponent("link", attributes);
    }

    protected static HtmlComponent meta(String... attributes) {
        return new HtmlComponent("meta", attributes);
    }

    protected static HtmlComponent noscript(String... attributes) {
        return new HtmlComponent("noscript", attributes);
    }

    protected static HtmlComponent script(String... attributes) {
        return new HtmlContainer("script", attributes);
    }

    protected static HtmlComponent style(String... attributes) {
        return new HtmlComponent("style", attributes);
    }

    protected static HtmlComponent template(String... attributes) {
        return new HtmlComponent("template", attributes);
    }

    public static final String ACTION_RESULT = "###ACTION_RESULT###";

    public static <T, V extends CharSequence> CharSequence forEach(Iterable<T> iterable, Function<T, V> function) {
        List<String> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t).toString());
        }
        return String.join("", result);
    }

    public static <T, V extends CharSequence> CharSequence forEach(T[] iterable, Function<T, V> function) {
        List<String> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t).toString());
        }
        return String.join("", result);
    }

    public static HtmlContainer a(CharSequence... html) {
        return new HtmlContainer("a", html);
    }

    public static HtmlContainer abbr(CharSequence... html) {
        return new HtmlContainer("abbr", html);
    }

    public static HtmlContainer acronym(CharSequence... html) {
        return new HtmlContainer("acronym", html);
    }

    public static HtmlContainer address(CharSequence... html) {
        return new HtmlContainer("address", html);
    }

    public static HtmlContainer applet(CharSequence... html) {
        return new HtmlContainer("applet", html);
    }

    public static HtmlContainer article(CharSequence... html) {
        return new HtmlContainer("article", html);
    }

    public static HtmlContainer aside(CharSequence... html) {
        return new HtmlContainer("aside", html);
    }

    public static HtmlContainer audio(CharSequence... html) {
        return new HtmlContainer("audio", html);
    }

    public static HtmlContainer b(CharSequence... html) {
        return new HtmlContainer("b", html);
    }

    public static HtmlContainer basefont(CharSequence... html) {
        return new HtmlContainer("basefont", html);
    }

    public static HtmlContainer bdi(CharSequence... html) {
        return new HtmlContainer("bdi", html);
    }

    public static HtmlContainer bdo(CharSequence... html) {
        return new HtmlContainer("bdo", html);
    }

    public static HtmlContainer big(CharSequence... html) {
        return new HtmlContainer("big", html);
    }

    public static HtmlContainer blockquote(CharSequence... html) {
        return new HtmlContainer("blockquote", html);
    }

    public static HtmlContainer body(CharSequence... html) {
        return new HtmlContainer("body", html);
    }

    public static HtmlContainer canvas(CharSequence... html) {
        return new HtmlContainer("canvas", html);
    }

    public static HtmlContainer caption(CharSequence... html) {
        return new HtmlContainer("caption", html);
    }

    public static HtmlContainer center(CharSequence... html) {
        return new HtmlContainer("center", html);
    }

    public static HtmlContainer cite(CharSequence... html) {
        return new HtmlContainer("cite", html);
    }

    public static HtmlContainer code(CharSequence... html) {
        return new HtmlContainer("code", html);
    }

    public static HtmlContainer colgroup(CharSequence... html) {
        return new HtmlContainer("colgroup", html);
    }

    public static HtmlContainer data(CharSequence... html) {
        return new HtmlContainer("data", html);
    }

    public static HtmlContainer datalist(CharSequence... html) {
        return new HtmlContainer("datalist", html);
    }

    public static HtmlContainer dd(CharSequence... html) {
        return new HtmlContainer("dd", html);
    }

    public static HtmlContainer del(CharSequence... html) {
        return new HtmlContainer("del", html);
    }

    public static HtmlContainer details(CharSequence... html) {
        return new HtmlContainer("details", html);
    }

    public static HtmlContainer dfn(CharSequence... html) {
        return new HtmlContainer("dfn", html);
    }

    public static HtmlContainer dialog(CharSequence... html) {
        return new HtmlContainer("dialog", html);
    }

    public static HtmlContainer dir(CharSequence... html) {
        return new HtmlContainer("dir", html);
    }

    public static HtmlContainer div(CharSequence... html) {
        return new HtmlContainer("div", html);
    }

}
