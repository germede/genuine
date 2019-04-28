package org.fluentness.templating;

import java.io.Serializable;

public class HtmlElement {
    private HtmlElement() {

    }

    // empty

    public static Serializable area(Serializable... renderables) {
        return new DomElement("area", renderables, false);
    }

    public static Serializable base(Serializable... renderables) {
        return new DomElement("base", renderables, false);
    }

    public static Serializable br(Serializable... renderables) {
        return new DomElement("br", renderables, false);
    }

    public static Serializable col(Serializable... renderables) {
        return new DomElement("col", renderables, false);
    }

    public static Serializable embed(Serializable... renderables) {
        return new DomElement("embed", renderables, false);
    }

    public static Serializable hr(Serializable... renderables) {
        return new DomElement("hr", renderables, false);
    }

    public static Serializable img(Serializable... renderables) {
        return new DomElement("img", renderables, false);
    }

    public static Serializable input(Serializable... renderables) {
        return new DomElement("input", renderables, false);
    }

    public static Serializable link(Serializable... renderables) {
        return new DomElement("link", renderables, false);
    }

    public static Serializable meta(Serializable... renderables) {
        return new DomElement("meta", renderables, false);
    }

    public static Serializable param(Serializable... renderables) {
        return new DomElement("param", renderables, false);
    }

    public static Serializable source(Serializable... renderables) {
        return new DomElement("source", renderables, false);
    }

    public static Serializable track(Serializable... renderables) {
        return new DomElement("track", renderables, false);
    }

    public static Serializable wbr(Serializable... renderables) {
        return new DomElement("wbr", renderables, false);
    }

    // container

    public static Serializable doctype(Serializable... renderables) {
        return new DomElement("doctype", renderables, true);
    }

    public static Serializable a(Serializable... renderables) {
        return new DomElement("a", renderables, true);
    }

    public static Serializable abbr(Serializable... renderables) {
        return new DomElement("abbr", renderables, true);
    }

    public static Serializable acronym(Serializable... renderables) {
        return new DomElement("acronym", renderables, true);
    }

    public static Serializable address(Serializable... renderables) {
        return new DomElement("address", renderables, true);
    }

    public static Serializable applet(Serializable... renderables) {
        return new DomElement("applet", renderables, true);
    }

    public static Serializable article(Serializable... renderables) {
        return new DomElement("article", renderables, true);
    }

    public static Serializable aside(Serializable... renderables) {
        return new DomElement("aside", renderables, true);
    }

    public static Serializable audio(Serializable... renderables) {
        return new DomElement("audio", renderables, true);
    }

    public static Serializable b(Serializable... renderables) {
        return new DomElement("b", renderables, true);
    }

    public static Serializable basefont(Serializable... renderables) {
        return new DomElement("basefont", renderables, true);
    }

    public static Serializable bdi(Serializable... renderables) {
        return new DomElement("bdi", renderables, true);
    }

    public static Serializable bdo(Serializable... renderables) {
        return new DomElement("bdo", renderables, true);
    }

    public static Serializable big(Serializable... renderables) {
        return new DomElement("big", renderables, true);
    }

    public static Serializable blockquote(Serializable... renderables) {
        return new DomElement("blockquote", renderables, true);
    }

    public static Serializable body(Serializable... renderables) {
        return new DomElement("body", renderables, true);
    }

    public static Serializable button(Serializable... renderables) {
        return new DomElement("button", renderables, true);
    }

    public static Serializable canvas(Serializable... renderables) {
        return new DomElement("canvas", renderables, true);
    }

    public static Serializable caption(Serializable... renderables) {
        return new DomElement("caption", renderables, true);
    }

    public static Serializable center(Serializable... renderables) {
        return new DomElement("center", renderables, true);
    }

    public static Serializable cite(Serializable... renderables) {
        return new DomElement("cite", renderables, true);
    }

    public static Serializable code(Serializable... renderables) {
        return new DomElement("code", renderables, true);
    }

    public static Serializable colgroup(Serializable... renderables) {
        return new DomElement("colgroup", renderables, true);
    }

    public static Serializable data(Serializable... renderables) {
        return new DomElement("data", renderables, true);
    }

