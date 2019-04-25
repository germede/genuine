package com.sample.controller;

import com.sample.model.Person;
import com.sample.view.PeopleView;
import org.fwf.ann.Route;
import org.fwf.dao.Repository;
import org.fwf.dao.RepositoryImpl;
import org.fwf.mvc.Controller;
import org.fwf.net.HttpResponse;

import java.util.List;

public class PeopleController implements Controller {

    private Repository<Person> personRepository = new RepositoryImpl<>(Person.class);

    @Route(path = "/")
    public HttpResponse list() {

//        Person person = new Person()
//                .setId(12)
//                .setName("Thomas")
//                .setSurname("Mueller");

        List<Person> people = personRepository.list();

//        Person person = personRepository.find(Person.class, 19);
//        person.setSurname("testttt");
//        personRepository.update(person);

        return render(new PeopleView(people));
    }

    @Route(path = "/redirect")
    public HttpResponse testRedirect() {
        return redirect("http://www.google.com/");
    }

    @Route(path = "/response")
    public HttpResponse testResponse() {
        return response("this is a raw response with custom response code").
                setStatusCode(201);
    }
}
