package org.fluentness.rendering;

import org.fluentness.common.NamedValue;

public interface HtmlFunctions extends MarkupFunctions {

    // helpers

    default Renderable includeCss(String href) {
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/resources/css/"+href);
    }

    // empty

    default Renderable area(NamedValue... attributes) {
        return new MarkupEmptyElement("area", attrs(attributes));
    }

    default Renderable base(NamedValue... attributes) {
        return new MarkupEmptyElement("base", attrs(attributes));
    }

    default Renderable br(NamedValue... attributes) {
        return new MarkupEmptyElement("br", attrs(attributes));
    }

    default Renderable col(NamedValue... attributes) {
        return new MarkupEmptyElement("col", attrs(attributes));
    }

    default Renderable embed(NamedValue... attributes) {
        return new MarkupEmptyElement("embed", attrs(attributes));
    }

    default Renderable hr(NamedValue... attributes) {
        return new MarkupEmptyElement("hr", attrs(attributes));
    }

    default Renderable img(NamedValue... attributes) {
        return new MarkupEmptyElement("img", attrs(attributes));
    }

    default Renderable input(NamedValue... attributes) {
        return new MarkupEmptyElement("input", attrs(attributes));
    }

    default Renderable link(NamedValue... attributes) {
        return new MarkupEmptyElement("link", attrs(attributes));
    }

    default Renderable meta(NamedValue... attributes) {
        return new MarkupEmptyElement("meta", attrs(attributes));
    }

    default Renderable param(NamedValue... attributes) {
        return new MarkupEmptyElement("param", attrs(attributes));
    }

    default Renderable source(NamedValue... attributes) {
        return new MarkupEmptyElement("source", attrs(attributes));
    }

    default Renderable track(NamedValue... attributes) {
        return new MarkupEmptyElement("track", attrs(attributes));
    }

    default Renderable wbr(NamedValue... attributes) {
        return new MarkupEmptyElement("wbr", attrs(attributes));
    }

    // container

    default Renderable a(CharSequence... content) {
        return new MarkupEmptyElement("a", content);
    }

    default Renderable abbr(CharSequence... content) {
        return new MarkupEmptyElement("abbr", content);
    }

    default Renderable acronym(CharSequence... content) {
        return new MarkupEmptyElement("acronym", content);
    }

    default Renderable address(CharSequence... content) {
        return new MarkupEmptyElement("address", content);
    }

    default Renderable applet(CharSequence... content) {
        return new MarkupEmptyElement("applet", content);
    }

    default Renderable article(CharSequence... content) {
        return new MarkupEmptyElement("article", content);
    }

    default Renderable aside(CharSequence... content) {
        return new MarkupEmptyElement("aside", content);
    }

    default Renderable audio(CharSequence... content) {
        return new MarkupEmptyElement("audio", content);
    }

    default Renderable b(CharSequence... content) {
        return new MarkupEmptyElement("b", content);
    }

    default Renderable basefont(CharSequence... content) {
        return new MarkupEmptyElement("basefont", content);
    }

    default Renderable bdi(CharSequence... content) {
        return new MarkupEmptyElement("bdi", content);
    }

    default Renderable bdo(CharSequence... content) {
        return new MarkupEmptyElement("bdo", content);
    }

    default Renderable big(CharSequence... content) {
        return new MarkupEmptyElement("big", content);
    }

    default Renderable blockquote(CharSequence... content) {
        return new MarkupEmptyElement("blockquote", content);
    }

    default Renderable body(CharSequence... content) {
        return new MarkupEmptyElement("body", content);
    }

    default Renderable button(CharSequence... content) {
        return new MarkupEmptyElement("button", content);
    }

    default Renderable canvas(CharSequence... content) {
        return new MarkupEmptyElement("canvas", content);
    }

    default Renderable caption(CharSequence... content) {
        return new MarkupEmptyElement("caption", content);
    }

    default Renderable center(CharSequence... content) {
        return new MarkupEmptyElement("center", content);
    }

    default Renderable cite(CharSequence... content) {
        return new MarkupEmptyElement("cite", content);
    }

    default Renderable code(CharSequence... content) {
        return new MarkupEmptyElement("code", content);
    }

    default Renderable colgroup(CharSequence... content) {
        return new MarkupEmptyElement("colgroup", content);
    }

    default Renderable data(CharSequence... content) {
        return new MarkupEmptyElement("data", content);
    }

    default Renderable datalist(CharSequence... content) {
        return new MarkupEmptyElement("datalist", content);
    }

