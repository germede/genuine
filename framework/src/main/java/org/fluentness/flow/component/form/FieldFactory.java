package org.fluentness.flow.component.form;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

public interface FieldFactory {

    default Field button(KeyValuePairLambda<String>... attributes) {
        return new Field("button",attributes);
    }

    default Field checkbox(KeyValuePairLambda<String>... attributes) {
        return new Field("checkbox",attributes);
    }

    default Field color(KeyValuePairLambda<String>... attributes) {
        return new Field("color",attributes);
    }

    default Field date(KeyValuePairLambda<String>... attributes) {
        return new Field("date",attributes);
    }

    default Field datetime(KeyValuePairLambda<String>... attributes) {
        return new Field("datetime",attributes);
    }

    default Field email(KeyValuePairLambda<String>... attributes) {
        return new Field("email",attributes);
    }

    default Field file(KeyValuePairLambda<String>... attributes) {
        return new Field("file",attributes);
    }

    default Field hidden(KeyValuePairLambda<String>... attributes) {
        return new Field("hidden",attributes);
    }

    default Field image(KeyValuePairLambda<String>... attributes) {
        return new Field("image",attributes);
    }

    default Field month(KeyValuePairLambda<String>... attributes) {
        return new Field("month",attributes);
    }

    default Field number(KeyValuePairLambda<String>... attributes) {
        return new Field("number",attributes);
    }

    default Field password(KeyValuePairLambda<String>... attributes) {
        return new Field("password",attributes);
    }

    default Field radio(KeyValuePairLambda<String>... attributes) {
        return new Field("radio",attributes);
    }

    default Field range(KeyValuePairLambda<String>... attributes) {
        return new Field("range",attributes);
    }

    default Field reset(KeyValuePairLambda<String>... attributes) {
        return new Field("reset",attributes);
    }

    default Field search(KeyValuePairLambda<String>... attributes) {
        return new Field("search",attributes);
    }

    default Field submit(KeyValuePairLambda<String>... attributes) {
        return new Field("submit",attributes);
    }

    default Field tel(KeyValuePairLambda<String>... attributes) {
        return new Field("tel",attributes);
    }

    default Field text(KeyValuePairLambda<String>... attributes) {
        return new Field("text",attributes);
    }

    default Field time(KeyValuePairLambda<String>... attributes) {
        return new Field("time",attributes);
    }

    default Field url(KeyValuePairLambda<String>... attributes) {
        return new Field("url",attributes);
    }

    default Field week(KeyValuePairLambda<String>... attributes) {
        return new Field("week",attributes);
    }

}
