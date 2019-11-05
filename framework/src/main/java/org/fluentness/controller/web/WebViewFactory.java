package org.fluentness.controller.web;

import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.controller.web.markup.html.ContainerHtmlView;
import org.fluentness.controller.web.markup.html.EmptyHtmlView;
import org.fluentness.controller.web.markup.html.HtmlView;
import org.fluentness.controller.web.text.RawView;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class WebViewFactory {

    // special web views
    public static HtmlView action(WebActionReference action, String inner) {
        return a(inner).href(action.getPath());
    }

    public static HtmlView action(WebActionReferenceWithRequest action, String inner) {
        return a(inner).href(action.getPath());
    }

    public static HtmlView action(WebActionReference action, MarkupView... inner) {
        return a(inner).href(action.getPath());
    }

    public static HtmlView action(WebActionReferenceWithRequest action, MarkupView... inner) {
        return a(inner).href(action.getPath());
    }

    public static WebView raw(String raw) {
        return new RawView(raw);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new MarkupView[0]);
    }

    // view container html views
    public static ContainerHtmlView a(MarkupView... inner) {
        return new ContainerHtmlView("a", inner);
    }

    public static ContainerHtmlView abbr(MarkupView... inner) {
        return new ContainerHtmlView("abbr", inner);
    }

    public static ContainerHtmlView acronym(MarkupView... inner) {
        return new ContainerHtmlView("acronym", inner);
    }

    public static ContainerHtmlView address(MarkupView... inner) {
        return new ContainerHtmlView("address", inner);
    }

    public static ContainerHtmlView applet(MarkupView... inner) {
        return new ContainerHtmlView("applet", inner);
    }

    public static ContainerHtmlView article(MarkupView... inner) {
        return new ContainerHtmlView("article", inner);
    }

    public static ContainerHtmlView aside(MarkupView... inner) {
        return new ContainerHtmlView("aside", inner);
    }

    public static ContainerHtmlView audio(MarkupView... inner) {
        return new ContainerHtmlView("audio", inner);
    }

    public static ContainerHtmlView b(MarkupView... inner) {
        return new ContainerHtmlView("b", inner);
    }

    public static ContainerHtmlView basefont(MarkupView... inner) {
        return new ContainerHtmlView("basefont", inner);
    }

    public static ContainerHtmlView bdi(MarkupView... inner) {
        return new ContainerHtmlView("bdi", inner);
    }

    public static ContainerHtmlView bdo(MarkupView... inner) {
        return new ContainerHtmlView("bdo", inner);
    }

    public static ContainerHtmlView big(MarkupView... inner) {
        return new ContainerHtmlView("big", inner);
    }

    public static ContainerHtmlView blockquote(MarkupView... inner) {
        return new ContainerHtmlView("blockquote", inner);
    }

    public static ContainerHtmlView body(MarkupView... inner) {
        return new ContainerHtmlView("body", inner);
    }

    public static ContainerHtmlView button(MarkupView... inner) {
        return new ContainerHtmlView("button", inner);
    }

    public static ContainerHtmlView canvas(MarkupView... inner) {
        return new ContainerHtmlView("canvas", inner);
    }

    public static ContainerHtmlView caption(MarkupView... inner) {
        return new ContainerHtmlView("caption", inner);
    }

    public static ContainerHtmlView center(MarkupView... inner) {
        return new ContainerHtmlView("center", inner);
    }

    public static ContainerHtmlView cite(MarkupView... inner) {
        return new ContainerHtmlView("cite", inner);
    }

    public static ContainerHtmlView code(MarkupView... inner) {
        return new ContainerHtmlView("code", inner);
    }

    public static ContainerHtmlView colgroup(MarkupView... inner) {
        return new ContainerHtmlView("colgroup", inner);
    }

    public static ContainerHtmlView data(MarkupView... inner) {
        return new ContainerHtmlView("data", inner);
    }

    public static ContainerHtmlView datalist(MarkupView... inner) {
        return new ContainerHtmlView("datalist", inner);
    }

    public static ContainerHtmlView dd(MarkupView... inner) {
        return new ContainerHtmlView("dd", inner);
    }

    public static ContainerHtmlView del(MarkupView... inner) {
        return new ContainerHtmlView("del", inner);
    }

    public static ContainerHtmlView details(MarkupView... inner) {
        return new ContainerHtmlView("details", inner);
    }

    public static ContainerHtmlView dfn(MarkupView... inner) {
        return new ContainerHtmlView("dfn", inner);
    }

    public static ContainerHtmlView dialog(MarkupView... inner) {
        return new ContainerHtmlView("dialog", inner);
    }

    public static ContainerHtmlView dir(MarkupView... inner) {
        return new ContainerHtmlView("dir", inner);
    }

    public static ContainerHtmlView div(MarkupView... inner) {
        return new ContainerHtmlView("div", inner);
    }

    public static ContainerHtmlView dl(MarkupView... inner) {
        return new ContainerHtmlView("dl", inner);
    }

    public static ContainerHtmlView dt(MarkupView... inner) {
        return new ContainerHtmlView("dt", inner);
    }

    public static ContainerHtmlView em(MarkupView... inner) {
        return new ContainerHtmlView("em", inner);
    }

    public static ContainerHtmlView fieldset(MarkupView... inner) {
        return new ContainerHtmlView("fieldset", inner);
    }

    public static ContainerHtmlView figcaption(MarkupView... inner) {
        return new ContainerHtmlView("figcaption", inner);
    }

    public static ContainerHtmlView figure(MarkupView... inner) {
        return new ContainerHtmlView("figure", inner);
    }

    public static ContainerHtmlView font(MarkupView... inner) {
        return new ContainerHtmlView("font", inner);
    }

    public static ContainerHtmlView footer(MarkupView... inner) {
        return new ContainerHtmlView("footer", inner);
    }

    public static ContainerHtmlView form(MarkupView... inner) {
        return new ContainerHtmlView("form", inner);
    }

    public static ContainerHtmlView frame(MarkupView... inner) {
        return new ContainerHtmlView("frame", inner);
    }

    public static ContainerHtmlView frameset(MarkupView... inner) {
        return new ContainerHtmlView("frameset", inner);
    }

    public static ContainerHtmlView h1(MarkupView... inner) {
        return new ContainerHtmlView("h1", inner);
    }

    public static ContainerHtmlView h2(MarkupView... inner) {
        return new ContainerHtmlView("h2", inner);
    }

    public static ContainerHtmlView h3(MarkupView... inner) {
        return new ContainerHtmlView("h3", inner);
    }

    public static ContainerHtmlView h4(MarkupView... inner) {
        return new ContainerHtmlView("h4", inner);
    }

    public static ContainerHtmlView h5(MarkupView... inner) {
        return new ContainerHtmlView("h5", inner);
    }

    public static ContainerHtmlView h6(MarkupView... inner) {
        return new ContainerHtmlView("h6", inner);
    }

    public static ContainerHtmlView head(MarkupView... inner) {
        return new ContainerHtmlView("head", inner);
    }

    public static ContainerHtmlView header(MarkupView... inner) {
        return new ContainerHtmlView("header", inner);
    }

    public static ContainerHtmlView html(MarkupView... inner) {
        return new ContainerHtmlView("html", inner);
    }

    public static ContainerHtmlView i(MarkupView... inner) {
        return new ContainerHtmlView("i", inner);
    }

    public static ContainerHtmlView iframe(MarkupView... inner) {
        return new ContainerHtmlView("iframe", inner);
    }

    public static ContainerHtmlView ins(MarkupView... inner) {
        return new ContainerHtmlView("ins", inner);
    }

    public static ContainerHtmlView kbd(MarkupView... inner) {
        return new ContainerHtmlView("kbd", inner);
    }

    public static ContainerHtmlView label(MarkupView... inner) {
        return new ContainerHtmlView("label", inner);
    }

    public static ContainerHtmlView legend(MarkupView... inner) {
        return new ContainerHtmlView("legend", inner);
    }

    public static ContainerHtmlView li(MarkupView... inner) {
        return new ContainerHtmlView("li", inner);
    }

    public static ContainerHtmlView main(MarkupView... inner) {
        return new ContainerHtmlView("main", inner);
    }

    public static ContainerHtmlView map(MarkupView... inner) {
        return new ContainerHtmlView("map", inner);
    }

    public static ContainerHtmlView mark(MarkupView... inner) {
        return new ContainerHtmlView("mark", inner);
    }

    public static ContainerHtmlView meter(MarkupView... inner) {
        return new ContainerHtmlView("meter", inner);
    }

    public static ContainerHtmlView nav(MarkupView... inner) {
        return new ContainerHtmlView("nav", inner);
    }

    public static ContainerHtmlView noframes(MarkupView... inner) {
        return new ContainerHtmlView("noframes", inner);
    }

    public static ContainerHtmlView noscript(MarkupView... inner) {
        return new ContainerHtmlView("noscript", inner);
    }

    public static ContainerHtmlView object(MarkupView... inner) {
        return new ContainerHtmlView("object", inner);
    }

    public static ContainerHtmlView ol(MarkupView... inner) {
        return new ContainerHtmlView("ol", inner);
    }

    public static ContainerHtmlView optgroup(MarkupView... inner) {
        return new ContainerHtmlView("optgroup", inner);
    }

    public static ContainerHtmlView option(MarkupView... inner) {
        return new ContainerHtmlView("option", inner);
    }

    public static ContainerHtmlView output(MarkupView... inner) {
        return new ContainerHtmlView("output", inner);
    }

    public static ContainerHtmlView p(MarkupView... inner) {
        return new ContainerHtmlView("p", inner);
    }

    public static ContainerHtmlView picture(MarkupView... inner) {
        return new ContainerHtmlView("picture", inner);
    }

    public static ContainerHtmlView pre(MarkupView... inner) {
        return new ContainerHtmlView("pre", inner);
    }

    public static ContainerHtmlView progress(MarkupView... inner) {
        return new ContainerHtmlView("progress", inner);
    }

    public static ContainerHtmlView q(MarkupView... inner) {
        return new ContainerHtmlView("q", inner);
    }

    public static ContainerHtmlView rp(MarkupView... inner) {
        return new ContainerHtmlView("rp", inner);
    }

    public static ContainerHtmlView rt(MarkupView... inner) {
        return new ContainerHtmlView("rt", inner);
    }

    public static ContainerHtmlView ruby(MarkupView... inner) {
        return new ContainerHtmlView("ruby", inner);
    }

    public static ContainerHtmlView s(MarkupView... inner) {
        return new ContainerHtmlView("s", inner);
    }

    public static ContainerHtmlView samp(MarkupView... inner) {
        return new ContainerHtmlView("samp", inner);
    }

    public static ContainerHtmlView script(MarkupView... inner) {
        return new ContainerHtmlView("script", inner);
    }

    public static ContainerHtmlView section(MarkupView... inner) {
        return new ContainerHtmlView("section", inner);
    }

    public static ContainerHtmlView select(MarkupView... inner) {
        return new ContainerHtmlView("select", inner);
    }

    public static ContainerHtmlView small(MarkupView... inner) {
        return new ContainerHtmlView("small", inner);
    }

    public static ContainerHtmlView span(MarkupView... inner) {
        return new ContainerHtmlView("span", inner);
    }

    public static ContainerHtmlView strike(MarkupView... inner) {
        return new ContainerHtmlView("strike", inner);
    }

    public static ContainerHtmlView strong(MarkupView... inner) {
        return new ContainerHtmlView("strong", inner);
    }

    public static ContainerHtmlView style(MarkupView... inner) {
        return new ContainerHtmlView("style", inner);
    }

    public static ContainerHtmlView sub(MarkupView... inner) {
        return new ContainerHtmlView("sub", inner);
    }

    public static ContainerHtmlView summary(MarkupView... inner) {
        return new ContainerHtmlView("summary", inner);
    }

    public static ContainerHtmlView sup(MarkupView... inner) {
        return new ContainerHtmlView("sup", inner);
    }

    public static ContainerHtmlView svg(MarkupView... inner) {
        return new ContainerHtmlView("svg", inner);
    }

    public static ContainerHtmlView table(MarkupView... inner) {
        return new ContainerHtmlView("table", inner);
    }

    public static ContainerHtmlView tbody(MarkupView... inner) {
        return new ContainerHtmlView("tbody", inner);
    }

    public static ContainerHtmlView td(MarkupView... inner) {
        return new ContainerHtmlView("td", inner);
    }

    public static ContainerHtmlView template(MarkupView... inner) {
        return new ContainerHtmlView("template", inner);
    }

    public static ContainerHtmlView textarea(MarkupView... inner) {
        return new ContainerHtmlView("textarea", inner);
    }

    public static ContainerHtmlView tfoot(MarkupView... inner) {
        return new ContainerHtmlView("tfoot", inner);
    }

    public static ContainerHtmlView th(MarkupView... inner) {
        return new ContainerHtmlView("th", inner);
    }

    public static ContainerHtmlView thead(MarkupView... inner) {
        return new ContainerHtmlView("thead", inner);
    }

    public static ContainerHtmlView time(MarkupView... inner) {
        return new ContainerHtmlView("time", inner);
    }

    public static ContainerHtmlView title(MarkupView... inner) {
        return new ContainerHtmlView("title", inner);
    }

    public static ContainerHtmlView tr(MarkupView... inner) {
        return new ContainerHtmlView("tr", inner);
    }

    public static ContainerHtmlView tt(MarkupView... inner) {
        return new ContainerHtmlView("tt", inner);
    }

    public static ContainerHtmlView u(MarkupView... inner) {
        return new ContainerHtmlView("u", inner);
    }

    public static ContainerHtmlView ul(MarkupView... inner) {
        return new ContainerHtmlView("ul", inner);
    }

    public static ContainerHtmlView var(MarkupView... inner) {
        return new ContainerHtmlView("var", inner);
    }

    public static ContainerHtmlView video(MarkupView... inner) {
        return new ContainerHtmlView("video", inner);
    }

    // string container html views
    public static ContainerHtmlView a(String inner) {
        return new ContainerHtmlView("a", inner);
    }

    public static ContainerHtmlView abbr(String inner) {
        return new ContainerHtmlView("abbr", inner);
    }

    public static ContainerHtmlView acronym(String inner) {
        return new ContainerHtmlView("acronym", inner);
    }

    public static ContainerHtmlView address(String inner) {
        return new ContainerHtmlView("address", inner);
    }

    public static ContainerHtmlView applet(String inner) {
        return new ContainerHtmlView("applet", inner);
    }

    public static ContainerHtmlView article(String inner) {
        return new ContainerHtmlView("article", inner);
    }

    public static ContainerHtmlView aside(String inner) {
        return new ContainerHtmlView("aside", inner);
    }

    public static ContainerHtmlView audio(String inner) {
        return new ContainerHtmlView("audio", inner);
    }

    public static ContainerHtmlView b(String inner) {
        return new ContainerHtmlView("b", inner);
    }

    public static ContainerHtmlView basefont(String inner) {
        return new ContainerHtmlView("basefont", inner);
    }

    public static ContainerHtmlView bdi(String inner) {
        return new ContainerHtmlView("bdi", inner);
    }

    public static ContainerHtmlView bdo(String inner) {
        return new ContainerHtmlView("bdo", inner);
    }

    public static ContainerHtmlView big(String inner) {
        return new ContainerHtmlView("big", inner);
    }

    public static ContainerHtmlView blockquote(String inner) {
        return new ContainerHtmlView("blockquote", inner);
    }

    public static ContainerHtmlView body(String inner) {
        return new ContainerHtmlView("body", inner);
    }

    public static ContainerHtmlView button(String inner) {
        return new ContainerHtmlView("button", inner);
    }

    public static ContainerHtmlView canvas(String inner) {
        return new ContainerHtmlView("canvas", inner);
    }

    public static ContainerHtmlView caption(String inner) {
        return new ContainerHtmlView("caption", inner);
    }

    public static ContainerHtmlView center(String inner) {
        return new ContainerHtmlView("center", inner);
    }

    public static ContainerHtmlView cite(String inner) {
        return new ContainerHtmlView("cite", inner);
    }

    public static ContainerHtmlView code(String inner) {
        return new ContainerHtmlView("code", inner);
    }

    public static ContainerHtmlView colgroup(String inner) {
        return new ContainerHtmlView("colgroup", inner);
    }

    public static ContainerHtmlView data(String inner) {
        return new ContainerHtmlView("data", inner);
    }

    public static ContainerHtmlView datalist(String inner) {
        return new ContainerHtmlView("datalist", inner);
    }

    public static ContainerHtmlView dd(String inner) {
        return new ContainerHtmlView("dd", inner);
    }

    public static ContainerHtmlView del(String inner) {
        return new ContainerHtmlView("del", inner);
    }

    public static ContainerHtmlView details(String inner) {
        return new ContainerHtmlView("details", inner);
    }

    public static ContainerHtmlView dfn(String inner) {
        return new ContainerHtmlView("dfn", inner);
    }

    public static ContainerHtmlView dialog(String inner) {
        return new ContainerHtmlView("dialog", inner);
    }

    public static ContainerHtmlView dir(String inner) {
        return new ContainerHtmlView("dir", inner);
    }

    public static ContainerHtmlView div(String inner) {
        return new ContainerHtmlView("div", inner);
    }

    public static ContainerHtmlView dl(String inner) {
        return new ContainerHtmlView("dl", inner);
    }

    public static ContainerHtmlView dt(String inner) {
        return new ContainerHtmlView("dt", inner);
    }

    public static ContainerHtmlView em(String inner) {
        return new ContainerHtmlView("em", inner);
    }

    public static ContainerHtmlView fieldset(String inner) {
        return new ContainerHtmlView("fieldset", inner);
    }

    public static ContainerHtmlView figcaption(String inner) {
        return new ContainerHtmlView("figcaption", inner);
    }

    public static ContainerHtmlView figure(String inner) {
        return new ContainerHtmlView("figure", inner);
    }

    public static ContainerHtmlView font(String inner) {
        return new ContainerHtmlView("font", inner);
    }

    public static ContainerHtmlView footer(String inner) {
        return new ContainerHtmlView("footer", inner);
    }

    public static ContainerHtmlView form(String inner) {
        return new ContainerHtmlView("form", inner);
    }

    public static ContainerHtmlView frame(String inner) {
        return new ContainerHtmlView("frame", inner);
    }

    public static ContainerHtmlView frameset(String inner) {
        return new ContainerHtmlView("frameset", inner);
    }

    public static ContainerHtmlView h1(String inner) {
        return new ContainerHtmlView("h1", inner);
    }

    public static ContainerHtmlView h2(String inner) {
        return new ContainerHtmlView("h2", inner);
    }

    public static ContainerHtmlView h3(String inner) {
        return new ContainerHtmlView("h3", inner);
    }

    public static ContainerHtmlView h4(String inner) {
        return new ContainerHtmlView("h4", inner);
    }

    public static ContainerHtmlView h5(String inner) {
        return new ContainerHtmlView("h5", inner);
    }

    public static ContainerHtmlView h6(String inner) {
        return new ContainerHtmlView("h6", inner);
    }

    public static ContainerHtmlView head(String inner) {
        return new ContainerHtmlView("head", inner);
    }

    public static ContainerHtmlView header(String inner) {
        return new ContainerHtmlView("header", inner);
    }

    public static ContainerHtmlView html(String inner) {
        return new ContainerHtmlView("html", inner);
    }

    public static ContainerHtmlView i(String inner) {
        return new ContainerHtmlView("i", inner);
    }

    public static ContainerHtmlView iframe(String inner) {
        return new ContainerHtmlView("iframe", inner);
    }

    public static ContainerHtmlView ins(String inner) {
        return new ContainerHtmlView("ins", inner);
    }

    public static ContainerHtmlView kbd(String inner) {
        return new ContainerHtmlView("kbd", inner);
    }

    public static ContainerHtmlView label(String inner) {
        return new ContainerHtmlView("label", inner);
    }

    public static ContainerHtmlView legend(String inner) {
        return new ContainerHtmlView("legend", inner);
    }

    public static ContainerHtmlView li(String inner) {
        return new ContainerHtmlView("li", inner);
    }

    public static ContainerHtmlView main(String inner) {
        return new ContainerHtmlView("main", inner);
    }

    public static ContainerHtmlView map(String inner) {
        return new ContainerHtmlView("map", inner);
    }

    public static ContainerHtmlView mark(String inner) {
        return new ContainerHtmlView("mark", inner);
    }

    public static ContainerHtmlView meter(String inner) {
        return new ContainerHtmlView("meter", inner);
    }

    public static ContainerHtmlView nav(String inner) {
        return new ContainerHtmlView("nav", inner);
    }

    public static ContainerHtmlView noframes(String inner) {
        return new ContainerHtmlView("noframes", inner);
    }

    public static ContainerHtmlView noscript(String inner) {
        return new ContainerHtmlView("noscript", inner);
    }

    public static ContainerHtmlView object(String inner) {
        return new ContainerHtmlView("object", inner);
    }

    public static ContainerHtmlView ol(String inner) {
        return new ContainerHtmlView("ol", inner);
    }

    public static ContainerHtmlView optgroup(String inner) {
        return new ContainerHtmlView("optgroup", inner);
    }

    public static ContainerHtmlView option(String inner) {
        return new ContainerHtmlView("option", inner);
    }

    public static ContainerHtmlView output(String inner) {
        return new ContainerHtmlView("output", inner);
    }

    public static ContainerHtmlView p(String inner) {
        return new ContainerHtmlView("p", inner);
    }

    public static ContainerHtmlView picture(String inner) {
        return new ContainerHtmlView("picture", inner);
    }

    public static ContainerHtmlView pre(String inner) {
        return new ContainerHtmlView("pre", inner);
    }

    public static ContainerHtmlView progress(String inner) {
        return new ContainerHtmlView("progress", inner);
    }

    public static ContainerHtmlView q(String inner) {
        return new ContainerHtmlView("q", inner);
    }

    public static ContainerHtmlView rp(String inner) {
        return new ContainerHtmlView("rp", inner);
    }

    public static ContainerHtmlView rt(String inner) {
        return new ContainerHtmlView("rt", inner);
    }

    public static ContainerHtmlView ruby(String inner) {
        return new ContainerHtmlView("ruby", inner);
    }

    public static ContainerHtmlView s(String inner) {
        return new ContainerHtmlView("s", inner);
    }

    public static ContainerHtmlView samp(String inner) {
        return new ContainerHtmlView("samp", inner);
    }

    public static ContainerHtmlView script(String inner) {
        return new ContainerHtmlView("script", inner);
    }

    public static ContainerHtmlView section(String inner) {
        return new ContainerHtmlView("section", inner);
    }

    public static ContainerHtmlView select(String inner) {
        return new ContainerHtmlView("select", inner);
    }

    public static ContainerHtmlView small(String inner) {
        return new ContainerHtmlView("small", inner);
    }

    public static ContainerHtmlView span(String inner) {
        return new ContainerHtmlView("span", inner);
    }

    public static ContainerHtmlView strike(String inner) {
        return new ContainerHtmlView("strike", inner);
    }

    public static ContainerHtmlView strong(String inner) {
        return new ContainerHtmlView("strong", inner);
    }

    public static ContainerHtmlView style(String inner) {
        return new ContainerHtmlView("style", inner);
    }

    public static ContainerHtmlView sub(String inner) {
        return new ContainerHtmlView("sub", inner);
    }

    public static ContainerHtmlView summary(String inner) {
        return new ContainerHtmlView("summary", inner);
    }

    public static ContainerHtmlView sup(String inner) {
        return new ContainerHtmlView("sup", inner);
    }

    public static ContainerHtmlView svg(String inner) {
        return new ContainerHtmlView("svg", inner);
    }

    public static ContainerHtmlView table(String inner) {
        return new ContainerHtmlView("table", inner);
    }

    public static ContainerHtmlView tbody(String inner) {
        return new ContainerHtmlView("tbody", inner);
    }

    public static ContainerHtmlView td(String inner) {
        return new ContainerHtmlView("td", inner);
    }

    public static ContainerHtmlView template(String inner) {
        return new ContainerHtmlView("template", inner);
    }

    public static ContainerHtmlView textarea(String inner) {
        return new ContainerHtmlView("textarea", inner);
    }

    public static ContainerHtmlView tfoot(String inner) {
        return new ContainerHtmlView("tfoot", inner);
    }

    public static ContainerHtmlView th(String inner) {
        return new ContainerHtmlView("th", inner);
    }

    public static ContainerHtmlView thead(String inner) {
        return new ContainerHtmlView("thead", inner);
    }

    public static ContainerHtmlView time(String inner) {
        return new ContainerHtmlView("time", inner);
    }

    public static ContainerHtmlView title(String inner) {
        return new ContainerHtmlView("title", inner);
    }

    public static ContainerHtmlView tr(String inner) {
        return new ContainerHtmlView("tr", inner);
    }

    public static ContainerHtmlView tt(String inner) {
        return new ContainerHtmlView("tt", inner);
    }

    public static ContainerHtmlView u(String inner) {
        return new ContainerHtmlView("u", inner);
    }

    public static ContainerHtmlView ul(String inner) {
        return new ContainerHtmlView("ul", inner);
    }

    public static ContainerHtmlView var(String inner) {
        return new ContainerHtmlView("var", inner);
    }

    public static ContainerHtmlView video(String inner) {
        return new ContainerHtmlView("video", inner);
    }

    // empty html views
    public static EmptyHtmlView area() {
        return new EmptyHtmlView("area");
    }

    public static EmptyHtmlView base() {
        return new EmptyHtmlView("base");
    }

    public static EmptyHtmlView br() {
        return new EmptyHtmlView("br");
    }

    public static EmptyHtmlView col() {
        return new EmptyHtmlView("col");
    }

    public static EmptyHtmlView embed() {
        return new EmptyHtmlView("embed");
    }

    public static EmptyHtmlView hr() {
        return new EmptyHtmlView("hr");
    }

    public static EmptyHtmlView img() {
        return new EmptyHtmlView("img");
    }

    public static EmptyHtmlView input() {
        return new EmptyHtmlView("input");
    }

    public static EmptyHtmlView link() {
        return new EmptyHtmlView("link");
    }

    public static EmptyHtmlView meta() {
        return new EmptyHtmlView("meta");
    }

    public static EmptyHtmlView param() {
        return new EmptyHtmlView("param");
    }

    public static EmptyHtmlView source() {
        return new EmptyHtmlView("source");
    }

    public static EmptyHtmlView track() {
        return new EmptyHtmlView("track");
    }

    public static EmptyHtmlView wbr() {
        return new EmptyHtmlView("wbr");
    }
}
