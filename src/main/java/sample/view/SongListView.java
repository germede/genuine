package sample.view;

import com.sample.model.SongModel;
import org.fluentness.entity.Entity;
import org.fluentness.rendering.Renderable;
import org.fluentness.view.Parameter;
import org.fluentness.view.Template;
import org.fluentness.view.View;

import java.util.List;

@Template(BaseView.class)
public class SongListView implements View.Html {

    @Parameter
    private List<Entity<SongModel>> songs;

    @Override
    public Renderable getRenderable() {
        return div(attrs(CLASS -> "row"),
                div(attrs(CLASS -> "column"),

                        div(attrs(CLASS -> "row"),
                                div(attrs(CLASS -> "column column-50"),
                                        h2(translate("song_list"))
                                ),
                                div(attrs(CLASS -> "column column-50"),
                                        a(attrs(CLASS -> "button float-right", HREF -> "/song/create"),
                                                translate("song_create")
                                        )
                                )
                        ),
                        table(
                                thead(
                                        tr(
                                                th(translate("song_title")),
                                                th(translate("song_artist")),
                                                th(translate("song_album")),
                                                th(translate("song_year")),
                                                th(translate("song_is_new"))
                                        )
                                ),
                                tbody(
                                        forEachEntityIn(songs, song ->
                                                tr(
                                                        td(song.get("title")),
                                                        td(song.get("artist")),
                                                        td(song.get("album")),
                                                        td(song.get("year")),
                                                        td(song.get("is_new"))
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