    public static Serializable datalist(Serializable... renderables) {
        return new DomElement("datalist", renderables, true);
    }

    public static Serializable dd(Serializable... renderables) {
        return new DomElement("dd", renderables, true);
    }

    public static Serializable del(Serializable... renderables) {
        return new DomElement("del", renderables, true);
    }

    public static Serializable details(Serializable... renderables) {
        return new DomElement("details", renderables, true);
    }

    public static Serializable dfn(Serializable... renderables) {
        return new DomElement("dfn", renderables, true);
    }

    public static Serializable dialog(Serializable... renderables) {
        return new DomElement("dialog", renderables, true);
    }

    public static Serializable dir(Serializable... renderables) {
        return new DomElement("dir", renderables, true);
    }

    public static Serializable div(Serializable... renderables) {
        return new DomElement("div", renderables, true);
    }

    public static Serializable dl(Serializable... renderables) {
        return new DomElement("dl", renderables, true);
    }

    public static Serializable dt(Serializable... renderables) {
        return new DomElement("dt", renderables, true);
    }

    public static Serializable em(Serializable... renderables) {
        return new DomElement("em", renderables, true);
    }

    public static Serializable fieldset(Serializable... renderables) {
        return new DomElement("fieldset", renderables, true);
    }

    public static Serializable figcaption(Serializable... renderables) {
        return new DomElement("figcaption", renderables, true);
    }

    public static Serializable figure(Serializable... renderables) {
        return new DomElement("figure", renderables, true);
    }

    public static Serializable font(Serializable... renderables) {
        return new DomElement("font", renderables, true);
    }

    public static Serializable footer(Serializable... renderables) {
        return new DomElement("footer", renderables, true);
    }

    public static Serializable form(Serializable... renderables) {
        return new DomElement("form", renderables, true);
    }

    public static Serializable frame(Serializable... renderables) {
        return new DomElement("frame", renderables, true);
    }

    public static Serializable frameset(Serializable... renderables) {
        return new DomElement("frameset", renderables, true);
    }

    public static Serializable h1(Serializable... renderables) {
        return new DomElement("h1", renderables, true);
    }

    public static Serializable head(Serializable... renderables) {
        return new DomElement("head", renderables, true);
    }

    public static Serializable header(Serializable... renderables) {
        return new DomElement("header", renderables, true);
    }

    public static Serializable html(Serializable... renderables) {
        return new DomElement("html", renderables, true);
    }

    public static Serializable i(Serializable... renderables) {
        return new DomElement("i", renderables, true);
    }

    public static Serializable iframe(Serializable... renderables) {
        return new DomElement("iframe", renderables, true);
    }

    public static Serializable ins(Serializable... renderables) {
        return new DomElement("ins", renderables, true);
    }

    public static Serializable kbd(Serializable... renderables) {
        return new DomElement("kbd", renderables, true);
    }

    public static Serializable label(Serializable... renderables) {
        return new DomElement("label", renderables, true);
    }

    public static Serializable legend(Serializable... renderables) {
        return new DomElement("legend", renderables, true);
    }

    public static Serializable li(Serializable... renderables) {
        return new DomElement("li", renderables, true);
    }

    public static Serializable main(Serializable... renderables) {
        return new DomElement("main", renderables, true);
    }

    public static Serializable map(Serializable... renderables) {
        return new DomElement("map", renderables, true);
    }

    public static Serializable mark(Serializable... renderables) {
        return new DomElement("mark", renderables, true);
    }

    public static Serializable meter(Serializable... renderables) {
        return new DomElement("meter", renderables, true);
    }

    public static Serializable nav(Serializable... renderables) {
        return new DomElement("nav", renderables, true);
    }

    public static Serializable noframes(Serializable... renderables) {
        return new DomElement("noframes", renderables, true);
    }

    public static Serializable noscript(Serializable... renderables) {
        return new DomElement("noscript", renderables, true);
    }

    public static Serializable object(Serializable... renderables) {
        return new DomElement("object", renderables, true);
    }

    public static Serializable ol(Serializable... renderables) {
        return new DomElement("ol", renderables, true);
    }

    public static Serializable optgroup(Serializable... renderables) {
        return new DomElement("optgroup", renderables, true);
    }

