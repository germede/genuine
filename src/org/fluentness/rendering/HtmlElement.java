package org.fluentness.rendering;

public interface HtmlElement {

    // empty

    default Renderable area(CharSequence... content) {
        return new MarkupElement("area", content, false);
    }

    default Renderable base(CharSequence... content) {
        return new MarkupElement("base", content, false);
    }

    default Renderable br(CharSequence... content) {
        return new MarkupElement("br", content, false);
    }

    default Renderable col(CharSequence... content) {
        return new MarkupElement("col", content, false);
    }

    default Renderable embed(CharSequence... content) {
        return new MarkupElement("embed", content, false);
    }

    default Renderable hr(CharSequence... content) {
        return new MarkupElement("hr", content, false);
    }

    default Renderable img(CharSequence... content) {
        return new MarkupElement("img", content, false);
    }

    default Renderable input(CharSequence... content) {
        return new MarkupElement("input", content, false);
    }

    default Renderable link(CharSequence... content) {
        return new MarkupElement("link", content, false);
    }

    default Renderable meta(CharSequence... content) {
        return new MarkupElement("meta", content, false);
    }

    default Renderable param(CharSequence... content) {
        return new MarkupElement("param", content, false);
    }

    default Renderable source(CharSequence... content) {
        return new MarkupElement("source", content, false);
    }

    default Renderable track(CharSequence... content) {
        return new MarkupElement("track", content, false);
    }

    default Renderable wbr(CharSequence... content) {
        return new MarkupElement("wbr", content, false);
    }

    // container

    default Renderable doctype(CharSequence... content) {
        return new MarkupElement("doctype", content, true);
    }

    default Renderable a(CharSequence... content) {
        return new MarkupElement("a", content, true);
    }

    default Renderable abbr(CharSequence... content) {
        return new MarkupElement("abbr", content, true);
    }

    default Renderable acronym(CharSequence... content) {
        return new MarkupElement("acronym", content, true);
    }

    default Renderable address(CharSequence... content) {
        return new MarkupElement("address", content, true);
    }

    default Renderable applet(CharSequence... content) {
        return new MarkupElement("applet", content, true);
    }

    default Renderable article(CharSequence... content) {
        return new MarkupElement("article", content, true);
    }

    default Renderable aside(CharSequence... content) {
        return new MarkupElement("aside", content, true);
    }

    default Renderable audio(CharSequence... content) {
        return new MarkupElement("audio", content, true);
    }

    default Renderable b(CharSequence... content) {
        return new MarkupElement("b", content, true);
    }

    default Renderable basefont(CharSequence... content) {
        return new MarkupElement("basefont", content, true);
    }

    default Renderable bdi(CharSequence... content) {
        return new MarkupElement("bdi", content, true);
    }

    default Renderable bdo(CharSequence... content) {
        return new MarkupElement("bdo", content, true);
    }

    default Renderable big(CharSequence... content) {
        return new MarkupElement("big", content, true);
    }

    default Renderable blockquote(CharSequence... content) {
        return new MarkupElement("blockquote", content, true);
    }

    default Renderable body(CharSequence... content) {
        return new MarkupElement("body", content, true);
    }

    default Renderable button(CharSequence... content) {
        return new MarkupElement("button", content, true);
    }

    default Renderable canvas(CharSequence... content) {
        return new MarkupElement("canvas", content, true);
    }

    default Renderable caption(CharSequence... content) {
        return new MarkupElement("caption", content, true);
    }

    default Renderable center(CharSequence... content) {
        return new MarkupElement("center", content, true);
    }

    default Renderable cite(CharSequence... content) {
        return new MarkupElement("cite", content, true);
    }

    default Renderable code(CharSequence... content) {
        return new MarkupElement("code", content, true);
    }

    default Renderable colgroup(CharSequence... content) {
        return new MarkupElement("colgroup", content, true);
    }

    default Renderable data(CharSequence... content) {
        return new MarkupElement("data", content, true);
    }

