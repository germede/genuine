package com.sample.views;

import com.sample.models.Person;
import org.fluentness.mvc.View;
import org.fluentness.tpl.HtmlAttribute;
import org.fluentness.tpl.HtmlTag;
import org.fluentness.tpl.HtmlView;

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
                .open(HtmlTag.div,
                        new HtmlAttribute("class","testRedirect"),
                        new HtmlAttribute("data-binding","testRedirect"),
                        new HtmlAttribute("testRedirect","testRedirect")
                )
                .includeIf(2==2, new DummyView())
                .forEach(people,
                        new HtmlView.ForEach<Person>() {
                            @Override
                            public void then(Person person, HtmlView htmlView) {
                                htmlView.append(person.getName());
                            }
                        })
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
