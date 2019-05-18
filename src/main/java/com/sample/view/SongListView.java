package com.sample.view;

import com.sample.form.SongSearchForm;
import com.sample.model.SongModel;
import org.fluentness.entity.Entity;
import org.fluentness.renderable.Renderable;
import org.fluentness.view.View;

import java.util.List;

@View.Template(BaseView.class)
public class SongListView implements View.Html {

    @Parameter
    private List<Entity<SongModel>> songs;

    @Override
    public Renderable getRenderable() {
        return div(with(CLASS -> "row"),
                div(with(CLASS -> "column"),
                        div(with(CLASS -> "row"),
                                div(with(CLASS -> "column column-50"),
                                        h2(translate("song_list"))
                                ),
                                div(with(CLASS -> "column column-50"),
                                        new SongSearchForm().getRenderable()
                                )
                        ),
                        table(
                                thead(
                                        tr(
                                                th(translate("song_title")),
                                                th(translate("song_artist")),
                                                th(translate("song_album")),
                                                th(translate("song_year")),
                                                th(translate("song_is_new")),
                                                th(translate("song_update")),
                                                th(translate("song_delete"))
                                        )
                                ),
                                tbody(
                                        forEachEntityIn(songs, song ->
                                                tr(
                                                        td(song.getString("title")),
                                                        td(song.getString("artist")),
                                                        td(song.getString("album")),
                                                        td(song.getString("year")),
                                                        td(song.getBoolean("is_new") ? "✔" : "\uD83D\uDDD9"),
                                                        td(a(with(CLASS -> "button", HREF -> "/song/update/" + song.getId()), "\uD83D\uDD89")),
                                                        td(a(with(CLASS -> "button", HREF -> "/song/delete/" + song.getId()), "\uD83D\uDDD1"))
                                                )
                                        )
                                )
                        ),
                        a(with(CLASS -> "button", HREF -> "/song/create"),
                                translate("song_create")
                        )
                )
        );
    }
}
