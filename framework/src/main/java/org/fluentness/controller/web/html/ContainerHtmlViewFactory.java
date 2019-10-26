package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.MarkupElementContainer;

interface ContainerHtmlViewFactory {

    static MarkupElementContainer a(WebView... innerViews) {
        return new MarkupElementContainer("a", innerViews);
    }

    static MarkupElementContainer abbr(WebView... innerViews) {
        return new MarkupElementContainer("abbr", innerViews);
    }

    static MarkupElementContainer acronym(WebView... innerViews) {
        return new MarkupElementContainer("acronym", innerViews);
    }

    static MarkupElementContainer address(WebView... innerViews) {
        return new MarkupElementContainer("address", innerViews);
    }

    static MarkupElementContainer applet(WebView... innerViews) {
        return new MarkupElementContainer("applet", innerViews);
    }

    static MarkupElementContainer article(WebView... innerViews) {
        return new MarkupElementContainer("article", innerViews);
    }

    static MarkupElementContainer aside(WebView... innerViews) {
        return new MarkupElementContainer("aside", innerViews);
    }

    static MarkupElementContainer audio(WebView... innerViews) {
        return new MarkupElementContainer("audio", innerViews);
    }

    static MarkupElementContainer b(WebView... innerViews) {
        return new MarkupElementContainer("b", innerViews);
    }

    static MarkupElementContainer basefont(WebView... innerViews) {
        return new MarkupElementContainer("basefont", innerViews);
    }

    static MarkupElementContainer bdi(WebView... innerViews) {
        return new MarkupElementContainer("bdi", innerViews);
    }

    static MarkupElementContainer bdo(WebView... innerViews) {
        return new MarkupElementContainer("bdo", innerViews);
    }

    static MarkupElementContainer big(WebView... innerViews) {
        return new MarkupElementContainer("big", innerViews);
    }

    static MarkupElementContainer blockquote(WebView... innerViews) {
        return new MarkupElementContainer("blockquote", innerViews);
    }

    static MarkupElementContainer body(WebView... innerViews) {
        return new MarkupElementContainer("body", innerViews);
    }

    static MarkupElementContainer button(WebView... innerViews) {
        return new MarkupElementContainer("button", innerViews);
    }

    static MarkupElementContainer canvas(WebView... innerViews) {
        return new MarkupElementContainer("canvas", innerViews);
    }

    static MarkupElementContainer caption(WebView... innerViews) {
        return new MarkupElementContainer("caption", innerViews);
    }

    static MarkupElementContainer center(WebView... innerViews) {
        return new MarkupElementContainer("center", innerViews);
    }

    static MarkupElementContainer cite(WebView... innerViews) {
        return new MarkupElementContainer("cite", innerViews);
    }

    static MarkupElementContainer code(WebView... innerViews) {
        return new MarkupElementContainer("code", innerViews);
    }

    static MarkupElementContainer colgroup(WebView... innerViews) {
        return new MarkupElementContainer("colgroup", innerViews);
    }

    static MarkupElementContainer data(WebView... innerViews) {
        return new MarkupElementContainer("data", innerViews);
    }

    static MarkupElementContainer datalist(WebView... innerViews) {
        return new MarkupElementContainer("datalist", innerViews);
    }

    static MarkupElementContainer dd(WebView... innerViews) {
        return new MarkupElementContainer("dd", innerViews);
    }

    static MarkupElementContainer del(WebView... innerViews) {
        return new MarkupElementContainer("del", innerViews);
    }

    static MarkupElementContainer details(WebView... innerViews) {
        return new MarkupElementContainer("details", innerViews);
    }

    static MarkupElementContainer dfn(WebView... innerViews) {
        return new MarkupElementContainer("dfn", innerViews);
    }

    static MarkupElementContainer dialog(WebView... innerViews) {
        return new MarkupElementContainer("dialog", innerViews);
    }

    static MarkupElementContainer dir(WebView... innerViews) {
        return new MarkupElementContainer("dir", innerViews);
    }

    static MarkupElementContainer div(WebView... innerViews) {
        return new MarkupElementContainer("div", innerViews);
    }

    static MarkupElementContainer dl(WebView... innerViews) {
        return new MarkupElementContainer("dl", innerViews);
    }

    static MarkupElementContainer dt(WebView... innerViews) {
        return new MarkupElementContainer("dt", innerViews);
    }

    static MarkupElementContainer em(WebView... innerViews) {
        return new MarkupElementContainer("em", innerViews);
    }

    static MarkupElementContainer fieldset(WebView... innerViews) {
        return new MarkupElementContainer("fieldset", innerViews);
    }

