package com.sample;

import org.fluentness.view.View;
import org.fluentness.view.ViewProvider;

import static com.sample.Boot.F;


public class Views implements ViewProvider {

    View base = html(
        head(
            title("A music archive made attrs love and Fluentness"),
            meta(NAME -> "lang", CONTENT -> "en"),
            meta(CHARSET -> "utf-8"),
            include(F.styles.milligram),
            include(F.styles.custom),
            includeJs("script.min.js")
        ),
        body(
            div(
                h1(translate("welcome_message")),
                div(
                    placeholder()
                )
            ).attrs(CLASS -> "container")
        )
    );

    @Template("base")
    View createSong = div(
        div(
            h2(translate("song_create")),
            F.forms.createSong
        ).attrs(CLASS -> "column")
    ).attrs(CLASS -> "row");

    @Template("base")
    View songList = div(
        div(
            div(
                div(
                    h2(translate("song_list"))
                ).attrs(CLASS -> "column column-50"),
                div(
                    F.forms.searchSong
                ).attrs(CLASS -> "column column-50")
            ).attrs(CLASS -> "row"),
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
//                                    td(a(attrs(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
//                                    td(a(attrs(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
//                            )))
            ),
            a(
                translate("song_create")
            ).attrs(CLASS -> "button", HREF -> "/song/create")
        ).attrs(CLASS -> "column")
    ).attrs(CLASS -> "row");

}
