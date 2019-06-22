package com.sample.flow;

import org.fluentness.flow.form.Form;
import org.fluentness.flow.form.FormProvider;

public class Forms extends FormProvider {

    Form createSong = post("/song/list",

        title -> text(
            required -> "true",
            id -> "song_title_input",
            placeholder -> translate("song_title_placeholder"),
            maxlength -> "50"
        ).precededBy(
            label(attrs(FOR -> "song_title_input"),
                translate("song_title")
            )
        ),

        artist -> text(
            required -> "true",
            id -> "song_artist_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(attrs(FOR -> "song_artist_input"),
                translate("song_artist")
            )
        ),

        album -> text(
            required -> "false",
            id -> "song_album_input",
            placeholder -> translate("song_artist_placeholder")
        ).precededBy(
            label(attrs(FOR -> "song_album_input"),
                translate("song_album")
            )
        ),

        year -> number(
            required -> "true",
            id -> "song_year_input",
            placeholder -> translate("song_year_placeholder"),
            min -> "0",
            max -> "2099",
            step -> "1"
        ).precededBy(
            label(attrs(FOR -> "song_year_input"),
                translate("song_year")
            )
        ),

        is_new -> checkbox(
            id -> "song_is_new_input"
        ).precededBy(
            label(attrs(FOR -> "song_is_new_input", CLASS -> "label-inline"),
                translate("song_is_new")
            )
        ).wrappedBy(
            div(attrs(CLASS -> "float-right"))
        ),

        submit -> submit(
            value -> translate("submit")
        ).followedBy(
            raw(" "),
            a(attrs(ONCLICK -> "window.history.back();", CLASS -> "button button-outline"),
                translate("cancel")
            )
        )
    );

    Form searchSong = get("song/search",
        title -> text(
            required -> "true",
            id -> "song_title_input",
            placeholder -> translate("song_title"),
            maxlength -> "20"
        )
    );
}