    static MarkupElementContainer figcaption(WebView... innerViews) {
        return new MarkupElementContainer("figcaption", innerViews);
    }

    static MarkupElementContainer figure(WebView... innerViews) {
        return new MarkupElementContainer("figure", innerViews);
    }

    static MarkupElementContainer font(WebView... innerViews) {
        return new MarkupElementContainer("font", innerViews);
    }

    static MarkupElementContainer footer(WebView... innerViews) {
        return new MarkupElementContainer("footer", innerViews);
    }

    static MarkupElementContainer form(WebView... innerViews) {
        return new MarkupElementContainer("form", innerViews);
    }

    static MarkupElementContainer frame(WebView... innerViews) {
        return new MarkupElementContainer("frame", innerViews);
    }

    static MarkupElementContainer frameset(WebView... innerViews) {
        return new MarkupElementContainer("frameset", innerViews);
    }

    static MarkupElementContainer h1(WebView... innerViews) {
        return new MarkupElementContainer("h1", innerViews);
    }

    static MarkupElementContainer h2(WebView... innerViews) {
        return new MarkupElementContainer("h2", innerViews);
    }

    static MarkupElementContainer h3(WebView... innerViews) {
        return new MarkupElementContainer("h3", innerViews);
    }

    static MarkupElementContainer h4(WebView... innerViews) {
        return new MarkupElementContainer("h4", innerViews);
    }

    static MarkupElementContainer h5(WebView... innerViews) {
        return new MarkupElementContainer("h5", innerViews);
    }

    static MarkupElementContainer h6(WebView... innerViews) {
        return new MarkupElementContainer("h6", innerViews);
    }

    static MarkupElementContainer head(WebView... innerViews) {
        return new MarkupElementContainer("head", innerViews);
    }

    static MarkupElementContainer header(WebView... innerViews) {
        return new MarkupElementContainer("header", innerViews);
    }

    static MarkupElementContainer html(WebView... innerViews) {
        return (MarkupElementContainer) new MarkupElementContainer("html", innerViews);
//            .precededBy(new MarkupElementEmpty("!doctype", html -> null));
    }

    static MarkupElementContainer i(WebView... innerViews) {
        return new MarkupElementContainer("i", innerViews);
    }

    static MarkupElementContainer iframe(WebView... innerViews) {
        return new MarkupElementContainer("iframe", innerViews);
    }

    static MarkupElementContainer ins(WebView... innerViews) {
        return new MarkupElementContainer("ins", innerViews);
    }

    static MarkupElementContainer kbd(WebView... innerViews) {
        return new MarkupElementContainer("kbd", innerViews);
    }

    static MarkupElementContainer label(WebView... innerViews) {
        return new MarkupElementContainer("label", innerViews);
    }

    static MarkupElementContainer legend(WebView... innerViews) {
        return new MarkupElementContainer("legend", innerViews);
    }

    static MarkupElementContainer li(WebView... innerViews) {
        return new MarkupElementContainer("li", innerViews);
    }

    static MarkupElementContainer main(WebView... innerViews) {
        return new MarkupElementContainer("main", innerViews);
    }

    static MarkupElementContainer map(WebView... innerViews) {
        return new MarkupElementContainer("map", innerViews);
    }

    static MarkupElementContainer mark(WebView... innerViews) {
        return new MarkupElementContainer("mark", innerViews);
    }

    static MarkupElementContainer meter(WebView... innerViews) {
        return new MarkupElementContainer("meter", innerViews);
    }

    static MarkupElementContainer nav(WebView... innerViews) {
        return new MarkupElementContainer("nav", innerViews);
    }

    static MarkupElementContainer noframes(WebView... innerViews) {
        return new MarkupElementContainer("noframes", innerViews);
    }

    static MarkupElementContainer noscript(WebView... innerViews) {
        return new MarkupElementContainer("noscript", innerViews);
    }

    static MarkupElementContainer object(WebView... innerViews) {
        return new MarkupElementContainer("object", innerViews);
    }

    static MarkupElementContainer ol(WebView... innerViews) {
        return new MarkupElementContainer("ol", innerViews);
    }

    static MarkupElementContainer optgroup(WebView... innerViews) {
        return new MarkupElementContainer("optgroup", innerViews);
    }

    static MarkupElementContainer option(WebView... innerViews) {
        return new MarkupElementContainer("option", innerViews);
    }

    static MarkupElementContainer output(WebView... innerViews) {
        return new MarkupElementContainer("output", innerViews);
    }

    static MarkupElementContainer p(WebView... innerViews) {
        return new MarkupElementContainer("p", innerViews);
    }

