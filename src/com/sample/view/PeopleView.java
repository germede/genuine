package com.sample.view;

import com.sample.model.Person;
import org.fluentworkflow.mvc.View;
import org.fluentworkflow.tpl.HtmlTag;
import org.fluentworkflow.tpl.HtmlView;

import java.util.List;

public class PeopleView implements View {

    private List<Person> people;

    public PeopleView(List<Person> people) {
        this.people = people;
    }

    @Override
    public String render() {

        return new HtmlView()
                .open(HtmlTag.html)
                .include(new HeadView())
                .include(new BodyView(people))
                .close(HtmlTag.html)
                .render();
    }
}
