package org.fluentness.flow.component.view;

interface HtmlFunctionsContainerView {

    default MarkupElementContainer a(View... innerViews) {
        return new MarkupElementContainer("a", innerViews);
    }

    default MarkupElementContainer abbr(View... innerViews) {
        return new MarkupElementContainer("abbr", innerViews);
    }

    default MarkupElementContainer acronym(View... innerViews) {
        return new MarkupElementContainer("acronym", innerViews);
    }

    default MarkupElementContainer address(View... innerViews) {
        return new MarkupElementContainer("address", innerViews);
    }

    default MarkupElementContainer applet(View... innerViews) {
        return new MarkupElementContainer("applet", innerViews);
    }

    default MarkupElementContainer article(View... innerViews) {
        return new MarkupElementContainer("article", innerViews);
    }

    default MarkupElementContainer aside(View... innerViews) {
        return new MarkupElementContainer("aside", innerViews);
    }

    default MarkupElementContainer audio(View... innerViews) {
        return new MarkupElementContainer("audio", innerViews);
    }

    default MarkupElementContainer b(View... innerViews) {
        return new MarkupElementContainer("b", innerViews);
    }

    default MarkupElementContainer basefont(View... innerViews) {
        return new MarkupElementContainer("basefont", innerViews);
    }

    default MarkupElementContainer bdi(View... innerViews) {
        return new MarkupElementContainer("bdi", innerViews);
    }

    default MarkupElementContainer bdo(View... innerViews) {
        return new MarkupElementContainer("bdo", innerViews);
    }

    default MarkupElementContainer big(View... innerViews) {
        return new MarkupElementContainer("big", innerViews);
    }

    default MarkupElementContainer blockquote(View... innerViews) {
        return new MarkupElementContainer("blockquote", innerViews);
    }

    default MarkupElementContainer body(View... innerViews) {
        return new MarkupElementContainer("body", innerViews);
    }

    default MarkupElementContainer button(View... innerViews) {
        return new MarkupElementContainer("button", innerViews);
    }

    default MarkupElementContainer canvas(View... innerViews) {
        return new MarkupElementContainer("canvas", innerViews);
    }

    default MarkupElementContainer caption(View... innerViews) {
        return new MarkupElementContainer("caption", innerViews);
    }

    default MarkupElementContainer center(View... innerViews) {
        return new MarkupElementContainer("center", innerViews);
    }

    default MarkupElementContainer cite(View... innerViews) {
        return new MarkupElementContainer("cite", innerViews);
    }

    default MarkupElementContainer code(View... innerViews) {
        return new MarkupElementContainer("code", innerViews);
    }

    default MarkupElementContainer colgroup(View... innerViews) {
        return new MarkupElementContainer("colgroup", innerViews);
    }

    default MarkupElementContainer data(View... innerViews) {
        return new MarkupElementContainer("data", innerViews);
    }

    default MarkupElementContainer datalist(View... innerViews) {
        return new MarkupElementContainer("datalist", innerViews);
    }

    default MarkupElementContainer dd(View... innerViews) {
        return new MarkupElementContainer("dd", innerViews);
    }

    default MarkupElementContainer del(View... innerViews) {
        return new MarkupElementContainer("del", innerViews);
    }

    default MarkupElementContainer details(View... innerViews) {
        return new MarkupElementContainer("details", innerViews);
    }

    default MarkupElementContainer dfn(View... innerViews) {
        return new MarkupElementContainer("dfn", innerViews);
    }

    default MarkupElementContainer dialog(View... innerViews) {
        return new MarkupElementContainer("dialog", innerViews);
    }

    default MarkupElementContainer dir(View... innerViews) {
        return new MarkupElementContainer("dir", innerViews);
    }

    default MarkupElementContainer div(View... innerViews) {
        return new MarkupElementContainer("div", innerViews);
    }

    default MarkupElementContainer dl(View... innerViews) {
        return new MarkupElementContainer("dl", innerViews);
    }

    default MarkupElementContainer dt(View... innerViews) {
        return new MarkupElementContainer("dt", innerViews);
    }

    default MarkupElementContainer em(View... innerViews) {
        return new MarkupElementContainer("em", innerViews);
    }

    default MarkupElementContainer fieldset(View... innerViews) {
        return new MarkupElementContainer("fieldset", innerViews);
    }

    default MarkupElementContainer figcaption(View... innerViews) {
        return new MarkupElementContainer("figcaption", innerViews);
    }

