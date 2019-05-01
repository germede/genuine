package org.fluentness.rendering;

public interface HtmlElement {

    // empty

    default CharSequence area(CharSequence... with) {
        return new DomElement("area", with, false);
    }

    default CharSequence base(CharSequence... with) {
        return new DomElement("base", with, false);
    }

    default CharSequence br(CharSequence... with) {
        return new DomElement("br", with, false);
    }

    default CharSequence col(CharSequence... with) {
        return new DomElement("col", with, false);
    }

    default CharSequence embed(CharSequence... with) {
        return new DomElement("embed", with, false);
    }

    default CharSequence hr(CharSequence... with) {
        return new DomElement("hr", with, false);
    }

    default CharSequence img(CharSequence... with) {
        return new DomElement("img", with, false);
    }

    default CharSequence input(CharSequence... with) {
        return new DomElement("input", with, false);
    }

    default CharSequence link(CharSequence... with) {
        return new DomElement("link", with, false);
    }

    default CharSequence meta(CharSequence... with) {
        return new DomElement("meta", with, false);
    }

    default CharSequence param(CharSequence... with) {
        return new DomElement("param", with, false);
    }

    default CharSequence source(CharSequence... with) {
        return new DomElement("source", with, false);
    }

    default CharSequence track(CharSequence... with) {
        return new DomElement("track", with, false);
    }

    default CharSequence wbr(CharSequence... with) {
        return new DomElement("wbr", with, false);
    }

    // container

    default CharSequence doctype(CharSequence... with) {
        return new DomElement("doctype", with, true);
    }

    default CharSequence a(CharSequence... with) {
        return new DomElement("a", with, true);
    }

    default CharSequence abbr(CharSequence... with) {
        return new DomElement("abbr", with, true);
    }

    default CharSequence acronym(CharSequence... with) {
        return new DomElement("acronym", with, true);
    }

    default CharSequence address(CharSequence... with) {
        return new DomElement("address", with, true);
    }

    default CharSequence applet(CharSequence... with) {
        return new DomElement("applet", with, true);
    }

    default CharSequence article(CharSequence... with) {
        return new DomElement("article", with, true);
    }

    default CharSequence aside(CharSequence... with) {
        return new DomElement("aside", with, true);
    }

    default CharSequence audio(CharSequence... with) {
        return new DomElement("audio", with, true);
    }

    default CharSequence b(CharSequence... with) {
        return new DomElement("b", with, true);
    }

    default CharSequence basefont(CharSequence... with) {
        return new DomElement("basefont", with, true);
    }

    default CharSequence bdi(CharSequence... with) {
        return new DomElement("bdi", with, true);
    }

    default CharSequence bdo(CharSequence... with) {
        return new DomElement("bdo", with, true);
    }

    default CharSequence big(CharSequence... with) {
        return new DomElement("big", with, true);
    }

    default CharSequence blockquote(CharSequence... with) {
        return new DomElement("blockquote", with, true);
    }

    default CharSequence body(CharSequence... with) {
        return new DomElement("body", with, true);
    }

    default CharSequence button(CharSequence... with) {
        return new DomElement("button", with, true);
    }

    default CharSequence canvas(CharSequence... with) {
        return new DomElement("canvas", with, true);
    }

    default CharSequence caption(CharSequence... with) {
        return new DomElement("caption", with, true);
    }

    default CharSequence center(CharSequence... with) {
        return new DomElement("center", with, true);
    }

    default CharSequence cite(CharSequence... with) {
        return new DomElement("cite", with, true);
    }

    default CharSequence code(CharSequence... with) {
        return new DomElement("code", with, true);
    }

    default CharSequence colgroup(CharSequence... with) {
        return new DomElement("colgroup", with, true);
    }

    default CharSequence data(CharSequence... with) {
        return new DomElement("data", with, true);
    }

