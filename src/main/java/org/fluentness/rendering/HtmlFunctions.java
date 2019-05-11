package org.fluentness.rendering;

import org.fluentness.common.NamedValue;

public interface HtmlFunctions extends MarkupFunctions {

    // helpers

    default Renderable includeCss(String href) {
        return link(rel -> "stylesheet", type -> "text/css", href_ -> "/resources/css/"+href);
    }

    // empty

    default Renderable area(NamedValue... attributes) {
        return new MarkupElement("area", attrs(attributes));
    }

    default Renderable base(NamedValue... attributes) {
        return new MarkupElement("base", attrs(attributes));
    }

    default Renderable br(NamedValue... attributes) {
        return new MarkupElement("br", attrs(attributes));
    }

    default Renderable col(NamedValue... attributes) {
        return new MarkupElement("col", attrs(attributes));
    }

    default Renderable embed(NamedValue... attributes) {
        return new MarkupElement("embed", attrs(attributes));
    }

    default Renderable hr(NamedValue... attributes) {
        return new MarkupElement("hr", attrs(attributes));
    }

    default Renderable img(NamedValue... attributes) {
        return new MarkupElement("img", attrs(attributes));
    }

    default Renderable input(NamedValue... attributes) {
        return new MarkupElement("input", attrs(attributes));
    }

    default Renderable link(NamedValue... attributes) {
        return new MarkupElement("link", attrs(attributes));
    }

    default Renderable meta(NamedValue... attributes) {
        return new MarkupElement("meta", attrs(attributes));
    }

    default Renderable param(NamedValue... attributes) {
        return new MarkupElement("param", attrs(attributes));
    }

    default Renderable source(NamedValue... attributes) {
        return new MarkupElement("source", attrs(attributes));
    }

    default Renderable track(NamedValue... attributes) {
        return new MarkupElement("track", attrs(attributes));
    }

    default Renderable wbr(NamedValue... attributes) {
        return new MarkupElement("wbr", attrs(attributes));
    }

    // container

    default Renderable a(CharSequence... content) {
        return new MarkupElement("a", content);
    }

    default Renderable abbr(CharSequence... content) {
        return new MarkupElement("abbr", content);
    }

    default Renderable acronym(CharSequence... content) {
        return new MarkupElement("acronym", content);
    }

    default Renderable address(CharSequence... content) {
        return new MarkupElement("address", content);
    }

    default Renderable applet(CharSequence... content) {
        return new MarkupElement("applet", content);
    }

    default Renderable article(CharSequence... content) {
        return new MarkupElement("article", content);
    }

    default Renderable aside(CharSequence... content) {
        return new MarkupElement("aside", content);
    }

    default Renderable audio(CharSequence... content) {
        return new MarkupElement("audio", content);
    }

    default Renderable b(CharSequence... content) {
        return new MarkupElement("b", content);
    }

    default Renderable basefont(CharSequence... content) {
        return new MarkupElement("basefont", content);
    }

    default Renderable bdi(CharSequence... content) {
        return new MarkupElement("bdi", content);
    }

    default Renderable bdo(CharSequence... content) {
        return new MarkupElement("bdo", content);
    }

    default Renderable big(CharSequence... content) {
        return new MarkupElement("big", content);
    }

    default Renderable blockquote(CharSequence... content) {
        return new MarkupElement("blockquote", content);
    }

    default Renderable body(CharSequence... content) {
        return new MarkupElement("body", content);
    }

    default Renderable button(CharSequence... content) {
        return new MarkupElement("button", content);
    }

    default Renderable canvas(CharSequence... content) {
        return new MarkupElement("canvas", content);
    }

    default Renderable caption(CharSequence... content) {
        return new MarkupElement("caption", content);
    }

    default Renderable center(CharSequence... content) {
        return new MarkupElement("center", content);
    }

    default Renderable cite(CharSequence... content) {
        return new MarkupElement("cite", content);
    }

    default Renderable code(CharSequence... content) {
        return new MarkupElement("code", content);
    }

    default Renderable colgroup(CharSequence... content) {
        return new MarkupElement("colgroup", content);
    }

