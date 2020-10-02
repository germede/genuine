package org.fluentness.prototype;

import org.fluentness.Fluentness;
import org.fluentness.application.WebApplication;
import org.fluentness.application.Application;
import org.fluentness.prototype.controller.IndexController;
import org.fluentness.prototype.controller.NoteController;
import org.fluentness.prototype.service.Authenticator;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.instantiation.InstantiationException;
import org.fluentness.service.server.Server;

@Application.Services({
    Configuration.class,
    Authenticator.class
})
public class HomeCloud extends WebApplication {

    public HomeCloud(Server server,
                     IndexController indexController,
                     NoteController noteController
    ) {
        super(server, indexController, noteController);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(HomeCloud.class, args);
    }
}