    default CharSequence datalist(CharSequence... with) {
        return new DomElement("datalist", with, true);
    }

    default CharSequence dd(CharSequence... with) {
        return new DomElement("dd", with, true);
    }

    default CharSequence del(CharSequence... with) {
        return new DomElement("del", with, true);
    }

    default CharSequence details(CharSequence... with) {
        return new DomElement("details", with, true);
    }

    default CharSequence dfn(CharSequence... with) {
        return new DomElement("dfn", with, true);
    }

    default CharSequence dialog(CharSequence... with) {
        return new DomElement("dialog", with, true);
    }

    default CharSequence dir(CharSequence... with) {
        return new DomElement("dir", with, true);
    }

    default CharSequence div(CharSequence... with) {
        return new DomElement("div", with, true);
    }

    default CharSequence dl(CharSequence... with) {
        return new DomElement("dl", with, true);
    }

    default CharSequence dt(CharSequence... with) {
        return new DomElement("dt", with, true);
    }

    default CharSequence em(CharSequence... with) {
        return new DomElement("em", with, true);
    }

    default CharSequence fieldset(CharSequence... with) {
        return new DomElement("fieldset", with, true);
    }

    default CharSequence figcaption(CharSequence... with) {
        return new DomElement("figcaption", with, true);
    }

    default CharSequence figure(CharSequence... with) {
        return new DomElement("figure", with, true);
    }

    default CharSequence font(CharSequence... with) {
        return new DomElement("font", with, true);
    }

    default CharSequence footer(CharSequence... with) {
        return new DomElement("footer", with, true);
    }

    default CharSequence form(CharSequence... with) {
        return new DomElement("form", with, true);
    }

    default CharSequence frame(CharSequence... with) {
        return new DomElement("frame", with, true);
    }

    default CharSequence frameset(CharSequence... with) {
        return new DomElement("frameset", with, true);
    }

    default CharSequence h1(CharSequence... with) {
        return new DomElement("h1", with, true);
    }

    default CharSequence head(CharSequence... with) {
        return new DomElement("head", with, true);
    }

    default CharSequence header(CharSequence... with) {
        return new DomElement("header", with, true);
    }

    default CharSequence html(CharSequence... with) {
        return new DomElement("html", with, true);
    }

    default CharSequence i(CharSequence... with) {
        return new DomElement("i", with, true);
    }

    default CharSequence iframe(CharSequence... with) {
        return new DomElement("iframe", with, true);
    }

    default CharSequence ins(CharSequence... with) {
        return new DomElement("ins", with, true);
    }

    default CharSequence kbd(CharSequence... with) {
        return new DomElement("kbd", with, true);
    }

    default CharSequence label(CharSequence... with) {
        return new DomElement("label", with, true);
    }

    default CharSequence legend(CharSequence... with) {
        return new DomElement("legend", with, true);
    }

    default CharSequence li(CharSequence... with) {
        return new DomElement("li", with, true);
    }

    default CharSequence main(CharSequence... with) {
        return new DomElement("main", with, true);
    }

    default CharSequence map(CharSequence... with) {
        return new DomElement("map", with, true);
    }

    default CharSequence mark(CharSequence... with) {
        return new DomElement("mark", with, true);
    }

    default CharSequence meter(CharSequence... with) {
        return new DomElement("meter", with, true);
    }

    default CharSequence nav(CharSequence... with) {
        return new DomElement("nav", with, true);
    }

    default CharSequence noframes(CharSequence... with) {
        return new DomElement("noframes", with, true);
    }

    default CharSequence noscript(CharSequence... with) {
        return new DomElement("noscript", with, true);
    }

    default CharSequence object(CharSequence... with) {
        return new DomElement("object", with, true);
    }

    default CharSequence ol(CharSequence... with) {
        return new DomElement("ol", with, true);
    }

    default CharSequence optgroup(CharSequence... with) {
        return new DomElement("optgroup", with, true);
    }