    default MarkupElementContainer figure(View... innerViews) {
        return new MarkupElementContainer("figure", innerViews);
    }

    default MarkupElementContainer font(View... innerViews) {
        return new MarkupElementContainer("font", innerViews);
    }

    default MarkupElementContainer footer(View... innerViews) {
        return new MarkupElementContainer("footer", innerViews);
    }

    default MarkupElementContainer form(View... innerViews) {
        return new MarkupElementContainer("form", innerViews);
    }

    default MarkupElementContainer frame(View... innerViews) {
        return new MarkupElementContainer("frame", innerViews);
    }

    default MarkupElementContainer frameset(View... innerViews) {
        return new MarkupElementContainer("frameset", innerViews);
    }

    default MarkupElementContainer h1(View... innerViews) {
        return new MarkupElementContainer("h1", innerViews);
    }

    default MarkupElementContainer h2(View... innerViews) {
        return new MarkupElementContainer("h2", innerViews);
    }

    default MarkupElementContainer h3(View... innerViews) {
        return new MarkupElementContainer("h3", innerViews);
    }

    default MarkupElementContainer h4(View... innerViews) {
        return new MarkupElementContainer("h4", innerViews);
    }

    default MarkupElementContainer h5(View... innerViews) {
        return new MarkupElementContainer("h5", innerViews);
    }

    default MarkupElementContainer h6(View... innerViews) {
        return new MarkupElementContainer("h6", innerViews);
    }

    default MarkupElementContainer head(View... innerViews) {
        return new MarkupElementContainer("head", innerViews);
    }

    default MarkupElementContainer header(View... innerViews) {
        return new MarkupElementContainer("header", innerViews);
    }

    default MarkupElementContainer html(View... innerViews) {
        return (MarkupElementContainer) new MarkupElementContainer("html", innerViews)
            .precededBy(new MarkupElementEmpty("!doctype", html -> null));
    }

    default MarkupElementContainer i(View... innerViews) {
        return new MarkupElementContainer("i", innerViews);
    }

    default MarkupElementContainer iframe(View... innerViews) {
        return new MarkupElementContainer("iframe", innerViews);
    }

    default MarkupElementContainer ins(View... innerViews) {
        return new MarkupElementContainer("ins", innerViews);
    }

    default MarkupElementContainer kbd(View... innerViews) {
        return new MarkupElementContainer("kbd", innerViews);
    }

    default MarkupElementContainer label(View... innerViews) {
        return new MarkupElementContainer("label", innerViews);
    }

    default MarkupElementContainer legend(View... innerViews) {
        return new MarkupElementContainer("legend", innerViews);
    }

    default MarkupElementContainer li(View... innerViews) {
        return new MarkupElementContainer("li", innerViews);
    }

    default MarkupElementContainer main(View... innerViews) {
        return new MarkupElementContainer("main", innerViews);
    }

    default MarkupElementContainer map(View... innerViews) {
        return new MarkupElementContainer("map", innerViews);
    }

    default MarkupElementContainer mark(View... innerViews) {
        return new MarkupElementContainer("mark", innerViews);
    }

    default MarkupElementContainer meter(View... innerViews) {
        return new MarkupElementContainer("meter", innerViews);
    }

    default MarkupElementContainer nav(View... innerViews) {
        return new MarkupElementContainer("nav", innerViews);
    }

    default MarkupElementContainer noframes(View... innerViews) {
        return new MarkupElementContainer("noframes", innerViews);
    }

    default MarkupElementContainer noscript(View... innerViews) {
        return new MarkupElementContainer("noscript", innerViews);
    }

    default MarkupElementContainer object(View... innerViews) {
        return new MarkupElementContainer("object", innerViews);
    }

    default MarkupElementContainer ol(View... innerViews) {
        return new MarkupElementContainer("ol", innerViews);
    }

    default MarkupElementContainer optgroup(View... innerViews) {
        return new MarkupElementContainer("optgroup", innerViews);
    }

    default MarkupElementContainer option(View... innerViews) {
        return new MarkupElementContainer("option", innerViews);
    }

    default MarkupElementContainer output(View... innerViews) {
        return new MarkupElementContainer("output", innerViews);
    }

    default MarkupElementContainer p(View... innerViews) {
        return new MarkupElementContainer("p", innerViews);
    }

