package com.sample.view;

import org.fluentness.form.Form;
import org.fluentness.rendering.Renderable;
import org.fluentness.view.Parameter;
import org.fluentness.view.Template;
import org.fluentness.view.View;

@Template(BaseView.class)
public class SongCreateView implements View.Html {

    @Parameter
    private Form songForm;

    @Override
    public Renderable getRenderable() {
        return div(with(CLASS -> "row"),
                div(with(CLASS -> "column"),
                        h2(translate("song_create")),
                        songForm
                )
        );
    }
}
