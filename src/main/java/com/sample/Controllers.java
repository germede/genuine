package com.sample;

import com.sample.generated.Song;
import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProvider;

import java.util.ArrayList;

public class Controllers implements ControllerProvider {

    Controller baseController = actions(
        index -> get("/",
            request -> redirect("/list")
        )
    );

    @Route("/song")
    Controller songController = actions(

        index -> get("/",
            request -> redirect("/list")
        ),

        list -> get("/list",
            request -> {
                String title = request.getGetParameter("title");
                return render(Atoz.views.songList,
                    songs -> new ArrayList<Song>());
            }
        ),

        create -> get("/create",
            request -> render(Atoz.views.createSong, songForm -> Atoz.forms.songForm)
        ),

        create_submit -> post("/create/submit",
            request -> {
                Song song = new Song(
                    1,
                    request.getPostParameter("title"),
                    request.getPostParameter("artist"),
                    request.getPostParameter("album"),
                    Integer.parseInt(request.getPostParameter("year")),
                    Boolean.parseBoolean(request.getPostParameter("is_new"))
                );

                return redirect("/song/list");
            }
        )

//        update -> get("/update/{id}",
//            (request, response) -> render(Atoz.views.createSong, songForm -> new SongForm())
//        ),
//
//        update_submit -> post("/create/submit",
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
//        delete -> get("/delete/{id}",
//            (request, response) -> render(Views.class, songForm -> new SongForm())
//        ),
    );
}