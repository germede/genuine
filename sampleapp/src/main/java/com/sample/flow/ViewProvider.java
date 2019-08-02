package com.sample.flow;

import com.sample.base.LocalizationService;
import com.sample.data.Song;
import org.fluentness.flow.component.view.View;
import org.fluentness.flow.provider.Provider;

import static org.fluentness.flow.component.view.html.HtmlViewFactory.*;

public class ViewProvider implements Provider<View> {

    private StyleProvider styleProvider;
    private FormProvider formProvider;
    private LocalizationService localizations;

    public ViewProvider(StyleProvider styleProvider, FormProvider formProvider, LocalizationService localizations) {
        this.styleProvider = styleProvider;
        this.formProvider = formProvider;
        this.localizations = localizations;
    }

    private View base(View toInclude) {
        return html(
                head(
                        title("A music archive made with love and Fluentness"),
                        meta(NAME -> "lang", CONTENT -> "en"),
                        meta(CHARSET -> "utf-8"),
                        style(styleProvider.bundle),
                        includeJs("script.min.js")
                ),
                body(
                        div(attrs(CLASS -> "container"),
                                h1(localizations.translate(localizations.welcome_message)),
                                toInclude
                        )
                )
        );
    }

    final View createSong = base(
            div(attrs(CLASS -> "row"),
                    div(attrs(CLASS -> "column"),
                            h2(translate("song_create")),
                            formProvider.createSong
                    )
            )
    );

    final View songList = base(
            div(attrs(CLASS -> "row"),
                    div(attrs(CLASS -> "column"),
                            div(attrs(CLASS -> "row"),
                                    div(attrs(CLASS -> "column column-50"),
                                            h2(translate("song_list"))
                                    ),
                                    div(attrs(CLASS -> "column column-50"),
                                            formProvider.searchSong
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
