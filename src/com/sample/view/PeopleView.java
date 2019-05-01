package com.sample.view;

import com.sample.model.Person;
import org.fluentness.view.Attribute;
import org.fluentness.view.View;

import java.util.List;

public class PeopleView implements View.Html {

    @Attribute
    public List<Person> people;

    @Override
    public CharSequence render() {

        return h1(CLASS + "test", ID + "1234", DATA + "asdf",
                textarea(ID+"THE BEST TEST AREA",
                        h1("test")
                ),
                input()
        );

    }
}
