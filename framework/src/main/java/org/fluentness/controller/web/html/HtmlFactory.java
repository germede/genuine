package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebActionReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlFactory {

    // special web views
    public static ContainerHtml action(WebActionReference action, Html... inner) {
        List<Html> result = new ArrayList<>();
        result.add(_href(action.getPath()));
        result.addAll(Arrays.asList(inner));
        return a(result.toArray(new Html[0]));
    }

    public static <T> FormHtml<T> form(Object model, WebActionReference submitAction) {
        return new FormHtml<>(model, submitAction);
    }

    public static <T> TableHtml<T> table(List<T> modelList) {
        return new TableHtml<>(modelList);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new Html[0]);
    }

    // attributes markup views
    public static Attribute _accept(String value) {
        return new Attribute("accept", value);
    }

    public static Attribute _accept_charset(String value) {
        return new Attribute("accept-charset", value);
    }

    public static Attribute _accesskey(String value) {
        return new Attribute("accesskey", value);
    }

    public static Attribute _action(String value) {
        return new Attribute("action", value);
    }

    public static Attribute _align(String value) {
        return new Attribute("align", value);
    }

    public static Attribute _alt(String value) {
        return new Attribute("alt", value);
    }

    public static Attribute _async(String value) {
        return new Attribute("async", value);
    }

    public static Attribute _autocomplete(String value) {
        return new Attribute("autocomplete", value);
    }

    public static Attribute _autofocus(String value) {
        return new Attribute("autofocus", value);
    }

    public static Attribute _autoplay(String value) {
        return new Attribute("autoplay", value);
    }

    public static Attribute _autosave(String value) {
        return new Attribute("autosave", value);
    }

    public static Attribute _bgcolor(String value) {
        return new Attribute("bgcolor", value);
    }

    public static Attribute _border(String value) {
        return new Attribute("border", value);
    }

    public static Attribute _buffered(String value) {
        return new Attribute("buffered", value);
    }

    public static Attribute _challenge(String value) {
        return new Attribute("challenge", value);
    }

    public static Attribute _charset(String value) {
        return new Attribute("charset", value);
    }

    public static Attribute _checked(String value) {
        return new Attribute("checked", value);
    }

    public static Attribute _cite(String value) {
        return new Attribute("cite", value);
    }

    public static Attribute _class(String value) {
        return new Attribute("class", value);
    }

    public static Attribute _code(String value) {
        return new Attribute("code", value);
    }

    public static Attribute _codebase(String value) {
        return new Attribute("codebase", value);
    }

    public static Attribute _color(String value) {
        return new Attribute("color", value);
    }

    public static Attribute _cols(String value) {
        return new Attribute("cols", value);
    }

    public static Attribute _colspan(String value) {
        return new Attribute("colspan", value);
    }

    public static Attribute _content(String value) {
        return new Attribute("content", value);
    }

    public static Attribute _contenteditable(String value) {
        return new Attribute("contenteditable", value);
    }

    public static Attribute _contextmenu(String value) {
        return new Attribute("contextmenu", value);
    }

    public static Attribute _controls(String value) {
        return new Attribute("controls", value);
    }

    public static Attribute _coords(String value) {
        return new Attribute("coords", value);
    }

    public static Attribute _crossorigin(String value) {
        return new Attribute("crossorigin", value);
    }

    public static Attribute _data(String value) {
        return new Attribute("data", value);
    }

    public static Attribute _datetime(String value) {
        return new Attribute("datetime", value);
    }

    public static Attribute _default(String value) {
        return new Attribute("default", value);
    }

    public static Attribute _dir(String value) {
        return new Attribute("dir", value);
    }

    public static Attribute _dirname(String value) {
        return new Attribute("dirname", value);
    }

    public static Attribute _disabled(String value) {
        return new Attribute("disabled", value);
    }

    public static Attribute _download(String value) {
        return new Attribute("download", value);
    }

    public static Attribute _draggable(String value) {
        return new Attribute("draggable", value);
    }

    public static Attribute _dropzone(String value) {
        return new Attribute("dropzone", value);
    }

    public static Attribute _enctype(String value) {
        return new Attribute("enctype", value);
    }

    public static Attribute _for_(String value) {
        return new Attribute("for", value);
    }

    public static Attribute _form(String value) {
        return new Attribute("form", value);
    }

    public static Attribute _formaction(String value) {
        return new Attribute("formaction", value);
    }

    public static Attribute _headers(String value) {
        return new Attribute("headers", value);
    }

    public static Attribute _height(String value) {
        return new Attribute("height", value);
    }

    public static Attribute _hidden(String value) {
        return new Attribute("hidden", value);
    }

    public static Attribute _high(String value) {
        return new Attribute("high", value);
    }

    public static Attribute _href(String value) {
        return new Attribute("href", value);
    }

    public static Attribute _hreflang(String value) {
        return new Attribute("hreflang", value);
    }

    public static Attribute _http_equiv(String value) {
        return new Attribute("http-equiv", value);
    }

    public static Attribute _icon(String value) {
        return new Attribute("icon", value);
    }

    public static Attribute _id(String value) {
        return new Attribute("id", value);
    }

    public static Attribute _integrity(String value) {
        return new Attribute("integrity", value);
    }

    public static Attribute _ismap(String value) {
        return new Attribute("ismap", value);
    }

    public static Attribute _itemprop(String value) {
        return new Attribute("itemprop", value);
    }

    public static Attribute _keytype(String value) {
        return new Attribute("keytype", value);
    }

    public static Attribute _kind(String value) {
        return new Attribute("kind", value);
    }

    public static Attribute _label(String value) {
        return new Attribute("label", value);
    }

    public static Attribute _lang(String value) {
        return new Attribute("lang", value);
    }

    public static Attribute _language(String value) {
        return new Attribute("language", value);
    }

    public static Attribute _list(String value) {
        return new Attribute("list", value);
    }

    public static Attribute _loop(String value) {
        return new Attribute("loop", value);
    }

    public static Attribute _low(String value) {
        return new Attribute("low", value);
    }

    public static Attribute _manifest(String value) {
        return new Attribute("manifest", value);
    }

    public static Attribute _max(String value) {
        return new Attribute("max", value);
    }

    public static Attribute _maxlength(String value) {
        return new Attribute("maxlength", value);
    }

    public static Attribute _media(String value) {
        return new Attribute("media", value);
    }

    public static Attribute _method(String value) {
        return new Attribute("method", value);
    }

    public static Attribute _min(String value) {
        return new Attribute("min", value);
    }

    public static Attribute _multiple(String value) {
        return new Attribute("multiple", value);
    }

    public static Attribute _muted(String value) {
        return new Attribute("muted", value);
    }

    public static Attribute _name(String value) {
        return new Attribute("name", value);
    }

    public static Attribute _novalidate(String value) {
        return new Attribute("novalidate", value);
    }

    public static Attribute _open(String value) {
        return new Attribute("open", value);
    }

    public static Attribute _optimum(String value) {
        return new Attribute("optimum", value);
    }

    public static Attribute _pattern(String value) {
        return new Attribute("pattern", value);
    }

    public static Attribute _ping(String value) {
        return new Attribute("ping", value);
    }

    public static Attribute _placeholder(String value) {
        return new Attribute("placeholder", value);
    }

    public static Attribute _poster(String value) {
        return new Attribute("poster", value);
    }

    public static Attribute _preload(String value) {
        return new Attribute("preload", value);
    }

    public static Attribute _radiogroup(String value) {
        return new Attribute("radiogroup", value);
    }

    public static Attribute _readonly(String value) {
        return new Attribute("readonly", value);
    }

    public static Attribute _rel(String value) {
        return new Attribute("rel", value);
    }

    public static Attribute _required(String value) {
        return new Attribute("required", value);
    }

    public static Attribute _reversed(String value) {
        return new Attribute("reversed", value);
    }

    public static Attribute _rows(String value) {
        return new Attribute("rows", value);
    }

    public static Attribute _rowspan(String value) {
        return new Attribute("rowspan", value);
    }

    public static Attribute _sandbox(String value) {
        return new Attribute("sandbox", value);
    }

    public static Attribute _scope(String value) {
        return new Attribute("scope", value);
    }

    public static Attribute _scoped(String value) {
        return new Attribute("scoped", value);
    }

    public static Attribute _seamless(String value) {
        return new Attribute("seamless", value);
    }

    public static Attribute _selected(String value) {
        return new Attribute("selected", value);
    }

    public static Attribute _shape(String value) {
        return new Attribute("shape", value);
    }

    public static Attribute _size(String value) {
        return new Attribute("size", value);
    }

    public static Attribute _sizes(String value) {
        return new Attribute("sizes", value);
    }

    public static Attribute _slot(String value) {
        return new Attribute("slot", value);
    }

    public static Attribute _span(String value) {
        return new Attribute("span", value);
    }

    public static Attribute _spellcheck(String value) {
        return new Attribute("spellcheck", value);
    }

    public static Attribute _src(String value) {
        return new Attribute("src", value);
    }

    public static Attribute _srcdoc(String value) {
        return new Attribute("srcdoc", value);
    }

    public static Attribute _srclang(String value) {
        return new Attribute("srclang", value);
    }

    public static Attribute _srcset(String value) {
        return new Attribute("srcset", value);
    }

    public static Attribute _start(String value) {
        return new Attribute("start", value);
    }

    public static Attribute _step(String value) {
        return new Attribute("step", value);
    }

    public static Attribute _style(String value) {
        return new Attribute("style", value);
    }

    public static Attribute _summary(String value) {
        return new Attribute("summary", value);
    }

    public static Attribute _tabindex(String value) {
        return new Attribute("tabindex", value);
    }

    public static Attribute _target(String value) {
        return new Attribute("target", value);
    }

    public static Attribute _title(String value) {
        return new Attribute("title", value);
    }

    public static Attribute _type(String value) {
        return new Attribute("type", value);
    }

    public static Attribute _usemap(String value) {
        return new Attribute("usemap", value);
    }

    public static Attribute _value(String value) {
        return new Attribute("value", value);
    }

    public static Attribute _width(String value) {
        return new Attribute("width", value);
    }

    public static Attribute _wrap(String value) {
        return new Attribute("wrap", value);
    }

    // container html views
    public static ContainerHtml a(Html... inner) {
        return new ContainerHtml("a", inner);
    }

    public static ContainerHtml abbr(Html... inner) {
        return new ContainerHtml("abbr", inner);
    }

    public static ContainerHtml acronym(Html... inner) {
        return new ContainerHtml("acronym", inner);
    }

    public static ContainerHtml address(Html... inner) {
        return new ContainerHtml("address", inner);
    }

    public static ContainerHtml applet(Html... inner) {
        return new ContainerHtml("applet", inner);
    }

    public static ContainerHtml article(Html... inner) {
        return new ContainerHtml("article", inner);
    }

    public static ContainerHtml aside(Html... inner) {
        return new ContainerHtml("aside", inner);
    }

    public static ContainerHtml audio(Html... inner) {
        return new ContainerHtml("audio", inner);
    }

    public static ContainerHtml b(Html... inner) {
        return new ContainerHtml("b", inner);
    }

    public static ContainerHtml basefont(Html... inner) {
        return new ContainerHtml("basefont", inner);
    }

    public static ContainerHtml bdi(Html... inner) {
        return new ContainerHtml("bdi", inner);
    }

    public static ContainerHtml bdo(Html... inner) {
        return new ContainerHtml("bdo", inner);
    }

    public static ContainerHtml big(Html... inner) {
        return new ContainerHtml("big", inner);
    }

    public static ContainerHtml blockquote(Html... inner) {
        return new ContainerHtml("blockquote", inner);
    }

    public static ContainerHtml body(Html... inner) {
        return new ContainerHtml("body", inner);
    }

    public static ContainerHtml button(Html... inner) {
        return new ContainerHtml("button", inner);
    }

    public static ContainerHtml canvas(Html... inner) {
        return new ContainerHtml("canvas", inner);
    }

    public static ContainerHtml caption(Html... inner) {
        return new ContainerHtml("caption", inner);
    }

    public static ContainerHtml center(Html... inner) {
        return new ContainerHtml("center", inner);
    }

    public static ContainerHtml cite(Html... inner) {
        return new ContainerHtml("cite", inner);
    }

    public static ContainerHtml code(Html... inner) {
        return new ContainerHtml("code", inner);
    }

    public static ContainerHtml colgroup(Html... inner) {
        return new ContainerHtml("colgroup", inner);
    }

    public static ContainerHtml data(Html... inner) {
        return new ContainerHtml("data", inner);
    }

    public static ContainerHtml datalist(Html... inner) {
        return new ContainerHtml("datalist", inner);
    }

    public static ContainerHtml dd(Html... inner) {
        return new ContainerHtml("dd", inner);
    }

    public static ContainerHtml del(Html... inner) {
        return new ContainerHtml("del", inner);
    }

    public static ContainerHtml details(Html... inner) {
        return new ContainerHtml("details", inner);
    }

    public static ContainerHtml dfn(Html... inner) {
        return new ContainerHtml("dfn", inner);
    }

    public static ContainerHtml dialog(Html... inner) {
        return new ContainerHtml("dialog", inner);
    }

    public static ContainerHtml dir(Html... inner) {
        return new ContainerHtml("dir", inner);
    }

    public static ContainerHtml div(Html... inner) {
        return new ContainerHtml("div", inner);
    }

    public static ContainerHtml dl(Html... inner) {
        return new ContainerHtml("dl", inner);
    }

    public static ContainerHtml dt(Html... inner) {
        return new ContainerHtml("dt", inner);
    }

    public static ContainerHtml em(Html... inner) {
        return new ContainerHtml("em", inner);
    }

    public static ContainerHtml fieldset(Html... inner) {
        return new ContainerHtml("fieldset", inner);
    }

    public static ContainerHtml figcaption(Html... inner) {
        return new ContainerHtml("figcaption", inner);
    }

    public static ContainerHtml figure(Html... inner) {
        return new ContainerHtml("figure", inner);
    }

    public static ContainerHtml font(Html... inner) {
        return new ContainerHtml("font", inner);
    }

    public static ContainerHtml footer(Html... inner) {
        return new ContainerHtml("footer", inner);
    }

    public static ContainerHtml form(Html... inner) {
        return new ContainerHtml("form", inner);
    }

    public static ContainerHtml frame(Html... inner) {
        return new ContainerHtml("frame", inner);
    }

    public static ContainerHtml frameset(Html... inner) {
        return new ContainerHtml("frameset", inner);
    }

    public static ContainerHtml h1(Html... inner) {
        return new ContainerHtml("h1", inner);
    }

    public static ContainerHtml h2(Html... inner) {
        return new ContainerHtml("h2", inner);
    }

    public static ContainerHtml h3(Html... inner) {
        return new ContainerHtml("h3", inner);
    }

    public static ContainerHtml h4(Html... inner) {
        return new ContainerHtml("h4", inner);
    }

    public static ContainerHtml h5(Html... inner) {
        return new ContainerHtml("h5", inner);
    }

    public static ContainerHtml h6(Html... inner) {
        return new ContainerHtml("h6", inner);
    }

    public static ContainerHtml head(Html... inner) {
        return new ContainerHtml("head", inner);
    }

    public static ContainerHtml header(Html... inner) {
        return new ContainerHtml("header", inner);
    }

    public static ContainerHtml html(Html... inner) {
        return new ContainerHtml("html", inner);
    }

    public static ContainerHtml i(Html... inner) {
        return new ContainerHtml("i", inner);
    }

    public static ContainerHtml iframe(Html... inner) {
        return new ContainerHtml("iframe", inner);
    }

    public static ContainerHtml ins(Html... inner) {
        return new ContainerHtml("ins", inner);
    }

    public static ContainerHtml kbd(Html... inner) {
        return new ContainerHtml("kbd", inner);
    }

    public static ContainerHtml label(Html... inner) {
        return new ContainerHtml("label", inner);
    }

    public static ContainerHtml legend(Html... inner) {
        return new ContainerHtml("legend", inner);
    }

    public static ContainerHtml li(Html... inner) {
        return new ContainerHtml("li", inner);
    }

    public static ContainerHtml main(Html... inner) {
        return new ContainerHtml("main", inner);
    }

    public static ContainerHtml map(Html... inner) {
        return new ContainerHtml("map", inner);
    }

    public static ContainerHtml mark(Html... inner) {
        return new ContainerHtml("mark", inner);
    }

    public static ContainerHtml meter(Html... inner) {
        return new ContainerHtml("meter", inner);
    }

    public static ContainerHtml nav(Html... inner) {
        return new ContainerHtml("nav", inner);
    }

    public static ContainerHtml noframes(Html... inner) {
        return new ContainerHtml("noframes", inner);
    }

    public static ContainerHtml noscript(Html... inner) {
        return new ContainerHtml("noscript", inner);
    }

    public static ContainerHtml object(Html... inner) {
        return new ContainerHtml("object", inner);
    }

    public static ContainerHtml ol(Html... inner) {
        return new ContainerHtml("ol", inner);
    }

    public static ContainerHtml optgroup(Html... inner) {
        return new ContainerHtml("optgroup", inner);
    }

    public static ContainerHtml option(Html... inner) {
        return new ContainerHtml("option", inner);
    }

    public static ContainerHtml output(Html... inner) {
        return new ContainerHtml("output", inner);
    }

    public static ContainerHtml p(Html... inner) {
        return new ContainerHtml("p", inner);
    }

    public static ContainerHtml picture(Html... inner) {
        return new ContainerHtml("picture", inner);
    }

    public static ContainerHtml pre(Html... inner) {
        return new ContainerHtml("pre", inner);
    }

    public static ContainerHtml progress(Html... inner) {
        return new ContainerHtml("progress", inner);
    }

    public static ContainerHtml q(Html... inner) {
        return new ContainerHtml("q", inner);
    }

    public static ContainerHtml rp(Html... inner) {
        return new ContainerHtml("rp", inner);
    }

    public static ContainerHtml rt(Html... inner) {
        return new ContainerHtml("rt", inner);
    }

    public static ContainerHtml ruby(Html... inner) {
        return new ContainerHtml("ruby", inner);
    }

    public static ContainerHtml s(Html... inner) {
        return new ContainerHtml("s", inner);
    }

    public static ContainerHtml samp(Html... inner) {
        return new ContainerHtml("samp", inner);
    }

    public static ContainerHtml script(Html... inner) {
        return new ContainerHtml("script", inner);
    }

    public static ContainerHtml section(Html... inner) {
        return new ContainerHtml("section", inner);
    }

    public static ContainerHtml select(Html... inner) {
        return new ContainerHtml("select", inner);
    }

    public static ContainerHtml small(Html... inner) {
        return new ContainerHtml("small", inner);
    }

    public static ContainerHtml span(Html... inner) {
        return new ContainerHtml("span", inner);
    }

    public static ContainerHtml strike(Html... inner) {
        return new ContainerHtml("strike", inner);
    }

    public static ContainerHtml strong(Html... inner) {
        return new ContainerHtml("strong", inner);
    }

    public static ContainerHtml style(Html... inner) {
        return new ContainerHtml("style", inner);
    }

    public static ContainerHtml sub(Html... inner) {
        return new ContainerHtml("sub", inner);
    }

    public static ContainerHtml summary(Html... inner) {
        return new ContainerHtml("summary", inner);
    }

    public static ContainerHtml sup(Html... inner) {
        return new ContainerHtml("sup", inner);
    }

    public static ContainerHtml svg(Html... inner) {
        return new ContainerHtml("svg", inner);
    }

    public static ContainerHtml table(Html... inner) {
        return new ContainerHtml("table", inner);
    }

    public static ContainerHtml tbody(Html... inner) {
        return new ContainerHtml("tbody", inner);
    }

    public static ContainerHtml td(Html... inner) {
        return new ContainerHtml("td", inner);
    }

    public static ContainerHtml template(Html... inner) {
        return new ContainerHtml("template", inner);
    }

    public static ContainerHtml textarea(Html... inner) {
        return new ContainerHtml("textarea", inner);
    }

    public static ContainerHtml tfoot(Html... inner) {
        return new ContainerHtml("tfoot", inner);
    }

    public static ContainerHtml th(Html... inner) {
        return new ContainerHtml("th", inner);
    }

    public static ContainerHtml thead(Html... inner) {
        return new ContainerHtml("thead", inner);
    }

    public static ContainerHtml time(Html... inner) {
        return new ContainerHtml("time", inner);
    }

    public static ContainerHtml title(Html... inner) {
        return new ContainerHtml("title", inner);
    }

    public static ContainerHtml tr(Html... inner) {
        return new ContainerHtml("tr", inner);
    }

    public static ContainerHtml tt(Html... inner) {
        return new ContainerHtml("tt", inner);
    }

    public static ContainerHtml u(Html... inner) {
        return new ContainerHtml("u", inner);
    }

    public static ContainerHtml ul(Html... inner) {
        return new ContainerHtml("ul", inner);
    }

    public static ContainerHtml var(Html... inner) {
        return new ContainerHtml("var", inner);
    }

    public static ContainerHtml video(Html... inner) {
        return new ContainerHtml("video", inner);
    }

    // empty html views
    public static EmptyHtml area(Attribute... attributes) {
        return new EmptyHtml("area", attributes);
    }

    public static EmptyHtml base(Attribute... attributes) {
        return new EmptyHtml("base", attributes);
    }

    public static EmptyHtml br(Attribute... attributes) {
        return new EmptyHtml("br", attributes);
    }

    public static EmptyHtml col(Attribute... attributes) {
        return new EmptyHtml("col", attributes);
    }

    public static EmptyHtml embed(Attribute... attributes) {
        return new EmptyHtml("embed", attributes);
    }

    public static EmptyHtml hr(Attribute... attributes) {
        return new EmptyHtml("hr", attributes);
    }

    public static EmptyHtml img(Attribute... attributes) {
        return new EmptyHtml("img", attributes);
    }

    public static EmptyHtml input(Attribute... attributes) {
        return new EmptyHtml("input", attributes);
    }

    public static EmptyHtml link(Attribute... attributes) {
        return new EmptyHtml("link", attributes);
    }

    public static EmptyHtml meta(Attribute... attributes) {
        return new EmptyHtml("meta", attributes);
    }

    public static EmptyHtml param(Attribute... attributes) {
        return new EmptyHtml("param", attributes);
    }

    public static EmptyHtml source(Attribute... attributes) {
        return new EmptyHtml("source", attributes);
    }

    public static EmptyHtml track(Attribute... attributes) {
        return new EmptyHtml("track", attributes);
    }

    public static EmptyHtml wbr(Attribute... attributes) {
        return new EmptyHtml("wbr", attributes);
    }

}
