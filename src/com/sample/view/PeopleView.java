package com.sample.view;

import com.sample.form.PersonForm;
import com.sample.model.Person;
import org.fluentness.form.Form;
import org.fluentness.view.Template;
import org.fluentness.view.View;

import java.util.List;

@Template(BaseView.class)
public class PeopleView implements View.Html {

    public List<Person> people;

    public Form personForm;

    public PeopleView(List<Person> people, PersonForm personForm) {

        this.people = people;
        this.personForm = personForm;
    }

    @Override
    public String render() {

        return h1(CLASS + "test", ID + "1234", DATA + "asdf",
                textarea(ID + "THE BEST TEST AREA"),
                h1("test"),
                2==2 ? h1("yea") : h1("no"),
                personForm,
                translate("welcome_message")
        ).render();

    }
}
