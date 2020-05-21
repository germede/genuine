package org.fluentness.prototype;

import org.fluentness.prototype.controller.WebController;
import org.fluentness.AbstractWeb;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.service.BasicAuthentication;
import org.fluentness.prototype.service.MapConfiguration;
import org.fluentness.service.Services;
import org.fluentness.service.server.Server;

@Services({
    MapConfiguration.class,
    BasicAuthentication.class,
})
public class Web extends AbstractWeb {

    public Web(Server server, WebController controller) {
        super(server, controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Web.class, args);
    }
}