    default Renderable data(CharSequence... content) {
        return new MarkupElement("data", content);
    }

    default Renderable datalist(CharSequence... content) {
        return new MarkupElement("datalist", content);
    }

    default Renderable dd(CharSequence... content) {
        return new MarkupElement("dd", content);
    }

    default Renderable del(CharSequence... content) {
        return new MarkupElement("del", content);
    }

    default Renderable details(CharSequence... content) {
        return new MarkupElement("details", content);
    }

    default Renderable dfn(CharSequence... content) {
        return new MarkupElement("dfn", content);
    }

    default Renderable dialog(CharSequence... content) {
        return new MarkupElement("dialog", content);
    }

    default Renderable dir(CharSequence... content) {
        return new MarkupElement("dir", content);
    }

    default Renderable div(CharSequence... content) {
        return new MarkupElement("div", content);
    }

    default Renderable dl(CharSequence... content) {
        return new MarkupElement("dl", content);
    }

    default Renderable dt(CharSequence... content) {
        return new MarkupElement("dt", content);
    }

    default Renderable em(CharSequence... content) {
        return new MarkupElement("em", content);
    }

    default Renderable fieldset(CharSequence... content) {
        return new MarkupElement("fieldset", content);
    }

    default Renderable figcaption(CharSequence... content) {
        return new MarkupElement("figcaption", content);
    }

    default Renderable figure(CharSequence... content) {
        return new MarkupElement("figure", content);
    }

    default Renderable font(CharSequence... content) {
        return new MarkupElement("font", content);
    }

    default Renderable footer(CharSequence... content) {
        return new MarkupElement("footer", content);
    }

    default Renderable form(CharSequence... content) {
        return new MarkupElement("form", content);
    }

    default Renderable frame(CharSequence... content) {
        return new MarkupElement("frame", content);
    }

    default Renderable frameset(CharSequence... content) {
        return new MarkupElement("frameset", content);
    }

    default Renderable h1(CharSequence... content) {
        return new MarkupElement("h1", content);
    }

    default Renderable h2(CharSequence... content) {
        return new MarkupElement("h2", content);
    }

    default Renderable h3(CharSequence... content) {
        return new MarkupElement("h3", content);
    }

    default Renderable h4(CharSequence... content) {
        return new MarkupElement("h4", content);
    }

    default Renderable h5(CharSequence... content) {
        return new MarkupElement("h5", content);
    }

    default Renderable h6(CharSequence... content) {
        return new MarkupElement("h6", content);
    }

    default Renderable head(CharSequence... content) {
        return new MarkupElement("head", content);
    }

    default Renderable header(CharSequence... content) {
        return new MarkupElement("header", content);
    }

    default Renderable html(CharSequence... content) {
        return new MarkupComposition(
                new MarkupElement("!doctype", attrs(html -> null)),
                new MarkupElement("html", content)
        );
    }

    default Renderable i(CharSequence... content) {
        return new MarkupElement("i", content);
    }

    default Renderable iframe(CharSequence... content) {
        return new MarkupElement("iframe", content);
    }

    default Renderable ins(CharSequence... content) {
        return new MarkupElement("ins", content);
    }

    default Renderable kbd(CharSequence... content) {
        return new MarkupElement("kbd", content);
    }

    default Renderable label(CharSequence... content) {
        return new MarkupElement("label", content);
    }

    default Renderable legend(CharSequence... content) {
        return new MarkupElement("legend", content);
    }

    default Renderable li(CharSequence... content) {
        return new MarkupElement("li", content);
    }

    default Renderable main(CharSequence... content) {
        return new MarkupElement("main", content);
    }

    default Renderable map(CharSequence... content) {
        return new MarkupElement("map", content);
    }

    default Renderable mark(CharSequence... content) {
        return new MarkupElement("mark", content);
    }

    default Renderable meter(CharSequence... content) {
        return new MarkupElement("meter", content);
    }

    default Renderable nav(CharSequence... content) {
        return new MarkupElement("nav", content);
    }

    default Renderable noframes(CharSequence... content) {
        return new MarkupElement("noframes", content);
    }

