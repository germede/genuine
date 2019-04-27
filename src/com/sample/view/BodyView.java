package com.sample.view;

import com.sample.model.Person;
import org.fluentness.templating.HtmlTemplate;
import org.fluentness.templating.MarkupTemplate;
import org.fluentness.templating.HtmlTag;
import org.fluentness.templating.Template;
import org.fluentness.view.View;
import org.fluentness.view.Attribute;

import java.util.List;

public class BodyView implements View {

    @Attribute
    public List<Person> people;

    @Override
    public Template getTemplate() {
        return new HtmlTemplate()
                .open(HtmlTag.body)
                .open(HtmlTag.div).set("class", "testRedirect").set("data-binding", "testRedirect").set("testRedirect", "testRedirect")
                .when(2 == 2, then -> then.include(new DummyView()))
                .open(HtmlTag.ul)
                .forEach(people,
                        (Person person, MarkupTemplate htmlView) -> htmlView
                                .open(HtmlTag.li).set("class", "list element")
                                .append(person.getName())
                                .close(HtmlTag.li)
                )
                .close(HtmlTag.ul)
//                .img()
                .close(HtmlTag.div)
                .when(2 != 2,
                        then -> then.append("asdf"),
                        otherwise -> otherwise.append("fdsa")
                )
                .open(HtmlTag.p)
                .append("test ###welcome_message### test ###test### ###test######test_message###")
                .close(HtmlTag.p)
                .close(HtmlTag.body);
    }
}
