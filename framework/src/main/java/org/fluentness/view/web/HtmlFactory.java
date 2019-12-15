package org.fluentness.view.web;

import org.fluentness.controller.web.WebAction;
import org.fluentness.model.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static org.fluentness.view.web.HtmlAttribute.HREF;

public final class HtmlFactory {

    // special web views
    public static HtmlElement action(WebAction action, CharSequence... html) {
        return a(html).add(HREF + action.getPath());
    }

    public static <T> HtmlForm<T> form(WebAction submitAction, Model model) {
        return new HtmlForm<>(model, submitAction);
    }

    public static <T> HtmlTable table(List<T> modelList) {
        return new HtmlTable(modelList);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new HtmlView[0]);
    }

    // container html views
    public static HtmlElement a(CharSequence... html) {
        return new HtmlElement("a", html);
    }

    public static HtmlElement abbr(CharSequence... html) {
        return new HtmlElement("abbr", html);
    }

    public static HtmlElement acronym(CharSequence... html) {
        return new HtmlElement("acronym", html);
    }

    public static HtmlElement address(CharSequence... html) {
        return new HtmlElement("address", html);
    }

    public static HtmlElement applet(CharSequence... html) {
        return new HtmlElement("applet", html);
    }

    public static HtmlElement article(CharSequence... html) {
        return new HtmlElement("article", html);
    }

    public static HtmlElement aside(CharSequence... html) {
        return new HtmlElement("aside", html);
    }

    public static HtmlElement audio(CharSequence... html) {
        return new HtmlElement("audio", html);
    }

    public static HtmlElement b(CharSequence... html) {
        return new HtmlElement("b", html);
    }

    public static HtmlElement basefont(CharSequence... html) {
        return new HtmlElement("basefont", html);
    }

    public static HtmlElement bdi(CharSequence... html) {
        return new HtmlElement("bdi", html);
    }

    public static HtmlElement bdo(CharSequence... html) {
        return new HtmlElement("bdo", html);
    }

    public static HtmlElement big(CharSequence... html) {
        return new HtmlElement("big", html);
    }

    public static HtmlElement blockquote(CharSequence... html) {
        return new HtmlElement("blockquote", html);
    }

    public static HtmlElement body(CharSequence... html) {
        return new HtmlElement("body", html);
    }

    public static HtmlElement button(CharSequence... html) {
        return new HtmlElement("button", html);
    }

    public static HtmlElement canvas(CharSequence... html) {
        return new HtmlElement("canvas", html);
    }

    public static HtmlElement caption(CharSequence... html) {
        return new HtmlElement("caption", html);
    }

    public static HtmlElement center(CharSequence... html) {
        return new HtmlElement("center", html);
    }

    public static HtmlElement cite(CharSequence... html) {
        return new HtmlElement("cite", html);
    }

    public static HtmlElement code(CharSequence... html) {
        return new HtmlElement("code", html);
    }

    public static HtmlElement colgroup(CharSequence... html) {
        return new HtmlElement("colgroup", html);
    }

    public static HtmlElement data(CharSequence... html) {
        return new HtmlElement("data", html);
    }

    public static HtmlElement datalist(CharSequence... html) {
        return new HtmlElement("datalist", html);
    }

    public static HtmlElement dd(CharSequence... html) {
        return new HtmlElement("dd", html);
    }

    public static HtmlElement del(CharSequence... html) {
        return new HtmlElement("del", html);
    }

    public static HtmlElement details(CharSequence... html) {
        return new HtmlElement("details", html);
    }

    public static HtmlElement dfn(CharSequence... html) {
        return new HtmlElement("dfn", html);
    }

    public static HtmlElement dialog(CharSequence... html) {
        return new HtmlElement("dialog", html);
    }

    public static HtmlElement dir(CharSequence... html) {
        return new HtmlElement("dir", html);
    }

    public static HtmlElement div(CharSequence... html) {
        return new HtmlElement("div", html);
    }

    public static HtmlElement dl(CharSequence... html) {
        return new HtmlElement("dl", html);
    }

    public static HtmlElement dt(CharSequence... html) {
        return new HtmlElement("dt", html);
    }

    public static HtmlElement em(CharSequence... html) {
        return new HtmlElement("em", html);
    }

    public static HtmlElement fieldset(CharSequence... html) {
        return new HtmlElement("fieldset", html);
    }

    public static HtmlElement figcaption(CharSequence... html) {
        return new HtmlElement("figcaption", html);
    }

    public static HtmlElement figure(CharSequence... html) {
        return new HtmlElement("figure", html);
    }

    public static HtmlElement font(CharSequence... html) {
        return new HtmlElement("font", html);
    }

    public static HtmlElement footer(CharSequence... html) {
        return new HtmlElement("footer", html);
    }

    public static HtmlElement form(CharSequence... html) {
        return new HtmlElement("form", html);
    }

    public static HtmlElement frame(CharSequence... html) {
        return new HtmlElement("frame", html);
    }

    public static HtmlElement frameset(CharSequence... html) {
        return new HtmlElement("frameset", html);
    }

    public static HtmlElement h1(CharSequence... html) {
        return new HtmlElement("h1", html);
    }

    public static HtmlElement h2(CharSequence... html) {
        return new HtmlElement("h2", html);
    }

    public static HtmlElement h3(CharSequence... html) {
        return new HtmlElement("h3", html);
    }

    public static HtmlElement h4(CharSequence... html) {
        return new HtmlElement("h4", html);
    }

    public static HtmlElement h5(CharSequence... html) {
        return new HtmlElement("h5", html);
    }

    public static HtmlElement h6(CharSequence... html) {
        return new HtmlElement("h6", html);
    }

    public static HtmlElement head(CharSequence... html) {
        return new HtmlElement("head", html);
    }

    public static HtmlElement header(CharSequence... html) {
        return new HtmlElement("header", html);
    }

    public static HtmlElement html(CharSequence... html) {
        return new HtmlElement("html", html);
    }

    public static HtmlElement i(CharSequence... html) {
        return new HtmlElement("i", html);
    }

    public static HtmlElement iframe(CharSequence... html) {
        return new HtmlElement("iframe", html);
    }

    public static HtmlElement ins(CharSequence... html) {
        return new HtmlElement("ins", html);
    }

    public static HtmlElement kbd(CharSequence... html) {
        return new HtmlElement("kbd", html);
    }

    public static HtmlElement label(CharSequence... html) {
        return new HtmlElement("label", html);
    }

    public static HtmlElement legend(CharSequence... html) {
        return new HtmlElement("legend", html);
    }

    public static HtmlElement li(CharSequence... html) {
        return new HtmlElement("li", html);
    }

    public static HtmlElement main(CharSequence... html) {
        return new HtmlElement("main", html);
    }

    public static HtmlElement map(CharSequence... html) {
        return new HtmlElement("map", html);
    }

    public static HtmlElement mark(CharSequence... html) {
        return new HtmlElement("mark", html);
    }

    public static HtmlElement meter(CharSequence... html) {
        return new HtmlElement("meter", html);
    }

    public static HtmlElement nav(CharSequence... html) {
        return new HtmlElement("nav", html);
    }

    public static HtmlElement noframes(CharSequence... html) {
        return new HtmlElement("noframes", html);
    }

    public static HtmlElement noscript(CharSequence... html) {
        return new HtmlElement("noscript", html);
    }

    public static HtmlElement object(CharSequence... html) {
        return new HtmlElement("object", html);
    }

    public static HtmlElement ol(CharSequence... html) {
        return new HtmlElement("ol", html);
    }

    public static HtmlElement optgroup(CharSequence... html) {
        return new HtmlElement("optgroup", html);
    }

    public static HtmlElement option(CharSequence... html) {
        return new HtmlElement("option", html);
    }

    public static HtmlElement output(CharSequence... html) {
        return new HtmlElement("output", html);
    }

    public static HtmlElement p(CharSequence... html) {
        return new HtmlElement("p", html);
    }

    public static HtmlElement picture(CharSequence... html) {
        return new HtmlElement("picture", html);
    }

    public static HtmlElement pre(CharSequence... html) {
        return new HtmlElement("pre", html);
    }

    public static HtmlElement progress(CharSequence... html) {
        return new HtmlElement("progress", html);
    }

    public static HtmlElement q(CharSequence... html) {
        return new HtmlElement("q", html);
    }

    public static HtmlElement rp(CharSequence... html) {
        return new HtmlElement("rp", html);
    }

    public static HtmlElement rt(CharSequence... html) {
        return new HtmlElement("rt", html);
    }

    public static HtmlElement ruby(CharSequence... html) {
        return new HtmlElement("ruby", html);
    }

    public static HtmlElement s(CharSequence... html) {
        return new HtmlElement("s", html);
    }

    public static HtmlElement samp(CharSequence... html) {
        return new HtmlElement("samp", html);
    }

    public static HtmlElement script(CharSequence... html) {
        return new HtmlElement("script", html);
    }

    public static HtmlElement section(CharSequence... html) {
        return new HtmlElement("section", html);
    }

    public static HtmlElement select(CharSequence... html) {
        return new HtmlElement("select", html);
    }

    public static HtmlElement small(CharSequence... html) {
        return new HtmlElement("small", html);
    }

    public static HtmlElement span(CharSequence... html) {
        return new HtmlElement("span", html);
    }

    public static HtmlElement strike(CharSequence... html) {
        return new HtmlElement("strike", html);
    }

    public static HtmlElement strong(CharSequence... html) {
        return new HtmlElement("strong", html);
    }

    public static HtmlElement style(CharSequence... html) {
        return new HtmlElement("style", html);
    }

    public static HtmlElement sub(CharSequence... html) {
        return new HtmlElement("sub", html);
    }

    public static HtmlElement summary(CharSequence... html) {
        return new HtmlElement("summary", html);
    }

    public static HtmlElement sup(CharSequence... html) {
        return new HtmlElement("sup", html);
    }

    public static HtmlElement svg(CharSequence... html) {
        return new HtmlElement("svg", html);
    }

    public static HtmlElement table(CharSequence... html) {
        return new HtmlElement("table", html);
    }

    public static HtmlElement tbody(CharSequence... html) {
        return new HtmlElement("tbody", html);
    }

    public static HtmlElement td(CharSequence... html) {
        return new HtmlElement("td", html);
    }

    public static HtmlElement template(CharSequence... html) {
        return new HtmlElement("template", html);
    }

    public static HtmlElement textarea(CharSequence... html) {
        return new HtmlElement("textarea", html);
    }

    public static HtmlElement tfoot(CharSequence... html) {
        return new HtmlElement("tfoot", html);
    }

    public static HtmlElement th(CharSequence... html) {
        return new HtmlElement("th", html);
    }

    public static HtmlElement thead(CharSequence... html) {
        return new HtmlElement("thead", html);
    }

    public static HtmlElement time(CharSequence... html) {
        return new HtmlElement("time", html);
    }

    public static HtmlElement title(CharSequence... html) {
        return new HtmlElement("title", html);
    }

    public static HtmlElement tr(CharSequence... html) {
        return new HtmlElement("tr", html);
    }

    public static HtmlElement tt(CharSequence... html) {
        return new HtmlElement("tt", html);
    }

    public static HtmlElement u(CharSequence... html) {
        return new HtmlElement("u", html);
    }

    public static HtmlElement ul(CharSequence... html) {
        return new HtmlElement("ul", html);
    }

    public static HtmlElement var(CharSequence... html) {
        return new HtmlElement("var", html);
    }

    public static HtmlElement video(CharSequence... html) {
        return new HtmlElement("video", html);
    }

    // empty html views
    public static HtmlElement area(String... attributes) {
        return new HtmlElement("area", attributes);
    }

    public static HtmlElement base(String... attributes) {
        return new HtmlElement("base", attributes);
    }

    public static HtmlElement br(String... attributes) {
        return new HtmlElement("br", attributes);
    }

    public static HtmlElement col(String... attributes) {
        return new HtmlElement("col", attributes);
    }

    public static HtmlElement embed(String... attributes) {
        return new HtmlElement("embed", attributes);
    }

    public static HtmlElement hr(String... attributes) {
        return new HtmlElement("hr", attributes);
    }

    public static HtmlElement img(String... attributes) {
        return new HtmlElement("img", attributes);
    }

    public static HtmlElement input(String... attributes) {
        return new HtmlElement("input", attributes);
    }

    public static HtmlElement link(String... attributes) {
        return new HtmlElement("link", attributes);
    }

    public static HtmlElement meta(String... attributes) {
        return new HtmlElement("meta", attributes);
    }

    public static HtmlElement param(String... attributes) {
        return new HtmlElement("param", attributes);
    }

    public static HtmlElement source(String... attributes) {
        return new HtmlElement("source", attributes);
    }

    public static HtmlElement track(String... attributes) {
        return new HtmlElement("track", attributes);
    }

    public static HtmlElement wbr(String... attributes) {
        return new HtmlElement("wbr", attributes);
    }

}