    default Renderable dd(CharSequence... content) {
        return new MarkupEmptyElement("dd", content);
    }

    default Renderable del(CharSequence... content) {
        return new MarkupEmptyElement("del", content);
    }

    default Renderable details(CharSequence... content) {
        return new MarkupEmptyElement("details", content);
    }

    default Renderable dfn(CharSequence... content) {
        return new MarkupEmptyElement("dfn", content);
    }

    default Renderable dialog(CharSequence... content) {
        return new MarkupEmptyElement("dialog", content);
    }

    default Renderable dir(CharSequence... content) {
        return new MarkupEmptyElement("dir", content);
    }

    default Renderable div(CharSequence... content) {
        return new MarkupEmptyElement("div", content);
    }

    default Renderable dl(CharSequence... content) {
        return new MarkupEmptyElement("dl", content);
    }

    default Renderable dt(CharSequence... content) {
        return new MarkupEmptyElement("dt", content);
    }

    default Renderable em(CharSequence... content) {
        return new MarkupEmptyElement("em", content);
    }

    default Renderable fieldset(CharSequence... content) {
        return new MarkupEmptyElement("fieldset", content);
    }

    default Renderable figcaption(CharSequence... content) {
        return new MarkupEmptyElement("figcaption", content);
    }

    default Renderable figure(CharSequence... content) {
        return new MarkupEmptyElement("figure", content);
    }

    default Renderable font(CharSequence... content) {
        return new MarkupEmptyElement("font", content);
    }

    default Renderable footer(CharSequence... content) {
        return new MarkupEmptyElement("footer", content);
    }

    default Renderable form(CharSequence... content) {
        return new MarkupEmptyElement("form", content);
    }

    default Renderable frame(CharSequence... content) {
        return new MarkupEmptyElement("frame", content);
    }

    default Renderable frameset(CharSequence... content) {
        return new MarkupEmptyElement("frameset", content);
    }

    default Renderable h1(CharSequence... content) {
        return new MarkupEmptyElement("h1", content);
    }

    default Renderable h2(CharSequence... content) {
        return new MarkupEmptyElement("h2", content);
    }

    default Renderable h3(CharSequence... content) {
        return new MarkupEmptyElement("h3", content);
    }

    default Renderable h4(CharSequence... content) {
        return new MarkupEmptyElement("h4", content);
    }

    default Renderable h5(CharSequence... content) {
        return new MarkupEmptyElement("h5", content);
    }

    default Renderable h6(CharSequence... content) {
        return new MarkupEmptyElement("h6", content);
    }

    default Renderable head(CharSequence... content) {
        return new MarkupEmptyElement("head", content);
    }

    default Renderable header(CharSequence... content) {
        return new MarkupEmptyElement("header", content);
    }

    default Renderable html(CharSequence... content) {
        return new MarkupComposition(
                new MarkupEmptyElement("!doctype", attrs(html -> null)),
                new MarkupEmptyElement("html", content)
        );
    }

    default Renderable i(CharSequence... content) {
        return new MarkupEmptyElement("i", content);
    }

    default Renderable iframe(CharSequence... content) {
        return new MarkupEmptyElement("iframe", content);
    }

    default Renderable ins(CharSequence... content) {
        return new MarkupEmptyElement("ins", content);
    }

    default Renderable kbd(CharSequence... content) {
        return new MarkupEmptyElement("kbd", content);
    }

    default Renderable label(CharSequence... content) {
        return new MarkupEmptyElement("label", content);
    }

    default Renderable legend(CharSequence... content) {
        return new MarkupEmptyElement("legend", content);
    }

    default Renderable li(CharSequence... content) {
        return new MarkupEmptyElement("li", content);
    }

    default Renderable main(CharSequence... content) {
        return new MarkupEmptyElement("main", content);
    }

    default Renderable map(CharSequence... content) {
        return new MarkupEmptyElement("map", content);
    }

    default Renderable mark(CharSequence... content) {
        return new MarkupEmptyElement("mark", content);
    }

    default Renderable meter(CharSequence... content) {
        return new MarkupEmptyElement("meter", content);
    }

    default Renderable nav(CharSequence... content) {
        return new MarkupEmptyElement("nav", content);
    }

    default Renderable noframes(CharSequence... content) {
        return new MarkupEmptyElement("noframes", content);
    }

    default Renderable noscript(CharSequence... content) {
        return new MarkupEmptyElement("noscript", content);
    }

