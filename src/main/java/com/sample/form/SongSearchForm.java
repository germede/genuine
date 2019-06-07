package com.sample.form;

import org.fluentness.form.Form;
import org.fluentness.router.HttpMethod;

public class SongSearchForm implements Form {

    @Override
    public String getAction() {
        return "/song/search";
    }

    @Override
    public String getMethod() {
        return HttpMethod.GET;
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

}
