package org.fluentness.flow.component.view.html;

import org.fluentness.flow.component.view.MarkupElementContainer;
import org.fluentness.flow.component.view.MarkupElementEmpty;
import org.fluentness.flow.component.view.View;

interface ContainerHtmlViewFactory {

    static MarkupElementContainer a(View... innerViews) {
        return new MarkupElementContainer("a", innerViews);
    }

    static MarkupElementContainer abbr(View... innerViews) {
        return new MarkupElementContainer("abbr", innerViews);
    }

    static MarkupElementContainer acronym(View... innerViews) {
        return new MarkupElementContainer("acronym", innerViews);
    }

    static MarkupElementContainer address(View... innerViews) {
        return new MarkupElementContainer("address", innerViews);
    }

    static MarkupElementContainer applet(View... innerViews) {
        return new MarkupElementContainer("applet", innerViews);
    }

    static MarkupElementContainer article(View... innerViews) {
        return new MarkupElementContainer("article", innerViews);
    }

    static MarkupElementContainer aside(View... innerViews) {
        return new MarkupElementContainer("aside", innerViews);
    }

    static MarkupElementContainer audio(View... innerViews) {
        return new MarkupElementContainer("audio", innerViews);
    }

    static MarkupElementContainer b(View... innerViews) {
        return new MarkupElementContainer("b", innerViews);
    }

    static MarkupElementContainer basefont(View... innerViews) {
        return new MarkupElementContainer("basefont", innerViews);
    }

    static MarkupElementContainer bdi(View... innerViews) {
        return new MarkupElementContainer("bdi", innerViews);
    }

    static MarkupElementContainer bdo(View... innerViews) {
        return new MarkupElementContainer("bdo", innerViews);
    }

    static MarkupElementContainer big(View... innerViews) {
        return new MarkupElementContainer("big", innerViews);
    }

    static MarkupElementContainer blockquote(View... innerViews) {
        return new MarkupElementContainer("blockquote", innerViews);
    }

    static MarkupElementContainer body(View... innerViews) {
        return new MarkupElementContainer("body", innerViews);
    }

    static MarkupElementContainer button(View... innerViews) {
        return new MarkupElementContainer("button", innerViews);
    }

    static MarkupElementContainer canvas(View... innerViews) {
        return new MarkupElementContainer("canvas", innerViews);
    }

    static MarkupElementContainer caption(View... innerViews) {
        return new MarkupElementContainer("caption", innerViews);
    }

    static MarkupElementContainer center(View... innerViews) {
        return new MarkupElementContainer("center", innerViews);
    }

    static MarkupElementContainer cite(View... innerViews) {
        return new MarkupElementContainer("cite", innerViews);
    }

    static MarkupElementContainer code(View... innerViews) {
        return new MarkupElementContainer("code", innerViews);
    }

    static MarkupElementContainer colgroup(View... innerViews) {
        return new MarkupElementContainer("colgroup", innerViews);
    }

    static MarkupElementContainer data(View... innerViews) {
        return new MarkupElementContainer("data", innerViews);
    }

    static MarkupElementContainer datalist(View... innerViews) {
        return new MarkupElementContainer("datalist", innerViews);
    }

    static MarkupElementContainer dd(View... innerViews) {
        return new MarkupElementContainer("dd", innerViews);
    }

    static MarkupElementContainer del(View... innerViews) {
        return new MarkupElementContainer("del", innerViews);
    }

    static MarkupElementContainer details(View... innerViews) {
        return new MarkupElementContainer("details", innerViews);
    }

    static MarkupElementContainer dfn(View... innerViews) {
        return new MarkupElementContainer("dfn", innerViews);
    }

    static MarkupElementContainer dialog(View... innerViews) {
        return new MarkupElementContainer("dialog", innerViews);
    }

    static MarkupElementContainer dir(View... innerViews) {
        return new MarkupElementContainer("dir", innerViews);
    }

    static MarkupElementContainer div(View... innerViews) {
        return new MarkupElementContainer("div", innerViews);
    }

    static MarkupElementContainer dl(View... innerViews) {
        return new MarkupElementContainer("dl", innerViews);
    }

    static MarkupElementContainer dt(View... innerViews) {
        return new MarkupElementContainer("dt", innerViews);
    }

    static MarkupElementContainer em(View... innerViews) {
        return new MarkupElementContainer("em", innerViews);
    }

    static MarkupElementContainer fieldset(View... innerViews) {
        return new MarkupElementContainer("fieldset", innerViews);
    }

