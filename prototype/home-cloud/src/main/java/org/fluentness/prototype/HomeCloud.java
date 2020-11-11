package org.fluentness.prototype;

import org.fluentness.Fluentness;
import org.fluentness.application.WebApplication;
import org.fluentness.prototype.controller.IndexController;
import org.fluentness.prototype.controller.NotesController;
import org.fluentness.prototype.service.Authenticator;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;
import org.fluentness.service.injector.InjectorException;
import org.fluentness.service.server.Server;

@Services({
    Configuration.class,
    Authenticator.class
})
public class HomeCloud extends WebApplication {

    public HomeCloud(Server server,
                     IndexController indexController,
                     NotesController notesController
    ) {
        super(server, indexController, notesController);
    }

    public static void main(String[] args) throws InjectorException {
        Fluentness.launch(HomeCloud.class, args);
    }
}
