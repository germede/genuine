package com.sample.controller;

import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.web.WebAction;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.fluentness.service.server.HttpMethod.GET;
import static org.fluentness.controller.controller.ControllerFactory.*;
import static org.fluentness.controller.web.HttpServletResponseFactory.*;

public class WebController implements Controller {

    private BookRepository bookRepository;

    private Web webView;

    public WebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @WebAction(path = "/test", method = GET)
    public String test(HttpServletRequest request) {
        Book newBook = new Book();
        newBook.setTitle("Ein Lied");
        bookRepository.create(newBook);
        return response("yea");
    }

    @WebAction(path = "/")
    public View index(HttpServletRequest request) {
        return list(request);
    }


    @WebAction(path = "/list")
    public View index(HttpServletRequest request) {
        return list(request);
    }

    Controller<L> song = actions("/song",
        get("/list", request ->
            render(
                viewProvider.songList.assigning(
                    songs -> this.bookRepository.findAll(),
                    testBoolean -> true,
                    testParameter -> 1234
                )
            )
        ),

        get("/search", request -> {
                List<Book> bookList = bookRepository
                    .findByTitle("%" + request.getParameter("title") + "%");
                return render(viewProvider.songList.assigning(songs -> bookList));
            }
        ),
        get("/create", request -> render(viewProvider.createSong)),
        post("/create/submit", request ->
            {


//                Song song = new Song(
//                    1,
//                    request.getPostParameter("title"),
//                    request.getPostParameter("artist"),
//                    request.getPostParameter("album"),
//                    Integer.parseInt(request.getPostParameter("year")),
//                    Boolean.parseBoolean(request.getPostParameter("is_new"))
//                );

                return redirect("/song/list");
            }
        )

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
    );

//    @DesktopAction(event = Event.ACTION_EVENT)
//    public void doSomething(Event event) {
//
//    }


    @AbstractConsoleController.Description(description = "Print all books containing name", arguments = {"name"})
    public void printAllBooksContainingName(String[] args) {
        bookRepository.findByTitle(args[0]).stream().map(Object::toString).forEach(System.out::println);
    }
}