package com.sample.form;

import org.fluentness.form.Form;
import org.fluentness.networking.HttpMethod;
import org.fluentness.rendering.Renderable;

public class SongSearchForm implements Form {

    @Override
    public String getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getAction() {
        return "/song/search";
    }

    @Override
    public Fields getFields() {
        return fields(
                title -> text(
                        REQUIRED -> "true",
                        ID -> "song_title_input",
                        PLACEHOLDER -> translate("song_title"),
                        MAXLENGTH -> "20"
                )
        );
    }

    @Override
    public Renderable getRenderable() {
        return form(____(METHOD -> getMethod(), ACTION -> getAction(), CLASS -> "form-inline float-right"),
                field("title"),
                input(____(TYPE -> "submit", VALUE -> translate("search")))
        );
    }

}
