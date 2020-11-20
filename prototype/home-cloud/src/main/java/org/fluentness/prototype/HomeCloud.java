package org.fluentness.prototype;

import org.fluentness.WebApplication;
import org.fluentness.prototype.controller.IndexController;
import org.fluentness.prototype.controller.NotesController;
import org.fluentness.prototype.service.DevConfiguration;
import org.fluentness.prototype.service.PasswordAuthenticator;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injector.ConstructorInjector;
import org.fluentness.service.injector.DefaultImplementations;
import org.fluentness.service.server.Server;

public class HomeCloud extends WebApplication {

    public HomeCloud(Server server,
                     IndexController indexController,
                     NotesController notesController
    ) {
        super(server, indexController, notesController);
    }

    public static void main(String[] args) throws Exception {
        DefaultImplementations.set(Configuration.class, DevConfiguration.class);
        DefaultImplementations.set(Authenticator.class, PasswordAuthenticator.class);

        new ConstructorInjector().inject(HomeCloud.class).run(args);
    }
}
