package com.sample.view;

import com.sample.model.Person;
import org.fluentness.view.Attribute;
import org.fluentness.view.View;

import java.io.Serializable;
import java.util.List;

import static org.fluentness.templating.HtmlAttribute.classs;
import static org.fluentness.templating.HtmlAttribute.id;
import static org.fluentness.templating.HtmlElement.*;

public class BodyView implements View {

    @Attribute
    public List<Person> people;

    @Override
    public Serializable render() {
        return body(
                div(classs("testRedirect"), id("testRedirect")

                ),
                ul(classs("list element")),
                p("test test lalala")
        );

//                .when(2 == 2, then -> then.include(new DummyView()))
//                .open(HtmlElement.ul)
//                .forEach(people,
//                        (Person person, Markup htmlView) -> htmlView
//                                .open(HtmlElement.li).set("class", "list element")
//                                .append(person.getName())
//                                .close(HtmlElement.li)
//                )
//                .close(HtmlElement.ul)
//                .img()
//                .when(2 != 2,
//                        then -> then.append("asdf"),
//                        otherwise -> otherwise.append("fdsa")
//                )
    }
}
