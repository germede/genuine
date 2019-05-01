package com.sample.view;

import com.sample.model.Person;
import org.fluentness.view.Attribute;
import org.fluentness.view.Template;
import org.fluentness.view.View;

import java.util.List;

@Template(DummyView.class)
public class BodyView implements View.Html {

    @Attribute
    public List<Person> people;

    @Override
    public CharSequence render() {
        return body();

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
