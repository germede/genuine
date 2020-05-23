package org.fluentness.prototype;

import org.fluentness.AbstractWeb;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.controller.WebEventController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;
import org.fluentness.service.server.Server;

@Services({
    Configuration.class,
})
public class Web extends AbstractWeb {

    public Web(Server server, WebEventController controller) {
        super(server, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Web.class, args);
    }
}
