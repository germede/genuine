package com.sample.flow;

import com.sample.data.Song;
import com.sample.data.SongRepository;
import org.fluentness.base.common.injection.InjectProvider;
import org.fluentness.base.common.injection.InjectRepository;
import org.fluentness.flow.producer.controller.Controller;
import org.fluentness.flow.producer.controller.ControllerProducer;
import org.fluentness.flow.producer.view.View;

import java.util.List;

public class Controllers extends ControllerProducer {

    @InjectRepository(Song.class)
    private SongRepository songRepository;

    @InjectProvider(View.class)
    private Views views;

    Controller base = actions(
        index -> get("/", request -> redirect("/song/list")),

        test -> get("/test", request -> {



            Song newSong = new Song();
            newSong.setTitle("Ein Lied");
            songRepository.create(newSong);
            return response("yea");
        })
    );

    Controller song = actions("/song",
        list -> get("/list", request -> {
                List<Song> songList = songRepository.findAll();
                return render(
                    views.songList.assigning(
                        songs -> songList,
                        testBoolean -> true,
                        testParameter -> 1234
                    )
                );
            }
        ),

        search -> get("/search", request -> {
                List<Song> songList = songRepository.findByTitle("%" + request.getGetParameter("title") + "%");
                return render(views.songList.assigning(songs -> songList));
            }
        ),

        create -> get("/create", request -> render(views.createSong)),

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