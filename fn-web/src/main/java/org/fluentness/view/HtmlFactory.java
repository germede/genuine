package org.fluentness.view;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.container.HtmlContainer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class HtmlFactory {
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

    public static HtmlComponent area(String... attributes) {
        return new HtmlComponent("area", attributes);
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

    public static HtmlComponent base(String... attributes) {
        return new HtmlComponent("base", attributes);
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

    public static HtmlComponent br(String... attributes) {
        return new HtmlComponent("br", attributes);
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

    public static HtmlComponent col(String... attributes) {
        return new HtmlComponent("col", attributes);
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

    public static HtmlContainer dl(CharSequence... html) {
        return new HtmlContainer("dl", html);
    }

    public static HtmlContainer dt(CharSequence... html) {
        return new HtmlContainer("dt", html);
    }

    public static HtmlContainer em(CharSequence... html) {
        return new HtmlContainer("em", html);
    }

    public static HtmlComponent embed(String... attributes) {
        return new HtmlComponent("embed", attributes);
    }

    public static HtmlContainer fieldset(CharSequence... html) {
        return new HtmlContainer("fieldset", html);
    }

    public static HtmlContainer figcaption(CharSequence... html) {
        return new HtmlContainer("figcaption", html);
    }

    public static HtmlContainer figure(CharSequence... html) {
        return new HtmlContainer("figure", html);
    }

    public static HtmlContainer font(CharSequence... html) {
        return new HtmlContainer("font", html);
    }

    public static HtmlContainer footer(CharSequence... html) {
        return new HtmlContainer("footer", html);
    }

    public static HtmlContainer form(CharSequence... html) {
        return new HtmlContainer("form", html);
    }

    public static HtmlContainer frame(CharSequence... html) {
        return new HtmlContainer("frame", html);
    }

    public static HtmlContainer frameset(CharSequence... html) {
        return new HtmlContainer("frameset", html);
    }

    public static HtmlContainer h1(CharSequence... html) {
        return new HtmlContainer("h1", html);
    }

    public static HtmlContainer h2(CharSequence... html) {
        return new HtmlContainer("h2", html);
    }

    public static HtmlContainer h3(CharSequence... html) {
        return new HtmlContainer("h3", html);
    }

    public static HtmlContainer h4(CharSequence... html) {
        return new HtmlContainer("h4", html);
    }

    public static HtmlContainer h5(CharSequence... html) {
        return new HtmlContainer("h5", html);
    }

    public static HtmlContainer h6(CharSequence... html) {
        return new HtmlContainer("h6", html);
    }

    public static HtmlContainer head(CharSequence... html) {
        return new HtmlContainer("head", html);
    }

    public static HtmlContainer header(CharSequence... html) {
        return new HtmlContainer("header", html);
    }

    public static HtmlComponent hr(String... attributes) {
        return new HtmlComponent("hr", attributes);
    }

    public static HtmlContainer i(CharSequence... html) {
        return new HtmlContainer("i", html);
    }

    public static HtmlContainer iframe(CharSequence... html) {
        return new HtmlContainer("iframe", html);
    }

    public static HtmlComponent img(String... attributes) {
        return new HtmlComponent("img", attributes);
    }

    public static HtmlComponent input(String... attributes) {
        return new HtmlComponent("input", attributes);
    }

    public static HtmlContainer ins(CharSequence... html) {
        return new HtmlContainer("ins", html);
    }

    public static HtmlContainer kbd(CharSequence... html) {
        return new HtmlContainer("kbd", html);
    }

    public static HtmlContainer label(CharSequence... html) {
        return new HtmlContainer("label", html);
    }

    public static HtmlContainer legend(CharSequence... html) {
        return new HtmlContainer("legend", html);
    }

    public static HtmlContainer li(CharSequence... html) {
        return new HtmlContainer("li", html);
    }

    public static HtmlComponent link(String... attributes) {
        return new HtmlComponent("link", attributes);
    }

    public static HtmlContainer main(CharSequence... html) {
        return new HtmlContainer("main", html);
    }

    public static HtmlContainer map(CharSequence... html) {
        return new HtmlContainer("map", html);
    }

    public static HtmlContainer mark(CharSequence... html) {
        return new HtmlContainer("mark", html);
    }

    public static HtmlComponent meta(String... attributes) {
        return new HtmlComponent("meta", attributes);
    }

    public static HtmlContainer meter(CharSequence... html) {
        return new HtmlContainer("meter", html);
    }

    public static HtmlContainer nav(CharSequence... html) {
        return new HtmlContainer("nav", html);
    }

    public static HtmlContainer noframes(CharSequence... html) {
        return new HtmlContainer("noframes", html);
    }

    public static HtmlComponent noscript(String... attributes) {
        return new HtmlComponent("noscript", attributes);
    }

    public static HtmlContainer object(CharSequence... html) {
        return new HtmlContainer("object", html);
    }

    public static HtmlContainer ol(CharSequence... html) {
        return new HtmlContainer("ol", html);
    }

    public static HtmlContainer optgroup(CharSequence... html) {
        return new HtmlContainer("optgroup", html);
    }

    public static HtmlContainer option(CharSequence... html) {
        return new HtmlContainer("option", html);
    }

    public static HtmlContainer output(CharSequence... html) {
        return new HtmlContainer("output", html);
    }

    public static HtmlContainer p(CharSequence... html) {
        return new HtmlContainer("p", html);
    }

    public static HtmlComponent param(String... attributes) {
        return new HtmlComponent("param", attributes);
    }

    public static HtmlContainer picture(CharSequence... html) {
        return new HtmlContainer("picture", html);
    }

    public static HtmlContainer pre(CharSequence... html) {
        return new HtmlContainer("pre", html);
    }

    public static HtmlContainer progress(CharSequence... html) {
        return new HtmlContainer("progress", html);
    }

    public static HtmlContainer q(CharSequence... html) {
        return new HtmlContainer("q", html);
    }

    public static HtmlContainer rp(CharSequence... html) {
        return new HtmlContainer("rp", html);
    }

    public static HtmlContainer rt(CharSequence... html) {
        return new HtmlContainer("rt", html);
    }

    public static HtmlContainer ruby(CharSequence... html) {
        return new HtmlContainer("ruby", html);
    }

    public static HtmlContainer s(CharSequence... html) {
        return new HtmlContainer("s", html);
    }

    public static HtmlContainer samp(CharSequence... html) {
        return new HtmlContainer("samp", html);
    }

    public static HtmlComponent script(String... attributes) {
        return new HtmlContainer("script", attributes);
    }

    public static HtmlContainer section(CharSequence... html) {
        return new HtmlContainer("section", html);
    }

    public static HtmlContainer select(CharSequence... html) {
        return new HtmlContainer("select", html);
    }

    public static HtmlContainer small(CharSequence... html) {
        return new HtmlContainer("small", html);
    }

    public static HtmlComponent source(String... attributes) {
        return new HtmlComponent("source", attributes);
    }

    public static HtmlContainer span(CharSequence... html) {
        return new HtmlContainer("span", html);
    }

    public static HtmlContainer strike(CharSequence... html) {
        return new HtmlContainer("strike", html);
    }

    public static HtmlContainer strong(CharSequence... html) {
        return new HtmlContainer("strong", html);
    }

    public static HtmlComponent style(String... attributes) {
        return new HtmlComponent("style", attributes);
    }

    public static HtmlContainer sub(CharSequence... html) {
        return new HtmlContainer("sub", html);
    }

    public static HtmlContainer summary(CharSequence... html) {
        return new HtmlContainer("summary", html);
    }

    public static HtmlContainer sup(CharSequence... html) {
        return new HtmlContainer("sup", html);
    }

    public static HtmlContainer svg(CharSequence... html) {
        return new HtmlContainer("svg", html);
    }

    public static HtmlContainer table(CharSequence... html) {
        return new HtmlContainer("table", html);
    }

    public static HtmlContainer tbody(CharSequence... html) {
        return new HtmlContainer("tbody", html);
    }

    public static HtmlContainer td(CharSequence... html) {
        return new HtmlContainer("td", html);
    }

    public static HtmlComponent template(String... attributes) {
        return new HtmlComponent("template", attributes);
    }

    public static HtmlContainer textarea(CharSequence... html) {
        return new HtmlContainer("textarea", html);
    }

    public static HtmlContainer tfoot(CharSequence... html) {
        return new HtmlContainer("tfoot", html);
    }

    public static HtmlContainer th(CharSequence... html) {
        return new HtmlContainer("th", html);
    }

    public static HtmlContainer thead(CharSequence... html) {
        return new HtmlContainer("thead", html);
    }

    public static HtmlContainer time(CharSequence... html) {
        return new HtmlContainer("time", html);
    }

    public static HtmlComponent title(CharSequence text) {
        return new HtmlContainer("title", new CharSequence[]{text});
    }

    public static HtmlContainer tr(CharSequence... html) {
        return new HtmlContainer("tr", html);
    }

    public static HtmlComponent track(String... attributes) {
        return new HtmlComponent("track", attributes);
    }

    public static HtmlContainer tt(CharSequence... html) {
        return new HtmlContainer("tt", html);
    }

    public static HtmlContainer u(CharSequence... html) {
        return new HtmlContainer("u", html);
    }

    public static HtmlContainer ul(CharSequence... html) {
        return new HtmlContainer("ul", html);
    }

    public static HtmlContainer var(CharSequence... html) {
        return new HtmlContainer("var", html);
    }

    public static HtmlContainer video(CharSequence... html) {
        return new HtmlContainer("video", html);
    }

    public static HtmlComponent wbr(String... attributes) {
        return new HtmlComponent("wbr", attributes);
    }
}