    public static Serializable option(Serializable... renderables) {
        return new DomElement("option", renderables, true);
    }

    public static Serializable output(Serializable... renderables) {
        return new DomElement("output", renderables, true);
    }

    public static Serializable p(Serializable... renderables) {
        return new DomElement("p", renderables, true);
    }

    public static Serializable picture(Serializable... renderables) {
        return new DomElement("picture", renderables, true);
    }

    public static Serializable pre(Serializable... renderables) {
        return new DomElement("pre", renderables, true);
    }

    public static Serializable progress(Serializable... renderables) {
        return new DomElement("progress", renderables, true);
    }

    public static Serializable q(Serializable... renderables) {
        return new DomElement("q", renderables, true);
    }

    public static Serializable rp(Serializable... renderables) {
        return new DomElement("rp", renderables, true);
    }

    public static Serializable rt(Serializable... renderables) {
        return new DomElement("rt", renderables, true);
    }

    public static Serializable ruby(Serializable... renderables) {
        return new DomElement("ruby", renderables, true);
    }

    public static Serializable s(Serializable... renderables) {
        return new DomElement("s", renderables, true);
    }

    public static Serializable samp(Serializable... renderables) {
        return new DomElement("samp", renderables, true);
    }

    public static Serializable script(Serializable... renderables) {
        return new DomElement("script", renderables, true);
    }

    public static Serializable section(Serializable... renderables) {
        return new DomElement("section", renderables, true);
    }

    public static Serializable select(Serializable... renderables) {
        return new DomElement("select", renderables, true);
    }

    public static Serializable small(Serializable... renderables) {
        return new DomElement("small", renderables, true);
    }

    public static Serializable span(Serializable... renderables) {
        return new DomElement("span", renderables, true);
    }

    public static Serializable strike(Serializable... renderables) {
        return new DomElement("strike", renderables, true);
    }

    public static Serializable strong(Serializable... renderables) {
        return new DomElement("strong", renderables, true);
    }

    public static Serializable style(Serializable... renderables) {
        return new DomElement("style", renderables, true);
    }

    public static Serializable sub(Serializable... renderables) {
        return new DomElement("sub", renderables, true);
    }

    public static Serializable summary(Serializable... renderables) {
        return new DomElement("summary", renderables, true);
    }

    public static Serializable sup(Serializable... renderables) {
        return new DomElement("sup", renderables, true);
    }

    public static Serializable svg(Serializable... renderables) {
        return new DomElement("svg", renderables, true);
    }

    public static Serializable table(Serializable... renderables) {
        return new DomElement("table", renderables, true);
    }

    public static Serializable tbody(Serializable... renderables) {
        return new DomElement("tbody", renderables, true);
    }

    public static Serializable td(Serializable... renderables) {
        return new DomElement("td", renderables, true);
    }

    public static Serializable template(Serializable... renderables) {
        return new DomElement("template", renderables, true);
    }

    public static Serializable textarea(Serializable... renderables) {
        return new DomElement("textarea", renderables, true);
    }

    public static Serializable tfoot(Serializable... renderables) {
        return new DomElement("tfoot", renderables, true);
    }

    public static Serializable th(Serializable... renderables) {
        return new DomElement("th", renderables, true);
    }

    public static Serializable thead(Serializable... renderables) {
        return new DomElement("thead", renderables, true);
    }

    public static Serializable time(Serializable... renderables) {
        return new DomElement("time", renderables, true);
    }

    public static Serializable title(Serializable... renderables) {
        return new DomElement("title", renderables, true);
    }

    public static Serializable tr(Serializable... renderables) {
        return new DomElement("tr", renderables, true);
    }

    public static Serializable tt(Serializable... renderables) {
        return new DomElement("tt", renderables, true);
    }

    public static Serializable u(Serializable... renderables) {
        return new DomElement("u", renderables, true);
    }

    public static Serializable ul(Serializable... renderables) {
        return new DomElement("ul", renderables, true);
    }

    public static Serializable var(Serializable... renderables) {
        return new DomElement("var", renderables, true);
    }

    public static Serializable video(Serializable... renderables) {
        return new DomElement("video", renderables, true);
    }
    }