    default Renderable object(CharSequence... content) {
        return new MarkupEmptyElement("object", content);
    }

    default Renderable ol(CharSequence... content) {
        return new MarkupEmptyElement("ol", content);
    }

    default Renderable optgroup(CharSequence... content) {
        return new MarkupEmptyElement("optgroup", content);
    }

    default Renderable option(CharSequence... content) {
        return new MarkupEmptyElement("option", content);
    }

    default Renderable output(CharSequence... content) {
        return new MarkupEmptyElement("output", content);
    }

    default Renderable p(CharSequence... content) {
        return new MarkupEmptyElement("p", content);
    }

    default Renderable picture(CharSequence... content) {
        return new MarkupEmptyElement("picture", content);
    }

    default Renderable pre(CharSequence... content) {
        return new MarkupEmptyElement("pre", content);
    }

    default Renderable progress(CharSequence... content) {
        return new MarkupEmptyElement("progress", content);
    }

    default Renderable q(CharSequence... content) {
        return new MarkupEmptyElement("q", content);
    }

    default Renderable rp(CharSequence... content) {
        return new MarkupEmptyElement("rp", content);
    }

    default Renderable rt(CharSequence... content) {
        return new MarkupEmptyElement("rt", content);
    }

    default Renderable ruby(CharSequence... content) {
        return new MarkupEmptyElement("ruby", content);
    }

    default Renderable s(CharSequence... content) {
        return new MarkupEmptyElement("s", content);
    }

    default Renderable samp(CharSequence... content) {
        return new MarkupEmptyElement("samp", content);
    }

    default Renderable script(CharSequence... content) {
        return new MarkupEmptyElement("script", content);
    }

    default Renderable section(CharSequence... content) {
        return new MarkupEmptyElement("section", content);
    }

    default Renderable select(CharSequence... content) {
        return new MarkupEmptyElement("select", content);
    }

    default Renderable small(CharSequence... content) {
        return new MarkupEmptyElement("small", content);
    }

    default Renderable span(CharSequence... content) {
        return new MarkupEmptyElement("span", content);
    }

    default Renderable strike(CharSequence... content) {
        return new MarkupEmptyElement("strike", content);
    }

    default Renderable strong(CharSequence... content) {
        return new MarkupEmptyElement("strong", content);
    }

    default Renderable style(CharSequence... content) {
        return new MarkupEmptyElement("style", content);
    }

    default Renderable sub(CharSequence... content) {
        return new MarkupEmptyElement("sub", content);
    }

    default Renderable summary(CharSequence... content) {
        return new MarkupEmptyElement("summary", content);
    }

    default Renderable sup(CharSequence... content) {
        return new MarkupEmptyElement("sup", content);
    }

    default Renderable svg(CharSequence... content) {
        return new MarkupEmptyElement("svg", content);
    }

    default Renderable table(CharSequence... content) {
        return new MarkupEmptyElement("table", content);
    }

    default Renderable tbody(CharSequence... content) {
        return new MarkupEmptyElement("tbody", content);
    }

    default Renderable td(CharSequence... content) {
        return new MarkupEmptyElement("td", content);
    }

    default Renderable template(CharSequence... content) {
        return new MarkupEmptyElement("template", content);
    }

    default Renderable textarea(CharSequence... content) {
        return new MarkupEmptyElement("textarea", content);
    }

    default Renderable tfoot(CharSequence... content) {
        return new MarkupEmptyElement("tfoot", content);
    }

    default Renderable th(CharSequence... content) {
        return new MarkupEmptyElement("th", content);
    }

    default Renderable thead(CharSequence... content) {
        return new MarkupEmptyElement("thead", content);
    }

    default Renderable time(CharSequence... content) {
        return new MarkupEmptyElement("time", content);
    }

    default Renderable title(CharSequence... content) {
        return new MarkupEmptyElement("title", content);
    }

    default Renderable tr(CharSequence... content) {
        return new MarkupEmptyElement("tr", content);
    }

    default Renderable tt(CharSequence... content) {
        return new MarkupEmptyElement("tt", content);
    }

    default Renderable u(CharSequence... content) {
        return new MarkupEmptyElement("u", content);
    }

    default Renderable ul(CharSequence... content) {
        return new MarkupEmptyElement("ul", content);
    }

    default Renderable var(CharSequence... content) {
        return new MarkupEmptyElement("var", content);
    }

    default Renderable video(CharSequence... content) {
        return new MarkupEmptyElement("video", content);
    }
}
