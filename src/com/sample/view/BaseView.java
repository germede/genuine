package com.sample.view;

import org.fluentness.view.Placeholder;
import org.fluentness.view.View;

public class BaseView implements View.Html {

    @Placeholder
    public View placeholder;

    @Override
    public String render() {
        return html(
                head(
                        title("the best site"),
                        meta(attrs(NAME -> "lang", CONTENT -> "es")),
                        meta(attrs(CHARSET -> "utf-8"))
                ),
                body(
//                        when(2 == 2, h1("test")),
                        placeholder

                )
        ).render();

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
