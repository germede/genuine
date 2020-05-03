package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlFactory {

    public static <T, V extends CharSequence> CharSequence forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return String.join("", result);
    }

    public static <T, V extends CharSequence> CharSequence forEach(T[] iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t));
        }
        return String.join("", result);
    }

    public static HtmlTemplate html(CharSequence... html) {
        return new HtmlTemplate(html);
    }
    // container html views

    public static Html a(CharSequence... html) {
        return new HtmlContainer("a", html);
    }

    public static Html abbr(CharSequence... html) {
        return new HtmlContainer("abbr", html);
    }

    public static Html acronym(CharSequence... html) {
        return new HtmlContainer("acronym", html);
    }

    public static Html address(CharSequence... html) {
        return new HtmlContainer("address", html);
    }

    public static Html applet(CharSequence... html) {
        return new HtmlContainer("applet", html);
    }

    public static Html article(CharSequence... html) {
        return new HtmlContainer("article", html);
    }

    public static Html aside(CharSequence... html) {
        return new HtmlContainer("aside", html);
    }

    public static Html audio(CharSequence... html) {
        return new HtmlContainer("audio", html);
    }

    public static Html b(CharSequence... html) {
        return new HtmlContainer("b", html);
    }

    public static Html basefont(CharSequence... html) {
        return new HtmlContainer("basefont", html);
    }

    public static Html bdi(CharSequence... html) {
        return new HtmlContainer("bdi", html);
    }

    public static Html bdo(CharSequence... html) {
        return new HtmlContainer("bdo", html);
    }

    public static Html big(CharSequence... html) {
        return new HtmlContainer("big", html);
    }

    public static Html blockquote(CharSequence... html) {
        return new HtmlContainer("blockquote", html);
    }

    public static Html body(CharSequence... html) {
        return new HtmlContainer("body", html);
    }

    public static Html button(CharSequence... html) {
        return new HtmlContainer("button", html);
    }

    public static Html canvas(CharSequence... html) {
        return new HtmlContainer("canvas", html);
    }

    public static Html caption(CharSequence... html) {
        return new HtmlContainer("caption", html);
    }

    public static Html center(CharSequence... html) {
        return new HtmlContainer("center", html);
    }

    public static Html cite(CharSequence... html) {
        return new HtmlContainer("cite", html);
    }

    public static Html code(CharSequence... html) {
        return new HtmlContainer("code", html);
    }

    public static Html colgroup(CharSequence... html) {
        return new HtmlContainer("colgroup", html);
    }

    public static Html data(CharSequence... html) {
        return new HtmlContainer("data", html);
    }

    public static Html datalist(CharSequence... html) {
        return new HtmlContainer("datalist", html);
    }

    public static Html dd(CharSequence... html) {
        return new HtmlContainer("dd", html);
    }

    public static Html del(CharSequence... html) {
        return new HtmlContainer("del", html);
    }

    public static Html details(CharSequence... html) {
        return new HtmlContainer("details", html);
    }

    public static Html dfn(CharSequence... html) {
        return new HtmlContainer("dfn", html);
    }

    public static Html dialog(CharSequence... html) {
        return new HtmlContainer("dialog", html);
    }

    public static Html dir(CharSequence... html) {
        return new HtmlContainer("dir", html);
    }

    public static Html div(CharSequence... html) {
        return new HtmlContainer("div", html);
    }

    public static Html dl(CharSequence... html) {
        return new HtmlContainer("dl", html);
    }

    public static Html dt(CharSequence... html) {
        return new HtmlContainer("dt", html);
    }

    public static Html em(CharSequence... html) {
        return new HtmlContainer("em", html);
    }

    public static Html fieldset(CharSequence... html) {
        return new HtmlContainer("fieldset", html);
    }

    public static Html figcaption(CharSequence... html) {
        return new HtmlContainer("figcaption", html);
    }

    public static Html figure(CharSequence... html) {
        return new HtmlContainer("figure", html);
    }

    public static Html font(CharSequence... html) {
        return new HtmlContainer("font", html);
    }

    public static Html footer(CharSequence... html) {
        return new HtmlContainer("footer", html);
    }

    public static Html form(CharSequence... html) {
        return new HtmlContainer("form", html);
    }

    public static Html frame(CharSequence... html) {
        return new HtmlContainer("frame", html);
    }

    public static Html frameset(CharSequence... html) {
        return new HtmlContainer("frameset", html);
    }

    public static Html h1(CharSequence... html) {
        return new HtmlContainer("h1", html);
    }

    public static Html h2(CharSequence... html) {
        return new HtmlContainer("h2", html);
    }

    public static Html h3(CharSequence... html) {
        return new HtmlContainer("h3", html);
    }

    public static Html h4(CharSequence... html) {
        return new HtmlContainer("h4", html);
    }

    public static Html h5(CharSequence... html) {
        return new HtmlContainer("h5", html);
    }

    public static Html h6(CharSequence... html) {
        return new HtmlContainer("h6", html);
    }

    public static Html head(CharSequence... html) {
        return new HtmlContainer("head", html);
    }

    public static Html header(CharSequence... html) {
        return new HtmlContainer("header", html);
    }

    public static Html i(CharSequence... html) {
        return new HtmlContainer("i", html);
    }

    public static Html iframe(CharSequence... html) {
        return new HtmlContainer("iframe", html);
    }

    public static Html ins(CharSequence... html) {
        return new HtmlContainer("ins", html);
    }

    public static Html kbd(CharSequence... html) {
        return new HtmlContainer("kbd", html);
    }

    public static Html label(CharSequence... html) {
        return new HtmlContainer("label", html);
    }

    public static Html legend(CharSequence... html) {
        return new HtmlContainer("legend", html);
    }

    public static Html li(CharSequence... html) {
        return new HtmlContainer("li", html);
    }

    public static Html main(CharSequence... html) {
        return new HtmlContainer("main", html);
    }

    public static Html map(CharSequence... html) {
        return new HtmlContainer("map", html);
    }

    public static Html mark(CharSequence... html) {
        return new HtmlContainer("mark", html);
    }

    public static Html meter(CharSequence... html) {
        return new HtmlContainer("meter", html);
    }

    public static Html nav(CharSequence... html) {
        return new HtmlContainer("nav", html);
    }

    public static Html noframes(CharSequence... html) {
        return new HtmlContainer("noframes", html);
    }

    public static Html noscript(CharSequence... html) {
        return new HtmlContainer("noscript", html);
    }

    public static Html object(CharSequence... html) {
        return new HtmlContainer("object", html);
    }

    public static Html ol(CharSequence... html) {
        return new HtmlContainer("ol", html);
    }

    public static Html optgroup(CharSequence... html) {
        return new HtmlContainer("optgroup", html);
    }

    public static Html option(CharSequence... html) {
        return new HtmlContainer("option", html);
    }

    public static Html output(CharSequence... html) {
        return new HtmlContainer("output", html);
    }

    public static Html p(CharSequence... html) {
        return new HtmlContainer("p", html);
    }

    public static Html picture(CharSequence... html) {
        return new HtmlContainer("picture", html);
    }

    public static Html pre(CharSequence... html) {
        return new HtmlContainer("pre", html);
    }

    public static Html progress(CharSequence... html) {
        return new HtmlContainer("progress", html);
    }

    public static Html q(CharSequence... html) {
        return new HtmlContainer("q", html);
    }

    public static Html rp(CharSequence... html) {
        return new HtmlContainer("rp", html);
    }

    public static Html rt(CharSequence... html) {
        return new HtmlContainer("rt", html);
    }

    public static Html ruby(CharSequence... html) {
        return new HtmlContainer("ruby", html);
    }

    public static Html s(CharSequence... html) {
        return new HtmlContainer("s", html);
    }

    public static Html samp(CharSequence... html) {
        return new HtmlContainer("samp", html);
    }

    public static Html script(CharSequence... html) {
        return new HtmlContainer("script", html);
    }

    public static Html section(CharSequence... html) {
        return new HtmlContainer("section", html);
    }

    public static Html select(CharSequence... html) {
        return new HtmlContainer("select", html);
    }

    public static Html small(CharSequence... html) {
        return new HtmlContainer("small", html);
    }

    public static Html span(CharSequence... html) {
        return new HtmlContainer("span", html);
    }

    public static Html strike(CharSequence... html) {
        return new HtmlContainer("strike", html);
    }

    public static Html strong(CharSequence... html) {
        return new HtmlContainer("strong", html);
    }

    public static Html style(CharSequence... html) {
        return new HtmlContainer("style", html);
    }

    public static Html sub(CharSequence... html) {
        return new HtmlContainer("sub", html);
    }

    public static Html summary(CharSequence... html) {
        return new HtmlContainer("summary", html);
    }

    public static Html sup(CharSequence... html) {
        return new HtmlContainer("sup", html);
    }

    public static Html svg(CharSequence... html) {
        return new HtmlContainer("svg", html);
    }

    public static Html table(CharSequence... html) {
        return new HtmlContainer("table", html);
    }

    public static Html tbody(CharSequence... html) {
        return new HtmlContainer("tbody", html);
    }

    public static Html td(CharSequence... html) {
        return new HtmlContainer("td", html);
    }

    public static Html template(CharSequence... html) {
        return new HtmlContainer("template", html);
    }

    public static Html textarea(CharSequence... html) {
        return new HtmlContainer("textarea", html);
    }

    public static Html tfoot(CharSequence... html) {
        return new HtmlContainer("tfoot", html);
    }

    public static Html th(CharSequence... html) {
        return new HtmlContainer("th", html);
    }

    public static Html thead(CharSequence... html) {
        return new HtmlContainer("thead", html);
    }

    public static Html time(CharSequence... html) {
        return new HtmlContainer("time", html);
    }

    public static Html title(CharSequence... html) {
        return new HtmlContainer("title", html);
    }

    public static Html tr(CharSequence... html) {
        return new HtmlContainer("tr", html);
    }

    public static Html tt(CharSequence... html) {
        return new HtmlContainer("tt", html);
    }

    public static Html u(CharSequence... html) {
        return new HtmlContainer("u", html);
    }

    public static Html ul(CharSequence... html) {
        return new HtmlContainer("ul", html);
    }

    public static Html var(CharSequence... html) {
        return new HtmlContainer("var", html);
    }

    public static Html video(CharSequence... html) {
        return new HtmlContainer("video", html);
    }

    // empty html views
    public static Html area(CharSequence... html) {
        return new HtmlEmpty("area", html);
    }

    public static Html base(CharSequence... html) {
        return new HtmlEmpty("base", html);
    }

    public static Html br(CharSequence... html) {
        return new HtmlEmpty("br", html);
    }

    public static Html col(CharSequence... html) {
        return new HtmlEmpty("col", html);
    }

    public static Html embed(CharSequence... html) {
        return new HtmlEmpty("embed", html);
    }

    public static Html hr(CharSequence... html) {
        return new HtmlEmpty("hr", html);
    }

    public static Html img(CharSequence... html) {
        return new HtmlEmpty("img", html);
    }

    public static Html input(CharSequence... html) {
        return new HtmlEmpty("input", html);
    }

    public static Html link(CharSequence... html) {
        return new HtmlEmpty("link", html);
    }

    public static Html meta(CharSequence... html) {
        return new HtmlEmpty("meta", html);
    }

    public static Html param(CharSequence... html) {
        return new HtmlEmpty("param", html);
    }

    public static Html source(CharSequence... html) {
        return new HtmlEmpty("source", html);
    }

    public static Html track(CharSequence... html) {
        return new HtmlEmpty("track", html);
    }

    public static Html wbr(CharSequence... html) {
        return new HtmlEmpty("wbr", html);
    }

}
