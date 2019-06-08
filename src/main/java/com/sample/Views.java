package com.sample;

import org.fluentness.view.View;
import org.fluentness.view.ViewProvider;

public class Views implements ViewProvider {

    View base = html(
        head(
            title("A music archive made with love and Fluentness"),
            meta(NAME -> "lang", CONTENT -> getLocale().getLanguage()),
            meta(CHARSET -> "utf-8"),
            style(Atoz.styles.milligram, "miligram"),
            style(Atoz.styles.custom, "custom"),
            includeJs("script.min.js")
        ),
        body(
            div(
                h1(translate("welcome_message")),
                div(
                    placeholder()
                )
            )
        ).with(CLASS -> "container")
    );

    @Template("base")
    View createSong = div(
        div(
            h2(translate("song_create"))
//                    retrieve(Form.class, "form")
        ).with(CLASS -> "column")
    ).with(CLASS -> "row");

    @Template("base")
    View songList = div(
        div(
            div(
                div(
                    h2(translate("song_list"))
                ).with(CLASS -> "column column-50"),
                div(
                    Atoz.forms.searchSong
                ).with(CLASS -> "column column-50")
            ),
            table(
                thead(tr(
                    th(translate("song_title")),
                    th(translate("song_artist")),
                    th(translate("song_album")),
                    th(translate("song_year")),
                    th(translate("song_is_new")),
                    th(translate("song_update")),
                    th(translate("song_delete"))
                ))
//                            tbody(forEachEntityIn(retrieve(List.class, "songs"), song -> tr(
//                                    td(song.getString("title")),
//                                    td(song.getString("artist")),
//                                    td(song.getString("album")),
//                                    td(song.getString("year")),
//                                    td(song.getBoolean("is_new") ? "✔" : "\uD83D\uDDD9"),
//                                    td(a(with(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
//                                    td(a(with(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
//                            )))
            ).with(CLASS -> "row"),
            a(
                translate("song_create")
            ).with(CLASS -> "button", HREF -> "/song/create")
        ).with(CLASS -> "column")
    ).with(CLASS -> "row");

}