    static MarkupElementContainer picture(WebView... innerViews) {
        return new MarkupElementContainer("picture", innerViews);
    }

    static MarkupElementContainer pre(WebView... innerViews) {
        return new MarkupElementContainer("pre", innerViews);
    }

    static MarkupElementContainer progress(WebView... innerViews) {
        return new MarkupElementContainer("progress", innerViews);
    }

    static MarkupElementContainer q(WebView... innerViews) {
        return new MarkupElementContainer("q", innerViews);
    }

    static MarkupElementContainer rp(WebView... innerViews) {
        return new MarkupElementContainer("rp", innerViews);
    }

    static MarkupElementContainer rt(WebView... innerViews) {
        return new MarkupElementContainer("rt", innerViews);
    }

    static MarkupElementContainer ruby(WebView... innerViews) {
        return new MarkupElementContainer("ruby", innerViews);
    }

    static MarkupElementContainer s(WebView... innerViews) {
        return new MarkupElementContainer("s", innerViews);
    }

    static MarkupElementContainer samp(WebView... innerViews) {
        return new MarkupElementContainer("samp", innerViews);
    }

    static MarkupElementContainer script(WebView... innerViews) {
        return new MarkupElementContainer("script", innerViews);
    }

    static MarkupElementContainer section(WebView... innerViews) {
        return new MarkupElementContainer("section", innerViews);
    }

    static MarkupElementContainer select(WebView... innerViews) {
        return new MarkupElementContainer("select", innerViews);
    }

    static MarkupElementContainer small(WebView... innerViews) {
        return new MarkupElementContainer("small", innerViews);
    }

    static MarkupElementContainer span(WebView... innerViews) {
        return new MarkupElementContainer("span", innerViews);
    }

    static MarkupElementContainer strike(WebView... innerViews) {
        return new MarkupElementContainer("strike", innerViews);
    }

    static MarkupElementContainer strong(WebView... innerViews) {
        return new MarkupElementContainer("strong", innerViews);
    }

    static MarkupElementContainer style(WebView... innerViews) {
        return new MarkupElementContainer("style", innerViews);
    }

    static MarkupElementContainer sub(WebView... innerViews) {
        return new MarkupElementContainer("sub", innerViews);
    }

    static MarkupElementContainer summary(WebView... innerViews) {
        return new MarkupElementContainer("summary", innerViews);
    }

    static MarkupElementContainer sup(WebView... innerViews) {
        return new MarkupElementContainer("sup", innerViews);
    }

    static MarkupElementContainer svg(WebView... innerViews) {
        return new MarkupElementContainer("svg", innerViews);
    }

    static MarkupElementContainer table(WebView... innerViews) {
        return new MarkupElementContainer("table", innerViews);
    }

    static MarkupElementContainer tbody(WebView... innerViews) {
        return new MarkupElementContainer("tbody", innerViews);
    }

    static MarkupElementContainer td(WebView... innerViews) {
        return new MarkupElementContainer("td", innerViews);
    }

    static MarkupElementContainer template(WebView... innerViews) {
        return new MarkupElementContainer("template", innerViews);
    }

    static MarkupElementContainer textarea(WebView... innerViews) {
        return new MarkupElementContainer("textarea", innerViews);
    }

    static MarkupElementContainer tfoot(WebView... innerViews) {
        return new MarkupElementContainer("tfoot", innerViews);
    }

    static MarkupElementContainer th(WebView... innerViews) {
        return new MarkupElementContainer("th", innerViews);
    }

    static MarkupElementContainer thead(WebView... innerViews) {
        return new MarkupElementContainer("thead", innerViews);
    }

    static MarkupElementContainer time(WebView... innerViews) {
        return new MarkupElementContainer("time", innerViews);
    }

    static MarkupElementContainer title(WebView... innerViews) {
        return new MarkupElementContainer("title", innerViews);
    }

    static MarkupElementContainer tr(WebView... innerViews) {
        return new MarkupElementContainer("tr", innerViews);
    }

    static MarkupElementContainer tt(WebView... innerViews) {
        return new MarkupElementContainer("tt", innerViews);
    }

    static MarkupElementContainer u(WebView... innerViews) {
        return new MarkupElementContainer("u", innerViews);
    }

    static MarkupElementContainer ul(WebView... innerViews) {
        return new MarkupElementContainer("ul", innerViews);
    }

    static MarkupElementContainer var(WebView... innerViews) {
        return new MarkupElementContainer("var", innerViews);
    }

    static MarkupElementContainer video(WebView... innerViews) {
        return new MarkupElementContainer("video", innerViews);
    }

}