    default MarkupElementContainer picture(View... innerViews) {
        return new MarkupElementContainer("picture", innerViews);
    }

    default MarkupElementContainer pre(View... innerViews) {
        return new MarkupElementContainer("pre", innerViews);
    }

    default MarkupElementContainer progress(View... innerViews) {
        return new MarkupElementContainer("progress", innerViews);
    }

    default MarkupElementContainer q(View... innerViews) {
        return new MarkupElementContainer("q", innerViews);
    }

    default MarkupElementContainer rp(View... innerViews) {
        return new MarkupElementContainer("rp", innerViews);
    }

    default MarkupElementContainer rt(View... innerViews) {
        return new MarkupElementContainer("rt", innerViews);
    }

    default MarkupElementContainer ruby(View... innerViews) {
        return new MarkupElementContainer("ruby", innerViews);
    }

    default MarkupElementContainer s(View... innerViews) {
        return new MarkupElementContainer("s", innerViews);
    }

    default MarkupElementContainer samp(View... innerViews) {
        return new MarkupElementContainer("samp", innerViews);
    }

    default MarkupElementContainer script(View... innerViews) {
        return new MarkupElementContainer("script", innerViews);
    }

    default MarkupElementContainer section(View... innerViews) {
        return new MarkupElementContainer("section", innerViews);
    }

    default MarkupElementContainer select(View... innerViews) {
        return new MarkupElementContainer("select", innerViews);
    }

    default MarkupElementContainer small(View... innerViews) {
        return new MarkupElementContainer("small", innerViews);
    }

    default MarkupElementContainer span(View... innerViews) {
        return new MarkupElementContainer("span", innerViews);
    }

    default MarkupElementContainer strike(View... innerViews) {
        return new MarkupElementContainer("strike", innerViews);
    }

    default MarkupElementContainer strong(View... innerViews) {
        return new MarkupElementContainer("strong", innerViews);
    }

    default MarkupElementContainer style(View... innerViews) {
        return new MarkupElementContainer("style", innerViews);
    }

    default MarkupElementContainer sub(View... innerViews) {
        return new MarkupElementContainer("sub", innerViews);
    }

    default MarkupElementContainer summary(View... innerViews) {
        return new MarkupElementContainer("summary", innerViews);
    }

    default MarkupElementContainer sup(View... innerViews) {
        return new MarkupElementContainer("sup", innerViews);
    }

    default MarkupElementContainer svg(View... innerViews) {
        return new MarkupElementContainer("svg", innerViews);
    }

    default MarkupElementContainer table(View... innerViews) {
        return new MarkupElementContainer("table", innerViews);
    }

    default MarkupElementContainer tbody(View... innerViews) {
        return new MarkupElementContainer("tbody", innerViews);
    }

    default MarkupElementContainer td(View... innerViews) {
        return new MarkupElementContainer("td", innerViews);
    }

    default MarkupElementContainer template(View... innerViews) {
        return new MarkupElementContainer("template", innerViews);
    }

    default MarkupElementContainer textarea(View... innerViews) {
        return new MarkupElementContainer("textarea", innerViews);
    }

    default MarkupElementContainer tfoot(View... innerViews) {
        return new MarkupElementContainer("tfoot", innerViews);
    }

    default MarkupElementContainer th(View... innerViews) {
        return new MarkupElementContainer("th", innerViews);
    }

    default MarkupElementContainer thead(View... innerViews) {
        return new MarkupElementContainer("thead", innerViews);
    }

    default MarkupElementContainer time(View... innerViews) {
        return new MarkupElementContainer("time", innerViews);
    }

    default MarkupElementContainer title(View... innerViews) {
        return new MarkupElementContainer("title", innerViews);
    }

    default MarkupElementContainer tr(View... innerViews) {
        return new MarkupElementContainer("tr", innerViews);
    }

    default MarkupElementContainer tt(View... innerViews) {
        return new MarkupElementContainer("tt", innerViews);
    }

    default MarkupElementContainer u(View... innerViews) {
        return new MarkupElementContainer("u", innerViews);
    }

    default MarkupElementContainer ul(View... innerViews) {
        return new MarkupElementContainer("ul", innerViews);
    }

    default MarkupElementContainer var(View... innerViews) {
        return new MarkupElementContainer("var", innerViews);
    }

    default MarkupElementContainer video(View... innerViews) {
        return new MarkupElementContainer("video", innerViews);
    }

}
