package org.fluentness.controller.web.html;

import org.fluentness.controller.web.markup.MarkupElementContainer;
import org.fluentness.controller.web.markup.MarkupElementEmpty;

interface ContainerStringHtmlViewFactory {

    static MarkupElementContainer a(String innerText) {
        return new MarkupElementContainer("a", innerText);
    }

    static MarkupElementContainer abbr(String innerText) {
        return new MarkupElementContainer("abbr", innerText);
    }

    static MarkupElementContainer acronym(String innerText) {
        return new MarkupElementContainer("acronym", innerText);
    }

    static MarkupElementContainer address(String innerText) {
        return new MarkupElementContainer("address", innerText);
    }

    static MarkupElementContainer applet(String innerText) {
        return new MarkupElementContainer("applet", innerText);
    }

    static MarkupElementContainer article(String innerText) {
        return new MarkupElementContainer("article", innerText);
    }

    static MarkupElementContainer aside(String innerText) {
        return new MarkupElementContainer("aside", innerText);
    }

    static MarkupElementContainer audio(String innerText) {
        return new MarkupElementContainer("audio", innerText);
    }

    static MarkupElementContainer b(String innerText) {
        return new MarkupElementContainer("b", innerText);
    }

    static MarkupElementContainer basefont(String innerText) {
        return new MarkupElementContainer("basefont", innerText);
    }

    static MarkupElementContainer bdi(String innerText) {
        return new MarkupElementContainer("bdi", innerText);
    }

    static MarkupElementContainer bdo(String innerText) {
        return new MarkupElementContainer("bdo", innerText);
    }

    static MarkupElementContainer big(String innerText) {
        return new MarkupElementContainer("big", innerText);
    }

    static MarkupElementContainer blockquote(String innerText) {
        return new MarkupElementContainer("blockquote", innerText);
    }

    static MarkupElementContainer body(String innerText) {
        return new MarkupElementContainer("body", innerText);
    }

    static MarkupElementContainer button(String innerText) {
        return new MarkupElementContainer("button", innerText);
    }

    static MarkupElementContainer canvas(String innerText) {
        return new MarkupElementContainer("canvas", innerText);
    }

    static MarkupElementContainer caption(String innerText) {
        return new MarkupElementContainer("caption", innerText);
    }

    static MarkupElementContainer center(String innerText) {
        return new MarkupElementContainer("center", innerText);
    }

    static MarkupElementContainer cite(String innerText) {
        return new MarkupElementContainer("cite", innerText);
    }

    static MarkupElementContainer code(String innerText) {
        return new MarkupElementContainer("code", innerText);
    }

    static MarkupElementContainer colgroup(String innerText) {
        return new MarkupElementContainer("colgroup", innerText);
    }

    static MarkupElementContainer data(String innerText) {
        return new MarkupElementContainer("data", innerText);
    }

    static MarkupElementContainer datalist(String innerText) {
        return new MarkupElementContainer("datalist", innerText);
    }

    static MarkupElementContainer dd(String innerText) {
        return new MarkupElementContainer("dd", innerText);
    }

    static MarkupElementContainer del(String innerText) {
        return new MarkupElementContainer("del", innerText);
    }

    static MarkupElementContainer details(String innerText) {
        return new MarkupElementContainer("details", innerText);
    }

    static MarkupElementContainer dfn(String innerText) {
        return new MarkupElementContainer("dfn", innerText);
    }

    static MarkupElementContainer dialog(String innerText) {
        return new MarkupElementContainer("dialog", innerText);
    }

    static MarkupElementContainer dir(String innerText) {
        return new MarkupElementContainer("dir", innerText);
    }

    static MarkupElementContainer div(String innerText) {
        return new MarkupElementContainer("div", innerText);
    }

    static MarkupElementContainer dl(String innerText) {
        return new MarkupElementContainer("dl", innerText);
    }

    static MarkupElementContainer dt(String innerText) {
        return new MarkupElementContainer("dt", innerText);
    }

    static MarkupElementContainer em(String innerText) {
        return new MarkupElementContainer("em", innerText);
    }

    static MarkupElementContainer fieldset(String innerText) {
        return new MarkupElementContainer("fieldset", innerText);
    }

