package com.sample.views;

import com.sample.models.Person;
import org.fluentness.view.MarkupView;
import org.fluentness.view.View;
import org.fluentness.view.HtmlTag;
import org.fluentness.view.HtmlView;

import java.util.List;

public class BodyView implements View {

    private List<Person> people;

    public BodyView(List<Person> people) {
        this.people = people;
    }

    @Override
    public String render() {
        return new HtmlView()
                .open(HtmlTag.body)
                .open(HtmlTag.div).set("class", "testRedirect").set("data-binding", "testRedirect").set("testRedirect", "testRedirect")
                .when(2 == 2, then -> then.include(new DummyView()))
                .forEach(people,
                        (MarkupView.ForEach<Person>) (person, htmlView) -> htmlView.append(person.getName()))
//                .img()
                .close(HtmlTag.div)
                .when(2 != 2,
                        then -> then.append("asdf"),
                        otherwise -> otherwise.append("fdsa")
                )
                .open(HtmlTag.p)
                .append("test ###welcome_message### test ###test### ###test######test_message###")
                .close(HtmlTag.p)
                .close(HtmlTag.body)
                .render();
    }
}
