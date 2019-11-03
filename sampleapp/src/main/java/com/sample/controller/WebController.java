package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.translator.TranslatorService;

import javax.servlet.http.HttpServletRequest;

public class WebController extends AbstractWebController {

    private BookRepository bookRepository;
    private TranslatorService translatorService;

    private Web web;

    public WebController(BookRepository bookRepository, TranslatorService translatorService) {
        this.bookRepository = bookRepository;
        this.translatorService = translatorService;

        web = new Web(this, translatorService);
    }

    @Action(path = "/listBooks")
    public WebView listBooks(HttpServletRequest request) {
        return web.listBooks(bookRepository.findAll());
    }

    @Action(path = "/asdfasdf")
    public WebView asdf(HttpServletRequest request) {
        return web.listBooks(bookRepository.findAll());
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