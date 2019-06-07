package com.sample;

import com.sample.form.SongSearchForm;
import sample.view.BaseView;
import org.fluentness.form.Form;
import org.fluentness.view.View;

import java.util.List;

public class Views implements View.Html {

    View base = html(
            head(
                    title("A music archive made with love and Fluentness"),
                    meta(with(NAME -> "lang", CONTENT -> getLocale().getLanguage())),
                    meta(with(CHARSET -> "utf-8")),
//                        new FormStyle().getRuleset().toString(),
                    includeCss("milligram.min.css"),
                    includeCss("custom.css"),
                    includeJs("script.min.js")
            ),
            body(
                    div(with(CLASS -> "container"),
                            h1(translate("welcome_message"))
//                            placeholder()
                    )
            )
    );


//    @Template(BaseView.class)
    View createSong = div(with(CLASS -> "row"),
            div(with(CLASS -> "column"),
                    h2(translate("song_create"))
//                    retrieve(Form.class, "form")
            )
    );

//    @Template(BaseView.class)
    View songList = div(with(CLASS -> "row"),
            div(with(CLASS -> "column"),
                    div(with(CLASS -> "row"),
                            div(with(CLASS -> "column column-50"),
                                    h2(translate("song_list"))
                            ),
                            div(with(CLASS -> "column column-50"),
                                    new SongSearchForm().getRenderable()
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
//                                    td(a(with(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
//                                    td(a(with(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
//                            )))
                    ),
                    a(with(CLASS -> "button", HREF -> "/song/create"),
                            translate("song_create")
                    )
            )
    );

}
