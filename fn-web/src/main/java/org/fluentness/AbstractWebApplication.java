package org.fluentness;

import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.router.DefaultRouter;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;

public abstract class AbstractWebApplication implements Application {

    @Override
    public Provider<Service> services() {
        return Application.super.services()
            .add(DefaultRouter.class)
            .add(SunServer.class)
            .add(SocketMail.class)
            ;
    }

    @Override
    public final void run(String[] args) throws Exception {
        Fluentness.getInstance(Server.class).start();
    }
}
