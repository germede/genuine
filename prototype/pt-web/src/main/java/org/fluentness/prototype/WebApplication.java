package org.fluentness.prototype;

import org.fluentness.application.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.application.Application;
import org.fluentness.service.instantiation.InstantiationException;
import org.fluentness.prototype.index.IndexController;
import org.fluentness.prototype.note.NoteController;
import org.fluentness.prototype.common.Configuration;
import org.fluentness.service.server.Server;

@Application.Services({
    Configuration.class,
})
public class WebApplication extends AbstractWebApplication {

    public WebApplication(Server server,
                          IndexController indexController,
                          NoteController noteController
    ) {
        super(server, indexController, noteController);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(WebApplication.class, args);
    }
}
