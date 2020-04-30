package org.fluentness.controller.web.template.html;

import org.fluentness.controller.web.template.WebTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlFactory {

    public static <T, V extends WebTemplate> CharSequence forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return String.join("", result);
    }

    public static HtmlTemplate html(CharSequence... html) {
        return new HtmlTemplate(html);
    }

    // container html views
    public static Html a(CharSequence... html) {
        return new Html("a", html);
    }

    public static Html abbr(CharSequence... html) {
        return new Html("abbr", html);
    }

    public static Html acronym(CharSequence... html) {
        return new Html("acronym", html);
    }

    public static Html address(CharSequence... html) {
        return new Html("address", html);
    }

    public static Html applet(CharSequence... html) {
        return new Html("applet", html);
    }

    public static Html article(CharSequence... html) {
        return new Html("article", html);
    }

    public static Html aside(CharSequence... html) {
        return new Html("aside", html);
    }

    public static Html audio(CharSequence... html) {
        return new Html("audio", html);
    }

    public static Html b(CharSequence... html) {
        return new Html("b", html);
    }

    public static Html basefont(CharSequence... html) {
        return new Html("basefont", html);
    }

    public static Html bdi(CharSequence... html) {
        return new Html("bdi", html);
    }

    public static Html bdo(CharSequence... html) {
        return new Html("bdo", html);
    }

    public static Html big(CharSequence... html) {
        return new Html("big", html);
    }

    public static Html blockquote(CharSequence... html) {
        return new Html("blockquote", html);
    }

    public static Html body(CharSequence... html) {
        return new Html("body", html);
    }

    public static Html button(CharSequence... html) {
        return new Html("button", html);
    }

    public static Html canvas(CharSequence... html) {
        return new Html("canvas", html);
    }

    public static Html caption(CharSequence... html) {
        return new Html("caption", html);
    }

    public static Html center(CharSequence... html) {
        return new Html("center", html);
    }

    public static Html cite(CharSequence... html) {
        return new Html("cite", html);
    }

    public static Html code(CharSequence... html) {
        return new Html("code", html);
    }

    public static Html colgroup(CharSequence... html) {
        return new Html("colgroup", html);
    }

    public static Html data(CharSequence... html) {
        return new Html("data", html);
    }

    public static Html datalist(CharSequence... html) {
        return new Html("datalist", html);
    }

    public static Html dd(CharSequence... html) {
        return new Html("dd", html);
    }

    public static Html del(CharSequence... html) {
        return new Html("del", html);
    }

    public static Html details(CharSequence... html) {
        return new Html("details", html);
    }

    public static Html dfn(CharSequence... html) {
        return new Html("dfn", html);
    }

    public static Html dialog(CharSequence... html) {
        return new Html("dialog", html);
    }

    public static Html dir(CharSequence... html) {
        return new Html("dir", html);
    }

    public static Html div(CharSequence... html) {
        return new Html("div", html);
    }

    public static Html dl(CharSequence... html) {
        return new Html("dl", html);
    }

    public static Html dt(CharSequence... html) {
        return new Html("dt", html);
    }

    public static Html em(CharSequence... html) {
        return new Html("em", html);
    }

    public static Html fieldset(CharSequence... html) {
        return new Html("fieldset", html);
    }

    public static Html figcaption(CharSequence... html) {
        return new Html("figcaption", html);
    }

    public static Html figure(CharSequence... html) {
        return new Html("figure", html);
    }

    public static Html font(CharSequence... html) {
        return new Html("font", html);
    }

    public static Html footer(CharSequence... html) {
        return new Html("footer", html);
    }

    public static Html form(CharSequence... html) {
        return new Html("form", html);
    }

    public static Html frame(CharSequence... html) {
        return new Html("frame", html);
    }

    public static Html frameset(CharSequence... html) {
        return new Html("frameset", html);
    }

    public static Html h1(CharSequence... html) {
        return new Html("h1", html);
    }

    public static Html h2(CharSequence... html) {
        return new Html("h2", html);
    }

    public static Html h3(CharSequence... html) {
        return new Html("h3", html);
    }

    public static Html h4(CharSequence... html) {
        return new Html("h4", html);
    }

    public static Html h5(CharSequence... html) {
        return new Html("h5", html);
    }

    public static Html h6(CharSequence... html) {
        return new Html("h6", html);
    }

    public static Html head(CharSequence... html) {
        return new Html("head", html);
    }

    public static Html header(CharSequence... html) {
        return new Html("header", html);
    }

    public static Html i(CharSequence... html) {
        return new Html("i", html);
    }

    public static Html iframe(CharSequence... html) {
        return new Html("iframe", html);
    }

    public static Html ins(CharSequence... html) {
        return new Html("ins", html);
    }

    public static Html kbd(CharSequence... html) {
        return new Html("kbd", html);
    }

    public static Html label(CharSequence... html) {
        return new Html("label", html);
    }

    public static Html legend(CharSequence... html) {
        return new Html("legend", html);
    }

    public static Html li(CharSequence... html) {
        return new Html("li", html);
    }

    public static Html main(CharSequence... html) {
        return new Html("main", html);
    }

    public static Html map(CharSequence... html) {
        return new Html("map", html);
    }

    public static Html mark(CharSequence... html) {
        return new Html("mark", html);
    }

    public static Html meter(CharSequence... html) {
        return new Html("meter", html);
    }

    public static Html nav(CharSequence... html) {
        return new Html("nav", html);
    }

    public static Html noframes(CharSequence... html) {
        return new Html("noframes", html);
    }

    public static Html noscript(CharSequence... html) {
        return new Html("noscript", html);
    }

    public static Html object(CharSequence... html) {
        return new Html("object", html);
    }

    public static Html ol(CharSequence... html) {
        return new Html("ol", html);
    }

    public static Html optgroup(CharSequence... html) {
        return new Html("optgroup", html);
    }

    public static Html option(CharSequence... html) {
        return new Html("option", html);
    }

    public static Html output(CharSequence... html) {
        return new Html("output", html);
    }

    public static Html p(CharSequence... html) {
        return new Html("p", html);
    }

    public static Html picture(CharSequence... html) {
        return new Html("picture", html);
    }

    public static Html pre(CharSequence... html) {
        return new Html("pre", html);
    }

    public static Html progress(CharSequence... html) {
        return new Html("progress", html);
    }

    public static Html q(CharSequence... html) {
        return new Html("q", html);
    }

    public static Html rp(CharSequence... html) {
        return new Html("rp", html);
    }

    public static Html rt(CharSequence... html) {
        return new Html("rt", html);
    }

    public static Html ruby(CharSequence... html) {
        return new Html("ruby", html);
    }

    public static Html s(CharSequence... html) {
        return new Html("s", html);
    }

    public static Html samp(CharSequence... html) {
        return new Html("samp", html);
    }

    public static Html script(CharSequence... html) {
        return new Html("script", html);
    }

    public static Html section(CharSequence... html) {
        return new Html("section", html);
    }

    public static Html select(CharSequence... html) {
        return new Html("select", html);
    }

    public static Html small(CharSequence... html) {
        return new Html("small", html);
    }

    public static Html span(CharSequence... html) {
        return new Html("span", html);
    }

    public static Html strike(CharSequence... html) {
        return new Html("strike", html);
    }

    public static Html strong(CharSequence... html) {
        return new Html("strong", html);
    }

    public static Html style(CharSequence... html) {
        return new Html("style", html);
    }

    public static Html sub(CharSequence... html) {
        return new Html("sub", html);
    }

    public static Html summary(CharSequence... html) {
        return new Html("summary", html);
    }

    public static Html sup(CharSequence... html) {
        return new Html("sup", html);
    }

    public static Html svg(CharSequence... html) {
        return new Html("svg", html);
    }

    public static Html table(CharSequence... html) {
        return new Html("table", html);
    }

    public static Html tbody(CharSequence... html) {
        return new Html("tbody", html);
    }

    public static Html td(CharSequence... html) {
        return new Html("td", html);
    }

    public static Html template(CharSequence... html) {
        return new Html("template", html);
    }

    public static Html textarea(CharSequence... html) {
        return new Html("textarea", html);
    }

    public static Html tfoot(CharSequence... html) {
        return new Html("tfoot", html);
    }

    public static Html th(CharSequence... html) {
        return new Html("th", html);
    }

    public static Html thead(CharSequence... html) {
        return new Html("thead", html);
    }

    public static Html time(CharSequence... html) {
        return new Html("time", html);
    }

    public static Html title(CharSequence... html) {
        return new Html("title", html);
    }

    public static Html tr(CharSequence... html) {
        return new Html("tr", html);
    }

    public static Html tt(CharSequence... html) {
        return new Html("tt", html);
    }

    public static Html u(CharSequence... html) {
        return new Html("u", html);
    }

    public static Html ul(CharSequence... html) {
        return new Html("ul", html);
    }

    public static Html var(CharSequence... html) {
        return new Html("var", html);
    }

    public static Html video(CharSequence... html) {
        return new Html("video", html);
    }

    // empty html views
    public static Html area(CharSequence... html) {
        return new Html("area", html);
    }

    public static Html base(CharSequence... html) {
        return new Html("base", html);
    }

    public static Html br(CharSequence... html) {
        return new Html("br", html);
    }

    public static Html col(CharSequence... html) {
        return new Html("col", html);
    }

    public static Html embed(CharSequence... html) {
        return new Html("embed", html);
    }

    public static Html hr(CharSequence... html) {
        return new Html("hr", html);
    }

    public static Html img(CharSequence... html) {
        return new Html("img", html);
    }

    public static Html input(CharSequence... html) {
        return new Html("input", html);
    }

    public static Html link(CharSequence... html) {
        return new Html("link", html);
    }

    public static Html meta(CharSequence... html) {
        return new Html("meta", html);
    }

    public static Html param(CharSequence... html) {
        return new Html("param", html);
    }

    public static Html source(CharSequence... html) {
        return new Html("source", html);
    }

    public static Html track(CharSequence... html) {
        return new Html("track", html);
    }

    public static Html wbr(CharSequence... html) {
        return new Html("wbr", html);
    }

}
