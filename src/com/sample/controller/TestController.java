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
                .setName("Thomas");

        // TODO inject repository singleton for each controller

        List<Person> people = personRepository.findAll(Person.class);
        int i = 0;
    }
}
