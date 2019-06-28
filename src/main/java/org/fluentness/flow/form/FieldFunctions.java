package org.fluentness.flow.form;

import org.fluentness.base.lambdas.KeyValuePair;

public interface FieldFunctions {

    default Field button(KeyValuePair<String>... attributes) {
        return new Field("button",attributes);
    }

    default Field checkbox(KeyValuePair<String>... attributes) {
        return new Field("checkbox",attributes);
    }

    default Field color(KeyValuePair<String>... attributes) {
        return new Field("color",attributes);
    }

    default Field date(KeyValuePair<String>... attributes) {
        return new Field("date",attributes);
    }

    default Field datetime(KeyValuePair<String>... attributes) {
        return new Field("datetime",attributes);
    }

    default Field email(KeyValuePair<String>... attributes) {
        return new Field("email",attributes);
    }

    default Field file(KeyValuePair<String>... attributes) {
        return new Field("file",attributes);
    }

    default Field hidden(KeyValuePair<String>... attributes) {
        return new Field("hidden",attributes);
    }

    default Field image(KeyValuePair<String>... attributes) {
        return new Field("image",attributes);
    }

    default Field month(KeyValuePair<String>... attributes) {
        return new Field("month",attributes);
    }

    default Field number(KeyValuePair<String>... attributes) {
        return new Field("number",attributes);
    }

    default Field password(KeyValuePair<String>... attributes) {
        return new Field("password",attributes);
    }

    default Field radio(KeyValuePair<String>... attributes) {
        return new Field("radio",attributes);
    }

    default Field range(KeyValuePair<String>... attributes) {
        return new Field("range",attributes);
    }

    default Field reset(KeyValuePair<String>... attributes) {
        return new Field("reset",attributes);
    }

    default Field search(KeyValuePair<String>... attributes) {
        return new Field("search",attributes);
    }

    default Field submit(KeyValuePair<String>... attributes) {
        return new Field("submit",attributes);
    }

    default Field tel(KeyValuePair<String>... attributes) {
        return new Field("tel",attributes);
    }

    default Field text(KeyValuePair<String>... attributes) {
        return new Field("text",attributes);
    }

    default Field time(KeyValuePair<String>... attributes) {
        return new Field("time",attributes);
    }

    default Field url(KeyValuePair<String>... attributes) {
        return new Field("url",attributes);
    }

    default Field week(KeyValuePair<String>... attributes) {
        return new Field("week",attributes);
    }

}
