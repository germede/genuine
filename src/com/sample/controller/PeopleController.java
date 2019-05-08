package com.sample.controller;

import com.sample.form.PersonForm;
import com.sample.model.PersonModel;
import com.sample.view.PeopleView;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.logging.Logger;
import org.fluentness.networking.Request;
import org.fluentness.networking.Response;
import org.fluentness.repository.Repository;
import org.fluentness.repository.RepositoryImpl;

public class PeopleController implements Controller {

    private Repository<PersonModel> personRepository = new RepositoryImpl<>(PersonModel.class);

    @Route("/list/{id}")
    public Response list(Request request) {

        Logger.debug(this.getClass(), request.getMethod());
        Logger.debug(this.getClass(), request.getUrlParameter());
        Logger.debug(this.getClass(), request.getGetParameter("test"));
        Logger.debug(this.getClass(), request.getPostParameter("test"));
        PersonModel person = new PersonModel();
        String table = person.getTable();
        String fields = String.join("", person.getColumns());

        person.set(
          name -> "pepe",
          surname -> "nachname"
        );

        int i = 0;
//        Person person = new Person()
//                .setName(name)
//                .setSurname(surname);
//
//
//        person.create();


//        person = personRepository.find(19);
//        person.setSurname("testtttaa");
//        person.update();


        return render(PeopleView.class,
                people -> personRepository.list(),
                personForm -> new PersonForm());
    }

//    @Route(path = "/redirect", method = HttpMethod.POST)
//    public Response testRedirect(Request request) {
//
//
//        return redirect("http://www.google.com/");
//    }

//    @Route("/response")
//    public Response testResponse() {
//        return response("this is a raw response with custom response code")
//                .setStatusCode(201)
//                .setHeader("asdf", "asdf");
//    }
}