    default Renderable datalist(CharSequence... content) {
        return new MarkupElement("datalist", content, true);
    }

    default Renderable dd(CharSequence... content) {
        return new MarkupElement("dd", content, true);
    }

    default Renderable del(CharSequence... content) {
        return new MarkupElement("del", content, true);
    }

    default Renderable details(CharSequence... content) {
        return new MarkupElement("details", content, true);
    }

    default Renderable dfn(CharSequence... content) {
        return new MarkupElement("dfn", content, true);
    }

    default Renderable dialog(CharSequence... content) {
        return new MarkupElement("dialog", content, true);
    }

    default Renderable dir(CharSequence... content) {
        return new MarkupElement("dir", content, true);
    }

    default Renderable div(CharSequence... content) {
        return new MarkupElement("div", content, true);
    }

    default Renderable dl(CharSequence... content) {
        return new MarkupElement("dl", content, true);
    }

    default Renderable dt(CharSequence... content) {
        return new MarkupElement("dt", content, true);
    }

    default Renderable em(CharSequence... content) {
        return new MarkupElement("em", content, true);
    }

    default Renderable fieldset(CharSequence... content) {
        return new MarkupElement("fieldset", content, true);
    }

    default Renderable figcaption(CharSequence... content) {
        return new MarkupElement("figcaption", content, true);
    }

    default Renderable figure(CharSequence... content) {
        return new MarkupElement("figure", content, true);
    }

    default Renderable font(CharSequence... content) {
        return new MarkupElement("font", content, true);
    }

    default Renderable footer(CharSequence... content) {
        return new MarkupElement("footer", content, true);
    }

    default Renderable form(CharSequence... content) {
        return new MarkupElement("form", content, true);
    }

    default Renderable frame(CharSequence... content) {
        return new MarkupElement("frame", content, true);
    }

    default Renderable frameset(CharSequence... content) {
        return new MarkupElement("frameset", content, true);
    }

    default Renderable h1(CharSequence... content) {
        return new MarkupElement("h1", content, true);
    }

    default Renderable head(CharSequence... content) {
        return new MarkupElement("head", content, true);
    }

    default Renderable header(CharSequence... content) {
        return new MarkupElement("header", content, true);
    }

    default Renderable html(CharSequence... content) {
        return new MarkupElement("html", content, true);
    }

    default Renderable i(CharSequence... content) {
        return new MarkupElement("i", content, true);
    }

    default Renderable iframe(CharSequence... content) {
        return new MarkupElement("iframe", content, true);
    }

    default Renderable ins(CharSequence... content) {
        return new MarkupElement("ins", content, true);
    }

    default Renderable kbd(CharSequence... content) {
        return new MarkupElement("kbd", content, true);
    }

    default Renderable label(CharSequence... content) {
        return new MarkupElement("label", content, true);
    }

    default Renderable legend(CharSequence... content) {
        return new MarkupElement("legend", content, true);
    }

    default Renderable li(CharSequence... content) {
        return new MarkupElement("li", content, true);
    }

    default Renderable main(CharSequence... content) {
        return new MarkupElement("main", content, true);
    }

    default Renderable map(CharSequence... content) {
        return new MarkupElement("map", content, true);
    }

    default Renderable mark(CharSequence... content) {
        return new MarkupElement("mark", content, true);
    }

    default Renderable meter(CharSequence... content) {
        return new MarkupElement("meter", content, true);
    }

    default Renderable nav(CharSequence... content) {
        return new MarkupElement("nav", content, true);
    }

    default Renderable noframes(CharSequence... content) {
        return new MarkupElement("noframes", content, true);
    }

    default Renderable noscript(CharSequence... content) {
        return new MarkupElement("noscript", content, true);
    }

    default Renderable object(CharSequence... content) {
        return new MarkupElement("object", content, true);
    }

    default Renderable ol(CharSequence... content) {
        return new MarkupElement("ol", content, true);
    }

    default Renderable optgroup(CharSequence... content) {
        return new MarkupElement("optgroup", content, true);
    }