    static MarkupElementContainer figcaption(View... innerViews) {
        return new MarkupElementContainer("figcaption", innerViews);
    }

    static MarkupElementContainer figure(View... innerViews) {
        return new MarkupElementContainer("figure", innerViews);
    }

    static MarkupElementContainer font(View... innerViews) {
        return new MarkupElementContainer("font", innerViews);
    }

    static MarkupElementContainer footer(View... innerViews) {
        return new MarkupElementContainer("footer", innerViews);
    }

    static MarkupElementContainer form(View... innerViews) {
        return new MarkupElementContainer("form", innerViews);
    }

    static MarkupElementContainer frame(View... innerViews) {
        return new MarkupElementContainer("frame", innerViews);
    }

    static MarkupElementContainer frameset(View... innerViews) {
        return new MarkupElementContainer("frameset", innerViews);
    }

    static MarkupElementContainer h1(View... innerViews) {
        return new MarkupElementContainer("h1", innerViews);
    }

    static MarkupElementContainer h2(View... innerViews) {
        return new MarkupElementContainer("h2", innerViews);
    }

    static MarkupElementContainer h3(View... innerViews) {
        return new MarkupElementContainer("h3", innerViews);
    }

    static MarkupElementContainer h4(View... innerViews) {
        return new MarkupElementContainer("h4", innerViews);
    }

    static MarkupElementContainer h5(View... innerViews) {
        return new MarkupElementContainer("h5", innerViews);
    }

    static MarkupElementContainer h6(View... innerViews) {
        return new MarkupElementContainer("h6", innerViews);
    }

    static MarkupElementContainer head(View... innerViews) {
        return new MarkupElementContainer("head", innerViews);
    }

    static MarkupElementContainer header(View... innerViews) {
        return new MarkupElementContainer("header", innerViews);
    }

    static MarkupElementContainer html(View... innerViews) {
        return (MarkupElementContainer) new MarkupElementContainer("html", innerViews)
            .precededBy(new MarkupElementEmpty("!doctype", html -> null));
    }

    static MarkupElementContainer i(View... innerViews) {
        return new MarkupElementContainer("i", innerViews);
    }

    static MarkupElementContainer iframe(View... innerViews) {
        return new MarkupElementContainer("iframe", innerViews);
    }

    static MarkupElementContainer ins(View... innerViews) {
        return new MarkupElementContainer("ins", innerViews);
    }

    static MarkupElementContainer kbd(View... innerViews) {
        return new MarkupElementContainer("kbd", innerViews);
    }

    static MarkupElementContainer label(View... innerViews) {
        return new MarkupElementContainer("label", innerViews);
    }

    static MarkupElementContainer legend(View... innerViews) {
        return new MarkupElementContainer("legend", innerViews);
    }

    static MarkupElementContainer li(View... innerViews) {
        return new MarkupElementContainer("li", innerViews);
    }

    static MarkupElementContainer main(View... innerViews) {
        return new MarkupElementContainer("main", innerViews);
    }

    static MarkupElementContainer map(View... innerViews) {
        return new MarkupElementContainer("map", innerViews);
    }

    static MarkupElementContainer mark(View... innerViews) {
        return new MarkupElementContainer("mark", innerViews);
    }

    static MarkupElementContainer meter(View... innerViews) {
        return new MarkupElementContainer("meter", innerViews);
    }

    static MarkupElementContainer nav(View... innerViews) {
        return new MarkupElementContainer("nav", innerViews);
    }

    static MarkupElementContainer noframes(View... innerViews) {
        return new MarkupElementContainer("noframes", innerViews);
    }

    static MarkupElementContainer noscript(View... innerViews) {
        return new MarkupElementContainer("noscript", innerViews);
    }

    static MarkupElementContainer object(View... innerViews) {
        return new MarkupElementContainer("object", innerViews);
    }

    static MarkupElementContainer ol(View... innerViews) {
        return new MarkupElementContainer("ol", innerViews);
    }

    static MarkupElementContainer optgroup(View... innerViews) {
        return new MarkupElementContainer("optgroup", innerViews);
    }

    static MarkupElementContainer option(View... innerViews) {
        return new MarkupElementContainer("option", innerViews);
    }

    static MarkupElementContainer output(View... innerViews) {
        return new MarkupElementContainer("output", innerViews);
    }

    static MarkupElementContainer p(View... innerViews) {
        return new MarkupElementContainer("p", innerViews);
    }

