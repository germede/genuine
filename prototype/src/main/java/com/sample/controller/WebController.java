package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.translation.TranslationService;

import javax.servlet.http.Cookie;

public class WebController extends AbstractWebController {

    private BookRepository bookRepository;
    private TranslationService translatorService;

    private Web web;

    public WebController(BookRepository bookRepository, TranslationService translatorService) {
        this.bookRepository = bookRepository;
        this.translatorService = translatorService;

        web = new Web(this, translatorService);
    }

    @Action(path = "/")
    public WebView index(Request request) {
        return listBooks(request);
    }

    @Action(path = "/listBooks")
    public WebView listBooks(Request request) {
        request.getParameter("");
        return web.listBooks(bookRepository.findAll());
    }

    @Action(path = "/asdfasdf")
    public WebView asdf() {
        return web.listBooks(bookRepository.findAll());
    }

    @Action(path = "/testResponse")
    public Response testCookie(Request request) {
        return response -> response.addCookie(new Cookie("asdf","asdf"));
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

}