    default CharSequence option(CharSequence... with) {
        return new DomElement("option", with, true);
    }

    default CharSequence output(CharSequence... with) {
        return new DomElement("output", with, true);
    }

    default CharSequence p(CharSequence... with) {
        return new DomElement("p", with, true);
    }

    default CharSequence picture(CharSequence... with) {
        return new DomElement("picture", with, true);
    }

    default CharSequence pre(CharSequence... with) {
        return new DomElement("pre", with, true);
    }

    default CharSequence progress(CharSequence... with) {
        return new DomElement("progress", with, true);
    }

    default CharSequence q(CharSequence... with) {
        return new DomElement("q", with, true);
    }

    default CharSequence rp(CharSequence... with) {
        return new DomElement("rp", with, true);
    }

    default CharSequence rt(CharSequence... with) {
        return new DomElement("rt", with, true);
    }

    default CharSequence ruby(CharSequence... with) {
        return new DomElement("ruby", with, true);
    }

    default CharSequence s(CharSequence... with) {
        return new DomElement("s", with, true);
    }

    default CharSequence samp(CharSequence... with) {
        return new DomElement("samp", with, true);
    }

    default CharSequence script(CharSequence... with) {
        return new DomElement("script", with, true);
    }

    default CharSequence section(CharSequence... with) {
        return new DomElement("section", with, true);
    }

    default CharSequence select(CharSequence... with) {
        return new DomElement("select", with, true);
    }

    default CharSequence small(CharSequence... with) {
        return new DomElement("small", with, true);
    }

    default CharSequence span(CharSequence... with) {
        return new DomElement("span", with, true);
    }

    default CharSequence strike(CharSequence... with) {
        return new DomElement("strike", with, true);
    }

    default CharSequence strong(CharSequence... with) {
        return new DomElement("strong", with, true);
    }

    default CharSequence style(CharSequence... with) {
        return new DomElement("style", with, true);
    }

    default CharSequence sub(CharSequence... with) {
        return new DomElement("sub", with, true);
    }

    default CharSequence summary(CharSequence... with) {
        return new DomElement("summary", with, true);
    }

    default CharSequence sup(CharSequence... with) {
        return new DomElement("sup", with, true);
    }

    default CharSequence svg(CharSequence... with) {
        return new DomElement("svg", with, true);
    }

    default CharSequence table(CharSequence... with) {
        return new DomElement("table", with, true);
    }

    default CharSequence tbody(CharSequence... with) {
        return new DomElement("tbody", with, true);
    }

    default CharSequence td(CharSequence... with) {
        return new DomElement("td", with, true);
    }

    default CharSequence template(CharSequence... with) {
        return new DomElement("template", with, true);
    }

    default CharSequence textarea(CharSequence... with) {
        return new DomElement("textarea", with, true);
    }

    default CharSequence tfoot(CharSequence... with) {
        return new DomElement("tfoot", with, true);
    }

    default CharSequence th(CharSequence... with) {
        return new DomElement("th", with, true);
    }

    default CharSequence thead(CharSequence... with) {
        return new DomElement("thead", with, true);
    }

    default CharSequence time(CharSequence... with) {
        return new DomElement("time", with, true);
    }

    default CharSequence title(CharSequence... with) {
        return new DomElement("title", with, true);
    }

    default CharSequence tr(CharSequence... with) {
        return new DomElement("tr", with, true);
    }

    default CharSequence tt(CharSequence... with) {
        return new DomElement("tt", with, true);
    }

    default CharSequence u(CharSequence... with) {
        return new DomElement("u", with, true);
    }

    default CharSequence ul(CharSequence... with) {
        return new DomElement("ul", with, true);
    }

    default CharSequence var(CharSequence... with) {
        return new DomElement("var", with, true);
    }

    default CharSequence video(CharSequence... with) {
        return new DomElement("video", with, true);
    }
    }
