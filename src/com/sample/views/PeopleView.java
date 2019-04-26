package com.sample.views;

import com.sample.models.Person;
import org.fluentness.view.View;
import org.fluentness.view.HtmlTag;
import org.fluentness.view.HtmlView;

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
