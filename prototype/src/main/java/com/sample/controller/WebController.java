package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.html.HtmlView;
import org.fluentness.service.translation.TranslationService;

import javax.servlet.http.Cookie;

import static com.sample.service.TranslationService.*;
import static org.fluentness.controller.web.WebViewFactory.action;
import static org.fluentness.controller.web.WebViewFactory.*;

public class WebController extends AbstractWebController {

    private BookRepository bookRepository;
    private TranslationService i18n;

    public WebController(BookRepository bookRepository, TranslationService translationService) {
        this.bookRepository = bookRepository;
        this.i18n = translationService;
    }

    @Action(path = "/")
    public WebView index(Request request) {
        return listBooks(request);
    }

    @Action(path = "/listBooks", authentication = true)
    public WebView listBooks(Request request) {
        return base(
            div(
                div(h2(i18n.translate(welcome_message, "Person"))).class_("column column-50"),
                action(this::index, i18n.translate(book_create)).class_("button")
            ).class_("row"),
            div(
                table(
                    thead(
                        tr(
                            th(i18n.translate(book_title)),
                            th(i18n.translate(book_author)),
                            th(i18n.translate(book_genre)),
                            th(i18n.translate(book_year)),
                            th(i18n.translate(book_is_new)),
                            th(i18n.translate(book_update)),
                            th(i18n.translate(book_delete))
                        )
                    ),
                    tbody(
                        forEach(bookRepository.findAll(), book ->
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

    @Action(path = "/testResponse")
    public Response testCookie(Request request) {
        return response -> response.addCookie(new Cookie("asdf", "asdf"));
    }


    private WebView base(HtmlView... toInclude) {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta().name("lang").content("en"),
                meta().charset("UTF-8"),
                link().rel("stylesheet").type("text/css").href("/resources/css/milligram.min.css"),
                script().src("/resources/js/script.min.js")
            ),
            body(
                div(toInclude).class_("container")
            )
        );
    }


//
//    @WebAction(path = "/")
//    public View index(HttpServletRequest request) {
//        return list(request);
//    }
//
//
//    @WebAction(path = "/list")
//    public View index(HttpServletRequest request) {
//        return list(request);
//    }
////
//    Controller<L> song = actions("/song",
//        get("/list", request ->
//            render(
//                viewProvider.songList.assigning(
//                    songs -> this.bookRepository.findAll(),
//                    testBoolean -> true,
//                    testParameter -> 1234
//                )
//            )
//        ),
//
//        get("/search", request -> {
//                List<Book> bookList = bookRepository
//                    .findByTitle("%" + request.getParameter("title") + "%");
//                return render(viewProvider.songList.assigning(songs -> bookList));
//            }
//        ),
//        get("/create", request -> render(viewProvider.createSong)),
//        post("/create/submit", request ->
//            {


//                Song song = new Song(
//                    1,
//                    request.getPostParameter("title"),
//                    request.getPostParameter("artist"),
//                    request.getPostParameter("album"),
//                    Integer.parseInt(request.getPostParameter("year")),
//                    Boolean.parseBoolean(request.getPostParameter("is_new"))
//                );

//                return redirect("/song/list");
//            }
//        )

//        get("/update/{id}",
//            (request, response) -> render(Atoz.views.createSong, createSong -> new SongForm())
//        ),
//
//        post("/create/submit",
//            (request, response) -> {
//                Entity<Models> song = new Entity(Models.class);
//                song.set(
//                    title -> request.getPostParameter("title"),
//                    artist -> request.getPostParameter("artist"),
//                    album -> request.getPostParameter("album"),
//                    year -> request.getPostParameter("year"),
//                    is_new -> request.getPostParameter("is_new")
//                );
//                songRepository.create(song);
//                redirect("/song/list");
//            }
//        ),
//
//        get("/delete/{id}",
//            (request, response) -> render(Views.class, createSong -> new SongForm())
//        ),
//    );

//    @DesktopAction(event = Event.ACTION_EVENT)
//    public void doSomething(Event event) {
//

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