    static MarkupElementContainer picture(View... innerViews) {
        return new MarkupElementContainer("picture", innerViews);
    }

    static MarkupElementContainer pre(View... innerViews) {
        return new MarkupElementContainer("pre", innerViews);
    }

    static MarkupElementContainer progress(View... innerViews) {
        return new MarkupElementContainer("progress", innerViews);
    }

    static MarkupElementContainer q(View... innerViews) {
        return new MarkupElementContainer("q", innerViews);
    }

    static MarkupElementContainer rp(View... innerViews) {
        return new MarkupElementContainer("rp", innerViews);
    }

    static MarkupElementContainer rt(View... innerViews) {
        return new MarkupElementContainer("rt", innerViews);
    }

    static MarkupElementContainer ruby(View... innerViews) {
        return new MarkupElementContainer("ruby", innerViews);
    }

    static MarkupElementContainer s(View... innerViews) {
        return new MarkupElementContainer("s", innerViews);
    }

    static MarkupElementContainer samp(View... innerViews) {
        return new MarkupElementContainer("samp", innerViews);
    }

    static MarkupElementContainer script(View... innerViews) {
        return new MarkupElementContainer("script", innerViews);
    }

    static MarkupElementContainer section(View... innerViews) {
        return new MarkupElementContainer("section", innerViews);
    }

    static MarkupElementContainer select(View... innerViews) {
        return new MarkupElementContainer("select", innerViews);
    }

    static MarkupElementContainer small(View... innerViews) {
        return new MarkupElementContainer("small", innerViews);
    }

    static MarkupElementContainer span(View... innerViews) {
        return new MarkupElementContainer("span", innerViews);
    }

    static MarkupElementContainer strike(View... innerViews) {
        return new MarkupElementContainer("strike", innerViews);
    }

    static MarkupElementContainer strong(View... innerViews) {
        return new MarkupElementContainer("strong", innerViews);
    }

    static MarkupElementContainer style(View... innerViews) {
        return new MarkupElementContainer("style", innerViews);
    }

    static MarkupElementContainer sub(View... innerViews) {
        return new MarkupElementContainer("sub", innerViews);
    }

    static MarkupElementContainer summary(View... innerViews) {
        return new MarkupElementContainer("summary", innerViews);
    }

    static MarkupElementContainer sup(View... innerViews) {
        return new MarkupElementContainer("sup", innerViews);
    }

    static MarkupElementContainer svg(View... innerViews) {
        return new MarkupElementContainer("svg", innerViews);
    }

    static MarkupElementContainer table(View... innerViews) {
        return new MarkupElementContainer("table", innerViews);
    }

    static MarkupElementContainer tbody(View... innerViews) {
        return new MarkupElementContainer("tbody", innerViews);
    }

    static MarkupElementContainer td(View... innerViews) {
        return new MarkupElementContainer("td", innerViews);
    }

    static MarkupElementContainer template(View... innerViews) {
        return new MarkupElementContainer("template", innerViews);
    }

    static MarkupElementContainer textarea(View... innerViews) {
        return new MarkupElementContainer("textarea", innerViews);
    }

    static MarkupElementContainer tfoot(View... innerViews) {
        return new MarkupElementContainer("tfoot", innerViews);
    }

    static MarkupElementContainer th(View... innerViews) {
        return new MarkupElementContainer("th", innerViews);
    }

    static MarkupElementContainer thead(View... innerViews) {
        return new MarkupElementContainer("thead", innerViews);
    }

    static MarkupElementContainer time(View... innerViews) {
        return new MarkupElementContainer("time", innerViews);
    }

    static MarkupElementContainer title(View... innerViews) {
        return new MarkupElementContainer("title", innerViews);
    }

    static MarkupElementContainer tr(View... innerViews) {
        return new MarkupElementContainer("tr", innerViews);
    }

    static MarkupElementContainer tt(View... innerViews) {
        return new MarkupElementContainer("tt", innerViews);
    }

    static MarkupElementContainer u(View... innerViews) {
        return new MarkupElementContainer("u", innerViews);
    }

    static MarkupElementContainer ul(View... innerViews) {
        return new MarkupElementContainer("ul", innerViews);
    }

    static MarkupElementContainer var(View... innerViews) {
        return new MarkupElementContainer("var", innerViews);
    }

    static MarkupElementContainer video(View... innerViews) {
        return new MarkupElementContainer("video", innerViews);
    }

}
