package com.sample.controller;

import com.sample.Views;
import com.sample.form.SongForm;
import com.sample.model.SongModel;
import com.sample.repository.SongRepository;
import sample.view.SongListView;
import org.fluentness.common.Inject;
import org.fluentness.controller.Controller;
import org.fluentness.entity.Entity;
import org.fluentness.router.HttpMethod;
import org.fluentness.controller.Request;
import org.fluentness.controller.Response;

@Controller.Route("/song")
public class SongController implements Controller {

    @Inject
    private SongRepository songRepository;

    @Route("/")
    public Response index() {
        return redirect("/list");
    }

    @Route("/list")
    public Response list() {
        return render(SongListView.class, songs -> songRepository.list());
    }

    @Route("/search")
    public Response search(Request request) {
        String title = request.getGetParameter("title");
        return render(SongListView.class, songs -> songRepository.findByTitle(title));
    }

    @Route("/create")
    public Response create(Request request) {

        // form was submitted
        if (request.getMethod().equals(HttpMethod.POST)) {


            Entity<SongModel> song = new Entity(SongModel.class);
            song.set(
                title -> request.getPostParameter("title"),
                artist -> request.getPostParameter("artist"),
                album -> request.getPostParameter("album"),
                year -> request.getPostParameter("year"),
                is_new -> request.getPostParameter("is_new")
            );
            songRepository.create(song);

            return redirect("/song/list");
        }

        return render(Views.class, songForm -> new SongForm());
    }

    @Route("/update/{id}")
    public Response update(Request request) {

        // form was submitted
        if (request.getMethod().equals(HttpMethod.POST)) {


            Entity<SongModel> song = new Entity(SongModel.class);
            song.set(
                title -> request.getPostParameter("title"),
                artist -> request.getPostParameter("artist"),
                album -> request.getPostParameter("album"),
                year -> request.getPostParameter("year"),
                is_new -> request.getPostParameter("is_new")
            );
            songRepository.create(song);

            return redirect("/song/list");
        }

        return render(Views.class, songForm -> new SongForm());
    }
}
