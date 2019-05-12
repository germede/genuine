package sample.form;

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
                        REQUIRED -> "true",
                        ID -> "song_title_input",
                        PLACEHOLDER -> translate("song_title_placeholder"),
                        MAXLENGTH -> "50"
                ),
                artist -> text(
                        REQUIRED -> "true",
                        ID -> "song_artist_input",
                        PLACEHOLDER -> translate("song_artist_placeholder")
                ),
                album -> text(
                        REQUIRED -> "false",
                        ID -> "song_album_input",
                        PLACEHOLDER -> translate("song_artist_placeholder")
                ),
                year -> number(
                        REQUIRED -> "true",
                        ID -> "song_year_input",
                        PLACEHOLDER -> translate("song_year_placeholder"),
                        MIN -> "0",
                        MAX -> "2099",
                        STEP -> "1"
                ),
                is_new -> checkbox(
                        ID -> "song_is_new_input"
                )
        );
    }

    @Override
    public Renderable getRenderable() {
        return fieldset(
                label(attrs(FOR -> "song_title_input"), translate("song_title")),
                field("title"),
                label(attrs(FOR -> "song_artist_input"), translate("song_artist")),
                field("artist"),
                label(attrs(FOR -> "song_album_input"), translate("song_album")),
                field("album"),
                label(attrs(FOR -> "song_year_input"), translate("song_year")),
                field("year"),

                div(attrs(CLASS -> "float-right"),
                        label(attrs(FOR -> "song_is_new_input", CLASS -> "label-inline"), translate("song_is_new")),
                        field("is_new")
                ),

                input(TYPE -> "submit", VALUE -> translate("submit")),
                " ",
                a(attrs(ONCLICK -> "window.history.back();", CLASS -> "button button-outline"), translate("cancel"))
        );
    }

}
