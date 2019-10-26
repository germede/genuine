package org.fluentness.controller.web.form;

public final class FieldFactory {

    private FieldFactory() {

    }

    public static Field button(String... attributes) {
        return new Field("button", attributes);
    }

    public static Field checkbox(String... attributes) {
        return new Field("checkbox", attributes);
    }

    public static Field color(String... attributes) {
        return new Field("color", attributes);
    }

    public static Field date(String... attributes) {
        return new Field("date", attributes);
    }

    public static Field datetime(String... attributes) {
        return new Field("datetime", attributes);
    }

    public static Field email(String... attributes) {
        return new Field("email", attributes);
    }

    public static Field file(String... attributes) {
        return new Field("file", attributes);
    }

    public static Field hidden(String... attributes) {
        return new Field("hidden", attributes);
    }

    public static Field image(String... attributes) {
        return new Field("image", attributes);
    }

    public static Field month(String... attributes) {
        return new Field("month", attributes);
    }

    public static Field number(String... attributes) {
        return new Field("number", attributes);
    }

    public static Field password(String... attributes) {
        return new Field("password", attributes);
    }

    public static Field radio(String... attributes) {
        return new Field("radio", attributes);
    }

    public static Field range(String... attributes) {
        return new Field("range", attributes);
    }

    public static Field reset(String... attributes) {
        return new Field("reset", attributes);
    }

    public static Field search(String... attributes) {
        return new Field("search", attributes);
    }

    public static Field submit(String... attributes) {
        return new Field("submit", attributes);
    }

    public static Field tel(String... attributes) {
        return new Field("tel", attributes);
    }

    public static Field text(String... attributes) {
        return new Field("text", attributes);
    }

    public static Field time(String... attributes) {
        return new Field("time", attributes);
    }

    public static Field url(String... attributes) {
        return new Field("url", attributes);
    }

    public static Field week(String... attributes) {
        return new Field("week", attributes);
    }

}
