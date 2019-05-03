package org.fluentness.rendering;

public interface HtmlElement {

    // empty

    default Renderable area(CharSequence... with) {
        return new MarkupElement("area", with, false);
    }

    default Renderable base(CharSequence... with) {
        return new MarkupElement("base", with, false);
    }

    default Renderable br(CharSequence... with) {
        return new MarkupElement("br", with, false);
    }

    default Renderable col(CharSequence... with) {
        return new MarkupElement("col", with, false);
    }

    default Renderable embed(CharSequence... with) {
        return new MarkupElement("embed", with, false);
    }

    default Renderable hr(CharSequence... with) {
        return new MarkupElement("hr", with, false);
    }

    default Renderable img(CharSequence... with) {
        return new MarkupElement("img", with, false);
    }

    default Renderable input(CharSequence... with) {
        return new MarkupElement("input", with, false);
    }

    default Renderable link(CharSequence... with) {
        return new MarkupElement("link", with, false);
    }

    default Renderable meta(CharSequence... with) {
        return new MarkupElement("meta", with, false);
    }

    default Renderable param(CharSequence... with) {
        return new MarkupElement("param", with, false);
    }

    default Renderable source(CharSequence... with) {
        return new MarkupElement("source", with, false);
    }

    default Renderable track(CharSequence... with) {
        return new MarkupElement("track", with, false);
    }

    default Renderable wbr(CharSequence... with) {
        return new MarkupElement("wbr", with, false);
    }

    // container

    default Renderable doctype(CharSequence... with) {
        return new MarkupElement("doctype", with, true);
    }

    default Renderable a(CharSequence... with) {
        return new MarkupElement("a", with, true);
    }

    default Renderable abbr(CharSequence... with) {
        return new MarkupElement("abbr", with, true);
    }

    default Renderable acronym(CharSequence... with) {
        return new MarkupElement("acronym", with, true);
    }

    default Renderable address(CharSequence... with) {
        return new MarkupElement("address", with, true);
    }

    default Renderable applet(CharSequence... with) {
        return new MarkupElement("applet", with, true);
    }

    default Renderable article(CharSequence... with) {
        return new MarkupElement("article", with, true);
    }

    default Renderable aside(CharSequence... with) {
        return new MarkupElement("aside", with, true);
    }

    default Renderable audio(CharSequence... with) {
        return new MarkupElement("audio", with, true);
    }

    default Renderable b(CharSequence... with) {
        return new MarkupElement("b", with, true);
    }

    default Renderable basefont(CharSequence... with) {
        return new MarkupElement("basefont", with, true);
    }

    default Renderable bdi(CharSequence... with) {
        return new MarkupElement("bdi", with, true);
    }

    default Renderable bdo(CharSequence... with) {
        return new MarkupElement("bdo", with, true);
    }

    default Renderable big(CharSequence... with) {
        return new MarkupElement("big", with, true);
    }

    default Renderable blockquote(CharSequence... with) {
        return new MarkupElement("blockquote", with, true);
    }

    default Renderable body(CharSequence... with) {
        return new MarkupElement("body", with, true);
    }

    default Renderable button(CharSequence... with) {
        return new MarkupElement("button", with, true);
    }

    default Renderable canvas(CharSequence... with) {
        return new MarkupElement("canvas", with, true);
    }

    default Renderable caption(CharSequence... with) {
        return new MarkupElement("caption", with, true);
    }

    default Renderable center(CharSequence... with) {
        return new MarkupElement("center", with, true);
    }

    default Renderable cite(CharSequence... with) {
        return new MarkupElement("cite", with, true);
    }

    default Renderable code(CharSequence... with) {
        return new MarkupElement("code", with, true);
    }

    default Renderable colgroup(CharSequence... with) {
        return new MarkupElement("colgroup", with, true);
    }

    default Renderable data(CharSequence... with) {
        return new MarkupElement("data", with, true);
    }

    default Renderable datalist(CharSequence... with) {
        return new MarkupElement("datalist", with, true);
    }

