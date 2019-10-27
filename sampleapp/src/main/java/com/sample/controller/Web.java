package com.sample.controller;

import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.text.RawView;

public class Web {



    WebView testView() {
        return new RawView("Test raw view");
    }

//    private WebView songList = base(
//            div(attrs(CLASS -> "row"),
//                    div(attrs(CLASS -> "column"),
//                            div(attrs(CLASS -> "row"),
//                                    div(attrs(CLASS -> "column column-50"),
//                                            h2(translate("song_list"))
//                                    ),
//                                    div(attrs(CLASS -> "column column-50"),
//                                            formProvider.searchSong
//                                    ),
//                                    table(
//                                            thead(
//                                                    tr(
//                                                            th(translate("song_title")),
//                                                            th(translate("song_artist")),
//                                                            th(translate("song_album")),
//                                                            th(translate("song_year")),
//                                                            th(translate("song_is_new")),
//                                                            th(translate("song_update")),
//                                                            th(translate("song_delete"))
//                                                    )
//                                            ),
//                                            tbody(
//                                                    forEachItemIn("songs", Book.class,
//                                                            song -> tr(
//                                                                    td(song.getTitle()),
//                                                                    ContainerHtmlViewFactory.td(print("testParameter"))
////                                td(song.getBoolean("is_new") ? "✔" : "\uD83D\uDDD9"),
////                                td(a(attrs(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
////                                td(a(attrs(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
//                                                            )
//                                                    )
//                                            )
//                                    ),
//                                    a(attrs(CLASS -> "button", href -> "/song/create"),
//                                            translate("song_create")
//                                    )
//                            )
//                    )
//            )
//    );
//
//    private Localization localizations;
//
//
//    public Web(Localization localizations) {
//        this.localizations = localizations;
//    }
//

//    private Field textField(String idString, String placeholderKey, String labelKey) {
//        return text(
//                required -> "true",
//                id -> idString,
//                placeholder -> translate(placeholderKey),
//                maxlength -> "50"
//        ).precededBy(
//                label(attrs(FOR -> idString),
//                        translate(labelKey)
//                )
//        );
//    }
//
//    Form createSong = post("/song/list",
//
//            title -> textField("song_title_input", "song_title_placeholder", "song_title"),
//
//            artist -> textField("song_artist_input", "song_artist_placeholder", "song_artist"),
//
//            album -> textField("song_album_input", "song_album_placeholder", "song_album"),
//
//            number(required + "true", id + "song_year_input", placeholder + translate("song_year_placeholder"),
//                    min -> "1900",
//                    max -> "2099",
//                    step -> "1"
//            ).precededBy(
//                    label(attrs(FOR -> "song_year_input"),
//                            translate("song_year")
//                    )
//            ),
//
//            is_new -> checkbox(
//                    id -> "song_is_new_input"
//            ).precededBy(
//                    label(attrs(FOR -> "song_is_new_input", CLASS -> "label-inline"),
//                            translate("song_is_new")
//                    )
//            ).wrappedBy(
//                    div(attrs(CLASS -> "float-right"))
//            ),
//
//            submit -> submit(
//                    value -> translate("submit")
//            ).followedBy(
//                    raw(" "),
//                    a(attrs(ONCLICK -> "window.history.back();", CLASS -> "button button-outline"),
//                            translate("cancel")
//                    )
//            )
//    );
//
//    Form searchSong = get("/song/search",
//            title -> text(
//                    required -> "true",
//                    id -> "song_title_input",
//                    placeholder -> translate("song_title"),
//                    maxlength -> "20"
//            )
//    );

//
//    private WebView base(WebView toInclude) {
//        return html(
//                head(
//                        title("A music archive made with love and Fluentness"),
//                        meta(NAME -> "lang", CONTENT -> "en"),
//                        meta(CHARSET -> "utf-8"),
//                        style(styleProvider.bundle),
//                        includeJs("script.min.js")
//                ),
//                body(
//                        div(attrs(CLASS -> "container"),
//                                h1(localizations.translate(localizations.welcome_message)),
//                                toInclude
//                        )
//                )
//        );
//    }
//    public WebView createSong(){
//        return base(
//                div(attrs(CLASS -> "row"),
//                        div(attrs(CLASS -> "column"),
//                                h2(translate("song_create")),
//                                formProvider.createSong
//                        )
//                )
//        );
//    }

}
