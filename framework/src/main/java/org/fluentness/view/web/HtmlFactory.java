package org.fluentness.view.web;

import org.fluentness.controller.web.WebAction;
import org.fluentness.model.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlFactory {

    // special web views
    public static HtmlContainer action(WebAction action, WebView... html) {
        WebView[] args = new WebView[html.length + 1];
        System.arraycopy(html, 0, args, 0, html.length);
        args[html.length] = _href(action.getPath());
        return a(args);
    }

    public static <T> HtmlForm<T> form(Model model, WebAction submitAction) {
        return new HtmlForm<>(model, submitAction);
    }

    public static <T> HtmlTable table(List<T> modelList) {
        return new HtmlTable(modelList);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new WebView[0]);
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
    public static HtmlContainer a(WebView... html) {
        return new HtmlContainer("a", html);
    }

    public static HtmlContainer abbr(WebView... html) {
        return new HtmlContainer("abbr", html);
    }

    public static HtmlContainer acronym(WebView... html) {
        return new HtmlContainer("acronym", html);
    }

    public static HtmlContainer address(WebView... html) {
        return new HtmlContainer("address", html);
    }

    public static HtmlContainer applet(WebView... html) {
        return new HtmlContainer("applet", html);
    }

    public static HtmlContainer article(WebView... html) {
        return new HtmlContainer("article", html);
    }

    public static HtmlContainer aside(WebView... html) {
        return new HtmlContainer("aside", html);
    }

    public static HtmlContainer audio(WebView... html) {
        return new HtmlContainer("audio", html);
    }

    public static HtmlContainer b(WebView... html) {
        return new HtmlContainer("b", html);
    }

    public static HtmlContainer basefont(WebView... html) {
        return new HtmlContainer("basefont", html);
    }

    public static HtmlContainer bdi(WebView... html) {
        return new HtmlContainer("bdi", html);
    }

    public static HtmlContainer bdo(WebView... html) {
        return new HtmlContainer("bdo", html);
    }

    public static HtmlContainer big(WebView... html) {
        return new HtmlContainer("big", html);
    }

    public static HtmlContainer blockquote(WebView... html) {
        return new HtmlContainer("blockquote", html);
    }

    public static HtmlContainer body(WebView... html) {
        return new HtmlContainer("body", html);
    }

    public static HtmlContainer button(WebView... html) {
        return new HtmlContainer("button", html);
    }

    public static HtmlContainer canvas(WebView... html) {
        return new HtmlContainer("canvas", html);
    }

    public static HtmlContainer caption(WebView... html) {
        return new HtmlContainer("caption", html);
    }

    public static HtmlContainer center(WebView... html) {
        return new HtmlContainer("center", html);
    }

    public static HtmlContainer cite(WebView... html) {
        return new HtmlContainer("cite", html);
    }

    public static HtmlContainer code(WebView... html) {
        return new HtmlContainer("code", html);
    }

    public static HtmlContainer colgroup(WebView... html) {
        return new HtmlContainer("colgroup", html);
    }

    public static HtmlContainer data(WebView... html) {
        return new HtmlContainer("data", html);
    }

    public static HtmlContainer datalist(WebView... html) {
        return new HtmlContainer("datalist", html);
    }

    public static HtmlContainer dd(WebView... html) {
        return new HtmlContainer("dd", html);
    }

    public static HtmlContainer del(WebView... html) {
        return new HtmlContainer("del", html);
    }

    public static HtmlContainer details(WebView... html) {
        return new HtmlContainer("details", html);
    }

    public static HtmlContainer dfn(WebView... html) {
        return new HtmlContainer("dfn", html);
    }

    public static HtmlContainer dialog(WebView... html) {
        return new HtmlContainer("dialog", html);
    }

    public static HtmlContainer dir(WebView... html) {
        return new HtmlContainer("dir", html);
    }

    public static HtmlContainer div(WebView... html) {
        return new HtmlContainer("div", html);
    }

    public static HtmlContainer dl(WebView... html) {
        return new HtmlContainer("dl", html);
    }

    public static HtmlContainer dt(WebView... html) {
        return new HtmlContainer("dt", html);
    }

    public static HtmlContainer em(WebView... html) {
        return new HtmlContainer("em", html);
    }

    public static HtmlContainer fieldset(WebView... html) {
        return new HtmlContainer("fieldset", html);
    }

    public static HtmlContainer figcaption(WebView... html) {
        return new HtmlContainer("figcaption", html);
    }

    public static HtmlContainer figure(WebView... html) {
        return new HtmlContainer("figure", html);
    }

    public static HtmlContainer font(WebView... html) {
        return new HtmlContainer("font", html);
    }

    public static HtmlContainer footer(WebView... html) {
        return new HtmlContainer("footer", html);
    }

    public static HtmlContainer form(WebView... html) {
        return new HtmlContainer("form", html);
    }

    public static HtmlContainer frame(WebView... html) {
        return new HtmlContainer("frame", html);
    }

    public static HtmlContainer frameset(WebView... html) {
        return new HtmlContainer("frameset", html);
    }

    public static HtmlContainer h1(WebView... html) {
        return new HtmlContainer("h1", html);
    }

    public static HtmlContainer h2(WebView... html) {
        return new HtmlContainer("h2", html);
    }

    public static HtmlContainer h3(WebView... html) {
        return new HtmlContainer("h3", html);
    }

    public static HtmlContainer h4(WebView... html) {
        return new HtmlContainer("h4", html);
    }

    public static HtmlContainer h5(WebView... html) {
        return new HtmlContainer("h5", html);
    }

    public static HtmlContainer h6(WebView... html) {
        return new HtmlContainer("h6", html);
    }

    public static HtmlContainer head(WebView... html) {
        return new HtmlContainer("head", html);
    }

    public static HtmlContainer header(WebView... html) {
        return new HtmlContainer("header", html);
    }

    public static HtmlContainer html(WebView... html) {
        return new HtmlContainer("html", html);
    }

    public static HtmlContainer i(WebView... html) {
        return new HtmlContainer("i", html);
    }

    public static HtmlContainer iframe(WebView... html) {
        return new HtmlContainer("iframe", html);
    }

    public static HtmlContainer ins(WebView... html) {
        return new HtmlContainer("ins", html);
    }

    public static HtmlContainer kbd(WebView... html) {
        return new HtmlContainer("kbd", html);
    }

    public static HtmlContainer label(WebView... html) {
        return new HtmlContainer("label", html);
    }

    public static HtmlContainer legend(WebView... html) {
        return new HtmlContainer("legend", html);
    }

    public static HtmlContainer li(WebView... html) {
        return new HtmlContainer("li", html);
    }

    public static HtmlContainer main(WebView... html) {
        return new HtmlContainer("main", html);
    }

    public static HtmlContainer map(WebView... html) {
        return new HtmlContainer("map", html);
    }

    public static HtmlContainer mark(WebView... html) {
        return new HtmlContainer("mark", html);
    }

    public static HtmlContainer meter(WebView... html) {
        return new HtmlContainer("meter", html);
    }

    public static HtmlContainer nav(WebView... html) {
        return new HtmlContainer("nav", html);
    }

    public static HtmlContainer noframes(WebView... html) {
        return new HtmlContainer("noframes", html);
    }

    public static HtmlContainer noscript(WebView... html) {
        return new HtmlContainer("noscript", html);
    }

    public static HtmlContainer object(WebView... html) {
        return new HtmlContainer("object", html);
    }

    public static HtmlContainer ol(WebView... html) {
        return new HtmlContainer("ol", html);
    }

    public static HtmlContainer optgroup(WebView... html) {
        return new HtmlContainer("optgroup", html);
    }

    public static HtmlContainer option(WebView... html) {
        return new HtmlContainer("option", html);
    }

    public static HtmlContainer output(WebView... html) {
        return new HtmlContainer("output", html);
    }

    public static HtmlContainer p(WebView... html) {
        return new HtmlContainer("p", html);
    }

    public static HtmlContainer picture(WebView... html) {
        return new HtmlContainer("picture", html);
    }

    public static HtmlContainer pre(WebView... html) {
        return new HtmlContainer("pre", html);
    }

    public static HtmlContainer progress(WebView... html) {
        return new HtmlContainer("progress", html);
    }

    public static HtmlContainer q(WebView... html) {
        return new HtmlContainer("q", html);
    }

    public static HtmlContainer rp(WebView... html) {
        return new HtmlContainer("rp", html);
    }

    public static HtmlContainer rt(WebView... html) {
        return new HtmlContainer("rt", html);
    }

    public static HtmlContainer ruby(WebView... html) {
        return new HtmlContainer("ruby", html);
    }

    public static HtmlContainer s(WebView... html) {
        return new HtmlContainer("s", html);
    }

    public static HtmlContainer samp(WebView... html) {
        return new HtmlContainer("samp", html);
    }

    public static HtmlContainer script(WebView... html) {
        return new HtmlContainer("script", html);
    }

    public static HtmlContainer section(WebView... html) {
        return new HtmlContainer("section", html);
    }

    public static HtmlContainer select(WebView... html) {
        return new HtmlContainer("select", html);
    }

    public static HtmlContainer small(WebView... html) {
        return new HtmlContainer("small", html);
    }

    public static HtmlContainer span(WebView... html) {
        return new HtmlContainer("span", html);
    }

    public static HtmlContainer strike(WebView... html) {
        return new HtmlContainer("strike", html);
    }

    public static HtmlContainer strong(WebView... html) {
        return new HtmlContainer("strong", html);
    }

    public static HtmlContainer style(WebView... html) {
        return new HtmlContainer("style", html);
    }

    public static HtmlContainer sub(WebView... html) {
        return new HtmlContainer("sub", html);
    }

    public static HtmlContainer summary(WebView... html) {
        return new HtmlContainer("summary", html);
    }

    public static HtmlContainer sup(WebView... html) {
        return new HtmlContainer("sup", html);
    }

    public static HtmlContainer svg(WebView... html) {
        return new HtmlContainer("svg", html);
    }

    public static HtmlContainer table(WebView... html) {
        return new HtmlContainer("table", html);
    }

    public static HtmlContainer tbody(WebView... html) {
        return new HtmlContainer("tbody", html);
    }

    public static HtmlContainer td(WebView... html) {
        return new HtmlContainer("td", html);
    }

    public static HtmlContainer template(WebView... html) {
        return new HtmlContainer("template", html);
    }

    public static HtmlContainer textarea(WebView... html) {
        return new HtmlContainer("textarea", html);
    }

    public static HtmlContainer tfoot(WebView... html) {
        return new HtmlContainer("tfoot", html);
    }

    public static HtmlContainer th(WebView... html) {
        return new HtmlContainer("th", html);
    }

    public static HtmlContainer thead(WebView... html) {
        return new HtmlContainer("thead", html);
    }

    public static HtmlContainer time(WebView... html) {
        return new HtmlContainer("time", html);
    }

    public static HtmlContainer title(WebView... html) {
        return new HtmlContainer("title", html);
    }

    public static HtmlContainer tr(WebView... html) {
        return new HtmlContainer("tr", html);
    }

    public static HtmlContainer tt(WebView... html) {
        return new HtmlContainer("tt", html);
    }

    public static HtmlContainer u(WebView... html) {
        return new HtmlContainer("u", html);
    }

    public static HtmlContainer ul(WebView... html) {
        return new HtmlContainer("ul", html);
    }

    public static HtmlContainer var(WebView... html) {
        return new HtmlContainer("var", html);
    }

    public static HtmlContainer video(WebView... html) {
        return new HtmlContainer("video", html);
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
