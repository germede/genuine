package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.MarkupView;

public interface HtmlView extends MarkupView {

    default HtmlView accept(String value) {
        attr("accept", value);
        return this;
    }

    default HtmlView accept_charset(String value) {
        attr("accept-charset", value);
        return this;
    }

    default HtmlView accesskey(String value) {
        attr("accesskey", value);
        return this;
    }

    default HtmlView action(String value) {
        attr("action", value);
        return this;
    }

    default HtmlView align(String value) {
        attr("align", value);
        return this;
    }

    default HtmlView alt(String value) {
        attr("alt", value);
        return this;
    }

    default HtmlView async(String value) {
        attr("async", value);
        return this;
    }

    default HtmlView autocomplete(String value) {
        attr("autocomplete", value);
        return this;
    }

    default HtmlView autofocus(String value) {
        attr("autofocus", value);
        return this;
    }

    default HtmlView autoplay(String value) {
        attr("autoplay", value);
        return this;
    }

    default HtmlView autosave(String value) {
        attr("autosave", value);
        return this;
    }

    default HtmlView bgcolor(String value) {
        attr("bgcolor", value);
        return this;
    }

    default HtmlView border(String value) {
        attr("border", value);
        return this;
    }

    default HtmlView buffered(String value) {
        attr("buffered", value);
        return this;
    }

    default HtmlView challenge(String value) {
        attr("challenge", value);
        return this;
    }

    default HtmlView charset(String value) {
        attr("charset", value);
        return this;
    }

    default HtmlView checked(String value) {
        attr("checked", value);
        return this;
    }

    default HtmlView cite(String value) {
        attr("cite", value);
        return this;
    }

    default HtmlView class_(String value) {
        attr("class", value);
        return this;
    }

    default HtmlView code(String value) {
        attr("code", value);
        return this;
    }

    default HtmlView codebase(String value) {
        attr("codebase", value);
        return this;
    }

    default HtmlView color(String value) {
        attr("color", value);
        return this;
    }

    default HtmlView cols(String value) {
        attr("cols", value);
        return this;
    }

    default HtmlView colspan(String value) {
        attr("colspan", value);
        return this;
    }

    default HtmlView content(String value) {
        attr("content", value);
        return this;
    }

    default HtmlView contenteditable(String value) {
        attr("contenteditable", value);
        return this;
    }

    default HtmlView contextmenu(String value) {
        attr("contextmenu", value);
        return this;
    }

    default HtmlView controls(String value) {
        attr("controls", value);
        return this;
    }

    default HtmlView coords(String value) {
        attr("coords", value);
        return this;
    }

    default HtmlView crossorigin(String value) {
        attr("crossorigin", value);
        return this;
    }

    default HtmlView data(String value) {
        attr("data", value);
        return this;
    }

    default HtmlView data(String key, String value) {
        attr("data-"+key, value);
        return this;
    }

    default HtmlView datetime(String value) {
        attr("datetime", value);
        return this;
    }

    default HtmlView default_(String value) {
        attr("default", value);
        return this;
    }

    default HtmlView defer(String value) {
        attr("defer", value);
        return this;
    }

    default HtmlView dir(String value) {
        attr("dir", value);
        return this;
    }

    default HtmlView dirname(String value) {
        attr("dirname", value);
        return this;
    }

    default HtmlView disabled(String value) {
        attr("disabled", value);
        return this;
    }

    default HtmlView download(String value) {
        attr("download", value);
        return this;
    }

    default HtmlView draggable(String value) {
        attr("draggable", value);
        return this;
    }

    default HtmlView dropzone(String value) {
        attr("dropzone", value);
        return this;
    }

    default HtmlView enctype(String value) {
        attr("enctype", value);
        return this;
    }

    default HtmlView for_(String value) {
        attr("for", value);
        return this;
    }

    default HtmlView form(String value) {
        attr("form", value);
        return this;
    }

    default HtmlView formaction(String value) {
        attr("formaction", value);
        return this;
    }

    default HtmlView headers(String value) {
        attr("headers", value);
        return this;
    }

    default HtmlView height(String value) {
        attr("height", value);
        return this;
    }

    default HtmlView hidden(String value) {
        attr("hidden", value);
        return this;
    }

    default HtmlView high(String value) {
        attr("high", value);
        return this;
    }

    default HtmlView href(String value) {
        attr("href", value);
        return this;
    }

    default HtmlView hreflang(String value) {
        attr("hreflang", value);
        return this;
    }

    default HtmlView http_equiv(String value) {
        attr("http-equiv", value);
        return this;
    }

    default HtmlView icon(String value) {
        attr("icon", value);
        return this;
    }

    default HtmlView id(String value) {
        attr("id", value);
        return this;
    }

    default HtmlView integrity(String value) {
        attr("integrity", value);
        return this;
    }

    default HtmlView ismap(String value) {
        attr("ismap", value);
        return this;
    }

    default HtmlView itemprop(String value) {
        attr("itemprop", value);
        return this;
    }

