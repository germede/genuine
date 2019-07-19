package org.fluentness.flow.view;

import org.fluentness.base.lambdas.KeyValuePair;

interface HtmlFunctionsEmpty {

    default MarkupElementEmpty area(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("area", attributes);
    }

    default MarkupElementEmpty base(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("base", attributes);
    }

    default MarkupElementEmpty br(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("br", attributes);
    }

    default MarkupElementEmpty col(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("col", attributes);
    }

    default MarkupElementEmpty embed(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("embed", attributes);
    }

    default MarkupElementEmpty hr(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("hr", attributes);
    }

    default MarkupElementEmpty img(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("img", attributes);
    }

    default MarkupElementEmpty input(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("input", attributes);
    }

    default MarkupElementEmpty link(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("link", attributes);
    }

    default MarkupElementEmpty meta(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("meta", attributes);
    }

    default MarkupElementEmpty param(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("param", attributes);
    }

    default MarkupElementEmpty source(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("source", attributes);
    }

    default MarkupElementEmpty track(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("track", attributes);
    }

    default MarkupElementEmpty wbr(KeyValuePair<String>... attributes) {
        return new MarkupElementEmpty("wbr", attributes);
    }


}
