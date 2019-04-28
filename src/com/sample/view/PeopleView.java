package com.sample.view;

import com.sample.model.Person;
import org.fluentness.view.Attribute;
import org.fluentness.view.View;

import java.io.Serializable;
import java.util.List;

import static org.fluentness.templating.HtmlAttribute.classs;
import static org.fluentness.templating.HtmlAttribute.id;
import static org.fluentness.templating.HtmlElement.body;
import static org.fluentness.templating.HtmlElement.h1;

public class PeopleView implements View {

    @Attribute
    public List<Person> people;

    @Override
    public Serializable render() {
        return body(
                h1(classs("test"), id("test"),
                        "Hello, World!"
                )
        );
    }
}
