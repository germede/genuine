package org.fluentness.view;

import org.fluentness.base.settings.Configuration;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.style.Style;
import org.fluentness.style.StyleCache;

import static org.fluentness.base.settings.Settings.Keys.STYLE_CACHE;

public interface MarkupFunctions {

    // helpers
    default EmptyMarkupElement includeCss(String href) {
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> href);
    }

    default ContainerMarkupElement includeJs(String src) {
        return script().attrs(SRC -> "/" + PublicDirectories.JS + "/" + src);
    }

    default EmptyMarkupElement include(Style style) {
        if (!Configuration.INSTANCE.getBoolean(STYLE_CACHE) || !StyleCache.INSTANCE.isCacheable(style)) {
            StyleCache.INSTANCE.store(style, style.toString());
        }
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + StyleCache.INSTANCE.getIdentifyingPath(style));
    }

    // empty
    default EmptyMarkupElement area(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("area", attributes);
    }

    default EmptyMarkupElement base(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("base", attributes);
    }

    default EmptyMarkupElement br(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("br", attributes);
    }

    default EmptyMarkupElement col(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("col", attributes);
    }

    default EmptyMarkupElement embed(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("embed", attributes);
    }

    default EmptyMarkupElement hr(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("hr", attributes);
    }

    default EmptyMarkupElement img(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("img", attributes);
    }

    default EmptyMarkupElement input(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("input", attributes);
    }

    default EmptyMarkupElement link(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("link", attributes);
    }

    default EmptyMarkupElement meta(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("meta", attributes);
    }

    default EmptyMarkupElement param(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("param", attributes);
    }

    default EmptyMarkupElement source(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("source", attributes);
    }

    default EmptyMarkupElement track(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("track", attributes);
    }

    default EmptyMarkupElement wbr(KeyValuePair<String>... attributes) {
        return new EmptyMarkupElement("wbr", attributes);
    }

    // container
    default ContainerMarkupElement a(MarkupElement... inner) {
        return new ContainerMarkupElement("a", inner);
    }

    default ContainerMarkupElement abbr(MarkupElement... inner) {
        return new ContainerMarkupElement("abbr", inner);
    }

    default ContainerMarkupElement acronym(MarkupElement... inner) {
        return new ContainerMarkupElement("acronym", inner);
    }

    default ContainerMarkupElement address(MarkupElement... inner) {
        return new ContainerMarkupElement("address", inner);
    }

    default ContainerMarkupElement applet(MarkupElement... inner) {
        return new ContainerMarkupElement("applet", inner);
    }

    default ContainerMarkupElement article(MarkupElement... inner) {
        return new ContainerMarkupElement("article", inner);
    }

    default ContainerMarkupElement aside(MarkupElement... inner) {
        return new ContainerMarkupElement("aside", inner);
    }

    default ContainerMarkupElement audio(MarkupElement... inner) {
        return new ContainerMarkupElement("audio", inner);
    }

    default ContainerMarkupElement b(MarkupElement... inner) {
        return new ContainerMarkupElement("b", inner);
    }

    default ContainerMarkupElement basefont(MarkupElement... inner) {
        return new ContainerMarkupElement("basefont", inner);
    }

    default ContainerMarkupElement bdi(MarkupElement... inner) {
        return new ContainerMarkupElement("bdi", inner);
    }

    default ContainerMarkupElement bdo(MarkupElement... inner) {
        return new ContainerMarkupElement("bdo", inner);
    }

    default ContainerMarkupElement big(MarkupElement... inner) {
        return new ContainerMarkupElement("big", inner);
    }

    default ContainerMarkupElement blockquote(MarkupElement... inner) {
        return new ContainerMarkupElement("blockquote", inner);
    }

    default ContainerMarkupElement body(MarkupElement... inner) {
        return new ContainerMarkupElement("body", inner);
    }

    default ContainerMarkupElement button(MarkupElement... inner) {
        return new ContainerMarkupElement("button", inner);
    }

    default ContainerMarkupElement canvas(MarkupElement... inner) {
        return new ContainerMarkupElement("canvas", inner);
    }

    default ContainerMarkupElement caption(MarkupElement... inner) {
        return new ContainerMarkupElement("caption", inner);
    }

    default ContainerMarkupElement center(MarkupElement... inner) {
        return new ContainerMarkupElement("center", inner);
    }

    default ContainerMarkupElement cite(MarkupElement... inner) {
        return new ContainerMarkupElement("cite", inner);
    }

    default ContainerMarkupElement code(MarkupElement... inner) {
        return new ContainerMarkupElement("code", inner);
    }

    default ContainerMarkupElement colgroup(MarkupElement... inner) {
        return new ContainerMarkupElement("colgroup", inner);
    }

    default ContainerMarkupElement data(MarkupElement... inner) {
        return new ContainerMarkupElement("data", inner);
    }

    default ContainerMarkupElement datalist(MarkupElement... inner) {
        return new ContainerMarkupElement("datalist", inner);
    }

    default ContainerMarkupElement dd(MarkupElement... inner) {
        return new ContainerMarkupElement("dd", inner);
    }

    default ContainerMarkupElement del(MarkupElement... inner) {
        return new ContainerMarkupElement("del", inner);
    }

    default ContainerMarkupElement details(MarkupElement... inner) {
        return new ContainerMarkupElement("details", inner);
    }

    default ContainerMarkupElement dfn(MarkupElement... inner) {
        return new ContainerMarkupElement("dfn", inner);
    }

    default ContainerMarkupElement dialog(MarkupElement... inner) {
        return new ContainerMarkupElement("dialog", inner);
    }

    default ContainerMarkupElement dir(MarkupElement... inner) {
        return new ContainerMarkupElement("dir", inner);
    }

    default ContainerMarkupElement div(MarkupElement... inner) {
        return new ContainerMarkupElement("div", inner);
    }

    default ContainerMarkupElement dl(MarkupElement... inner) {
        return new ContainerMarkupElement("dl", inner);
    }

    default ContainerMarkupElement dt(MarkupElement... inner) {
        return new ContainerMarkupElement("dt", inner);
    }

    default ContainerMarkupElement em(MarkupElement... inner) {
        return new ContainerMarkupElement("em", inner);
    }

    default ContainerMarkupElement fieldset(MarkupElement... inner) {
        return new ContainerMarkupElement("fieldset", inner);
    }

    default ContainerMarkupElement figcaption(MarkupElement... inner) {
        return new ContainerMarkupElement("figcaption", inner);
    }

    default ContainerMarkupElement figure(MarkupElement... inner) {
        return new ContainerMarkupElement("figure", inner);
    }

    default ContainerMarkupElement font(MarkupElement... inner) {
        return new ContainerMarkupElement("font", inner);
    }

    default ContainerMarkupElement footer(MarkupElement... inner) {
        return new ContainerMarkupElement("footer", inner);
    }

    default ContainerMarkupElement form(MarkupElement... inner) {
        return new ContainerMarkupElement("form", inner);
    }

    default ContainerMarkupElement frame(MarkupElement... inner) {
        return new ContainerMarkupElement("frame", inner);
    }

    default ContainerMarkupElement frameset(MarkupElement... inner) {
        return new ContainerMarkupElement("frameset", inner);
    }

    default ContainerMarkupElement h1(MarkupElement... inner) {
        return new ContainerMarkupElement("h1", inner);
    }

    default ContainerMarkupElement h2(MarkupElement... inner) {
        return new ContainerMarkupElement("h2", inner);
    }

    default ContainerMarkupElement h3(MarkupElement... inner) {
        return new ContainerMarkupElement("h3", inner);
    }

    default ContainerMarkupElement h4(MarkupElement... inner) {
        return new ContainerMarkupElement("h4", inner);
    }

    default ContainerMarkupElement h5(MarkupElement... inner) {
        return new ContainerMarkupElement("h5", inner);
    }

    default ContainerMarkupElement h6(MarkupElement... inner) {
        return new ContainerMarkupElement("h6", inner);
    }

    default ContainerMarkupElement head(MarkupElement... inner) {
        return new ContainerMarkupElement("head", inner);
    }

    default ContainerMarkupElement header(MarkupElement... inner) {
        return new ContainerMarkupElement("header", inner);
    }

    default ContainerMarkupElement html(MarkupElement... inner) {
        return (ContainerMarkupElement) new ContainerMarkupElement("html", inner)
            .precededBy(new EmptyMarkupElement("!doctype", html -> null));
    }

    default ContainerMarkupElement i(MarkupElement... inner) {
        return new ContainerMarkupElement("i", inner);
    }

    default ContainerMarkupElement iframe(MarkupElement... inner) {
        return new ContainerMarkupElement("iframe", inner);
    }

    default ContainerMarkupElement ins(MarkupElement... inner) {
        return new ContainerMarkupElement("ins", inner);
    }

    default ContainerMarkupElement kbd(MarkupElement... inner) {
        return new ContainerMarkupElement("kbd", inner);
    }

    default ContainerMarkupElement label(MarkupElement... inner) {
        return new ContainerMarkupElement("label", inner);
    }

    default ContainerMarkupElement legend(MarkupElement... inner) {
        return new ContainerMarkupElement("legend", inner);
    }

    default ContainerMarkupElement li(MarkupElement... inner) {
        return new ContainerMarkupElement("li", inner);
    }

    default ContainerMarkupElement main(MarkupElement... inner) {
        return new ContainerMarkupElement("main", inner);
    }

    default ContainerMarkupElement map(MarkupElement... inner) {
        return new ContainerMarkupElement("map", inner);
    }

    default ContainerMarkupElement mark(MarkupElement... inner) {
        return new ContainerMarkupElement("mark", inner);
    }

    default ContainerMarkupElement meter(MarkupElement... inner) {
        return new ContainerMarkupElement("meter", inner);
    }

    default ContainerMarkupElement nav(MarkupElement... inner) {
        return new ContainerMarkupElement("nav", inner);
    }

    default ContainerMarkupElement noframes(MarkupElement... inner) {
        return new ContainerMarkupElement("noframes", inner);
    }

    default ContainerMarkupElement noscript(MarkupElement... inner) {
        return new ContainerMarkupElement("noscript", inner);
    }

    default ContainerMarkupElement object(MarkupElement... inner) {
        return new ContainerMarkupElement("object", inner);
    }

    default ContainerMarkupElement ol(MarkupElement... inner) {
        return new ContainerMarkupElement("ol", inner);
    }

    default ContainerMarkupElement optgroup(MarkupElement... inner) {
        return new ContainerMarkupElement("optgroup", inner);
    }

    default ContainerMarkupElement option(MarkupElement... inner) {
        return new ContainerMarkupElement("option", inner);
    }

    default ContainerMarkupElement output(MarkupElement... inner) {
        return new ContainerMarkupElement("output", inner);
    }

    default ContainerMarkupElement p(MarkupElement... inner) {
        return new ContainerMarkupElement("p", inner);
    }

    default ContainerMarkupElement picture(MarkupElement... inner) {
        return new ContainerMarkupElement("picture", inner);
    }

    default ContainerMarkupElement pre(MarkupElement... inner) {
        return new ContainerMarkupElement("pre", inner);
    }

    default ContainerMarkupElement progress(MarkupElement... inner) {
        return new ContainerMarkupElement("progress", inner);
    }

    default ContainerMarkupElement q(MarkupElement... inner) {
        return new ContainerMarkupElement("q", inner);
    }

    default ContainerMarkupElement rp(MarkupElement... inner) {
        return new ContainerMarkupElement("rp", inner);
    }

    default ContainerMarkupElement rt(MarkupElement... inner) {
        return new ContainerMarkupElement("rt", inner);
    }

    default ContainerMarkupElement ruby(MarkupElement... inner) {
        return new ContainerMarkupElement("ruby", inner);
    }

    default ContainerMarkupElement s(MarkupElement... inner) {
        return new ContainerMarkupElement("s", inner);
    }

    default ContainerMarkupElement samp(MarkupElement... inner) {
        return new ContainerMarkupElement("samp", inner);
    }

    default ContainerMarkupElement script(MarkupElement... inner) {
        return new ContainerMarkupElement("script", inner);
    }

    default ContainerMarkupElement section(MarkupElement... inner) {
        return new ContainerMarkupElement("section", inner);
    }

    default ContainerMarkupElement select(MarkupElement... inner) {
        return new ContainerMarkupElement("select", inner);
    }

    default ContainerMarkupElement small(MarkupElement... inner) {
        return new ContainerMarkupElement("small", inner);
    }

    default ContainerMarkupElement span(MarkupElement... inner) {
        return new ContainerMarkupElement("span", inner);
    }

    default ContainerMarkupElement strike(MarkupElement... inner) {
        return new ContainerMarkupElement("strike", inner);
    }

    default ContainerMarkupElement strong(MarkupElement... inner) {
        return new ContainerMarkupElement("strong", inner);
    }

    default ContainerMarkupElement style(MarkupElement... inner) {
        return new ContainerMarkupElement("style", inner);
    }

    default ContainerMarkupElement sub(MarkupElement... inner) {
        return new ContainerMarkupElement("sub", inner);
    }

    default ContainerMarkupElement summary(MarkupElement... inner) {
        return new ContainerMarkupElement("summary", inner);
    }

    default ContainerMarkupElement sup(MarkupElement... inner) {
        return new ContainerMarkupElement("sup", inner);
    }

    default ContainerMarkupElement svg(MarkupElement... inner) {
        return new ContainerMarkupElement("svg", inner);
    }

    default ContainerMarkupElement table(MarkupElement... inner) {
        return new ContainerMarkupElement("table", inner);
    }

    default ContainerMarkupElement tbody(MarkupElement... inner) {
        return new ContainerMarkupElement("tbody", inner);
    }

    default ContainerMarkupElement td(MarkupElement... inner) {
        return new ContainerMarkupElement("td", inner);
    }

    default ContainerMarkupElement template(MarkupElement... inner) {
        return new ContainerMarkupElement("template", inner);
    }

    default ContainerMarkupElement textarea(MarkupElement... inner) {
        return new ContainerMarkupElement("textarea", inner);
    }

    default ContainerMarkupElement tfoot(MarkupElement... inner) {
        return new ContainerMarkupElement("tfoot", inner);
    }

    default ContainerMarkupElement th(MarkupElement... inner) {
        return new ContainerMarkupElement("th", inner);
    }

    default ContainerMarkupElement thead(MarkupElement... inner) {
        return new ContainerMarkupElement("thead", inner);
    }

    default ContainerMarkupElement time(MarkupElement... inner) {
        return new ContainerMarkupElement("time", inner);
    }

    default ContainerMarkupElement title(MarkupElement... inner) {
        return new ContainerMarkupElement("title", inner);
    }

    default ContainerMarkupElement tr(MarkupElement... inner) {
        return new ContainerMarkupElement("tr", inner);
    }

    default ContainerMarkupElement tt(MarkupElement... inner) {
        return new ContainerMarkupElement("tt", inner);
    }

    default ContainerMarkupElement u(MarkupElement... inner) {
        return new ContainerMarkupElement("u", inner);
    }

    default ContainerMarkupElement ul(MarkupElement... inner) {
        return new ContainerMarkupElement("ul", inner);
    }

    default ContainerMarkupElement var(MarkupElement... inner) {
        return new ContainerMarkupElement("var", inner);
    }

    default ContainerMarkupElement video(MarkupElement... inner) {
        return new ContainerMarkupElement("video", inner);
    }

    default ContainerMarkupElement a(String inner) {
        return new ContainerMarkupElement("a", inner);
    }

    default ContainerMarkupElement abbr(String inner) {
        return new ContainerMarkupElement("abbr", inner);
    }

    default ContainerMarkupElement acronym(String inner) {
        return new ContainerMarkupElement("acronym", inner);
    }

    default ContainerMarkupElement address(String inner) {
        return new ContainerMarkupElement("address", inner);
    }

    default ContainerMarkupElement applet(String inner) {
        return new ContainerMarkupElement("applet", inner);
    }

    default ContainerMarkupElement article(String inner) {
        return new ContainerMarkupElement("article", inner);
    }

    default ContainerMarkupElement aside(String inner) {
        return new ContainerMarkupElement("aside", inner);
    }

    default ContainerMarkupElement audio(String inner) {
        return new ContainerMarkupElement("audio", inner);
    }

    default ContainerMarkupElement b(String inner) {
        return new ContainerMarkupElement("b", inner);
    }

    default ContainerMarkupElement basefont(String inner) {
        return new ContainerMarkupElement("basefont", inner);
    }

    default ContainerMarkupElement bdi(String inner) {
        return new ContainerMarkupElement("bdi", inner);
    }

    default ContainerMarkupElement bdo(String inner) {
        return new ContainerMarkupElement("bdo", inner);
    }

    default ContainerMarkupElement big(String inner) {
        return new ContainerMarkupElement("big", inner);
    }

    default ContainerMarkupElement blockquote(String inner) {
        return new ContainerMarkupElement("blockquote", inner);
    }

    default ContainerMarkupElement body(String inner) {
        return new ContainerMarkupElement("body", inner);
    }

    default ContainerMarkupElement button(String inner) {
        return new ContainerMarkupElement("button", inner);
    }

    default ContainerMarkupElement canvas(String inner) {
        return new ContainerMarkupElement("canvas", inner);
    }

    default ContainerMarkupElement caption(String inner) {
        return new ContainerMarkupElement("caption", inner);
    }

    default ContainerMarkupElement center(String inner) {
        return new ContainerMarkupElement("center", inner);
    }

    default ContainerMarkupElement cite(String inner) {
        return new ContainerMarkupElement("cite", inner);
    }

    default ContainerMarkupElement code(String inner) {
        return new ContainerMarkupElement("code", inner);
    }

    default ContainerMarkupElement colgroup(String inner) {
        return new ContainerMarkupElement("colgroup", inner);
    }

    default ContainerMarkupElement data(String inner) {
        return new ContainerMarkupElement("data", inner);
    }

    default ContainerMarkupElement datalist(String inner) {
        return new ContainerMarkupElement("datalist", inner);
    }

    default ContainerMarkupElement dd(String inner) {
        return new ContainerMarkupElement("dd", inner);
    }

    default ContainerMarkupElement del(String inner) {
        return new ContainerMarkupElement("del", inner);
    }

    default ContainerMarkupElement details(String inner) {
        return new ContainerMarkupElement("details", inner);
    }

    default ContainerMarkupElement dfn(String inner) {
        return new ContainerMarkupElement("dfn", inner);
    }

    default ContainerMarkupElement dialog(String inner) {
        return new ContainerMarkupElement("dialog", inner);
    }

    default ContainerMarkupElement dir(String inner) {
        return new ContainerMarkupElement("dir", inner);
    }

    default ContainerMarkupElement div(String inner) {
        return new ContainerMarkupElement("div", inner);
    }

    default ContainerMarkupElement dl(String inner) {
        return new ContainerMarkupElement("dl", inner);
    }

    default ContainerMarkupElement dt(String inner) {
        return new ContainerMarkupElement("dt", inner);
    }

    default ContainerMarkupElement em(String inner) {
        return new ContainerMarkupElement("em", inner);
    }

    default ContainerMarkupElement fieldset(String inner) {
        return new ContainerMarkupElement("fieldset", inner);
    }

    default ContainerMarkupElement figcaption(String inner) {
        return new ContainerMarkupElement("figcaption", inner);
    }

    default ContainerMarkupElement figure(String inner) {
        return new ContainerMarkupElement("figure", inner);
    }

    default ContainerMarkupElement font(String inner) {
        return new ContainerMarkupElement("font", inner);
    }

    default ContainerMarkupElement footer(String inner) {
        return new ContainerMarkupElement("footer", inner);
    }