    default Renderable noscript(CharSequence... content) {
        return new MarkupElement("noscript", content);
    }

    default Renderable object(CharSequence... content) {
        return new MarkupElement("object", content);
    }

    default Renderable ol(CharSequence... content) {
        return new MarkupElement("ol", content);
    }

    default Renderable optgroup(CharSequence... content) {
        return new MarkupElement("optgroup", content);
    }

    default Renderable option(CharSequence... content) {
        return new MarkupElement("option", content);
    }

    default Renderable output(CharSequence... content) {
        return new MarkupElement("output", content);
    }

    default Renderable p(CharSequence... content) {
        return new MarkupElement("p", content);
    }

    default Renderable picture(CharSequence... content) {
        return new MarkupElement("picture", content);
    }

    default Renderable pre(CharSequence... content) {
        return new MarkupElement("pre", content);
    }

    default Renderable progress(CharSequence... content) {
        return new MarkupElement("progress", content);
    }

    default Renderable q(CharSequence... content) {
        return new MarkupElement("q", content);
    }

    default Renderable rp(CharSequence... content) {
        return new MarkupElement("rp", content);
    }

    default Renderable rt(CharSequence... content) {
        return new MarkupElement("rt", content);
    }

    default Renderable ruby(CharSequence... content) {
        return new MarkupElement("ruby", content);
    }

    default Renderable s(CharSequence... content) {
        return new MarkupElement("s", content);
    }

    default Renderable samp(CharSequence... content) {
        return new MarkupElement("samp", content);
    }

    default Renderable script(CharSequence... content) {
        return new MarkupElement("script", content);
    }

    default Renderable section(CharSequence... content) {
        return new MarkupElement("section", content);
    }

    default Renderable select(CharSequence... content) {
        return new MarkupElement("select", content);
    }

    default Renderable small(CharSequence... content) {
        return new MarkupElement("small", content);
    }

    default Renderable span(CharSequence... content) {
        return new MarkupElement("span", content);
    }

    default Renderable strike(CharSequence... content) {
        return new MarkupElement("strike", content);
    }

    default Renderable strong(CharSequence... content) {
        return new MarkupElement("strong", content);
    }

    default Renderable style(CharSequence... content) {
        return new MarkupElement("style", content);
    }

    default Renderable sub(CharSequence... content) {
        return new MarkupElement("sub", content);
    }

    default Renderable summary(CharSequence... content) {
        return new MarkupElement("summary", content);
    }

    default Renderable sup(CharSequence... content) {
        return new MarkupElement("sup", content);
    }

    default Renderable svg(CharSequence... content) {
        return new MarkupElement("svg", content);
    }

    default Renderable table(CharSequence... content) {
        return new MarkupElement("table", content);
    }

    default Renderable tbody(CharSequence... content) {
        return new MarkupElement("tbody", content);
    }

    default Renderable td(CharSequence... content) {
        return new MarkupElement("td", content);
    }

    default Renderable template(CharSequence... content) {
        return new MarkupElement("template", content);
    }

    default Renderable textarea(CharSequence... content) {
        return new MarkupElement("textarea", content);
    }

    default Renderable tfoot(CharSequence... content) {
        return new MarkupElement("tfoot", content);
    }

    default Renderable th(CharSequence... content) {
        return new MarkupElement("th", content);
    }

    default Renderable thead(CharSequence... content) {
        return new MarkupElement("thead", content);
    }

    default Renderable time(CharSequence... content) {
        return new MarkupElement("time", content);
    }

    default Renderable title(CharSequence... content) {
        return new MarkupElement("title", content);
    }

    default Renderable tr(CharSequence... content) {
        return new MarkupElement("tr", content);
    }

    default Renderable tt(CharSequence... content) {
        return new MarkupElement("tt", content);
    }

    default Renderable u(CharSequence... content) {
        return new MarkupElement("u", content);
    }

    default Renderable ul(CharSequence... content) {
        return new MarkupElement("ul", content);
    }

    default Renderable var(CharSequence... content) {
        return new MarkupElement("var", content);
    }

    default Renderable video(CharSequence... content) {
        return new MarkupElement("video", content);
    }
}
