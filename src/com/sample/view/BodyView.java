package com.sample.view;

import com.sample.model.Person;
import org.fwf.mvc.View;
import org.fwf.tpl.HtmlAttribute;
import org.fwf.tpl.HtmlTag;
import org.fwf.tpl.HtmlView;

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
                .close(HtmlTag.body)
                .render();
    }
}
