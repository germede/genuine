package com.sample.controller;

import com.sample.model.Person;
import org.fwf.ann.BaseRoute;
import org.fwf.ann.Inject;
import org.fwf.ann.Route;
import org.fwf.dto.CrudRepository;
import org.fwf.mvc.Controller;

import java.util.List;

@BaseRoute("/test")
public class TestController extends Controller {

    @Inject
    public CrudRepository<Person> personRepository;

    @Route("/action")
    public void action() {

        Person person = new Person()
                .setId(12)
                .setName("Thomas")
                .setSurname("Mueller");


        List<Person> people = personRepository.findAll(Person.class);
        people.get(10).setName("Gerhard");
        people.get(10).setSurname("1234");
        people.get(10).setId(1234);
        personRepository.update(people.get(10));
    }
}
