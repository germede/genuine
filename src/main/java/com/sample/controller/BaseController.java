package com.sample.controller;

import com.sample.repository.SongRepository;
import org.fluentness.common.Inject;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.networking.Response;
import org.fluentness.register.NamedValueRegister;

public class BaseController implements Controller {

    @Inject
    private SongRepository songRepository;

    @Route("/")
    public Response index() {
        NamedValueRegister.existsName("asdf");
        return redirect("/song/list");
    }
}