    default HtmlView keytype(String value) {
        attr("keytype", value);
        return this;
    }

    default HtmlView kind(String value) {
        attr("kind", value);
        return this;
    }

    default HtmlView label(String value) {
        attr("label", value);
        return this;
    }

    default HtmlView lang(String value) {
        attr("lang", value);
        return this;
    }

    default HtmlView language(String value) {
        attr("language", value);
        return this;
    }

    default HtmlView list(String value) {
        attr("list", value);
        return this;
    }

    default HtmlView loop(String value) {
        attr("loop", value);
        return this;
    }

    default HtmlView low(String value) {
        attr("low", value);
        return this;
    }

    default HtmlView manifest(String value) {
        attr("manifest", value);
        return this;
    }

    default HtmlView max(String value) {
        attr("max", value);
        return this;
    }

    default HtmlView maxlength(String value) {
        attr("maxlength", value);
        return this;
    }

    default HtmlView media(String value) {
        attr("media", value);
        return this;
    }

    default HtmlView method(String value) {
        attr("method", value);
        return this;
    }

    default HtmlView min(String value) {
        attr("min", value);
        return this;
    }

    default HtmlView multiple(String value) {
        attr("multiple", value);
        return this;
    }

    default HtmlView muted(String value) {
        attr("muted", value);
        return this;
    }

    default HtmlView name(String value) {
        attr("name", value);
        return this;
    }

    default HtmlView novalidate(String value) {
        attr("novalidate", value);
        return this;
    }

    default HtmlView open(String value) {
        attr("open", value);
        return this;
    }

    default HtmlView optimum(String value) {
        attr("optimum", value);
        return this;
    }

    default HtmlView pattern(String value) {
        attr("pattern", value);
        return this;
    }

    default HtmlView ping(String value) {
        attr("ping", value);
        return this;
    }

    default HtmlView placeholder(String value) {
        attr("placeholder", value);
        return this;
    }

    default HtmlView poster(String value) {
        attr("poster", value);
        return this;
    }

    default HtmlView preload(String value) {
        attr("preload", value);
        return this;
    }

    default HtmlView radiogroup(String value) {
        attr("radiogroup", value);
        return this;
    }

    default HtmlView readonly(String value) {
        attr("readonly", value);
        return this;
    }

    default HtmlView rel(String value) {
        attr("rel", value);
        return this;
    }

    default HtmlView required(String value) {
        attr("required", value);
        return this;
    }

    default HtmlView reversed(String value) {
        attr("reversed", value);
        return this;
    }

    default HtmlView rows(String value) {
        attr("rows", value);
        return this;
    }

    default HtmlView rowspan(String value) {
        attr("rowspan", value);
        return this;
    }

    default HtmlView sandbox(String value) {
        attr("sandbox", value);
        return this;
    }

    default HtmlView scope(String value) {
        attr("scope", value);
        return this;
    }

    default HtmlView scoped(String value) {
        attr("scoped", value);
        return this;
    }

    default HtmlView seamless(String value) {
        attr("seamless", value);
        return this;
    }

    default HtmlView selected(String value) {
        attr("selected", value);
        return this;
    }

    default HtmlView shape(String value) {
        attr("shape", value);
        return this;
    }

    default HtmlView size(String value) {
        attr("size", value);
        return this;
    }

    default HtmlView sizes(String value) {
        attr("sizes", value);
        return this;
    }

    default HtmlView slot(String value) {
        attr("slot", value);
        return this;
    }

    default HtmlView span(String value) {
        attr("span", value);
        return this;
    }

    default HtmlView spellcheck(String value) {
        attr("spellcheck", value);
        return this;
    }

    default HtmlView src(String value) {
        attr("src", value);
        return this;
    }

    default HtmlView srcdoc(String value) {
        attr("srcdoc", value);
        return this;
    }

    default HtmlView srclang(String value) {
        attr("srclang", value);
        return this;
    }

    default HtmlView srcset(String value) {
        attr("srcset", value);
        return this;
    }

    default HtmlView start(String value) {
        attr("start", value);
        return this;
    }

    default HtmlView step(String value) {
        attr("step", value);
        return this;
    }

    default HtmlView style(String value) {
        attr("style", value);
        return this;
    }

    default HtmlView summary(String value) {
        attr("summary", value);
        return this;
    }

    default HtmlView tabindex(String value) {
        attr("tabindex", value);
        return this;
    }

    default HtmlView target(String value) {
        attr("target", value);
        return this;
    }

    default HtmlView title(String value) {
        attr("title", value);
        return this;
    }

    default HtmlView type(String value) {
        attr("type", value);
        return this;
    }

    default HtmlView usemap(String value) {
        attr("usemap", value);
        return this;
    }

    default HtmlView value(String value) {
        attr("value", value);
        return this;
    }

    default HtmlView width(String value) {
        attr("width", value);
        return this;
    }

    default HtmlView wrap(String value) {
        attr("wrap", value);
        return this;
    }
}
