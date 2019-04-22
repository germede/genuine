package com.sample.controller;

import com.sample.model.Person;
import com.sample.view.PeopleView;
import org.fwf.ann.Route;
import org.fwf.dao.Repository;
import org.fwf.dao.RepositoryImpl;
import org.fwf.mvc.Controller;
import org.fwf.net.HttpResponse;

import java.util.List;

public class TestController implements Controller {

    private Repository<Person> personRepository = new RepositoryImpl<>(Person.class);

    @Route
    public HttpResponse action() {

//        Person person = new Person()
//                .setId(12)
//                .setName("Thomas")
//                .setSurname("Mueller");

        List<Person> people = personRepository.list();

//        Person person = personRepository.find(Person.class, 19);
//        person.setSurname("testttt");
//        personRepository.update(person);

        return new HttpResponse(200, new PeopleView(people).render());
    }
}
