package sample.flow;

import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.provider.ControllerProvider;
import sample.data.Song;
import sample.data.SongRepository;

import java.util.List;

public class Controllers extends ControllerProvider {

    Views views;
    SongRepository songRepository;

    public Controllers(Views views, SongRepository songRepository) {
        this.views = views;
        this.songRepository = songRepository;
    }

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
                views.songList.assigning(
                    songs -> songRepository.findAll(),
                    testBoolean -> true,
                    testParameter -> 1234
                )
            )
        ),

        get("/search", request -> {
                List<Song> songList = songRepository
                    .findByTitle("%" + request.getParameter("title") + "%");
                return render(views.songList.assigning(songs -> songList));
            }
        ),
        get("/create", request -> render(views.createSong)),
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