    default Renderable dd(CharSequence... with) {
        return new MarkupElement("dd", with, true);
    }

    default Renderable del(CharSequence... with) {
        return new MarkupElement("del", with, true);
    }

    default Renderable details(CharSequence... with) {
        return new MarkupElement("details", with, true);
    }

    default Renderable dfn(CharSequence... with) {
        return new MarkupElement("dfn", with, true);
    }

    default Renderable dialog(CharSequence... with) {
        return new MarkupElement("dialog", with, true);
    }

    default Renderable dir(CharSequence... with) {
        return new MarkupElement("dir", with, true);
    }

    default Renderable div(CharSequence... with) {
        return new MarkupElement("div", with, true);
    }

    default Renderable dl(CharSequence... with) {
        return new MarkupElement("dl", with, true);
    }

    default Renderable dt(CharSequence... with) {
        return new MarkupElement("dt", with, true);
    }

    default Renderable em(CharSequence... with) {
        return new MarkupElement("em", with, true);
    }

    default Renderable fieldset(CharSequence... with) {
        return new MarkupElement("fieldset", with, true);
    }

    default Renderable figcaption(CharSequence... with) {
        return new MarkupElement("figcaption", with, true);
    }

    default Renderable figure(CharSequence... with) {
        return new MarkupElement("figure", with, true);
    }

    default Renderable font(CharSequence... with) {
        return new MarkupElement("font", with, true);
    }

    default Renderable footer(CharSequence... with) {
        return new MarkupElement("footer", with, true);
    }

    default Renderable form(CharSequence... with) {
        return new MarkupElement("form", with, true);
    }

    default Renderable frame(CharSequence... with) {
        return new MarkupElement("frame", with, true);
    }

    default Renderable frameset(CharSequence... with) {
        return new MarkupElement("frameset", with, true);
    }

    default Renderable h1(CharSequence... with) {
        return new MarkupElement("h1", with, true);
    }

    default Renderable head(CharSequence... with) {
        return new MarkupElement("head", with, true);
    }

    default Renderable header(CharSequence... with) {
        return new MarkupElement("header", with, true);
    }

    default Renderable html(CharSequence... with) {
        return new MarkupElement("html", with, true);
    }

    default Renderable i(CharSequence... with) {
        return new MarkupElement("i", with, true);
    }

    default Renderable iframe(CharSequence... with) {
        return new MarkupElement("iframe", with, true);
    }

    default Renderable ins(CharSequence... with) {
        return new MarkupElement("ins", with, true);
    }

    default Renderable kbd(CharSequence... with) {
        return new MarkupElement("kbd", with, true);
    }

    default Renderable label(CharSequence... with) {
        return new MarkupElement("label", with, true);
    }

    default Renderable legend(CharSequence... with) {
        return new MarkupElement("legend", with, true);
    }

    default Renderable li(CharSequence... with) {
        return new MarkupElement("li", with, true);
    }

    default Renderable main(CharSequence... with) {
        return new MarkupElement("main", with, true);
    }

    default Renderable map(CharSequence... with) {
        return new MarkupElement("map", with, true);
    }

    default Renderable mark(CharSequence... with) {
        return new MarkupElement("mark", with, true);
    }

    default Renderable meter(CharSequence... with) {
        return new MarkupElement("meter", with, true);
    }

    default Renderable nav(CharSequence... with) {
        return new MarkupElement("nav", with, true);
    }

    default Renderable noframes(CharSequence... with) {
        return new MarkupElement("noframes", with, true);
    }

    default Renderable noscript(CharSequence... with) {
        return new MarkupElement("noscript", with, true);
    }

    default Renderable object(CharSequence... with) {
        return new MarkupElement("object", with, true);
    }

    default Renderable ol(CharSequence... with) {
        return new MarkupElement("ol", with, true);
    }

    default Renderable optgroup(CharSequence... with) {
        return new MarkupElement("optgroup", with, true);
    }

