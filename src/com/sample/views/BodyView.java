package com.sample.views;

import com.sample.models.Person;
import org.fluentness.view.MarkupView;
import org.fluentness.view.View;
import org.fluentness.view.Tag;
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
                .open(Tag.body)
                .open(Tag.div).set("class", "testRedirect").set("data-binding", "testRedirect").set("testRedirect", "testRedirect")
                .when(2 == 2, then -> then.include(new DummyView()))
                .open(Tag.ul)
                .forEach(people,
                        (Person person, MarkupView htmlView) -> htmlView
                                .open(Tag.li).set("class", "list element")
                                .append(person.getName())
                                .close(Tag.li)
                )
                .close(Tag.ul)
//                .img()
                .close(Tag.div)
                .when(2 != 2,
                        then -> then.append("asdf"),
                        otherwise -> otherwise.append("fdsa")
                )
                .open(Tag.p)
                .append("test ###welcome_message### test ###test### ###test######test_message###")
                .close(Tag.p)
                .close(Tag.body)
                .render();
    }
}
