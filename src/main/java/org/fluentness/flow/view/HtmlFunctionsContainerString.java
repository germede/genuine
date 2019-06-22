package org.fluentness.flow.view;

interface HtmlFunctionsContainerString {

    default MarkupElementContainer a(String innerText) {
        return new MarkupElementContainer("a", innerText);
    }

    default MarkupElementContainer abbr(String innerText) {
        return new MarkupElementContainer("abbr", innerText);
    }

    default MarkupElementContainer acronym(String innerText) {
        return new MarkupElementContainer("acronym", innerText);
    }

    default MarkupElementContainer address(String innerText) {
        return new MarkupElementContainer("address", innerText);
    }

    default MarkupElementContainer applet(String innerText) {
        return new MarkupElementContainer("applet", innerText);
    }

    default MarkupElementContainer article(String innerText) {
        return new MarkupElementContainer("article", innerText);
    }

    default MarkupElementContainer aside(String innerText) {
        return new MarkupElementContainer("aside", innerText);
    }

    default MarkupElementContainer audio(String innerText) {
        return new MarkupElementContainer("audio", innerText);
    }

    default MarkupElementContainer b(String innerText) {
        return new MarkupElementContainer("b", innerText);
    }

    default MarkupElementContainer basefont(String innerText) {
        return new MarkupElementContainer("basefont", innerText);
    }

    default MarkupElementContainer bdi(String innerText) {
        return new MarkupElementContainer("bdi", innerText);
    }

    default MarkupElementContainer bdo(String innerText) {
        return new MarkupElementContainer("bdo", innerText);
    }

    default MarkupElementContainer big(String innerText) {
        return new MarkupElementContainer("big", innerText);
    }

    default MarkupElementContainer blockquote(String innerText) {
        return new MarkupElementContainer("blockquote", innerText);
    }

    default MarkupElementContainer body(String innerText) {
        return new MarkupElementContainer("body", innerText);
    }

    default MarkupElementContainer button(String innerText) {
        return new MarkupElementContainer("button", innerText);
    }

    default MarkupElementContainer canvas(String innerText) {
        return new MarkupElementContainer("canvas", innerText);
    }

    default MarkupElementContainer caption(String innerText) {
        return new MarkupElementContainer("caption", innerText);
    }

    default MarkupElementContainer center(String innerText) {
        return new MarkupElementContainer("center", innerText);
    }

    default MarkupElementContainer cite(String innerText) {
        return new MarkupElementContainer("cite", innerText);
    }

    default MarkupElementContainer code(String innerText) {
        return new MarkupElementContainer("code", innerText);
    }

    default MarkupElementContainer colgroup(String innerText) {
        return new MarkupElementContainer("colgroup", innerText);
    }

    default MarkupElementContainer data(String innerText) {
        return new MarkupElementContainer("data", innerText);
    }

    default MarkupElementContainer datalist(String innerText) {
        return new MarkupElementContainer("datalist", innerText);
    }

    default MarkupElementContainer dd(String innerText) {
        return new MarkupElementContainer("dd", innerText);
    }

    default MarkupElementContainer del(String innerText) {
        return new MarkupElementContainer("del", innerText);
    }

    default MarkupElementContainer details(String innerText) {
        return new MarkupElementContainer("details", innerText);
    }

    default MarkupElementContainer dfn(String innerText) {
        return new MarkupElementContainer("dfn", innerText);
    }

    default MarkupElementContainer dialog(String innerText) {
        return new MarkupElementContainer("dialog", innerText);
    }

    default MarkupElementContainer dir(String innerText) {
        return new MarkupElementContainer("dir", innerText);
    }

    default MarkupElementContainer div(String innerText) {
        return new MarkupElementContainer("div", innerText);
    }

    default MarkupElementContainer dl(String innerText) {
        return new MarkupElementContainer("dl", innerText);
    }

    default MarkupElementContainer dt(String innerText) {
        return new MarkupElementContainer("dt", innerText);
    }

    default MarkupElementContainer em(String innerText) {
        return new MarkupElementContainer("em", innerText);
    }

    default MarkupElementContainer fieldset(String innerText) {
        return new MarkupElementContainer("fieldset", innerText);
    }

