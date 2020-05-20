package com.sample;

import com.sample.controller.WebController;
import org.fluentness.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.server.Server;

public class WebApplication extends AbstractWebApplication {

    public WebApplication(Server server, WebController controller) {
        super(server, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(WebApplication.class, args);
    }
}
