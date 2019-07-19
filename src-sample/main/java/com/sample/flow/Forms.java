package com.sample.flow;

import org.fluentness.flow.form.Field;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.form.FormProvider;

public class Forms extends FormProvider {

    Field textField(String idString, String placeholderKey, String labelKey) {
        return text(
            required -> "true",
            id -> idString,
            placeholder -> translate(placeholderKey),
            maxlength -> "50"
        ).precededBy(
            label(attrs(FOR -> idString),
                translate(labelKey)
            )
        );
    }

    Field yearField(String idString, String placeholderKey, String labelKey) {
        return number(
            required -> "true",
            id -> idString,
            placeholder -> translate(placeholderKey),
            min -> "1900",
            max -> "2099",
            step -> "1"
        ).precededBy(
            label(attrs(FOR -> idString),
                translate(labelKey)
            )
        );
    }

    Form createSong = post("/song/list",

        title -> textField("song_title_input", "song_title_placeholder", "song_title"),

        artist -> textField("song_artist_input", "song_artist_placeholder", "song_artist"),

        album -> textField("song_album_input", "song_album_placeholder", "song_album"),

        year -> yearField("song_year_input","song_year_placeholder","song_year"),

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

    Form searchSong = get("/song/search",
        title -> text(
            required -> "true",
            id -> "song_title_input",
            placeholder -> translate("song_title"),
            maxlength -> "20"
        )
    );
}
