package sample.controller;

import com.sample.form.SongForm;
import com.sample.model.SongModel;
import com.sample.repository.SongRepository;
import com.sample.view.SongCreateView;
import com.sample.view.SongListView;
import org.fluentness.common.Inject;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.entity.Entity;
import org.fluentness.networking.HttpMethod;
import org.fluentness.networking.Request;
import org.fluentness.networking.Response;

@Route("/song")
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

        return render(SongCreateView.class, songForm -> new SongForm());
    }
}
