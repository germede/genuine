package com.sample.form;

import org.fluentness.form.Form;
import org.fluentness.networking.HttpMethod;
import org.fluentness.rendering.Renderable;

public class SongForm implements Form {

    @Override
    public String getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getAction() {
        return "/song/list";
    }

    @Override
    public Fields getFields() {
        return fields(
                title -> text(
                        required -> "true",
                        id -> "song_title_input",
                        placeholder -> translate("song_title_placeholder"),
                        maxlength -> "50"
                ),
                artist -> text(
                        required -> "true",
                        id -> "song_artist_input",
                        placeholder -> translate("song_artist_placeholder")
                ),
                album -> text(
                        required -> "false",
                        id -> "song_album_input",
                        placeholder -> translate("song_artist_placeholder")
                ),
                year -> number(
                        required -> "true",
                        id -> "song_year_input",
                        placeholder -> translate("song_year_placeholder"),
                        min -> "0",
                        max -> "2099",
                        step -> "1"
                ),
                is_new -> checkbox(
                        id -> "song_is_new_input"
                )
        );
    }

    @Override
    public Renderable getRenderable() {
        return form(with(METHOD -> getMethod(), ACTION -> getAction()),
                fieldset(
                        label(with(FOR -> "song_title_input"), translate("song_title")),
                        field("title"),
                        label(with(FOR -> "song_artist_input"), translate("song_artist")),
                        field("artist"),
                        label(with(FOR -> "song_album_input"), translate("song_album")),
                        field("album"),
                        label(with(FOR -> "song_year_input"), translate("song_year")),
                        field("year"),

                        div(with(CLASS -> "float-right"),
                                label(with(FOR -> "song_is_new_input", CLASS -> "label-inline"), translate("song_is_new")),
                                field("is_new")
                        ),

                        input(with(TYPE -> "submit", VALUE -> translate("submit"))),
                        " ",
                        a(with(ONCLICK -> "window.history.back();", CLASS -> "button button-outline"), translate("cancel"))
                )
        );
    }

}
