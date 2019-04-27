package com.sample.view;

import com.sample.model.Person;
import org.fluentness.templating.HtmlTemplate;
import org.fluentness.templating.HtmlTag;
import org.fluentness.templating.Template;
import org.fluentness.view.View;
import org.fluentness.view.Attribute;

import java.util.List;

public class PeopleView implements View {

    @Attribute
    public List<Person> people;

    @Override
    public Template getTemplate() {

        return new HtmlTemplate()
                .open(HtmlTag.html)
                .include(new HeadView())
                .include(new BodyView().set("people",people))
                .close(HtmlTag.html);
    }
}