    static MarkupElementContainer figcaption(String innerText) {
        return new MarkupElementContainer("figcaption", innerText);
    }

    static MarkupElementContainer figure(String innerText) {
        return new MarkupElementContainer("figure", innerText);
    }

    static MarkupElementContainer font(String innerText) {
        return new MarkupElementContainer("font", innerText);
    }

    static MarkupElementContainer footer(String innerText) {
        return new MarkupElementContainer("footer", innerText);
    }

    static MarkupElementContainer form(String innerText) {
        return new MarkupElementContainer("form", innerText);
    }

    static MarkupElementContainer frame(String innerText) {
        return new MarkupElementContainer("frame", innerText);
    }

    static MarkupElementContainer frameset(String innerText) {
        return new MarkupElementContainer("frameset", innerText);
    }

    static MarkupElementContainer h1(String innerText) {
        return new MarkupElementContainer("h1", innerText);
    }

    static MarkupElementContainer h2(String innerText) {
        return new MarkupElementContainer("h2", innerText);
    }

    static MarkupElementContainer h3(String innerText) {
        return new MarkupElementContainer("h3", innerText);
    }

    static MarkupElementContainer h4(String innerText) {
        return new MarkupElementContainer("h4", innerText);
    }

    static MarkupElementContainer h5(String innerText) {
        return new MarkupElementContainer("h5", innerText);
    }

    static MarkupElementContainer h6(String innerText) {
        return new MarkupElementContainer("h6", innerText);
    }

    static MarkupElementContainer head(String innerText) {
        return new MarkupElementContainer("head", innerText);
    }

    static MarkupElementContainer header(String innerText) {
        return new MarkupElementContainer("header", innerText);
    }

    static MarkupElementContainer html(String innerText) {
        return (MarkupElementContainer) new MarkupElementContainer("html", innerText)
            .precededBy(new MarkupElementEmpty("!doctype", html -> null));
    }

    static MarkupElementContainer i(String innerText) {
        return new MarkupElementContainer("i", innerText);
    }

    static MarkupElementContainer iframe(String innerText) {
        return new MarkupElementContainer("iframe", innerText);
    }

    static MarkupElementContainer ins(String innerText) {
        return new MarkupElementContainer("ins", innerText);
    }

    static MarkupElementContainer kbd(String innerText) {
        return new MarkupElementContainer("kbd", innerText);
    }

    static MarkupElementContainer label(String innerText) {
        return new MarkupElementContainer("label", innerText);
    }

    static MarkupElementContainer legend(String innerText) {
        return new MarkupElementContainer("legend", innerText);
    }

    static MarkupElementContainer li(String innerText) {
        return new MarkupElementContainer("li", innerText);
    }

    static MarkupElementContainer main(String innerText) {
        return new MarkupElementContainer("main", innerText);
    }

    static MarkupElementContainer map(String innerText) {
        return new MarkupElementContainer("map", innerText);
    }

    static MarkupElementContainer mark(String innerText) {
        return new MarkupElementContainer("mark", innerText);
    }

    static MarkupElementContainer meter(String innerText) {
        return new MarkupElementContainer("meter", innerText);
    }

    static MarkupElementContainer nav(String innerText) {
        return new MarkupElementContainer("nav", innerText);
    }

    static MarkupElementContainer noframes(String innerText) {
        return new MarkupElementContainer("noframes", innerText);
    }

    static MarkupElementContainer noscript(String innerText) {
        return new MarkupElementContainer("noscript", innerText);
    }

    static MarkupElementContainer object(String innerText) {
        return new MarkupElementContainer("object", innerText);
    }

    static MarkupElementContainer ol(String innerText) {
        return new MarkupElementContainer("ol", innerText);
    }

    static MarkupElementContainer optgroup(String innerText) {
        return new MarkupElementContainer("optgroup", innerText);
    }

    static MarkupElementContainer option(String innerText) {
        return new MarkupElementContainer("option", innerText);
    }

    static MarkupElementContainer output(String innerText) {
        return new MarkupElementContainer("output", innerText);
    }

    static MarkupElementContainer p(String innerText) {
        return new MarkupElementContainer("p", innerText);
    }

