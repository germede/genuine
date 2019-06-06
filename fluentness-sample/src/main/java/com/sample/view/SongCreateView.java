package com.sample.view;

import org.fluentness.form.Form;
import org.fluentness.renderable.Renderable;
import org.fluentness.view.View;

public class SongCreateView implements View.Html {

    @Parameter
    private Form songForm;

    @Override
    @Template(BaseView.class)
    public Renderable getRenderable() {
        return div(with(CLASS -> "row"),
                div(with(CLASS -> "column"),
                        h2(translate("song_create")),
                        songForm.getRenderable()
                )
        );
    }
}
