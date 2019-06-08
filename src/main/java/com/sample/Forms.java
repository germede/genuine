package com.sample;

import org.fluentness.form.Form;
import org.fluentness.form.FormProvider;

public class Forms implements FormProvider {

    Form songForm = form(POST, "/song/list",
        title -> text(
            required -> "true",
            id -> "song_title_input",
            placeholder -> translate("song_title_placeholder"),
            maxlength -> "50"
        ).precededBy(
            label(with(FOR -> "song_title_input"), translate("song_title"))
        ),
        artist -> text(
            required -> "true",
            id -> "song_artist_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(with(FOR -> "song_artist_input"), translate("song_artist"))
        ),
        album -> text(
            required -> "false",
            id -> "song_album_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(with(FOR -> "song_album_input"), translate("song_album"))
        ),
        year -> number(
            required -> "true",
            id -> "song_year_input",
            placeholder -> translate("song_year_placeholder"),
            min -> "0",
            max -> "2099",
            step -> "1"
        ).precededBy(
            label(with(FOR -> "song_year_input"), translate("song_year"))
        ),

        is_new -> checkbox(
            id -> "song_is_new_input"
        ).precededBy(
            label(with(FOR -> "song_is_new_input", CLASS -> "label-inline"), translate("song_is_new"))
        ).wrappedBy(
            div(with(CLASS -> "float-right"))
        ),
        submit -> submit(
            value -> translate("submit")
        ).followedBy(
            a(with(ONCLICK -> "window.history.back();", CLASS -> "button button-outline"), translate("cancel"))
        )
    ).wrappedBy(
        fieldset()
    );

    Form songSearchForm = form(GET, "song/search",
        title -> text(
            REQUIRED -> "true",
            ID -> "song_title_input",
            PLACEHOLDER -> translate("song_title"),
            MAXLENGTH -> "20"
        )
    );
}
