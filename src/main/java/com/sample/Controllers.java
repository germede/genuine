package com.sample;

import com.sample.generated.Song;
import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProducer;
import org.fluentness.task.TaskConsumer;
import org.fluentness.view.ViewConsumer;

import java.util.ArrayList;


public class Controllers extends ControllerProducer implements ViewConsumer<Views>, TaskConsumer<Tasks> {

    Controller baseController = actions(

    );

    @Route("/song")
    Controller songController = actions(


        list -> get("/list", request -> render(views().songList.with(songs -> new ArrayList<Song>()))),

        create -> get("/create", request -> render(views().createSong)),

        create_submit -> post("/create/submit", request ->
            {
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
//            (request, response) -> render(Atoz.views.createSong, createSong -> new SongForm())
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
//            (request, response) -> render(Views.class, createSong -> new SongForm())
//        ),
    );
}