    default Renderable option(CharSequence... with) {
        return new MarkupElement("option", with, true);
    }

    default Renderable output(CharSequence... with) {
        return new MarkupElement("output", with, true);
    }

    default Renderable p(CharSequence... with) {
        return new MarkupElement("p", with, true);
    }

    default Renderable picture(CharSequence... with) {
        return new MarkupElement("picture", with, true);
    }

    default Renderable pre(CharSequence... with) {
        return new MarkupElement("pre", with, true);
    }

    default Renderable progress(CharSequence... with) {
        return new MarkupElement("progress", with, true);
    }

    default Renderable q(CharSequence... with) {
        return new MarkupElement("q", with, true);
    }

    default Renderable rp(CharSequence... with) {
        return new MarkupElement("rp", with, true);
    }

    default Renderable rt(CharSequence... with) {
        return new MarkupElement("rt", with, true);
    }

    default Renderable ruby(CharSequence... with) {
        return new MarkupElement("ruby", with, true);
    }

    default Renderable s(CharSequence... with) {
        return new MarkupElement("s", with, true);
    }

    default Renderable samp(CharSequence... with) {
        return new MarkupElement("samp", with, true);
    }

    default Renderable script(CharSequence... with) {
        return new MarkupElement("script", with, true);
    }

    default Renderable section(CharSequence... with) {
        return new MarkupElement("section", with, true);
    }

    default Renderable select(CharSequence... with) {
        return new MarkupElement("select", with, true);
    }

    default Renderable small(CharSequence... with) {
        return new MarkupElement("small", with, true);
    }

    default Renderable span(CharSequence... with) {
        return new MarkupElement("span", with, true);
    }

    default Renderable strike(CharSequence... with) {
        return new MarkupElement("strike", with, true);
    }

    default Renderable strong(CharSequence... with) {
        return new MarkupElement("strong", with, true);
    }

    default Renderable style(CharSequence... with) {
        return new MarkupElement("style", with, true);
    }

    default Renderable sub(CharSequence... with) {
        return new MarkupElement("sub", with, true);
    }

    default Renderable summary(CharSequence... with) {
        return new MarkupElement("summary", with, true);
    }

    default Renderable sup(CharSequence... with) {
        return new MarkupElement("sup", with, true);
    }

    default Renderable svg(CharSequence... with) {
        return new MarkupElement("svg", with, true);
    }

    default Renderable table(CharSequence... with) {
        return new MarkupElement("table", with, true);
    }

    default Renderable tbody(CharSequence... with) {
        return new MarkupElement("tbody", with, true);
    }

    default Renderable td(CharSequence... with) {
        return new MarkupElement("td", with, true);
    }

    default Renderable template(CharSequence... with) {
        return new MarkupElement("template", with, true);
    }

    default Renderable textarea(CharSequence... with) {
        return new MarkupElement("textarea", with, true);
    }

    default Renderable tfoot(CharSequence... with) {
        return new MarkupElement("tfoot", with, true);
    }

    default Renderable th(CharSequence... with) {
        return new MarkupElement("th", with, true);
    }

    default Renderable thead(CharSequence... with) {
        return new MarkupElement("thead", with, true);
    }

    default Renderable time(CharSequence... with) {
        return new MarkupElement("time", with, true);
    }

    default Renderable title(CharSequence... with) {
        return new MarkupElement("title", with, true);
    }

    default Renderable tr(CharSequence... with) {
        return new MarkupElement("tr", with, true);
    }

    default Renderable tt(CharSequence... with) {
        return new MarkupElement("tt", with, true);
    }

    default Renderable u(CharSequence... with) {
        return new MarkupElement("u", with, true);
    }

    default Renderable ul(CharSequence... with) {
        return new MarkupElement("ul", with, true);
    }

    default Renderable var(CharSequence... with) {
        return new MarkupElement("var", with, true);
    }

    default Renderable video(CharSequence... with) {
        return new MarkupElement("video", with, true);
    }
    }
