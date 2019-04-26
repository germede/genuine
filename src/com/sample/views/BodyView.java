package com.sample.views;

import com.sample.models.Person;
import org.fluentworkflow.mvc.View;
import org.fluentworkflow.tpl.HtmlAttribute;
import org.fluentworkflow.tpl.HtmlTag;
import org.fluentworkflow.tpl.HtmlView;

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
                .open(HtmlTag.p)
                .append("test ###welcome_message### test ###test### ###test######test_message###")
                .close(HtmlTag.p)
                .close(HtmlTag.body)
                .render();
    }
}
