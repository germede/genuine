package com.sample.controller;

import com.sample.repository.Book;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.html.HtmlView;
import org.fluentness.service.localization.LocalizationService;

import java.util.List;

import static org.fluentness.controller.web.WebViewFactory.*;

public class Web {

    private LocalizationService l10n;

    public Web(LocalizationService l10n) {
        this.l10n = l10n;
    }

    WebView testView() {
        return raw("Test raw view");
    }

    WebView listBooks(List<Book> books) {
        return base(
            div(
                div(h2(l10n.translate("welcome_message", "Person"))).class_("column column-50"),
                a(l10n.translate("book_create")).class_("button").href("/book/create")
            ).class_("row"),
            div(
                table(
                    thead(
                        tr(
                            th(l10n.translate("book_title")),
                            th(l10n.translate("book_author")),
                            th(l10n.translate("book_genre")),
                            th(l10n.translate("book_year")),
                            th(l10n.translate("book_is_new")),
                            th(l10n.translate("book_update")),
                            th(l10n.translate("book_delete"))
                        )
                    ),
                    tbody(
                        forEach(books, book ->
                            tr(
                                td(book.getTitle()),
                                td(book.getTitle().length() > 1 ? "✔" : "\uD83D\uDDD9"),
                                td(a("\uD83D\uDD89").class_("button").href("/book/update/" + book.getId())),
                                td(a("\uD83D\uDDD1").class_("button").href("/book/delete/" + book.getId()))
                            )
                        )
                    )
                )
            ).class_("row")
        );
    }

    private WebView base(HtmlView... toInclude) {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta().name("lang").content("en"),
                meta().charset("utf-8"),
                link().rel("stylesheet").type("text/css").href("/resources/css/milligram.min.css"),
                script().src("/resources/js/script.min.js")
            ),
            body(
                div(toInclude).class_("container")
            )
        );
    }

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
