package com.sample;

import org.fluentness.form.Form;
import org.fluentness.form.FormProvider;

public class Forms implements FormProvider {

    Form createSong = form(POST, "/song/list",
        title -> text(
            required -> "true",
            id -> "song_title_input",
            placeholder -> translate("song_title_placeholder"),
            maxlength -> "50"
        ).precededBy(
            label(translate("song_title")).with(FOR -> "song_title_input")
        ),
        artist -> text(
            required -> "true",
            id -> "song_artist_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(translate("song_artist")).with(FOR -> "song_artist_input")
        ),
        album -> text(
            required -> "false",
            id -> "song_album_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(translate("song_album")).with(FOR -> "song_album_input")
        ),
        year -> number(
            required -> "true",
            id -> "song_year_input",
            placeholder -> translate("song_year_placeholder"),
            min -> "0",
            max -> "2099",
            step -> "1"
        ).precededBy(
            label(translate("song_year")).with(FOR -> "song_year_input")
        ),

        is_new -> checkbox(
            id -> "song_is_new_input"
        ).precededBy(
            label(translate("song_is_new")).with(FOR -> "song_is_new_input", CLASS -> "label-inline")
        ).wrappedBy(
            div().with(CLASS -> "float-right")
        ),
        submit -> submit(
            value -> translate("submit")
        ).followedBy(
            a(translate("cancel")).with(ONCLICK -> "window.history.back();", CLASS -> "button button-outline")
        )
    ).wrappedBy(
        fieldset()
    );

    Form searchSong = form(GET, "song/search",
        title -> text(
            REQUIRED -> "true",
            ID -> "song_title_input",
            PLACEHOLDER -> translate("song_title"),
            MAXLENGTH -> "20"
        )
    );
}
