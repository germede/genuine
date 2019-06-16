package com.sample;

import org.fluentness.form.FormConsumer;
import org.fluentness.style.StyleConsumer;
import org.fluentness.view.View;
import org.fluentness.view.ViewProvider;

public class Views extends ViewProvider implements StyleConsumer<Styles>, FormConsumer<Forms> {

    View base = html(
        head(
            title("A music archive made attrs love and Fluentness"),
            meta(NAME -> "lang", CONTENT -> "en"),
            meta(CHARSET -> "utf-8"),
            include(styles().bundle),
            includeJs("script.min.js")
        ),
        body(
            div(attrs(CLASS -> "container"),
                h1(translate("welcome_message")),
                placeholder()
            )
        )
    );

    View createSong = using(base,
        div(attrs(CLASS -> "row"),
            div(attrs(CLASS -> "column"),
                h2(translate("song_create")),
                forms().createSong
            )
        )
    );

    View songList = using(base,
        div(attrs(CLASS -> "row"),
            div(attrs(CLASS -> "column"),
                div(attrs(CLASS -> "row"),
                    div(attrs(CLASS -> "column column-50"),
                        h2(translate("song_list"))
                    ),
                    div(attrs(CLASS -> "column column-50"),
                        forms().searchSong
                    )
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
//                                    td(a(attrs(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
//                                    td(a(attrs(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
//                            )))
                ),
                a(attrs(CLASS -> "button", href -> "/song/create"),
                    translate("song_create")
                )
            )
        )
    );

}
