package org.fluentness.view;

public interface HtmlFunctions extends MarkupFunctions {

    // helpers

    default View includeCss(String href) {
        return link(with(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/resources/css/" + href));
    }

    default View includeJs(String src) {
        return script(with(SRC -> "/resources/js/" + src));
    }


//    default View style(Class<? extends StyleProvider> styleClass) {
//        try {
//            return style(styleClass.newInstance().getRuleset().toString());
//        } catch (InstantiationException | IllegalAccessException e) {
//            Logger.error(this.getClass(), e);
//        }
//        return style();
//    }

    // empty

    default View area(MarkupAttributes... attributes) {
        return new MarkupElement("area", attributes);
    }

    default View base(MarkupAttributes... attributes) {
        return new MarkupElement("base", attributes);
    }

    default View br(MarkupAttributes... attributes) {
        return new MarkupElement("br", attributes);
    }

    default View col(MarkupAttributes... attributes) {
        return new MarkupElement("col", attributes);
    }

    default View embed(MarkupAttributes... attributes) {
        return new MarkupElement("embed", attributes);
    }

    default View hr(MarkupAttributes... attributes) {
        return new MarkupElement("hr", attributes);
    }

    default View img(MarkupAttributes... attributes) {
        return new MarkupElement("img", attributes);
    }

    default View input(MarkupAttributes... attributes) {
        return new MarkupElement("input", attributes);
    }

    default View link(MarkupAttributes... attributes) {
        return new MarkupElement("link", attributes);
    }

    default View meta(MarkupAttributes... attributes) {
        return new MarkupElement("meta", attributes);
    }

    default View param(MarkupAttributes... attributes) {
        return new MarkupElement("param", attributes);
    }

    default View source(MarkupAttributes... attributes) {
        return new MarkupElement("source", attributes);
    }

    default View track(MarkupAttributes... attributes) {
        return new MarkupElement("track", attributes);
    }

    default View wbr(MarkupAttributes... attributes) {
        return new MarkupElement("wbr", attributes);
    }

    // container

    default View a(CharSequence... content) {
        return new MarkupElement("a", content);
    }

    default View abbr(CharSequence... content) {
        return new MarkupElement("abbr", content);
    }

    default View acronym(CharSequence... content) {
        return new MarkupElement("acronym", content);
    }

    default View address(CharSequence... content) {
        return new MarkupElement("address", content);
    }

    default View applet(CharSequence... content) {
        return new MarkupElement("applet", content);
    }

    default View article(CharSequence... content) {
        return new MarkupElement("article", content);
    }

    default View aside(CharSequence... content) {
        return new MarkupElement("aside", content);
    }

    default View audio(CharSequence... content) {
        return new MarkupElement("audio", content);
    }

    default View b(CharSequence... content) {
        return new MarkupElement("b", content);
    }

    default View basefont(CharSequence... content) {
        return new MarkupElement("basefont", content);
    }

    default View bdi(CharSequence... content) {
        return new MarkupElement("bdi", content);
    }

    default View bdo(CharSequence... content) {
        return new MarkupElement("bdo", content);
    }

    default View big(CharSequence... content) {
        return new MarkupElement("big", content);
    }

    default View blockquote(CharSequence... content) {
        return new MarkupElement("blockquote", content);
    }

    default View body(CharSequence... content) {
        return new MarkupElement("body", content);
    }

    default View button(CharSequence... content) {
        return new MarkupElement("button", content);
    }

    default View canvas(CharSequence... content) {
        return new MarkupElement("canvas", content);
    }

    default View caption(CharSequence... content) {
        return new MarkupElement("caption", content);
    }

    default View center(CharSequence... content) {
        return new MarkupElement("center", content);
    }

    default View cite(CharSequence... content) {
        return new MarkupElement("cite", content);
    }

    default View code(CharSequence... content) {
        return new MarkupElement("code", content);
    }

    default View colgroup(CharSequence... content) {
        return new MarkupElement("colgroup", content);
    }

    default View data(CharSequence... content) {
        return new MarkupElement("data", content);
    }

    default View datalist(CharSequence... content) {
        return new MarkupElement("datalist", content);
    }

    default View dd(CharSequence... content) {
        return new MarkupElement("dd", content);
    }

    default View del(CharSequence... content) {
        return new MarkupElement("del", content);
    }

    default View details(CharSequence... content) {
        return new MarkupElement("details", content);
    }

    default View dfn(CharSequence... content) {
        return new MarkupElement("dfn", content);
    }

    default View dialog(CharSequence... content) {
        return new MarkupElement("dialog", content);
    }

    default View dir(CharSequence... content) {
        return new MarkupElement("dir", content);
    }

    default View div(CharSequence... content) {
        return new MarkupElement("div", content);
    }

    default View dl(CharSequence... content) {
        return new MarkupElement("dl", content);
    }

    default View dt(CharSequence... content) {
        return new MarkupElement("dt", content);
    }

    default View em(CharSequence... content) {
        return new MarkupElement("em", content);
    }

    default View fieldset(CharSequence... content) {
        return new MarkupElement("fieldset", content);
    }

    default View figcaption(CharSequence... content) {
        return new MarkupElement("figcaption", content);
    }

    default View figure(CharSequence... content) {
        return new MarkupElement("figure", content);
    }

    default View font(CharSequence... content) {
        return new MarkupElement("font", content);
    }

    default View footer(CharSequence... content) {
        return new MarkupElement("footer", content);
    }

    default View form(CharSequence... content) {
        return new MarkupElement("form", content);
    }

    default View frame(CharSequence... content) {
        return new MarkupElement("frame", content);
    }

    default View frameset(CharSequence... content) {
        return new MarkupElement("frameset", content);
    }

    default View h1(CharSequence... content) {
        return new MarkupElement("h1", content);
    }

    default View h2(CharSequence... content) {
        return new MarkupElement("h2", content);
    }

    default View h3(CharSequence... content) {
        return new MarkupElement("h3", content);
    }

    default View h4(CharSequence... content) {
        return new MarkupElement("h4", content);
    }

    default View h5(CharSequence... content) {
        return new MarkupElement("h5", content);
    }

    default View h6(CharSequence... content) {
        return new MarkupElement("h6", content);
    }

    default View head(CharSequence... content) {
        return new MarkupElement("head", content);
    }

    default View header(CharSequence... content) {
        return new MarkupElement("header", content);
    }

    default View html(CharSequence... content) {
        return new MarkupElement("html", content).precededBy(new MarkupElement("!doctype", with(html -> null)));
    }

    default View i(CharSequence... content) {
        return new MarkupElement("i", content);
    }

    default View iframe(CharSequence... content) {
        return new MarkupElement("iframe", content);
    }

    default View ins(CharSequence... content) {
        return new MarkupElement("ins", content);
    }

    default View kbd(CharSequence... content) {
        return new MarkupElement("kbd", content);
    }

    default View label(CharSequence... content) {
        return new MarkupElement("label", content);
    }

    default View legend(CharSequence... content) {
        return new MarkupElement("legend", content);
    }

    default View li(CharSequence... content) {
        return new MarkupElement("li", content);
    }

    default View main(CharSequence... content) {
        return new MarkupElement("main", content);
    }

    default View map(CharSequence... content) {
        return new MarkupElement("map", content);
    }

    default View mark(CharSequence... content) {
        return new MarkupElement("mark", content);
    }

    default View meter(CharSequence... content) {
        return new MarkupElement("meter", content);
    }

    default View nav(CharSequence... content) {
        return new MarkupElement("nav", content);
    }

    default View noframes(CharSequence... content) {
        return new MarkupElement("noframes", content);
    }

    default View noscript(CharSequence... content) {
        return new MarkupElement("noscript", content);
    }

    default View object(CharSequence... content) {
        return new MarkupElement("object", content);
    }

    default View ol(CharSequence... content) {
        return new MarkupElement("ol", content);
    }

    default View optgroup(CharSequence... content) {
        return new MarkupElement("optgroup", content);
    }

    default View option(CharSequence... content) {
        return new MarkupElement("option", content);
    }

    default View output(CharSequence... content) {
        return new MarkupElement("output", content);
    }

    default View p(CharSequence... content) {
        return new MarkupElement("p", content);
    }

    default View picture(CharSequence... content) {
        return new MarkupElement("picture", content);
    }

    default View pre(CharSequence... content) {
        return new MarkupElement("pre", content);
    }

    default View progress(CharSequence... content) {
        return new MarkupElement("progress", content);
    }

    default View q(CharSequence... content) {
        return new MarkupElement("q", content);
    }

    default View rp(CharSequence... content) {
        return new MarkupElement("rp", content);
    }

    default View rt(CharSequence... content) {
        return new MarkupElement("rt", content);
    }

    default View ruby(CharSequence... content) {
        return new MarkupElement("ruby", content);
    }

    default View s(CharSequence... content) {
        return new MarkupElement("s", content);
    }

    default View samp(CharSequence... content) {
        return new MarkupElement("samp", content);
    }

    default View script(CharSequence... content) {
        return new MarkupElement("script", content);
    }

    default View section(CharSequence... content) {
        return new MarkupElement("section", content);
    }

    default View select(CharSequence... content) {
        return new MarkupElement("select", content);
    }

    default View small(CharSequence... content) {
        return new MarkupElement("small", content);
    }

    default View span(CharSequence... content) {
        return new MarkupElement("span", content);
    }

    default View strike(CharSequence... content) {
        return new MarkupElement("strike", content);
    }

    default View strong(CharSequence... content) {
        return new MarkupElement("strong", content);
    }

    default View style(CharSequence... content) {
        return new MarkupElement("style", content);
    }

    default View sub(CharSequence... content) {
        return new MarkupElement("sub", content);
    }

    default View summary(CharSequence... content) {
        return new MarkupElement("summary", content);
    }

    default View sup(CharSequence... content) {
        return new MarkupElement("sup", content);
    }

    default View svg(CharSequence... content) {
        return new MarkupElement("svg", content);
    }

    default View table(CharSequence... content) {
        return new MarkupElement("table", content);
    }

    default View tbody(CharSequence... content) {
        return new MarkupElement("tbody", content);
    }

    default View td(CharSequence... content) {
        return new MarkupElement("td", content);
    }

    default View template(CharSequence... content) {
        return new MarkupElement("template", content);
    }

    default View textarea(CharSequence... content) {
        return new MarkupElement("textarea", content);
    }

    default View tfoot(CharSequence... content) {
        return new MarkupElement("tfoot", content);
    }

    default View th(CharSequence... content) {
        return new MarkupElement("th", content);
    }

    default View thead(CharSequence... content) {
        return new MarkupElement("thead", content);
    }

    default View time(CharSequence... content) {
        return new MarkupElement("time", content);
    }

    default View title(CharSequence... content) {
        return new MarkupElement("title", content);
    }

    default View tr(CharSequence... content) {
        return new MarkupElement("tr", content);
    }

    default View tt(CharSequence... content) {
        return new MarkupElement("tt", content);
    }

    default View u(CharSequence... content) {
        return new MarkupElement("u", content);
    }

    default View ul(CharSequence... content) {
        return new MarkupElement("ul", content);
    }

    default View var(CharSequence... content) {
        return new MarkupElement("var", content);
    }

    default View video(CharSequence... content) {
        return new MarkupElement("video", content);
    }
}