    default Renderable option(CharSequence... content) {
        return new MarkupElement("option", content, true);
    }

    default Renderable output(CharSequence... content) {
        return new MarkupElement("output", content, true);
    }

    default Renderable p(CharSequence... content) {
        return new MarkupElement("p", content, true);
    }

    default Renderable picture(CharSequence... content) {
        return new MarkupElement("picture", content, true);
    }

    default Renderable pre(CharSequence... content) {
        return new MarkupElement("pre", content, true);
    }

    default Renderable progress(CharSequence... content) {
        return new MarkupElement("progress", content, true);
    }

    default Renderable q(CharSequence... content) {
        return new MarkupElement("q", content, true);
    }

    default Renderable rp(CharSequence... content) {
        return new MarkupElement("rp", content, true);
    }

    default Renderable rt(CharSequence... content) {
        return new MarkupElement("rt", content, true);
    }

    default Renderable ruby(CharSequence... content) {
        return new MarkupElement("ruby", content, true);
    }

    default Renderable s(CharSequence... content) {
        return new MarkupElement("s", content, true);
    }

    default Renderable samp(CharSequence... content) {
        return new MarkupElement("samp", content, true);
    }

    default Renderable script(CharSequence... content) {
        return new MarkupElement("script", content, true);
    }

    default Renderable section(CharSequence... content) {
        return new MarkupElement("section", content, true);
    }

    default Renderable select(CharSequence... content) {
        return new MarkupElement("select", content, true);
    }

    default Renderable small(CharSequence... content) {
        return new MarkupElement("small", content, true);
    }

    default Renderable span(CharSequence... content) {
        return new MarkupElement("span", content, true);
    }

    default Renderable strike(CharSequence... content) {
        return new MarkupElement("strike", content, true);
    }

    default Renderable strong(CharSequence... content) {
        return new MarkupElement("strong", content, true);
    }

    default Renderable style(CharSequence... content) {
        return new MarkupElement("style", content, true);
    }

    default Renderable sub(CharSequence... content) {
        return new MarkupElement("sub", content, true);
    }

    default Renderable summary(CharSequence... content) {
        return new MarkupElement("summary", content, true);
    }

    default Renderable sup(CharSequence... content) {
        return new MarkupElement("sup", content, true);
    }

    default Renderable svg(CharSequence... content) {
        return new MarkupElement("svg", content, true);
    }

    default Renderable table(CharSequence... content) {
        return new MarkupElement("table", content, true);
    }

    default Renderable tbody(CharSequence... content) {
        return new MarkupElement("tbody", content, true);
    }

    default Renderable td(CharSequence... content) {
        return new MarkupElement("td", content, true);
    }

    default Renderable template(CharSequence... content) {
        return new MarkupElement("template", content, true);
    }

    default Renderable textarea(CharSequence... content) {
        return new MarkupElement("textarea", content, true);
    }

    default Renderable tfoot(CharSequence... content) {
        return new MarkupElement("tfoot", content, true);
    }

    default Renderable th(CharSequence... content) {
        return new MarkupElement("th", content, true);
    }

    default Renderable thead(CharSequence... content) {
        return new MarkupElement("thead", content, true);
    }

    default Renderable time(CharSequence... content) {
        return new MarkupElement("time", content, true);
    }

    default Renderable title(CharSequence... content) {
        return new MarkupElement("title", content, true);
    }

    default Renderable tr(CharSequence... content) {
        return new MarkupElement("tr", content, true);
    }

    default Renderable tt(CharSequence... content) {
        return new MarkupElement("tt", content, true);
    }

    default Renderable u(CharSequence... content) {
        return new MarkupElement("u", content, true);
    }

    default Renderable ul(CharSequence... content) {
        return new MarkupElement("ul", content, true);
    }

    default Renderable var(CharSequence... content) {
        return new MarkupElement("var", content, true);
    }

    default Renderable video(CharSequence... content) {
        return new MarkupElement("video", content, true);
    }
    }
