package com.sample.view;

import com.sample.model.Person;
import org.fwf.mvc.View;
import org.fwf.tpl.HtmlTag;
import org.fwf.tpl.HtmlView;

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
