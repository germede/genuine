package com.sample.controller;

import org.fwf.mvc.Controller;
import org.fwf.net.BaseRoute;
import org.fwf.net.Route;

@BaseRoute("/test")
public class TestController implements Controller {

    @Route("/action")
    public void action() {
        System.out.println("TEST");
    }
}
