package com.sample.flow;

import com.sample.base.LocalizationService;
import com.sample.data.Song;
import org.fluentness.flow.component.view.View;

public class ViewProvider extends org.fluentness.flow.provider.ViewProvider {

    StyleProvider styles;
    FormProvider forms;
    LocalizationService ls;

    public ViewProvider(StyleProvider styles, FormProvider forms, LocalizationService ls) {
        this.styles = styles;
        this.forms = forms;
        this.ls = ls;
    }

    private View base(View toInclude) {
        return html(
                head(
                        title("A music archive made with love and Fluentness"),
                        meta(NAME -> "lang", CONTENT -> "en"),
                        meta(CHARSET -> "utf-8"),
                        style(styles.bundle),
                        includeJs("script.min.js")
                ),
                body(
                        div(attrs(CLASS -> "container"),
                                h1(ls.translate(ls.welcomeMessage)),
                                toInclude
                        )
                )
        );
    }

    View createSong = base(
        div(attrs(CLASS -> "row"),
            div(attrs(CLASS -> "column"),
                h2(translate("song_create")),
                forms.createSong
            )
        )
    );

    View songList = base(
        div(attrs(CLASS -> "row"),
            div(attrs(CLASS -> "column"),
                div(attrs(CLASS -> "row"),
                    div(attrs(CLASS -> "column column-50"),
                        h2(translate("song_list"))
                    ),
                    div(attrs(CLASS -> "column column-50"),
                        forms.searchSong
                    ),
                    table(
                        thead(
                            tr(
                                th(translate("song_title")),
                                th(translate("song_artist")),
                                th(translate("song_album")),
                                th(translate("song_year")),
                                th(translate("song_is_new")),
                                th(translate("song_update")),
                                th(translate("song_delete"))
                            )
                        ),
                        tbody(
                            forEachItemIn("songs", Song.class,
                                song -> tr(
                                    td(song.getTitle()),
                                    td(print("testParameter"))
//                                td(song.getBoolean("is_new") ? "✔" : "\uD83D\uDDD9"),
//                                td(a(attrs(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
//                                td(a(attrs(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
                                )
                            )
                        )
                    ),
                    a(attrs(CLASS -> "button", href -> "/song/create"),
                        translate("song_create")
                    )
                )
            )
        )
    );

}