    static MarkupElementContainer picture(String innerText) {
        return new MarkupElementContainer("picture", innerText);
    }

    static MarkupElementContainer pre(String innerText) {
        return new MarkupElementContainer("pre", innerText);
    }

    static MarkupElementContainer progress(String innerText) {
        return new MarkupElementContainer("progress", innerText);
    }

    static MarkupElementContainer q(String innerText) {
        return new MarkupElementContainer("q", innerText);
    }

    static MarkupElementContainer rp(String innerText) {
        return new MarkupElementContainer("rp", innerText);
    }

    static MarkupElementContainer rt(String innerText) {
        return new MarkupElementContainer("rt", innerText);
    }

    static MarkupElementContainer ruby(String innerText) {
        return new MarkupElementContainer("ruby", innerText);
    }

    static MarkupElementContainer s(String innerText) {
        return new MarkupElementContainer("s", innerText);
    }

    static MarkupElementContainer samp(String innerText) {
        return new MarkupElementContainer("samp", innerText);
    }

    static MarkupElementContainer script(String innerText) {
        return new MarkupElementContainer("script", innerText);
    }

    static MarkupElementContainer section(String innerText) {
        return new MarkupElementContainer("section", innerText);
    }

    static MarkupElementContainer select(String innerText) {
        return new MarkupElementContainer("select", innerText);
    }

    static MarkupElementContainer small(String innerText) {
        return new MarkupElementContainer("small", innerText);
    }

    static MarkupElementContainer span(String innerText) {
        return new MarkupElementContainer("span", innerText);
    }

    static MarkupElementContainer strike(String innerText) {
        return new MarkupElementContainer("strike", innerText);
    }

    static MarkupElementContainer strong(String innerText) {
        return new MarkupElementContainer("strong", innerText);
    }

    static MarkupElementContainer style(String innerText) {
        return new MarkupElementContainer("style", innerText);
    }

    static MarkupElementContainer sub(String innerText) {
        return new MarkupElementContainer("sub", innerText);
    }

    static MarkupElementContainer summary(String innerText) {
        return new MarkupElementContainer("summary", innerText);
    }

    static MarkupElementContainer sup(String innerText) {
        return new MarkupElementContainer("sup", innerText);
    }

    static MarkupElementContainer svg(String innerText) {
        return new MarkupElementContainer("svg", innerText);
    }

    static MarkupElementContainer table(String innerText) {
        return new MarkupElementContainer("table", innerText);
    }

    static MarkupElementContainer tbody(String innerText) {
        return new MarkupElementContainer("tbody", innerText);
    }

    static MarkupElementContainer td(String innerText) {
        return new MarkupElementContainer("td", innerText);
    }

    static MarkupElementContainer template(String innerText) {
        return new MarkupElementContainer("template", innerText);
    }

    static MarkupElementContainer textarea(String innerText) {
        return new MarkupElementContainer("textarea", innerText);
    }

    static MarkupElementContainer tfoot(String innerText) {
        return new MarkupElementContainer("tfoot", innerText);
    }

    static MarkupElementContainer th(String innerText) {
        return new MarkupElementContainer("th", innerText);
    }

    static MarkupElementContainer thead(String innerText) {
        return new MarkupElementContainer("thead", innerText);
    }

    static MarkupElementContainer time(String innerText) {
        return new MarkupElementContainer("time", innerText);
    }

    static MarkupElementContainer title(String innerText) {
        return new MarkupElementContainer("title", innerText);
    }

    static MarkupElementContainer tr(String innerText) {
        return new MarkupElementContainer("tr", innerText);
    }

    static MarkupElementContainer tt(String innerText) {
        return new MarkupElementContainer("tt", innerText);
    }

    static MarkupElementContainer u(String innerText) {
        return new MarkupElementContainer("u", innerText);
    }

    static MarkupElementContainer ul(String innerText) {
        return new MarkupElementContainer("ul", innerText);
    }

    static MarkupElementContainer var(String innerText) {
        return new MarkupElementContainer("var", innerText);
    }

    static MarkupElementContainer video(String innerText) {
        return new MarkupElementContainer("video", innerText);
    }

}
