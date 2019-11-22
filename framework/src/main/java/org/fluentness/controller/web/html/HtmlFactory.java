package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebActionReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlFactory {

    // special web views
    public static HtmlContainer action(WebActionReference action, Html... inner) {
        List<Html> result = new ArrayList<>();
        result.add(_href(action.getPath()));
        result.addAll(Arrays.asList(inner));
        return a(result.toArray(new Html[0]));
    }

    public static <T> HtmlForm<T> form(Object model, WebActionReference submitAction) {
        return new HtmlForm<>(model, submitAction);
    }

    public static <T> HtmlTable<T> table(List<T> modelList) {
        return new HtmlTable<>(modelList);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new Html[0]);
    }

    // attributes markup views
    public static HtmlAttribute _attr(String key, String value) {
        return new HtmlAttribute(key, value);
    }

    public static HtmlAttribute _accept(String value) {
        return new HtmlAttribute("accept", value);
    }

    public static HtmlAttribute _accept_charset(String value) {
        return new HtmlAttribute("accept-charset", value);
    }

    public static HtmlAttribute _accesskey(String value) {
        return new HtmlAttribute("accesskey", value);
    }

    public static HtmlAttribute _action(String value) {
        return new HtmlAttribute("action", value);
    }

    public static HtmlAttribute _align(String value) {
        return new HtmlAttribute("align", value);
    }

    public static HtmlAttribute _alt(String value) {
        return new HtmlAttribute("alt", value);
    }

    public static HtmlAttribute _async(String value) {
        return new HtmlAttribute("async", value);
    }

    public static HtmlAttribute _autocomplete(String value) {
        return new HtmlAttribute("autocomplete", value);
    }

    public static HtmlAttribute _autofocus(String value) {
        return new HtmlAttribute("autofocus", value);
    }

    public static HtmlAttribute _autoplay(String value) {
        return new HtmlAttribute("autoplay", value);
    }

    public static HtmlAttribute _autosave(String value) {
        return new HtmlAttribute("autosave", value);
    }

    public static HtmlAttribute _bgcolor(String value) {
        return new HtmlAttribute("bgcolor", value);
    }

    public static HtmlAttribute _border(String value) {
        return new HtmlAttribute("border", value);
    }

    public static HtmlAttribute _buffered(String value) {
        return new HtmlAttribute("buffered", value);
    }

    public static HtmlAttribute _challenge(String value) {
        return new HtmlAttribute("challenge", value);
    }

    public static HtmlAttribute _charset(String value) {
        return new HtmlAttribute("charset", value);
    }

    public static HtmlAttribute _checked(String value) {
        return new HtmlAttribute("checked", value);
    }

    public static HtmlAttribute _cite(String value) {
        return new HtmlAttribute("cite", value);
    }

    public static HtmlAttribute _class(String value) {
        return new HtmlAttribute("class", value);
    }

    public static HtmlAttribute _code(String value) {
        return new HtmlAttribute("code", value);
    }

    public static HtmlAttribute _codebase(String value) {
        return new HtmlAttribute("codebase", value);
    }

    public static HtmlAttribute _color(String value) {
        return new HtmlAttribute("color", value);
    }

    public static HtmlAttribute _cols(String value) {
        return new HtmlAttribute("cols", value);
    }

    public static HtmlAttribute _colspan(String value) {
        return new HtmlAttribute("colspan", value);
    }

    public static HtmlAttribute _content(String value) {
        return new HtmlAttribute("content", value);
    }

    public static HtmlAttribute _contenteditable(String value) {
        return new HtmlAttribute("contenteditable", value);
    }

    public static HtmlAttribute _contextmenu(String value) {
        return new HtmlAttribute("contextmenu", value);
    }

    public static HtmlAttribute _controls(String value) {
        return new HtmlAttribute("controls", value);
    }

    public static HtmlAttribute _coords(String value) {
        return new HtmlAttribute("coords", value);
    }

    public static HtmlAttribute _crossorigin(String value) {
        return new HtmlAttribute("crossorigin", value);
    }

    public static HtmlAttribute _data(String value) {
        return new HtmlAttribute("data", value);
    }

    public static HtmlAttribute _datetime(String value) {
        return new HtmlAttribute("datetime", value);
    }

    public static HtmlAttribute _default(String value) {
        return new HtmlAttribute("default", value);
    }

    public static HtmlAttribute _dir(String value) {
        return new HtmlAttribute("dir", value);
    }

    public static HtmlAttribute _dirname(String value) {
        return new HtmlAttribute("dirname", value);
    }

    public static HtmlAttribute _disabled(String value) {
        return new HtmlAttribute("disabled", value);
    }

    public static HtmlAttribute _download(String value) {
        return new HtmlAttribute("download", value);
    }

    public static HtmlAttribute _draggable(String value) {
        return new HtmlAttribute("draggable", value);
    }

    public static HtmlAttribute _dropzone(String value) {
        return new HtmlAttribute("dropzone", value);
    }

    public static HtmlAttribute _enctype(String value) {
        return new HtmlAttribute("enctype", value);
    }

    public static HtmlAttribute _for_(String value) {
        return new HtmlAttribute("for", value);
    }

    public static HtmlAttribute _form(String value) {
        return new HtmlAttribute("form", value);
    }

    public static HtmlAttribute _formaction(String value) {
        return new HtmlAttribute("formaction", value);
    }

    public static HtmlAttribute _headers(String value) {
        return new HtmlAttribute("headers", value);
    }

    public static HtmlAttribute _height(String value) {
        return new HtmlAttribute("height", value);
    }

    public static HtmlAttribute _hidden(String value) {
        return new HtmlAttribute("hidden", value);
    }

    public static HtmlAttribute _high(String value) {
        return new HtmlAttribute("high", value);
    }

    public static HtmlAttribute _href(String value) {
        return new HtmlAttribute("href", value);
    }

    public static HtmlAttribute _hreflang(String value) {
        return new HtmlAttribute("hreflang", value);
    }

    public static HtmlAttribute _http_equiv(String value) {
        return new HtmlAttribute("http-equiv", value);
    }

    public static HtmlAttribute _icon(String value) {
        return new HtmlAttribute("icon", value);
    }

    public static HtmlAttribute _id(String value) {
        return new HtmlAttribute("id", value);
    }

    public static HtmlAttribute _integrity(String value) {
        return new HtmlAttribute("integrity", value);
    }

    public static HtmlAttribute _ismap(String value) {
        return new HtmlAttribute("ismap", value);
    }

    public static HtmlAttribute _itemprop(String value) {
        return new HtmlAttribute("itemprop", value);
    }

    public static HtmlAttribute _keytype(String value) {
        return new HtmlAttribute("keytype", value);
    }

    public static HtmlAttribute _kind(String value) {
        return new HtmlAttribute("kind", value);
    }

    public static HtmlAttribute _label(String value) {
        return new HtmlAttribute("label", value);
    }

    public static HtmlAttribute _lang(String value) {
        return new HtmlAttribute("lang", value);
    }

    public static HtmlAttribute _language(String value) {
        return new HtmlAttribute("language", value);
    }

    public static HtmlAttribute _list(String value) {
        return new HtmlAttribute("list", value);
    }

    public static HtmlAttribute _loop(String value) {
        return new HtmlAttribute("loop", value);
    }

    public static HtmlAttribute _low(String value) {
        return new HtmlAttribute("low", value);
    }

    public static HtmlAttribute _manifest(String value) {
        return new HtmlAttribute("manifest", value);
    }

    public static HtmlAttribute _max(String value) {
        return new HtmlAttribute("max", value);
    }

    public static HtmlAttribute _maxlength(String value) {
        return new HtmlAttribute("maxlength", value);
    }

    public static HtmlAttribute _media(String value) {
        return new HtmlAttribute("media", value);
    }

    public static HtmlAttribute _method(String value) {
        return new HtmlAttribute("method", value);
    }

    public static HtmlAttribute _min(String value) {
        return new HtmlAttribute("min", value);
    }

    public static HtmlAttribute _multiple(String value) {
        return new HtmlAttribute("multiple", value);
    }

    public static HtmlAttribute _muted(String value) {
        return new HtmlAttribute("muted", value);
    }

    public static HtmlAttribute _name(String value) {
        return new HtmlAttribute("name", value);
    }

    public static HtmlAttribute _novalidate(String value) {
        return new HtmlAttribute("novalidate", value);
    }

    public static HtmlAttribute _open(String value) {
        return new HtmlAttribute("open", value);
    }

    public static HtmlAttribute _optimum(String value) {
        return new HtmlAttribute("optimum", value);
    }

    public static HtmlAttribute _pattern(String value) {
        return new HtmlAttribute("pattern", value);
    }

    public static HtmlAttribute _ping(String value) {
        return new HtmlAttribute("ping", value);
    }

    public static HtmlAttribute _placeholder(String value) {
        return new HtmlAttribute("placeholder", value);
    }

    public static HtmlAttribute _poster(String value) {
        return new HtmlAttribute("poster", value);
    }

    public static HtmlAttribute _preload(String value) {
        return new HtmlAttribute("preload", value);
    }

    public static HtmlAttribute _radiogroup(String value) {
        return new HtmlAttribute("radiogroup", value);
    }

    public static HtmlAttribute _readonly(String value) {
        return new HtmlAttribute("readonly", value);
    }

    public static HtmlAttribute _rel(String value) {
        return new HtmlAttribute("rel", value);
    }

    public static HtmlAttribute _required(String value) {
        return new HtmlAttribute("required", value);
    }

    public static HtmlAttribute _reversed(String value) {
        return new HtmlAttribute("reversed", value);
    }

    public static HtmlAttribute _rows(String value) {
        return new HtmlAttribute("rows", value);
    }

    public static HtmlAttribute _rowspan(String value) {
        return new HtmlAttribute("rowspan", value);
    }

    public static HtmlAttribute _sandbox(String value) {
        return new HtmlAttribute("sandbox", value);
    }

    public static HtmlAttribute _scope(String value) {
        return new HtmlAttribute("scope", value);
    }

    public static HtmlAttribute _scoped(String value) {
        return new HtmlAttribute("scoped", value);
    }

    public static HtmlAttribute _seamless(String value) {
        return new HtmlAttribute("seamless", value);
    }

    public static HtmlAttribute _selected(String value) {
        return new HtmlAttribute("selected", value);
    }

    public static HtmlAttribute _shape(String value) {
        return new HtmlAttribute("shape", value);
    }

    public static HtmlAttribute _size(String value) {
        return new HtmlAttribute("size", value);
    }

    public static HtmlAttribute _sizes(String value) {
        return new HtmlAttribute("sizes", value);
    }

    public static HtmlAttribute _slot(String value) {
        return new HtmlAttribute("slot", value);
    }

    public static HtmlAttribute _span(String value) {
        return new HtmlAttribute("span", value);
    }

    public static HtmlAttribute _spellcheck(String value) {
        return new HtmlAttribute("spellcheck", value);
    }

    public static HtmlAttribute _src(String value) {
        return new HtmlAttribute("src", value);
    }

    public static HtmlAttribute _srcdoc(String value) {
        return new HtmlAttribute("srcdoc", value);
    }

    public static HtmlAttribute _srclang(String value) {
        return new HtmlAttribute("srclang", value);
    }

    public static HtmlAttribute _srcset(String value) {
        return new HtmlAttribute("srcset", value);
    }

    public static HtmlAttribute _start(String value) {
        return new HtmlAttribute("start", value);
    }

    public static HtmlAttribute _step(String value) {
        return new HtmlAttribute("step", value);
    }

    public static HtmlAttribute _style(String value) {
        return new HtmlAttribute("style", value);
    }

    public static HtmlAttribute _summary(String value) {
        return new HtmlAttribute("summary", value);
    }

    public static HtmlAttribute _tabindex(String value) {
        return new HtmlAttribute("tabindex", value);
    }

    public static HtmlAttribute _target(String value) {
        return new HtmlAttribute("target", value);
    }

    public static HtmlAttribute _title(String value) {
        return new HtmlAttribute("title", value);
    }

    public static HtmlAttribute _type(String value) {
        return new HtmlAttribute("type", value);
    }

    public static HtmlAttribute _usemap(String value) {
        return new HtmlAttribute("usemap", value);
    }

    public static HtmlAttribute _value(String value) {
        return new HtmlAttribute("value", value);
    }

    public static HtmlAttribute _width(String value) {
        return new HtmlAttribute("width", value);
    }

    public static HtmlAttribute _wrap(String value) {
        return new HtmlAttribute("wrap", value);
    }

    // container html views
    public static HtmlContainer a(Html... inner) {
        return new HtmlContainer("a", inner);
    }

    public static HtmlContainer abbr(Html... inner) {
        return new HtmlContainer("abbr", inner);
    }

    public static HtmlContainer acronym(Html... inner) {
        return new HtmlContainer("acronym", inner);
    }

    public static HtmlContainer address(Html... inner) {
        return new HtmlContainer("address", inner);
    }

    public static HtmlContainer applet(Html... inner) {
        return new HtmlContainer("applet", inner);
    }

    public static HtmlContainer article(Html... inner) {
        return new HtmlContainer("article", inner);
    }

    public static HtmlContainer aside(Html... inner) {
        return new HtmlContainer("aside", inner);
    }

    public static HtmlContainer audio(Html... inner) {
        return new HtmlContainer("audio", inner);
    }

    public static HtmlContainer b(Html... inner) {
        return new HtmlContainer("b", inner);
    }

    public static HtmlContainer basefont(Html... inner) {
        return new HtmlContainer("basefont", inner);
    }

    public static HtmlContainer bdi(Html... inner) {
        return new HtmlContainer("bdi", inner);
    }

    public static HtmlContainer bdo(Html... inner) {
        return new HtmlContainer("bdo", inner);
    }

    public static HtmlContainer big(Html... inner) {
        return new HtmlContainer("big", inner);
    }

    public static HtmlContainer blockquote(Html... inner) {
        return new HtmlContainer("blockquote", inner);
    }

    public static HtmlContainer body(Html... inner) {
        return new HtmlContainer("body", inner);
    }

    public static HtmlContainer button(Html... inner) {
        return new HtmlContainer("button", inner);
    }

    public static HtmlContainer canvas(Html... inner) {
        return new HtmlContainer("canvas", inner);
    }

    public static HtmlContainer caption(Html... inner) {
        return new HtmlContainer("caption", inner);
    }

    public static HtmlContainer center(Html... inner) {
        return new HtmlContainer("center", inner);
    }

    public static HtmlContainer cite(Html... inner) {
        return new HtmlContainer("cite", inner);
    }

    public static HtmlContainer code(Html... inner) {
        return new HtmlContainer("code", inner);
    }

    public static HtmlContainer colgroup(Html... inner) {
        return new HtmlContainer("colgroup", inner);
    }

    public static HtmlContainer data(Html... inner) {
        return new HtmlContainer("data", inner);
    }

    public static HtmlContainer datalist(Html... inner) {
        return new HtmlContainer("datalist", inner);
    }

    public static HtmlContainer dd(Html... inner) {
        return new HtmlContainer("dd", inner);
    }

    public static HtmlContainer del(Html... inner) {
        return new HtmlContainer("del", inner);
    }

    public static HtmlContainer details(Html... inner) {
        return new HtmlContainer("details", inner);
    }

    public static HtmlContainer dfn(Html... inner) {
        return new HtmlContainer("dfn", inner);
    }

    public static HtmlContainer dialog(Html... inner) {
        return new HtmlContainer("dialog", inner);
    }

    public static HtmlContainer dir(Html... inner) {
        return new HtmlContainer("dir", inner);
    }

    public static HtmlContainer div(Html... inner) {
        return new HtmlContainer("div", inner);
    }

    public static HtmlContainer dl(Html... inner) {
        return new HtmlContainer("dl", inner);
    }

    public static HtmlContainer dt(Html... inner) {
        return new HtmlContainer("dt", inner);
    }

    public static HtmlContainer em(Html... inner) {
        return new HtmlContainer("em", inner);
    }

    public static HtmlContainer fieldset(Html... inner) {
        return new HtmlContainer("fieldset", inner);
    }

    public static HtmlContainer figcaption(Html... inner) {
        return new HtmlContainer("figcaption", inner);
    }

    public static HtmlContainer figure(Html... inner) {
        return new HtmlContainer("figure", inner);
    }

    public static HtmlContainer font(Html... inner) {
        return new HtmlContainer("font", inner);
    }

    public static HtmlContainer footer(Html... inner) {
        return new HtmlContainer("footer", inner);
    }

    public static HtmlContainer form(Html... inner) {
        return new HtmlContainer("form", inner);
    }

    public static HtmlContainer frame(Html... inner) {
        return new HtmlContainer("frame", inner);
    }

    public static HtmlContainer frameset(Html... inner) {
        return new HtmlContainer("frameset", inner);
    }

    public static HtmlContainer h1(Html... inner) {
        return new HtmlContainer("h1", inner);
    }

    public static HtmlContainer h2(Html... inner) {
        return new HtmlContainer("h2", inner);
    }

    public static HtmlContainer h3(Html... inner) {
        return new HtmlContainer("h3", inner);
    }

    public static HtmlContainer h4(Html... inner) {
        return new HtmlContainer("h4", inner);
    }

    public static HtmlContainer h5(Html... inner) {
        return new HtmlContainer("h5", inner);
    }

    public static HtmlContainer h6(Html... inner) {
        return new HtmlContainer("h6", inner);
    }

    public static HtmlContainer head(Html... inner) {
        return new HtmlContainer("head", inner);
    }

    public static HtmlContainer header(Html... inner) {
        return new HtmlContainer("header", inner);
    }

    public static HtmlContainer html(Html... inner) {
        return new HtmlContainer("html", inner);
    }

    public static HtmlContainer i(Html... inner) {
        return new HtmlContainer("i", inner);
    }

    public static HtmlContainer iframe(Html... inner) {
        return new HtmlContainer("iframe", inner);
    }

    public static HtmlContainer ins(Html... inner) {
        return new HtmlContainer("ins", inner);
    }

    public static HtmlContainer kbd(Html... inner) {
        return new HtmlContainer("kbd", inner);
    }

    public static HtmlContainer label(Html... inner) {
        return new HtmlContainer("label", inner);
    }

    public static HtmlContainer legend(Html... inner) {
        return new HtmlContainer("legend", inner);
    }

    public static HtmlContainer li(Html... inner) {
        return new HtmlContainer("li", inner);
    }

    public static HtmlContainer main(Html... inner) {
        return new HtmlContainer("main", inner);
    }

    public static HtmlContainer map(Html... inner) {
        return new HtmlContainer("map", inner);
    }

    public static HtmlContainer mark(Html... inner) {
        return new HtmlContainer("mark", inner);
    }

    public static HtmlContainer meter(Html... inner) {
        return new HtmlContainer("meter", inner);
    }

    public static HtmlContainer nav(Html... inner) {
        return new HtmlContainer("nav", inner);
    }

    public static HtmlContainer noframes(Html... inner) {
        return new HtmlContainer("noframes", inner);
    }

    public static HtmlContainer noscript(Html... inner) {
        return new HtmlContainer("noscript", inner);
    }

    public static HtmlContainer object(Html... inner) {
        return new HtmlContainer("object", inner);
    }

    public static HtmlContainer ol(Html... inner) {
        return new HtmlContainer("ol", inner);
    }

    public static HtmlContainer optgroup(Html... inner) {
        return new HtmlContainer("optgroup", inner);
    }

    public static HtmlContainer option(Html... inner) {
        return new HtmlContainer("option", inner);
    }

    public static HtmlContainer output(Html... inner) {
        return new HtmlContainer("output", inner);
    }

    public static HtmlContainer p(Html... inner) {
        return new HtmlContainer("p", inner);
    }

    public static HtmlContainer picture(Html... inner) {
        return new HtmlContainer("picture", inner);
    }

    public static HtmlContainer pre(Html... inner) {
        return new HtmlContainer("pre", inner);
    }

    public static HtmlContainer progress(Html... inner) {
        return new HtmlContainer("progress", inner);
    }

    public static HtmlContainer q(Html... inner) {
        return new HtmlContainer("q", inner);
    }

    public static HtmlContainer rp(Html... inner) {
        return new HtmlContainer("rp", inner);
    }

    public static HtmlContainer rt(Html... inner) {
        return new HtmlContainer("rt", inner);
    }

    public static HtmlContainer ruby(Html... inner) {
        return new HtmlContainer("ruby", inner);
    }

    public static HtmlContainer s(Html... inner) {
        return new HtmlContainer("s", inner);
    }

    public static HtmlContainer samp(Html... inner) {
        return new HtmlContainer("samp", inner);
    }

    public static HtmlContainer script(Html... inner) {
        return new HtmlContainer("script", inner);
    }

    public static HtmlContainer section(Html... inner) {
        return new HtmlContainer("section", inner);
    }

    public static HtmlContainer select(Html... inner) {
        return new HtmlContainer("select", inner);
    }

    public static HtmlContainer small(Html... inner) {
        return new HtmlContainer("small", inner);
    }

    public static HtmlContainer span(Html... inner) {
        return new HtmlContainer("span", inner);
    }

    public static HtmlContainer strike(Html... inner) {
        return new HtmlContainer("strike", inner);
    }

    public static HtmlContainer strong(Html... inner) {
        return new HtmlContainer("strong", inner);
    }

    public static HtmlContainer style(Html... inner) {
        return new HtmlContainer("style", inner);
    }

    public static HtmlContainer sub(Html... inner) {
        return new HtmlContainer("sub", inner);
    }

    public static HtmlContainer summary(Html... inner) {
        return new HtmlContainer("summary", inner);
    }

    public static HtmlContainer sup(Html... inner) {
        return new HtmlContainer("sup", inner);
    }

    public static HtmlContainer svg(Html... inner) {
        return new HtmlContainer("svg", inner);
    }

    public static HtmlContainer table(Html... inner) {
        return new HtmlContainer("table", inner);
    }

    public static HtmlContainer tbody(Html... inner) {
        return new HtmlContainer("tbody", inner);
    }

    public static HtmlContainer td(Html... inner) {
        return new HtmlContainer("td", inner);
    }

    public static HtmlContainer template(Html... inner) {
        return new HtmlContainer("template", inner);
    }

    public static HtmlContainer textarea(Html... inner) {
        return new HtmlContainer("textarea", inner);
    }

    public static HtmlContainer tfoot(Html... inner) {
        return new HtmlContainer("tfoot", inner);
    }

    public static HtmlContainer th(Html... inner) {
        return new HtmlContainer("th", inner);
    }

    public static HtmlContainer thead(Html... inner) {
        return new HtmlContainer("thead", inner);
    }

    public static HtmlContainer time(Html... inner) {
        return new HtmlContainer("time", inner);
    }

    public static HtmlContainer title(Html... inner) {
        return new HtmlContainer("title", inner);
    }

    public static HtmlContainer tr(Html... inner) {
        return new HtmlContainer("tr", inner);
    }

    public static HtmlContainer tt(Html... inner) {
        return new HtmlContainer("tt", inner);
    }

    public static HtmlContainer u(Html... inner) {
        return new HtmlContainer("u", inner);
    }

    public static HtmlContainer ul(Html... inner) {
        return new HtmlContainer("ul", inner);
    }

    public static HtmlContainer var(Html... inner) {
        return new HtmlContainer("var", inner);
    }

    public static HtmlContainer video(Html... inner) {
        return new HtmlContainer("video", inner);
    }

    // empty html views
    public static HtmlEmpty area(HtmlAttribute... attributes) {
        return new HtmlEmpty("area", attributes);
    }

    public static HtmlEmpty base(HtmlAttribute... attributes) {
        return new HtmlEmpty("base", attributes);
    }

    public static HtmlEmpty br(HtmlAttribute... attributes) {
        return new HtmlEmpty("br", attributes);
    }

    public static HtmlEmpty col(HtmlAttribute... attributes) {
        return new HtmlEmpty("col", attributes);
    }

    public static HtmlEmpty embed(HtmlAttribute... attributes) {
        return new HtmlEmpty("embed", attributes);
    }

    public static HtmlEmpty hr(HtmlAttribute... attributes) {
        return new HtmlEmpty("hr", attributes);
    }

    public static HtmlEmpty img(HtmlAttribute... attributes) {
        return new HtmlEmpty("img", attributes);
    }

    public static HtmlEmpty input(HtmlAttribute... attributes) {
        return new HtmlEmpty("input", attributes);
    }

    public static HtmlEmpty link(HtmlAttribute... attributes) {
        return new HtmlEmpty("link", attributes);
    }

    public static HtmlEmpty meta(HtmlAttribute... attributes) {
        return new HtmlEmpty("meta", attributes);
    }

    public static HtmlEmpty param(HtmlAttribute... attributes) {
        return new HtmlEmpty("param", attributes);
    }

    public static HtmlEmpty source(HtmlAttribute... attributes) {
        return new HtmlEmpty("source", attributes);
    }

    public static HtmlEmpty track(HtmlAttribute... attributes) {
        return new HtmlEmpty("track", attributes);
    }

    public static HtmlEmpty wbr(HtmlAttribute... attributes) {
        return new HtmlEmpty("wbr", attributes);
    }

}
