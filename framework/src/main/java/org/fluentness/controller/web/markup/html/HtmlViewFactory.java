package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebActionReference;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.AttributeMarkupView;
import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.controller.web.text.RawView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class HtmlViewFactory {

    // special web views
    public static ContainerHtmlView action(WebActionReference action, MarkupView... inner) {
        List<MarkupView> result = new ArrayList<>();
        result.add(_href(action.getPath()));
        result.addAll(Arrays.asList(inner));
        return a(result.toArray(new MarkupView[0]));
    }

    public static FormHtmlView form(Object model, WebActionReference submitAction) {
        return new FormHtmlView(model, submitAction);
    }

    public static TableHtmlView table(List modelList) {
        return new TableHtmlView(modelList);
    }

    public static WebView raw(String raw) {
        return new RawView(raw);
    }

    public static <T, V> V[] forEach(Iterable<T> iterable, Function<T, V> function) {
        List<V> result = new LinkedList<>();
        iterable.forEach(t -> result.add(function.apply(t)));
        return result.toArray((V[]) new MarkupView[0]);
    }

    // attributes markup views
    public static AttributeMarkupView _accept(String value) {
        return new AttributeMarkupView("accept", value);
    }

    public static AttributeMarkupView _accept_charset(String value) {
        return new AttributeMarkupView("accept-charset", value);
    }

    public static AttributeMarkupView _accesskey(String value) {
        return new AttributeMarkupView("accesskey", value);
    }

    public static AttributeMarkupView _action(String value) {
        return new AttributeMarkupView("action", value);
    }

    public static AttributeMarkupView _align(String value) {
        return new AttributeMarkupView("align", value);
    }

    public static AttributeMarkupView _alt(String value) {
        return new AttributeMarkupView("alt", value);
    }

    public static AttributeMarkupView _async(String value) {
        return new AttributeMarkupView("async", value);
    }

    public static AttributeMarkupView _autocomplete(String value) {
        return new AttributeMarkupView("autocomplete", value);
    }

    public static AttributeMarkupView _autofocus(String value) {
        return new AttributeMarkupView("autofocus", value);
    }

    public static AttributeMarkupView _autoplay(String value) {
        return new AttributeMarkupView("autoplay", value);
    }

    public static AttributeMarkupView _autosave(String value) {
        return new AttributeMarkupView("autosave", value);
    }

    public static AttributeMarkupView _bgcolor(String value) {
        return new AttributeMarkupView("bgcolor", value);
    }

    public static AttributeMarkupView _border(String value) {
        return new AttributeMarkupView("border", value);
    }

    public static AttributeMarkupView _buffered(String value) {
        return new AttributeMarkupView("buffered", value);
    }

    public static AttributeMarkupView _challenge(String value) {
        return new AttributeMarkupView("challenge", value);
    }

    public static AttributeMarkupView _charset(String value) {
        return new AttributeMarkupView("charset", value);
    }

    public static AttributeMarkupView _checked(String value) {
        return new AttributeMarkupView("checked", value);
    }

    public static AttributeMarkupView _cite(String value) {
        return new AttributeMarkupView("cite", value);
    }

    public static AttributeMarkupView _class(String value) {
        return new AttributeMarkupView("class", value);
    }

    public static AttributeMarkupView _code(String value) {
        return new AttributeMarkupView("code", value);
    }

    public static AttributeMarkupView _codebase(String value) {
        return new AttributeMarkupView("codebase", value);
    }

    public static AttributeMarkupView _color(String value) {
        return new AttributeMarkupView("color", value);
    }

    public static AttributeMarkupView _cols(String value) {
        return new AttributeMarkupView("cols", value);
    }

    public static AttributeMarkupView _colspan(String value) {
        return new AttributeMarkupView("colspan", value);
    }

    public static AttributeMarkupView _content(String value) {
        return new AttributeMarkupView("content", value);
    }

    public static AttributeMarkupView _contenteditable(String value) {
        return new AttributeMarkupView("contenteditable", value);
    }

    public static AttributeMarkupView _contextmenu(String value) {
        return new AttributeMarkupView("contextmenu", value);
    }

    public static AttributeMarkupView _controls(String value) {
        return new AttributeMarkupView("controls", value);
    }

    public static AttributeMarkupView _coords(String value) {
        return new AttributeMarkupView("coords", value);
    }

    public static AttributeMarkupView _crossorigin(String value) {
        return new AttributeMarkupView("crossorigin", value);
    }

    public static AttributeMarkupView _data(String value) {
        return new AttributeMarkupView("data", value);
    }

    public static AttributeMarkupView _datetime(String value) {
        return new AttributeMarkupView("datetime", value);
    }

    public static AttributeMarkupView _default(String value) {
        return new AttributeMarkupView("default", value);
    }

    public static AttributeMarkupView _dir(String value) {
        return new AttributeMarkupView("dir", value);
    }

    public static AttributeMarkupView _dirname(String value) {
        return new AttributeMarkupView("dirname", value);
    }

    public static AttributeMarkupView _disabled(String value) {
        return new AttributeMarkupView("disabled", value);
    }

    public static AttributeMarkupView _download(String value) {
        return new AttributeMarkupView("download", value);
    }

    public static AttributeMarkupView _draggable(String value) {
        return new AttributeMarkupView("draggable", value);
    }

    public static AttributeMarkupView _dropzone(String value) {
        return new AttributeMarkupView("dropzone", value);
    }

    public static AttributeMarkupView _enctype(String value) {
        return new AttributeMarkupView("enctype", value);
    }

    public static AttributeMarkupView _for_(String value) {
        return new AttributeMarkupView("for", value);
    }

    public static AttributeMarkupView _form(String value) {
        return new AttributeMarkupView("form", value);
    }

    public static AttributeMarkupView _formaction(String value) {
        return new AttributeMarkupView("formaction", value);
    }

    public static AttributeMarkupView _headers(String value) {
        return new AttributeMarkupView("headers", value);
    }

    public static AttributeMarkupView _height(String value) {
        return new AttributeMarkupView("height", value);
    }

    public static AttributeMarkupView _hidden(String value) {
        return new AttributeMarkupView("hidden", value);
    }

    public static AttributeMarkupView _high(String value) {
        return new AttributeMarkupView("high", value);
    }

    public static AttributeMarkupView _href(String value) {
        return new AttributeMarkupView("href", value);
    }

    public static AttributeMarkupView _hreflang(String value) {
        return new AttributeMarkupView("hreflang", value);
    }

    public static AttributeMarkupView _http_equiv(String value) {
        return new AttributeMarkupView("http-equiv", value);
    }

    public static AttributeMarkupView _icon(String value) {
        return new AttributeMarkupView("icon", value);
    }

    public static AttributeMarkupView _id(String value) {
        return new AttributeMarkupView("id", value);
    }

    public static AttributeMarkupView _integrity(String value) {
        return new AttributeMarkupView("integrity", value);
    }

    public static AttributeMarkupView _ismap(String value) {
        return new AttributeMarkupView("ismap", value);
    }

    public static AttributeMarkupView _itemprop(String value) {
        return new AttributeMarkupView("itemprop", value);
    }

    public static AttributeMarkupView _keytype(String value) {
        return new AttributeMarkupView("keytype", value);
    }

    public static AttributeMarkupView _kind(String value) {
        return new AttributeMarkupView("kind", value);
    }

    public static AttributeMarkupView _label(String value) {
        return new AttributeMarkupView("label", value);
    }

    public static AttributeMarkupView _lang(String value) {
        return new AttributeMarkupView("lang", value);
    }

    public static AttributeMarkupView _language(String value) {
        return new AttributeMarkupView("language", value);
    }

    public static AttributeMarkupView _list(String value) {
        return new AttributeMarkupView("list", value);
    }

    public static AttributeMarkupView _loop(String value) {
        return new AttributeMarkupView("loop", value);
    }

    public static AttributeMarkupView _low(String value) {
        return new AttributeMarkupView("low", value);
    }

    public static AttributeMarkupView _manifest(String value) {
        return new AttributeMarkupView("manifest", value);
    }

    public static AttributeMarkupView _max(String value) {
        return new AttributeMarkupView("max", value);
    }

    public static AttributeMarkupView _maxlength(String value) {
        return new AttributeMarkupView("maxlength", value);
    }

    public static AttributeMarkupView _media(String value) {
        return new AttributeMarkupView("media", value);
    }

    public static AttributeMarkupView _method(String value) {
        return new AttributeMarkupView("method", value);
    }

    public static AttributeMarkupView _min(String value) {
        return new AttributeMarkupView("min", value);
    }

    public static AttributeMarkupView _multiple(String value) {
        return new AttributeMarkupView("multiple", value);
    }

    public static AttributeMarkupView _muted(String value) {
        return new AttributeMarkupView("muted", value);
    }

    public static AttributeMarkupView _name(String value) {
        return new AttributeMarkupView("name", value);
    }

    public static AttributeMarkupView _novalidate(String value) {
        return new AttributeMarkupView("novalidate", value);
    }

    public static AttributeMarkupView _open(String value) {
        return new AttributeMarkupView("open", value);
    }

    public static AttributeMarkupView _optimum(String value) {
        return new AttributeMarkupView("optimum", value);
    }

    public static AttributeMarkupView _pattern(String value) {
        return new AttributeMarkupView("pattern", value);
    }

    public static AttributeMarkupView _ping(String value) {
        return new AttributeMarkupView("ping", value);
    }

    public static AttributeMarkupView _placeholder(String value) {
        return new AttributeMarkupView("placeholder", value);
    }

    public static AttributeMarkupView _poster(String value) {
        return new AttributeMarkupView("poster", value);
    }

    public static AttributeMarkupView _preload(String value) {
        return new AttributeMarkupView("preload", value);
    }

    public static AttributeMarkupView _radiogroup(String value) {
        return new AttributeMarkupView("radiogroup", value);
    }

    public static AttributeMarkupView _readonly(String value) {
        return new AttributeMarkupView("readonly", value);
    }

    public static AttributeMarkupView _rel(String value) {
        return new AttributeMarkupView("rel", value);
    }

    public static AttributeMarkupView _required(String value) {
        return new AttributeMarkupView("required", value);
    }

    public static AttributeMarkupView _reversed(String value) {
        return new AttributeMarkupView("reversed", value);
    }

    public static AttributeMarkupView _rows(String value) {
        return new AttributeMarkupView("rows", value);
    }

    public static AttributeMarkupView _rowspan(String value) {
        return new AttributeMarkupView("rowspan", value);
    }

    public static AttributeMarkupView _sandbox(String value) {
        return new AttributeMarkupView("sandbox", value);
    }

    public static AttributeMarkupView _scope(String value) {
        return new AttributeMarkupView("scope", value);
    }

    public static AttributeMarkupView _scoped(String value) {
        return new AttributeMarkupView("scoped", value);
    }

    public static AttributeMarkupView _seamless(String value) {
        return new AttributeMarkupView("seamless", value);
    }

    public static AttributeMarkupView _selected(String value) {
        return new AttributeMarkupView("selected", value);
    }

    public static AttributeMarkupView _shape(String value) {
        return new AttributeMarkupView("shape", value);
    }

    public static AttributeMarkupView _size(String value) {
        return new AttributeMarkupView("size", value);
    }

    public static AttributeMarkupView _sizes(String value) {
        return new AttributeMarkupView("sizes", value);
    }

    public static AttributeMarkupView _slot(String value) {
        return new AttributeMarkupView("slot", value);
    }

    public static AttributeMarkupView _span(String value) {
        return new AttributeMarkupView("span", value);
    }

    public static AttributeMarkupView _spellcheck(String value) {
        return new AttributeMarkupView("spellcheck", value);
    }

    public static AttributeMarkupView _src(String value) {
        return new AttributeMarkupView("src", value);
    }

    public static AttributeMarkupView _srcdoc(String value) {
        return new AttributeMarkupView("srcdoc", value);
    }

    public static AttributeMarkupView _srclang(String value) {
        return new AttributeMarkupView("srclang", value);
    }

    public static AttributeMarkupView _srcset(String value) {
        return new AttributeMarkupView("srcset", value);
    }

    public static AttributeMarkupView _start(String value) {
        return new AttributeMarkupView("start", value);
    }

    public static AttributeMarkupView _step(String value) {
        return new AttributeMarkupView("step", value);
    }

    public static AttributeMarkupView _style(String value) {
        return new AttributeMarkupView("style", value);
    }

    public static AttributeMarkupView _summary(String value) {
        return new AttributeMarkupView("summary", value);
    }

    public static AttributeMarkupView _tabindex(String value) {
        return new AttributeMarkupView("tabindex", value);
    }

    public static AttributeMarkupView _target(String value) {
        return new AttributeMarkupView("target", value);
    }

    public static AttributeMarkupView _title(String value) {
        return new AttributeMarkupView("title", value);
    }

    public static AttributeMarkupView _type(String value) {
        return new AttributeMarkupView("type", value);
    }

    public static AttributeMarkupView _usemap(String value) {
        return new AttributeMarkupView("usemap", value);
    }

    public static AttributeMarkupView _value(String value) {
        return new AttributeMarkupView("value", value);
    }

    public static AttributeMarkupView _width(String value) {
        return new AttributeMarkupView("width", value);
    }

    public static AttributeMarkupView _wrap(String value) {
        return new AttributeMarkupView("wrap", value);
    }

    // container html views
    public static ContainerHtmlView a(MarkupView... inner) {
        return new ContainerHtmlView("a", inner);
    }

    public static ContainerHtmlView abbr(MarkupView... inner) {
        return new ContainerHtmlView("abbr", inner);
    }

    public static ContainerHtmlView acronym(MarkupView... inner) {
        return new ContainerHtmlView("acronym", inner);
    }

    public static ContainerHtmlView address(MarkupView... inner) {
        return new ContainerHtmlView("address", inner);
    }

    public static ContainerHtmlView applet(MarkupView... inner) {
        return new ContainerHtmlView("applet", inner);
    }

    public static ContainerHtmlView article(MarkupView... inner) {
        return new ContainerHtmlView("article", inner);
    }

    public static ContainerHtmlView aside(MarkupView... inner) {
        return new ContainerHtmlView("aside", inner);
    }

    public static ContainerHtmlView audio(MarkupView... inner) {
        return new ContainerHtmlView("audio", inner);
    }

    public static ContainerHtmlView b(MarkupView... inner) {
        return new ContainerHtmlView("b", inner);
    }

    public static ContainerHtmlView basefont(MarkupView... inner) {
        return new ContainerHtmlView("basefont", inner);
    }

    public static ContainerHtmlView bdi(MarkupView... inner) {
        return new ContainerHtmlView("bdi", inner);
    }

    public static ContainerHtmlView bdo(MarkupView... inner) {
        return new ContainerHtmlView("bdo", inner);
    }

    public static ContainerHtmlView big(MarkupView... inner) {
        return new ContainerHtmlView("big", inner);
    }

    public static ContainerHtmlView blockquote(MarkupView... inner) {
        return new ContainerHtmlView("blockquote", inner);
    }

    public static ContainerHtmlView body(MarkupView... inner) {
        return new ContainerHtmlView("body", inner);
    }

    public static ContainerHtmlView button(MarkupView... inner) {
        return new ContainerHtmlView("button", inner);
    }

    public static ContainerHtmlView canvas(MarkupView... inner) {
        return new ContainerHtmlView("canvas", inner);
    }

    public static ContainerHtmlView caption(MarkupView... inner) {
        return new ContainerHtmlView("caption", inner);
    }

    public static ContainerHtmlView center(MarkupView... inner) {
        return new ContainerHtmlView("center", inner);
    }

    public static ContainerHtmlView cite(MarkupView... inner) {
        return new ContainerHtmlView("cite", inner);
    }

    public static ContainerHtmlView code(MarkupView... inner) {
        return new ContainerHtmlView("code", inner);
    }

    public static ContainerHtmlView colgroup(MarkupView... inner) {
        return new ContainerHtmlView("colgroup", inner);
    }

    public static ContainerHtmlView data(MarkupView... inner) {
        return new ContainerHtmlView("data", inner);
    }

    public static ContainerHtmlView datalist(MarkupView... inner) {
        return new ContainerHtmlView("datalist", inner);
    }

    public static ContainerHtmlView dd(MarkupView... inner) {
        return new ContainerHtmlView("dd", inner);
    }

    public static ContainerHtmlView del(MarkupView... inner) {
        return new ContainerHtmlView("del", inner);
    }

    public static ContainerHtmlView details(MarkupView... inner) {
        return new ContainerHtmlView("details", inner);
    }

    public static ContainerHtmlView dfn(MarkupView... inner) {
        return new ContainerHtmlView("dfn", inner);
    }

    public static ContainerHtmlView dialog(MarkupView... inner) {
        return new ContainerHtmlView("dialog", inner);
    }

    public static ContainerHtmlView dir(MarkupView... inner) {
        return new ContainerHtmlView("dir", inner);
    }

    public static ContainerHtmlView div(MarkupView... inner) {
        return new ContainerHtmlView("div", inner);
    }

    public static ContainerHtmlView dl(MarkupView... inner) {
        return new ContainerHtmlView("dl", inner);
    }

    public static ContainerHtmlView dt(MarkupView... inner) {
        return new ContainerHtmlView("dt", inner);
    }

    public static ContainerHtmlView em(MarkupView... inner) {
        return new ContainerHtmlView("em", inner);
    }

    public static ContainerHtmlView fieldset(MarkupView... inner) {
        return new ContainerHtmlView("fieldset", inner);
    }

    public static ContainerHtmlView figcaption(MarkupView... inner) {
        return new ContainerHtmlView("figcaption", inner);
    }

    public static ContainerHtmlView figure(MarkupView... inner) {
        return new ContainerHtmlView("figure", inner);
    }

    public static ContainerHtmlView font(MarkupView... inner) {
        return new ContainerHtmlView("font", inner);
    }

    public static ContainerHtmlView footer(MarkupView... inner) {
        return new ContainerHtmlView("footer", inner);
    }

    public static ContainerHtmlView form(MarkupView... inner) {
        return new ContainerHtmlView("form", inner);
    }

    public static ContainerHtmlView frame(MarkupView... inner) {
        return new ContainerHtmlView("frame", inner);
    }

    public static ContainerHtmlView frameset(MarkupView... inner) {
        return new ContainerHtmlView("frameset", inner);
    }

    public static ContainerHtmlView h1(MarkupView... inner) {
        return new ContainerHtmlView("h1", inner);
    }

    public static ContainerHtmlView h2(MarkupView... inner) {
        return new ContainerHtmlView("h2", inner);
    }

    public static ContainerHtmlView h3(MarkupView... inner) {
        return new ContainerHtmlView("h3", inner);
    }

    public static ContainerHtmlView h4(MarkupView... inner) {
        return new ContainerHtmlView("h4", inner);
    }

    public static ContainerHtmlView h5(MarkupView... inner) {
        return new ContainerHtmlView("h5", inner);
    }

    public static ContainerHtmlView h6(MarkupView... inner) {
        return new ContainerHtmlView("h6", inner);
    }

    public static ContainerHtmlView head(MarkupView... inner) {
        return new ContainerHtmlView("head", inner);
    }

    public static ContainerHtmlView header(MarkupView... inner) {
        return new ContainerHtmlView("header", inner);
    }

    public static ContainerHtmlView html(MarkupView... inner) {
        return new ContainerHtmlView("html", inner);
    }

    public static ContainerHtmlView i(MarkupView... inner) {
        return new ContainerHtmlView("i", inner);
    }

    public static ContainerHtmlView iframe(MarkupView... inner) {
        return new ContainerHtmlView("iframe", inner);
    }

    public static ContainerHtmlView ins(MarkupView... inner) {
        return new ContainerHtmlView("ins", inner);
    }

    public static ContainerHtmlView kbd(MarkupView... inner) {
        return new ContainerHtmlView("kbd", inner);
    }

    public static ContainerHtmlView label(MarkupView... inner) {
        return new ContainerHtmlView("label", inner);
    }

    public static ContainerHtmlView legend(MarkupView... inner) {
        return new ContainerHtmlView("legend", inner);
    }

    public static ContainerHtmlView li(MarkupView... inner) {
        return new ContainerHtmlView("li", inner);
    }

    public static ContainerHtmlView main(MarkupView... inner) {
        return new ContainerHtmlView("main", inner);
    }

    public static ContainerHtmlView map(MarkupView... inner) {
        return new ContainerHtmlView("map", inner);
    }

    public static ContainerHtmlView mark(MarkupView... inner) {
        return new ContainerHtmlView("mark", inner);
    }

    public static ContainerHtmlView meter(MarkupView... inner) {
        return new ContainerHtmlView("meter", inner);
    }

    public static ContainerHtmlView nav(MarkupView... inner) {
        return new ContainerHtmlView("nav", inner);
    }

    public static ContainerHtmlView noframes(MarkupView... inner) {
        return new ContainerHtmlView("noframes", inner);
    }

    public static ContainerHtmlView noscript(MarkupView... inner) {
        return new ContainerHtmlView("noscript", inner);
    }

    public static ContainerHtmlView object(MarkupView... inner) {
        return new ContainerHtmlView("object", inner);
    }

    public static ContainerHtmlView ol(MarkupView... inner) {
        return new ContainerHtmlView("ol", inner);
    }

    public static ContainerHtmlView optgroup(MarkupView... inner) {
        return new ContainerHtmlView("optgroup", inner);
    }

    public static ContainerHtmlView option(MarkupView... inner) {
        return new ContainerHtmlView("option", inner);
    }

    public static ContainerHtmlView output(MarkupView... inner) {
        return new ContainerHtmlView("output", inner);
    }

    public static ContainerHtmlView p(MarkupView... inner) {
        return new ContainerHtmlView("p", inner);
    }

    public static ContainerHtmlView picture(MarkupView... inner) {
        return new ContainerHtmlView("picture", inner);
    }

    public static ContainerHtmlView pre(MarkupView... inner) {
        return new ContainerHtmlView("pre", inner);
    }

    public static ContainerHtmlView progress(MarkupView... inner) {
        return new ContainerHtmlView("progress", inner);
    }

    public static ContainerHtmlView q(MarkupView... inner) {
        return new ContainerHtmlView("q", inner);
    }

    public static ContainerHtmlView rp(MarkupView... inner) {
        return new ContainerHtmlView("rp", inner);
    }

    public static ContainerHtmlView rt(MarkupView... inner) {
        return new ContainerHtmlView("rt", inner);
    }

    public static ContainerHtmlView ruby(MarkupView... inner) {
        return new ContainerHtmlView("ruby", inner);
    }

    public static ContainerHtmlView s(MarkupView... inner) {
        return new ContainerHtmlView("s", inner);
    }

    public static ContainerHtmlView samp(MarkupView... inner) {
        return new ContainerHtmlView("samp", inner);
    }

    public static ContainerHtmlView script(MarkupView... inner) {
        return new ContainerHtmlView("script", inner);
    }

    public static ContainerHtmlView section(MarkupView... inner) {
        return new ContainerHtmlView("section", inner);
    }

    public static ContainerHtmlView select(MarkupView... inner) {
        return new ContainerHtmlView("select", inner);
    }

    public static ContainerHtmlView small(MarkupView... inner) {
        return new ContainerHtmlView("small", inner);
    }

    public static ContainerHtmlView span(MarkupView... inner) {
        return new ContainerHtmlView("span", inner);
    }

    public static ContainerHtmlView strike(MarkupView... inner) {
        return new ContainerHtmlView("strike", inner);
    }

    public static ContainerHtmlView strong(MarkupView... inner) {
        return new ContainerHtmlView("strong", inner);
    }

    public static ContainerHtmlView style(MarkupView... inner) {
        return new ContainerHtmlView("style", inner);
    }

    public static ContainerHtmlView sub(MarkupView... inner) {
        return new ContainerHtmlView("sub", inner);
    }

    public static ContainerHtmlView summary(MarkupView... inner) {
        return new ContainerHtmlView("summary", inner);
    }

    public static ContainerHtmlView sup(MarkupView... inner) {
        return new ContainerHtmlView("sup", inner);
    }

    public static ContainerHtmlView svg(MarkupView... inner) {
        return new ContainerHtmlView("svg", inner);
    }

    public static ContainerHtmlView table(MarkupView... inner) {
        return new ContainerHtmlView("table", inner);
    }

    public static ContainerHtmlView tbody(MarkupView... inner) {
        return new ContainerHtmlView("tbody", inner);
    }

    public static ContainerHtmlView td(MarkupView... inner) {
        return new ContainerHtmlView("td", inner);
    }

    public static ContainerHtmlView template(MarkupView... inner) {
        return new ContainerHtmlView("template", inner);
    }

    public static ContainerHtmlView textarea(MarkupView... inner) {
        return new ContainerHtmlView("textarea", inner);
    }

    public static ContainerHtmlView tfoot(MarkupView... inner) {
        return new ContainerHtmlView("tfoot", inner);
    }

    public static ContainerHtmlView th(MarkupView... inner) {
        return new ContainerHtmlView("th", inner);
    }

    public static ContainerHtmlView thead(MarkupView... inner) {
        return new ContainerHtmlView("thead", inner);
    }

    public static ContainerHtmlView time(MarkupView... inner) {
        return new ContainerHtmlView("time", inner);
    }

    public static ContainerHtmlView title(MarkupView... inner) {
        return new ContainerHtmlView("title", inner);
    }

    public static ContainerHtmlView tr(MarkupView... inner) {
        return new ContainerHtmlView("tr", inner);
    }

    public static ContainerHtmlView tt(MarkupView... inner) {
        return new ContainerHtmlView("tt", inner);
    }

    public static ContainerHtmlView u(MarkupView... inner) {
        return new ContainerHtmlView("u", inner);
    }

    public static ContainerHtmlView ul(MarkupView... inner) {
        return new ContainerHtmlView("ul", inner);
    }

    public static ContainerHtmlView var(MarkupView... inner) {
        return new ContainerHtmlView("var", inner);
    }

    public static ContainerHtmlView video(MarkupView... inner) {
        return new ContainerHtmlView("video", inner);
    }

    // empty html views
    public static EmptyHtmlView area(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("area", attributes);
    }

    public static EmptyHtmlView base(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("base", attributes);
    }

    public static EmptyHtmlView br(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("br", attributes);
    }

    public static EmptyHtmlView col(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("col", attributes);
    }

    public static EmptyHtmlView embed(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("embed", attributes);
    }

    public static EmptyHtmlView hr(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("hr", attributes);
    }

    public static EmptyHtmlView img(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("img", attributes);
    }

    public static EmptyHtmlView input(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("input", attributes);
    }

    public static EmptyHtmlView link(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("link", attributes);
    }

    public static EmptyHtmlView meta(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("meta", attributes);
    }

    public static EmptyHtmlView param(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("param", attributes);
    }

    public static EmptyHtmlView source(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("source", attributes);
    }

    public static EmptyHtmlView track(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("track", attributes);
    }

    public static EmptyHtmlView wbr(AttributeMarkupView... attributes) {
        return new EmptyHtmlView("wbr", attributes);
    }

}
