package org.fluentness.flow.component.view;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

interface HtmlFunctionsEmpty {

    default MarkupElementEmpty area(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("area", attributes);
    }

    default MarkupElementEmpty base(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("base", attributes);
    }

    default MarkupElementEmpty br(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("br", attributes);
    }

    default MarkupElementEmpty col(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("col", attributes);
    }

    default MarkupElementEmpty embed(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("embed", attributes);
    }

    default MarkupElementEmpty hr(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("hr", attributes);
    }

    default MarkupElementEmpty img(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("img", attributes);
    }

    default MarkupElementEmpty input(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("input", attributes);
    }

    default MarkupElementEmpty link(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("link", attributes);
    }

    default MarkupElementEmpty meta(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("meta", attributes);
    }

    default MarkupElementEmpty param(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("param", attributes);
    }

    default MarkupElementEmpty source(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("source", attributes);
    }

    default MarkupElementEmpty track(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("track", attributes);
    }

    default MarkupElementEmpty wbr(KeyValuePairLambda<String>... attributes) {
        return new MarkupElementEmpty("wbr", attributes);
    }


}
