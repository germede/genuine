package com.sample.controller;

import com.sample.model.Person;
import org.fwf.ann.BaseRoute;
import org.fwf.ann.Inject;
import org.fwf.ann.Route;
import org.fwf.dto.RepositoryImpl;
import org.fwf.mvc.Controller;

@BaseRoute("/test")
public class TestController extends Controller {

    @Inject
    public RepositoryImpl<Person> personRepository;

    @Route(path = "/action", method = "GET")
    public void action() {

//        Person person = new Person()
//                .setId(12)
//                .setName("Thomas")
//                .setSurname("Mueller");


//        Person person = personRepository.find(Person.class, 19);
//        person.setSurname("testttt");
//        personRepository.update(person);

        redirect("http://www.google.com/");
    }
}
