package com.sample.flow;

import com.sample.data.Song;
import com.sample.data.SongRepository;
import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.provider.ControllerProvider;

import java.util.List;

public class Controllers extends ControllerProvider {

    Controller base = actions(
        index -> get("/", request -> redirect("/song/list")),

        test -> get("/test", request -> {


            Song newSong = new Song();
            newSong.setTitle("Ein Lied");
            repository(SongRepository.class).create(newSong);
            return response("yea");
        })
    );

    Controller song = actions("/song",
        list -> get("/list", request -> {
                List<Song> songList = repository(SongRepository.class).findAll();
                return render(
                    provider(Views.class).songList.assigning(
                        songs -> songList,
                        testBoolean -> true,
                        testParameter -> 1234
                    )
                );
            }
        ),

        search -> get("/search", request -> {
                List<Song> songList = repository(SongRepository.class)
                    .findByTitle("%" + request.getParameter("title") + "%");
                return render(provider(Views.class).songList.assigning(songs -> songList));
            }
        ),

        create -> get("/create", request -> render(provider(Views.class).createSong)),

        create_submit -> post("/create/submit", request ->
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