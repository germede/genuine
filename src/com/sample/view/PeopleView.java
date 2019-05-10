package com.sample.view;

import org.fluentness.entity.Entity;
import org.fluentness.form.Form;
import org.fluentness.rendering.Renderable;
import org.fluentness.view.Parameter;
import org.fluentness.view.Template;
import org.fluentness.view.View;

import java.util.List;

@Template(BaseView.class)
public class PeopleView implements View.Html {

    @Parameter
    private List<Entity> people;

    @Parameter
    private Form personForm;

    @Override
    public Renderable getRenderable() {
        return h1(attrs(CLASS -> "test", ID -> "1234", DATA -> "asdf"),

                textarea(),
                h1("test"),
                forEachEntityIn(people, person ->
                        h1(person.get("name"))
                ),

                2 == 2 ? h1("yea") : h1("no"),
                personForm.getRenderable(),
                translate("welcome_message")
        );
    }
}
