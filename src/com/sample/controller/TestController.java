package com.sample.controller;

import com.sample.model.Person;
import com.sample.view.TestView;
import org.fwf.ann.Inject;
import org.fwf.ann.Route;
import org.fwf.dto.Repository;
import org.fwf.mvc.Controller;

public class TestController extends Controller {

    @Inject
    public Repository<Person> personRepository;

    @Route
    public void action() {

//        Person person = new Person()
//                .setId(12)
//                .setName("Thomas")
//                .setSurname("Mueller");


//        Person person = personRepository.find(Person.class, 19);
//        person.setSurname("testttt");
//        personRepository.update(person);

        render(new TestView("test"),200);
    }
}
