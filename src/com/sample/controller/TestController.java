package com.sample.controller;

import com.sample.model.Person;
import org.fwf.mvc.Controller;
import org.fwf.ann.BaseRoute;
import org.fwf.ann.Route;

@BaseRoute("/test")
public class TestController extends Controller {

    @Route("/action")
    public void action() {

        Person person = new Person()
                .setName("Mike")
                .create();

    }
}