//    default ContainerMarkupElement form(String inner) {
//        return new ContainerMarkupElement("form", inner);
//    }

    default ContainerMarkupElement frame(String inner) {
        return new ContainerMarkupElement("frame", inner);
    }

    default ContainerMarkupElement frameset(String inner) {
        return new ContainerMarkupElement("frameset", inner);
    }

    default ContainerMarkupElement h1(String inner) {
        return new ContainerMarkupElement("h1", inner);
    }

    default ContainerMarkupElement h2(String inner) {
        return new ContainerMarkupElement("h2", inner);
    }

    default ContainerMarkupElement h3(String inner) {
        return new ContainerMarkupElement("h3", inner);
    }

    default ContainerMarkupElement h4(String inner) {
        return new ContainerMarkupElement("h4", inner);
    }

    default ContainerMarkupElement h5(String inner) {
        return new ContainerMarkupElement("h5", inner);
    }

    default ContainerMarkupElement h6(String inner) {
        return new ContainerMarkupElement("h6", inner);
    }

    default ContainerMarkupElement head(String inner) {
        return new ContainerMarkupElement("head", inner);
    }

    default ContainerMarkupElement header(String inner) {
        return new ContainerMarkupElement("header", inner);
    }

    default ContainerMarkupElement html(String inner) {
        return (ContainerMarkupElement) new ContainerMarkupElement("html", inner)
            .precededBy(new EmptyMarkupElement("!doctype", html -> null));
    }

    default ContainerMarkupElement i(String inner) {
        return new ContainerMarkupElement("i", inner);
    }

    default ContainerMarkupElement iframe(String inner) {
        return new ContainerMarkupElement("iframe", inner);
    }

    default ContainerMarkupElement ins(String inner) {
        return new ContainerMarkupElement("ins", inner);
    }

    default ContainerMarkupElement kbd(String inner) {
        return new ContainerMarkupElement("kbd", inner);
    }

    default ContainerMarkupElement label(String inner) {
        return new ContainerMarkupElement("label", inner);
    }

    default ContainerMarkupElement legend(String inner) {
        return new ContainerMarkupElement("legend", inner);
    }

    default ContainerMarkupElement li(String inner) {
        return new ContainerMarkupElement("li", inner);
    }

    default ContainerMarkupElement main(String inner) {
        return new ContainerMarkupElement("main", inner);
    }

    default ContainerMarkupElement map(String inner) {
        return new ContainerMarkupElement("map", inner);
    }

    default ContainerMarkupElement mark(String inner) {
        return new ContainerMarkupElement("mark", inner);
    }

    default ContainerMarkupElement meter(String inner) {
        return new ContainerMarkupElement("meter", inner);
    }

    default ContainerMarkupElement nav(String inner) {
        return new ContainerMarkupElement("nav", inner);
    }

    default ContainerMarkupElement noframes(String inner) {
        return new ContainerMarkupElement("noframes", inner);
    }

    default ContainerMarkupElement noscript(String inner) {
        return new ContainerMarkupElement("noscript", inner);
    }

    default ContainerMarkupElement object(String inner) {
        return new ContainerMarkupElement("object", inner);
    }

    default ContainerMarkupElement ol(String inner) {
        return new ContainerMarkupElement("ol", inner);
    }

    default ContainerMarkupElement optgroup(String inner) {
        return new ContainerMarkupElement("optgroup", inner);
    }

    default ContainerMarkupElement option(String inner) {
        return new ContainerMarkupElement("option", inner);
    }

    default ContainerMarkupElement output(String inner) {
        return new ContainerMarkupElement("output", inner);
    }

    default ContainerMarkupElement p(String inner) {
        return new ContainerMarkupElement("p", inner);
    }

    default ContainerMarkupElement picture(String inner) {
        return new ContainerMarkupElement("picture", inner);
    }

    default ContainerMarkupElement pre(String inner) {
        return new ContainerMarkupElement("pre", inner);
    }

    default ContainerMarkupElement progress(String inner) {
        return new ContainerMarkupElement("progress", inner);
    }

    default ContainerMarkupElement q(String inner) {
        return new ContainerMarkupElement("q", inner);
    }

    default ContainerMarkupElement rp(String inner) {
        return new ContainerMarkupElement("rp", inner);
    }

    default ContainerMarkupElement rt(String inner) {
        return new ContainerMarkupElement("rt", inner);
    }

    default ContainerMarkupElement ruby(String inner) {
        return new ContainerMarkupElement("ruby", inner);
    }

    default ContainerMarkupElement s(String inner) {
        return new ContainerMarkupElement("s", inner);
    }

    default ContainerMarkupElement samp(String inner) {
        return new ContainerMarkupElement("samp", inner);
    }

    default ContainerMarkupElement script(String inner) {
        return new ContainerMarkupElement("script", inner);
    }

    default ContainerMarkupElement section(String inner) {
        return new ContainerMarkupElement("section", inner);
    }

    default ContainerMarkupElement select(String inner) {
        return new ContainerMarkupElement("select", inner);
    }

    default ContainerMarkupElement small(String inner) {
        return new ContainerMarkupElement("small", inner);
    }

    default ContainerMarkupElement span(String inner) {
        return new ContainerMarkupElement("span", inner);
    }

    default ContainerMarkupElement strike(String inner) {
        return new ContainerMarkupElement("strike", inner);
    }

    default ContainerMarkupElement strong(String inner) {
        return new ContainerMarkupElement("strong", inner);
    }

