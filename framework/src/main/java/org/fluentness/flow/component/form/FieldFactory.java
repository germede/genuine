package org.fluentness.flow.component.form;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

public final class FieldFactory {

    private FieldFactory() {

    }

    public static Field button(KeyValuePairLambda<String>... attributes) {
        return new Field("button", attributes);
    }

    public static Field checkbox(KeyValuePairLambda<String>... attributes) {
        return new Field("checkbox", attributes);
    }

    public static Field color(KeyValuePairLambda<String>... attributes) {
        return new Field("color", attributes);
    }

    public static Field date(KeyValuePairLambda<String>... attributes) {
        return new Field("date", attributes);
    }

    public static Field datetime(KeyValuePairLambda<String>... attributes) {
        return new Field("datetime", attributes);
    }

    public static Field email(KeyValuePairLambda<String>... attributes) {
        return new Field("email", attributes);
    }

    public static Field file(KeyValuePairLambda<String>... attributes) {
        return new Field("file", attributes);
    }

    public static Field hidden(KeyValuePairLambda<String>... attributes) {
        return new Field("hidden", attributes);
    }

    public static Field image(KeyValuePairLambda<String>... attributes) {
        return new Field("image", attributes);
    }

    public static Field month(KeyValuePairLambda<String>... attributes) {
        return new Field("month", attributes);
    }

    public static Field number(KeyValuePairLambda<String>... attributes) {
        return new Field("number", attributes);
    }

    public static Field password(KeyValuePairLambda<String>... attributes) {
        return new Field("password", attributes);
    }

    public static Field radio(KeyValuePairLambda<String>... attributes) {
        return new Field("radio", attributes);
    }

    public static Field range(KeyValuePairLambda<String>... attributes) {
        return new Field("range", attributes);
    }

    public static Field reset(KeyValuePairLambda<String>... attributes) {
        return new Field("reset", attributes);
    }

    public static Field search(KeyValuePairLambda<String>... attributes) {
        return new Field("search", attributes);
    }

    public static Field submit(KeyValuePairLambda<String>... attributes) {
        return new Field("submit", attributes);
    }

    public static Field tel(KeyValuePairLambda<String>... attributes) {
        return new Field("tel", attributes);
    }

    public static Field text(KeyValuePairLambda<String>... attributes) {
        return new Field("text", attributes);
    }

    public static Field time(KeyValuePairLambda<String>... attributes) {
        return new Field("time", attributes);
    }

    public static Field url(KeyValuePairLambda<String>... attributes) {
        return new Field("url", attributes);
    }

    public static Field week(KeyValuePairLambda<String>... attributes) {
        return new Field("week", attributes);
    }

}
