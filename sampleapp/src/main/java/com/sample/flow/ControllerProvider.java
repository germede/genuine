package com.sample.flow;

import com.sample.data.Song;
import com.sample.data.SongRepository;
import org.fluentness.base.common.constant.HttpStatusCode;
import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.component.controller.Controlleri;
import org.fluentness.flow.provider.Provider;

import java.util.List;

import static org.fluentness.flow.component.controller.ControllerFactory.*;
import static org.fluentness.flow.component.controller.HttpServletResponseFactory.*;

public class ControllerProvider implements Provider<Controller> {

    private ViewProvider viewProvider;
    private SongRepository songRepository;

    public ControllerProvider(ViewProvider viewProvider, SongRepository songRepository) {
        this.viewProvider = viewProvider;
        this.songRepository = songRepository;
    }

    @Route("/test", method = )
    Controlleri test = request -> response(HttpStatusCode.OK, "yea");

    @Route("/", method = )
    Controlleri index = request -> test.handle(request);

    Controller base = actions(
        get("/", request -> redirect("/song/list")),

        get("/test", request -> {
            Song newSong = new Song();
            newSong.setTitle("Ein Lied");
            songRepository.create(newSong);
            return response("yea");
        })
    );

    Controller song = actions("/song",
        get("/list", request ->
            render(
                viewProvider.songList.assigning(
                    songs -> this.songRepository.findAll(),
                    testBoolean -> true,
                    testParameter -> 1234
                )
            )
        ),

        get("/search", request -> {
                List<Song> songList = songRepository
                    .findByTitle("%" + request.getParameter("title") + "%");
                return render(viewProvider.songList.assigning(songs -> songList));
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
}