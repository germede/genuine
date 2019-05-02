package com.sample.controller;

import com.sample.model.Person;
import com.sample.view.PeopleView;
import org.fluentness.controller.BaseRoute;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.networking.HttpRequest;
import org.fluentness.logging.Log;
import org.fluentness.repository.Repository;
import org.fluentness.repository.RepositoryImpl;
import org.fluentness.networking.HttpResponse;
import org.fluentness.view.View;

import java.util.List;

@BaseRoute("/test")
public class PeopleController implements Controller {

    private Repository<Person> personRepository = new RepositoryImpl<>(Person.class);

    @Route(path = "/list")
    public HttpResponse list(HttpRequest request) {

        Log.info(this.getClass(), request.getMethod());
        Log.info(this.getClass(), request.getGetParameter("test"));
        Log.info(this.getClass(), request.getPostParameter("test"));

//        Person person = new Person()
//                .setName(name)
//                .setSurname(surname);
//
//
//        person.create();

        List<Person> people = personRepository.list();


//        person = personRepository.find(19);
//        person.setSurname("testtttaa");
//        person.update();

        View view = new PeopleView()
                .setAttribute("people", people)
                .setAttribute("testBoolean", true);

        return render(view);
    }

//    @Route(path = "/redirect", method = HttpMethod.POST)
//    public Response testRedirect(Request request) {
//
//
//        return redirect("http://www.google.com/");
//    }

    @Route(path = "/response")
    public HttpResponse testResponse() {
        return response("this is a raw response with custom response code")
                .setStatusCode(201)
                .setHeader("asdf", "asdf");
    }
}