    default MarkupElementContainer figcaption(String innerText) {
        return new MarkupElementContainer("figcaption", innerText);
    }

    default MarkupElementContainer figure(String innerText) {
        return new MarkupElementContainer("figure", innerText);
    }

    default MarkupElementContainer font(String innerText) {
        return new MarkupElementContainer("font", innerText);
    }

    default MarkupElementContainer footer(String innerText) {
        return new MarkupElementContainer("footer", innerText);
    }

    default MarkupElementContainer form(String innerText) {
        return new MarkupElementContainer("form", innerText);
    }

    default MarkupElementContainer frame(String innerText) {
        return new MarkupElementContainer("frame", innerText);
    }

    default MarkupElementContainer frameset(String innerText) {
        return new MarkupElementContainer("frameset", innerText);
    }

    default MarkupElementContainer h1(String innerText) {
        return new MarkupElementContainer("h1", innerText);
    }

    default MarkupElementContainer h2(String innerText) {
        return new MarkupElementContainer("h2", innerText);
    }

    default MarkupElementContainer h3(String innerText) {
        return new MarkupElementContainer("h3", innerText);
    }

    default MarkupElementContainer h4(String innerText) {
        return new MarkupElementContainer("h4", innerText);
    }

    default MarkupElementContainer h5(String innerText) {
        return new MarkupElementContainer("h5", innerText);
    }

    default MarkupElementContainer h6(String innerText) {
        return new MarkupElementContainer("h6", innerText);
    }

    default MarkupElementContainer head(String innerText) {
        return new MarkupElementContainer("head", innerText);
    }

    default MarkupElementContainer header(String innerText) {
        return new MarkupElementContainer("header", innerText);
    }

    default MarkupElementContainer html(String innerText) {
        return (MarkupElementContainer) new MarkupElementContainer("html", innerText)
            .precededBy(new MarkupElementEmpty("!doctype", html -> null));
    }

    default MarkupElementContainer i(String innerText) {
        return new MarkupElementContainer("i", innerText);
    }

    default MarkupElementContainer iframe(String innerText) {
        return new MarkupElementContainer("iframe", innerText);
    }

    default MarkupElementContainer ins(String innerText) {
        return new MarkupElementContainer("ins", innerText);
    }

    default MarkupElementContainer kbd(String innerText) {
        return new MarkupElementContainer("kbd", innerText);
    }

    default MarkupElementContainer label(String innerText) {
        return new MarkupElementContainer("label", innerText);
    }

    default MarkupElementContainer legend(String innerText) {
        return new MarkupElementContainer("legend", innerText);
    }

    default MarkupElementContainer li(String innerText) {
        return new MarkupElementContainer("li", innerText);
    }

    default MarkupElementContainer main(String innerText) {
        return new MarkupElementContainer("main", innerText);
    }

    default MarkupElementContainer map(String innerText) {
        return new MarkupElementContainer("map", innerText);
    }

    default MarkupElementContainer mark(String innerText) {
        return new MarkupElementContainer("mark", innerText);
    }

    default MarkupElementContainer meter(String innerText) {
        return new MarkupElementContainer("meter", innerText);
    }

    default MarkupElementContainer nav(String innerText) {
        return new MarkupElementContainer("nav", innerText);
    }

    default MarkupElementContainer noframes(String innerText) {
        return new MarkupElementContainer("noframes", innerText);
    }

    default MarkupElementContainer noscript(String innerText) {
        return new MarkupElementContainer("noscript", innerText);
    }

    default MarkupElementContainer object(String innerText) {
        return new MarkupElementContainer("object", innerText);
    }

    default MarkupElementContainer ol(String innerText) {
        return new MarkupElementContainer("ol", innerText);
    }

    default MarkupElementContainer optgroup(String innerText) {
        return new MarkupElementContainer("optgroup", innerText);
    }

    default MarkupElementContainer option(String innerText) {
        return new MarkupElementContainer("option", innerText);
    }

    default MarkupElementContainer output(String innerText) {
        return new MarkupElementContainer("output", innerText);
    }

    default MarkupElementContainer p(String innerText) {
        return new MarkupElementContainer("p", innerText);
    }