//    default ContainerMarkupElement style(String inner) {
//        return new ContainerMarkupElement("style", inner);
//    }

    default ContainerMarkupElement sub(String inner) {
        return new ContainerMarkupElement("sub", inner);
    }

    default ContainerMarkupElement summary(String inner) {
        return new ContainerMarkupElement("summary", inner);
    }

    default ContainerMarkupElement sup(String inner) {
        return new ContainerMarkupElement("sup", inner);
    }

    default ContainerMarkupElement svg(String inner) {
        return new ContainerMarkupElement("svg", inner);
    }

    default ContainerMarkupElement table(String inner) {
        return new ContainerMarkupElement("table", inner);
    }

    default ContainerMarkupElement tbody(String inner) {
        return new ContainerMarkupElement("tbody", inner);
    }

    default ContainerMarkupElement td(String inner) {
        return new ContainerMarkupElement("td", inner);
    }

    default ContainerMarkupElement template(String inner) {
        return new ContainerMarkupElement("template", inner);
    }

    default ContainerMarkupElement textarea(String inner) {
        return new ContainerMarkupElement("textarea", inner);
    }

    default ContainerMarkupElement tfoot(String inner) {
        return new ContainerMarkupElement("tfoot", inner);
    }

    default ContainerMarkupElement th(String inner) {
        return new ContainerMarkupElement("th", inner);
    }

    default ContainerMarkupElement thead(String inner) {
        return new ContainerMarkupElement("thead", inner);
    }

    default ContainerMarkupElement time(String inner) {
        return new ContainerMarkupElement("time", inner);
    }

    default ContainerMarkupElement title(String inner) {
        return new ContainerMarkupElement("title", inner);
    }

    default ContainerMarkupElement tr(String inner) {
        return new ContainerMarkupElement("tr", inner);
    }

    default ContainerMarkupElement tt(String inner) {
        return new ContainerMarkupElement("tt", inner);
    }

    default ContainerMarkupElement u(String inner) {
        return new ContainerMarkupElement("u", inner);
    }

    default ContainerMarkupElement ul(String inner) {
        return new ContainerMarkupElement("ul", inner);
    }

    default ContainerMarkupElement var(String inner) {
        return new ContainerMarkupElement("var", inner);
    }

    default ContainerMarkupElement video(String inner) {
        return new ContainerMarkupElement("video", inner);
    }

}