    default MarkupElementContainer picture(String innerText) {
        return new MarkupElementContainer("picture", innerText);
    }

    default MarkupElementContainer pre(String innerText) {
        return new MarkupElementContainer("pre", innerText);
    }

    default MarkupElementContainer progress(String innerText) {
        return new MarkupElementContainer("progress", innerText);
    }

    default MarkupElementContainer q(String innerText) {
        return new MarkupElementContainer("q", innerText);
    }

    default MarkupElementContainer rp(String innerText) {
        return new MarkupElementContainer("rp", innerText);
    }

    default MarkupElementContainer rt(String innerText) {
        return new MarkupElementContainer("rt", innerText);
    }

    default MarkupElementContainer ruby(String innerText) {
        return new MarkupElementContainer("ruby", innerText);
    }

    default MarkupElementContainer s(String innerText) {
        return new MarkupElementContainer("s", innerText);
    }

    default MarkupElementContainer samp(String innerText) {
        return new MarkupElementContainer("samp", innerText);
    }

    default MarkupElementContainer script(String innerText) {
        return new MarkupElementContainer("script", innerText);
    }

    default MarkupElementContainer section(String innerText) {
        return new MarkupElementContainer("section", innerText);
    }

    default MarkupElementContainer select(String innerText) {
        return new MarkupElementContainer("select", innerText);
    }

    default MarkupElementContainer small(String innerText) {
        return new MarkupElementContainer("small", innerText);
    }

    default MarkupElementContainer span(String innerText) {
        return new MarkupElementContainer("span", innerText);
    }

    default MarkupElementContainer strike(String innerText) {
        return new MarkupElementContainer("strike", innerText);
    }

    default MarkupElementContainer strong(String innerText) {
        return new MarkupElementContainer("strong", innerText);
    }

    default MarkupElementContainer style(String innerText) {
        return new MarkupElementContainer("style", innerText);
    }

    default MarkupElementContainer sub(String innerText) {
        return new MarkupElementContainer("sub", innerText);
    }

    default MarkupElementContainer summary(String innerText) {
        return new MarkupElementContainer("summary", innerText);
    }

    default MarkupElementContainer sup(String innerText) {
        return new MarkupElementContainer("sup", innerText);
    }

    default MarkupElementContainer svg(String innerText) {
        return new MarkupElementContainer("svg", innerText);
    }

    default MarkupElementContainer table(String innerText) {
        return new MarkupElementContainer("table", innerText);
    }

    default MarkupElementContainer tbody(String innerText) {
        return new MarkupElementContainer("tbody", innerText);
    }

    default MarkupElementContainer td(String innerText) {
        return new MarkupElementContainer("td", innerText);
    }

    default MarkupElementContainer template(String innerText) {
        return new MarkupElementContainer("template", innerText);
    }

    default MarkupElementContainer textarea(String innerText) {
        return new MarkupElementContainer("textarea", innerText);
    }

    default MarkupElementContainer tfoot(String innerText) {
        return new MarkupElementContainer("tfoot", innerText);
    }

    default MarkupElementContainer th(String innerText) {
        return new MarkupElementContainer("th", innerText);
    }

    default MarkupElementContainer thead(String innerText) {
        return new MarkupElementContainer("thead", innerText);
    }

    default MarkupElementContainer time(String innerText) {
        return new MarkupElementContainer("time", innerText);
    }

    default MarkupElementContainer title(String innerText) {
        return new MarkupElementContainer("title", innerText);
    }

    default MarkupElementContainer tr(String innerText) {
        return new MarkupElementContainer("tr", innerText);
    }

    default MarkupElementContainer tt(String innerText) {
        return new MarkupElementContainer("tt", innerText);
    }

    default MarkupElementContainer u(String innerText) {
        return new MarkupElementContainer("u", innerText);
    }

    default MarkupElementContainer ul(String innerText) {
        return new MarkupElementContainer("ul", innerText);
    }

    default MarkupElementContainer var(String innerText) {
        return new MarkupElementContainer("var", innerText);
    }

    default MarkupElementContainer video(String innerText) {
        return new MarkupElementContainer("video", innerText);
    }

}
